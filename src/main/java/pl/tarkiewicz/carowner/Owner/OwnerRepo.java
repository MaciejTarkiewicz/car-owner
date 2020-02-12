package pl.tarkiewicz.carowner.Owner;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OwnerRepo extends JpaRepository<Owner,Long> {

    @Query(value = "SELECT OWNER.SURNAME as surname, OWNER.LASTNAME as lastname, CAR_CATEGORY as carCategory, COUNT(CAR_CATEGORY) as countCarCategory FROM CAR \n" +
            "JOIN CAR_OWNER ON CAR.ID = CAR_OWNER.CAR_ID\n" +
            "JOIN OWNER ON OWNER.ID = CAR_OWNER.OWNER_ID\n" +
            "GROUP BY (CAR_CATEGORY,OWNER.SURNAME)", nativeQuery = true)
    List<OwnerCarCategoryDto> getCarsCategory();

}
