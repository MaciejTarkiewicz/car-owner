package pl.tarkiewicz.carowner.Car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars/all")
    public List<CarDto> getCars(){
        return carService.getCars();
    }

    @GetMapping(value = "/cars/all1")
    public List<CarDtoWithCars> getCarsWithOwners(){
        return carService.getCarsWithOwners();
    }

    @GetMapping(value = "car")
    public CarDtoWithCars getCarWithOwner(@RequestParam Long id){
        return carService.getCarWithOwner(id);
    }

    @GetMapping(value = "car1")
    public CarDto getCar(@RequestParam Long id){
        return carService.getCar(id);
    }
}
