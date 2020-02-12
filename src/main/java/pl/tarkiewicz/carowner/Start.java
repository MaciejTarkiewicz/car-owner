package pl.tarkiewicz.carowner;

import java.time.LocalDate;
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
        Owner owner1 = new Owner();
        Owner owner2 = new Owner();
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();
        Car car5 = new Car();

        car1.setBrand("Audi");
        car1.setName("A7");
        car1.setProductionYear(LocalDate.parse("2020-07-07"));
        car1.setCarCategory(CarCategory.BENZINE);

        car2.setBrand("Audi");
        car2.setName("A5");
        car2.setProductionYear(LocalDate.parse("2019-09-09"));
        car2.setCarCategory(CarCategory.DIESEL);

        car3.setBrand("Audi");
        car3.setName("A8");
        car3.setProductionYear(LocalDate.parse("2018-08-08"));
        car3.setCarCategory(CarCategory.DIESEL);

        car4.setBrand("Opel");
        car4.setName("Corsa");
        car4.setProductionYear(LocalDate.parse("2017-07-07"));
        car4.setCarCategory(CarCategory.BENZINE);

        car5.setBrand("Opel");
        car5.setName("Insignia");
        car5.setProductionYear(LocalDate.parse("2016-06-06"));
        car5.setCarCategory(CarCategory.BENZINE);

        owner1.setSurname("Maciek");
        owner1.setLastname("Kowalski");

        owner2.setSurname("Tomasz");
        owner2.setLastname("Nowak");

        owner1.setCars(Stream.of(car1, car2, car3).collect(Collectors.toSet()));
        car1.setOwnerSet(Stream.of(owner1).collect(Collectors.toSet()));
        car2.setOwnerSet(Stream.of(owner1).collect(Collectors.toSet()));
        car3.setOwnerSet(Stream.of(owner1).collect(Collectors.toSet()));

        owner2.setCars(Stream.of(car4, car5).collect(Collectors.toSet()));
        car4.setOwnerSet(Stream.of(owner2).collect(Collectors.toSet()));
        car5.setOwnerSet(Stream.of(owner2).collect(Collectors.toSet()));

        ownerRepo.save(owner1);
        ownerRepo.save(owner2);

    }

}
