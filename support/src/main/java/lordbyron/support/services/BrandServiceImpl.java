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
        Model model = getModel(brandDto.getProductModel());
        Brand brand = getBrand(brandDto.getProductBrand());
        var allBrands = product.getBrands();
        for (Brand b : allBrands) {
            boolean check = b.getName().contains(checkBrand.getName());
            if (check) {
                throw new NotFoundException("Producto ya está registrado, ingrese otra marca");
            }
        }

        if (checkBrand == null) {
            Brand brand = new Brand();
            brand.setName(name);
            brandRepository.save(brand);
        }
    }

    private Brand getBrand(String productBrand) {
        var checkBrand= brandRepository.findByName(productBrand);

    }

    private Model getModel(String productModel) {
        var checkModel = modelService.searchModel(productModel);
        if (checkModel.isEmpty()) {
            try {
                return modelService.newModel(productModel);
            } catch (Exception e) {
                throw new NotFoundException(e.getMessage());
            }
        }else{
            return modelService.searchModel(productModel).get();
        }
    }

    @Override
    public Brand searchBrand(String name) {
        return null;
    }

    @Override
    public Iterable<Brand> getAllBrand() {
        return brandRepository.findAll();
    }
}
