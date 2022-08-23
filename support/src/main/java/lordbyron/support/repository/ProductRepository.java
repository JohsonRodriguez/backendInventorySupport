package lordbyron.support.repository;

import lordbyron.support.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product,String> {
    List<Product> findByType(String type);
    long countByType(String type);
    Optional<Product> findBySerial(String serial);
    List<Product> findAllByType(String type);

}
