package pl.tarkiewicz.carowner.Owner;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import pl.tarkiewicz.carowner.Car.Car;

@Entity
@Table(name = "Owner")
public class Owner {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String surname;
    private String lastname;

    @ManyToMany
    @JoinTable(name = "car_owner",
            joinColumns = { @JoinColumn(name = "onwer_id") },
            inverseJoinColumns = { @JoinColumn(name = "car_id") })
    private Set<Car> carSet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Set<Car> getCars() {
        return carSet;
    }

    public void setCars(Set<Car> carSet) {
        this.carSet = carSet;
    }
}
