package lordbyron.support.services;

import lordbyron.support.entity.Brand;
import lordbyron.support.entity.Model;

import java.util.Optional;

public interface ModelService {
    Model newModel(String name, Brand brand);
    Optional<Model> searchModel(String name);
    Iterable<Model> getAllModel();
}
