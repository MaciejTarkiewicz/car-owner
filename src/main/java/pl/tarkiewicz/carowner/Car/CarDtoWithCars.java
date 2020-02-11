package pl.tarkiewicz.carowner.Car;

import java.time.LocalDate;
import java.util.Set;

import pl.tarkiewicz.carowner.Owner.OwnerDto;

public class CarDtoWithCars {

    private String brand;
    private String name;
    private LocalDate productionYear;
    private Set<OwnerDto> ownerSet;
    private CarCategory carCategory;

    public void setOwnerSet(Set<OwnerDto> ownerSet) {
        this.ownerSet = ownerSet;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductionYear(LocalDate productionYear) {
        this.productionYear = productionYear;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public LocalDate getProductionYear() {
        return productionYear;
    }

    public Set<OwnerDto> getOwnerSet() {
        return ownerSet;
    }

    public CarCategory getCarCategory() {
        return carCategory;
    }

    public void setCarCategory(CarCategory carCategory) {
        this.carCategory = carCategory;
    }

    static Builder builder() {
        return new Builder();
    }

    static class Builder {

        private String brand;
        private String name;
        private LocalDate productionYear;
        private Set<OwnerDto> ownerSet;
        private CarCategory carCategory;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        Builder brand(String brand) {
            this.brand = brand;
            return this;
        }

        Builder productionYear(LocalDate productionYear) {
            this.productionYear = productionYear;
            return this;
        }

        Builder ownerSet(Set<OwnerDto> ownerSet) {
            this.ownerSet = ownerSet;
            return this;

        }

        Builder carCategory(CarCategory carCategory) {
            this.carCategory = carCategory;
            return this;
        }

        CarDtoWithCars build() {
            CarDtoWithCars carDtoWithCars = new CarDtoWithCars();
            carDtoWithCars.setBrand(brand);
            carDtoWithCars.setName(name);
            carDtoWithCars.setProductionYear(productionYear);
            carDtoWithCars.setOwnerSet(ownerSet);
            carDtoWithCars.setCarCategory(carCategory);
            return carDtoWithCars;
        }
    }

}
