package lordbyron.support.services;

import lordbyron.support.entity.Brand;
import lordbyron.support.entity.Model;
import lordbyron.support.repository.ModelRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ModelServiceImpl implements ModelService{
    private final ModelRepository modelRepository;

    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public Model newModel(String name, Brand brand) {
        Model model = new Model();
        model.setName(name);
        model.setBrand(brand);
        return modelRepository.save(model);
    }

    @Override
    public Optional<Model> searchModel(String name) {
        return modelRepository.findByName(name);
    }

    @Override
    public Iterable<Model> getAllModel() {
        return modelRepository.findAll();
    }
}
