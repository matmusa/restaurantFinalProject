package peaksoft.api;

import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.response.AllChequeResponse;
import peaksoft.dto.response.page.ChequePaginationResponse;
import peaksoft.dto.response.ChequeResponse;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.service.ChequeService;

import java.util.List;

@RestController
@RequestMapping("/cheques")
@RequiredArgsConstructor
public class ChequeApi {

    private final ChequeService chequeService;

    @PermitAll
    @GetMapping("/{id}")
    public List<ChequeResponse> getAllCheques(@PathVariable Long id) {
        return chequeService.getAllChequesByUserId(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','CHEF')")
    @PostMapping("/{id}/{menuItemsId}")
    public SimpleResponse saveCheque(@PathVariable Long id, @PathVariable Long menuItemsId) {
        return chequeService.saveCheque(id, menuItemsId);
    }

    @PermitAll
    @GetMapping("/get/{id}")
    public ChequeResponse getChequeById(@PathVariable Long id) {
        return chequeService.getChequesById(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','CHEF')")
    @DeleteMapping("/{id}")
    public SimpleResponse deleteChequeById(@PathVariable Long id) {
        return chequeService.deleteChequeById(id);
    }

    @PermitAll
    @GetMapping("all/{id}")
    List<AllChequeResponse> getAllInformationFromUser(@PathVariable Long id) {
        return chequeService.getFullInformationFromUser(id);
    }
    @PermitAll
    @GetMapping("/sum/{restaurantId}")
    public Double getAllChecksSumsFromRestaurant(@PathVariable Long restaurantId) {
        return chequeService.getAllChecksSumsFromRestaurant(restaurantId);

    }
    @PermitAll
    @GetMapping("/page/{id}")
    public ChequePaginationResponse getAllByPagination(@PathVariable Long id,
                                                       @RequestParam int page,
                                                       @RequestParam int size) {
        return chequeService.getPagination(id, page, size);

    }
}
