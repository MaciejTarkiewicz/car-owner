package pl.tarkiewicz.carowner;

import java.util.List;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import pl.tarkiewicz.carowner.Owner.OwnerCarCategoryDto;
import pl.tarkiewicz.carowner.Owner.OwnerRepo;

@Route
public class Gui extends VerticalLayout {

    private OwnerRepo ownerRepo;

    public Gui(OwnerRepo ownerRepo) {
        this.ownerRepo = ownerRepo;
        List<OwnerCarCategoryDto> ownerList = ownerRepo.getCarsCategory();
        Grid<OwnerCarCategoryDto> grid = new Grid<>(OwnerCarCategoryDto.class);
        grid.setItems(ownerList);
        add(grid);

    }



}
