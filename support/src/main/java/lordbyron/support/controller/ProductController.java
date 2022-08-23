package lordbyron.support.controller;

import lordbyron.support.Dto.ProductDto;
import lordbyron.support.entity.Product;
import lordbyron.support.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    public void newBrand(@RequestBody ProductDto productDto){
        productService.newProduct(productDto);
    }

    @GetMapping("findProduct/{serial}")
    public Product getByProduct(@PathVariable("serial") String serial) {
        return productService.searchProduct(serial);
    }

    @GetMapping("findType/{type}")
    public List<Product> getProductByType(@PathVariable("type") String type) {
        return productService.getAllProductsByType(type);
    }
}
