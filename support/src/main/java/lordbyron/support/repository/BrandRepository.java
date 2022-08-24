package lordbyron.support.repository;

import lordbyron.support.entity.Brand;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface BrandRepository extends CrudRepository<Brand,Long>{
    Optional<Brand> findByName(String name);
}
