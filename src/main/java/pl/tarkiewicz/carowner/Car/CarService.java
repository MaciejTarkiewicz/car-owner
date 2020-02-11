package pl.tarkiewicz.carowner.Car;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.tarkiewicz.carowner.Owner.OwnerDto;
import pl.tarkiewicz.carowner.Owner.OwnerService;

@Service
public class CarService {

    private final CarRepo carRepo;
    private final OwnerService ownerService;

    @Autowired
    public CarService(CarRepo carRepo, OwnerService ownerService) {
        this.carRepo = carRepo;
        this.ownerService = ownerService;
    }

    public List<CarDto> getCars() {
        return carRepo.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public List<CarDtoWithCars> getCarsWithOwners() {
        return carRepo.findAll().stream()
                .map(this::convertToDtoWithOwners)
                .collect(Collectors.toList());
    }

    public CarDtoWithCars getCarWithOwner(Long id) {
        return carRepo.findById(id).map(this::convertToDtoWithOwners).orElseThrow(() -> new RuntimeException("Car doesn't exist"));

    }

    public CarDto getCar(Long id) {
        return carRepo.findById(id).map(this::convertToDto).orElseThrow(() -> new RuntimeException("Car doesn't exist"));

    }

    private CarDto convertToDto(Car car) {
        return CarDto.builder()
                .brand(car.getBrand())
                .name(car.getName())
                .productionYear(car.getProductionYear())
                .carCategory(car.getCarCategory())
                .build();
    }

    private CarDtoWithCars convertToDtoWithOwners(Car car) {
        Set<OwnerDto> ownersDto = new HashSet<>();
        for (int i = 0; i < car.getOwnerSet().size(); i++) {
            ownersDto.add(ownerService.convertToDto(car.getOwnerSet().iterator().next()));
        }
        return CarDtoWithCars.builder()
                .brand(car.getBrand())
                .name(car.getName())
                .productionYear(car.getProductionYear())
                .ownerSet(ownersDto)
                .carCategory(car.getCarCategory())
                .build();
    }
}

