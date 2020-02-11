package pl.tarkiewicz.carowner.Car;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<Car,Long> {

    //List<CarDto> getCarsCategory();

}
