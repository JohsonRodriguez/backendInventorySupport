package lordbyron.support.services;

import lordbyron.support.Dto.BrandDto;
import lordbyron.support.entity.Brand;
import org.springframework.stereotype.Service;


public interface BrandService {
    void newBrand(BrandDto brandDto);
    Brand searchBrand(String name);
    Iterable<Brand> getAllBrand();
}
