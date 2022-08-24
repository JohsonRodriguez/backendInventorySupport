package lordbyron.support.services;

import lordbyron.support.Dto.BrandDto;
import lordbyron.support.entity.Brand;
import lordbyron.support.entity.Model;
import lordbyron.support.exception.NotFoundException;
import lordbyron.support.repository.BrandRepository;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService{
    private final BrandRepository  brandRepository;
    private final ModelService modelService;

    public BrandServiceImpl(BrandRepository brandRepository, ModelService modelService) {
        this.brandRepository = brandRepository;
        this.modelService = modelService;
    }

    @Override
    public void newBrand(BrandDto brandDto) {
        Brand brand = getBrand(brandDto.getProductBrand());
//        Model model = getModel(brandDto.getProductModel(),brand);
        try {
              modelService.newModel(brandDto.getProductModel(),brand);
        }catch (Exception e) {

        }

//        var allModels = brand.getModels();
//        for (Model m : allModels) {
//            boolean check = m.getName().contains(model.getName());
//            if (!check) {
//               throw new NotFoundException("Marca y Modelo ya estan registrados, ingrese otro modelo");
//                brand.getModels().add(model);
//            }
//        }


    }



    @Override
    public Brand searchBrand(String name) {
        return null;
    }

    @Override
    public Iterable<Brand> getAllBrand() {
        return brandRepository.findAll();
    }

    //Methods
    private Brand getBrand(String productBrand) {
        var checkBrand= brandRepository.findByName(productBrand);
        if (checkBrand.isEmpty()) {
            try {
                Brand brand = new Brand();
                brand.setName(productBrand);
                return  brandRepository.save(brand);
            } catch (Exception e) {
                throw new NotFoundException(e.getMessage());
            }
        }else{
            return brandRepository.findByName(productBrand).get();
        }

    }

//    private Model getModel(String productModel,Brand brand) {
//
//        var checkModel = modelService.searchModel(productModel);
//        if (checkModel.isEmpty()) {
//            try {
//                return modelService.newModel(productModel,brand);
//            } catch (Exception e) {
//                throw new NotFoundException(e.getMessage());
//            }
//        }else{
//            return modelService.searchModel(productModel).get();
//        }
//    }
}
