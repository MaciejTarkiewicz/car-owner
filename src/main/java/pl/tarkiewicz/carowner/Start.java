package pl.tarkiewicz.carowner;

import java.time.LocalDate;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.tarkiewicz.carowner.Car.Car;
import pl.tarkiewicz.carowner.Car.CarCategory;
import pl.tarkiewicz.carowner.Car.CarRepo;
import pl.tarkiewicz.carowner.Owner.Owner;
import pl.tarkiewicz.carowner.Owner.OwnerRepo;

@Component
public class Start {

    private final CarRepo carRepo;
    private final OwnerRepo ownerRepo;

    @Autowired
    public Start(CarRepo carRepo, OwnerRepo ownerRepo) {
        this.carRepo = carRepo;
        this.ownerRepo = ownerRepo;
    }

    @Autowired
    public void Start() {
        Owner owner = new Owner();
        Car car1 = new Car();
        Car car2 = new Car();

        car1.setBrand("Audi");
        car1.setName("A7");
        car1.setProductionYear(LocalDate.parse("2020-07-07"));
        car1.setCarCategory(CarCategory.BENZINE);

        car2.setBrand("Audi");
        car2.setName("A5");
        car2.setProductionYear(LocalDate.parse("2019-07-07"));
        car2.setCarCategory(CarCategory.DIESEL);

        owner.setSurname("Maciek");
        owner.setLastname("Kowalski");

        owner.setCars(Stream.of(car1, car2).collect(Collectors.toSet()));
        car1.setOwnerSet(Stream.of(owner).collect(Collectors.toSet()));
        car2.setOwnerSet(Stream.of(owner).collect(Collectors.toSet()));

        ownerRepo.save(owner);

    }

}
