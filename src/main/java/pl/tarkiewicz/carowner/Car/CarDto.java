package pl.tarkiewicz.carowner.Car;

import java.time.LocalDate;

public class CarDto {

    private String brand;
    private String name;
    private LocalDate productionYear;
    private CarCategory carCategory;

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
        private CarCategory carCategory;

        Builder name(String name) {
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

        Builder carCategory(CarCategory carCategory) {
            this.carCategory = carCategory;
            return this;
        }

        CarDto build() {
            CarDto carDto = new CarDto();
            carDto.setBrand(brand);
            carDto.setName(name);
            carDto.setProductionYear(productionYear);
            carDto.setCarCategory(carCategory);
            return carDto;
        }
    }

}
