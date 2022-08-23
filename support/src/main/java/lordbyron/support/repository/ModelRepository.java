package lordbyron.support.repository;

import lordbyron.support.entity.Brand;
import lordbyron.support.entity.Model;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface ModelRepository extends CrudRepository<Model,Long> {
     Optional<Model> findByName(String name);

}
