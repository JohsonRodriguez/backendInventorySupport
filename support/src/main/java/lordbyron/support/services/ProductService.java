package lordbyron.support.services;

import lordbyron.support.Dto.ProductDto;
import lordbyron.support.entity.Model;
import lordbyron.support.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductService {
    void newProduct(ProductDto productDto);
    Product searchProduct(String serial);
    List<Product> getAllProductsByType(String serial);
    Iterable<Product> getAllProducts();
}
