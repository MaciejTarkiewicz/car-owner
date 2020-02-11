package pl.tarkiewicz.carowner.Owner;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {

    private final OwnerRepo ownerRepo;

    @Autowired
    public OwnerService(OwnerRepo ownerRepo) {
        this.ownerRepo = ownerRepo;
    }

    List<OwnerDto> getOwners() {
        return ownerRepo.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }


    public OwnerDto convertToDto(Owner owner) {
        return OwnerDto.builder()
                .surname(owner.getSurname())
                .lastname(owner.getLastname())
                .build();
    }
}
