package pl.tarkiewicz.carowner.Owner;

public class OwnerDto {

    private String surname;
    private String lastname;

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSurname() {
        return surname;
    }

    public String getLastname() {
        return lastname;
    }

    static Builder builder() {
        return new Builder();
    }

    public static final class Builder {

        private String surname;
        private String lastname;

        Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        Builder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        OwnerDto build() {
            OwnerDto ownerDto = new OwnerDto();
            ownerDto.setSurname(surname);
            ownerDto.setLastname(lastname);
            return ownerDto;
        }
    }

}
