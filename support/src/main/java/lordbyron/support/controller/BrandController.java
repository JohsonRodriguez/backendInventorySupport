package lordbyron.support.controller;

import lordbyron.support.Dto.BrandDto;
import lordbyron.support.entity.Brand;
import lordbyron.support.services.BrandService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/brand")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/all")
    public Iterable<Brand> getAllBrand(){
        return brandService.getAllBrand();
    }

    @PostMapping("/add/{name}")
    public void newBrand(@PathVariable("name") String name){
        brandService.newBrand(name);
    }


}
