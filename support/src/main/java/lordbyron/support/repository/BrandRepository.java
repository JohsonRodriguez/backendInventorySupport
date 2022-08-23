package lordbyron.support.repository;

import lordbyron.support.entity.Brand;
import org.springframework.data.repository.CrudRepository;


public interface BrandRepository extends CrudRepository<Brand,Long>{
    Brand findByName(String name);
}
