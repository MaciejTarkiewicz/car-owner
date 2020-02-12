package pl.tarkiewicz.carowner.Owner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OwnerController {

    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping(value = "/owners/all")
    public List<OwnerDto> getOwners() {
        return ownerService.getOwners();

    }

    @GetMapping(value = "/owners/car/category")
    public List<OwnerCarCategoryDto> getCarCategoryOwners() {
        return ownerService.getCarCategoryOwners();

    }

}
