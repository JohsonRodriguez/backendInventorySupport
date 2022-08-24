package lordbyron.support.services;

import lordbyron.support.Dto.BrandDto;
import lordbyron.support.Dto.ProductDto;
import lordbyron.support.Shared.MethodsService;
import lordbyron.support.entity.Brand;
import lordbyron.support.entity.Product;
import lordbyron.support.exception.NotFoundException;
import lordbyron.support.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService{
    private final MethodsService methodsService;
    private final BrandService brandService;
    private final ModelService modelService;
    private final ProductRepository productRepository;
    String newId;

    public ProductServiceImpl(MethodsService methodsService, BrandService brandService, ModelService modelService, ProductRepository productRepository) {
        this.methodsService = methodsService;
        this.brandService = brandService;
        this.modelService = modelService;
        this.productRepository = productRepository;
    }


    @Override
    public void newProduct(ProductDto productDto) {
        Product lastProduct;
        String lastId;
        var checkSerial = productRepository.findBySerial(productDto.getSerial());
        if(checkSerial.isPresent()){
            throw new NotFoundException("Producto ya está registrado, ingrese otra producto");
        }
        long count = productRepository.countByType(productDto.getType());
        var allproducts = productRepository.findByType(productDto.getType());
        if(count==0){
             lastId = "000";
        }else{
             lastProduct = allproducts.get(allproducts.size() - 1);
             lastId = lastProduct.getId();
        }

        newId= methodsService.generateNewId(count,productDto.getType().substring(0,4),lastId);
        Product product = new Product();
        product.setId(newId);
        product.setType(productDto.getType());
        product.setBrand(productDto.getBrand());
        product.setModel(productDto.getModel());
        product.setSerial(productDto.getSerial());
        product.setColour(productDto.getColour());
        product.setDetails(productDto.getDetails());
        product.setObservation(productDto.getObservation());
        product.setStatus(productDto.getStatus());
        product.setLocation(productDto.getLocation());
        BrandDto brandDto = new BrandDto();
        brandDto.setProductBrand(productDto.getBrand());
        brandDto.setProductModel(productDto.getModel());
        brandService.newBrand(brandDto);
        productRepository.save(product);
    }


    @Override
    public Product searchProduct(String serial) {
        return productRepository.findBySerial(serial).get();
    }

    @Override
    public List<Product> getAllProductsByType(String type) {
        return productRepository.findAllByType(type);
    }

    @Override
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
