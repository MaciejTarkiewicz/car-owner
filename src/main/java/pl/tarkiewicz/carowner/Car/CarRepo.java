package pl.tarkiewicz.carowner.Car;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<Car,Long> {

}
