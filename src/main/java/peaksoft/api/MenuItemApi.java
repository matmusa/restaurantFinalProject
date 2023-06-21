package peaksoft.api;

import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.response.page.MenuItemPaginationResponse;
import peaksoft.dto.request.MenuItemRequest;
import peaksoft.dto.response.GlobalSearchResponse;
import peaksoft.dto.response.MenuItemResponse;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.service.MenuItemService;

import java.util.List;

@RestController
@RequestMapping("/menuItems")
@RequiredArgsConstructor
public class MenuItemApi {

    private final MenuItemService menuItemService;


    @PostMapping("/{restaurantId}/{subCategories}")
    public SimpleResponse saveMenuItem(@PathVariable Long restaurantId,
                                       @PathVariable Long subCategories,
                                       @RequestBody MenuItemRequest menuItemRequest) {
        return menuItemService.saveMenuItems(restaurantId, subCategories, menuItemRequest);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','CHEF')")
    @PutMapping("/{id}")
    public SimpleResponse updateMenuItemById(@PathVariable Long id,
                                             @RequestBody MenuItemRequest menuItemRequest) {
        return menuItemService.updateMenuItemsById(id, menuItemRequest);

    }

    @PreAuthorize("hasAnyAuthority('ADMIN','CHEF')")
    @DeleteMapping("/{id}")
    public SimpleResponse deleteMenuItemById(@PathVariable Long id) {
        return menuItemService.deleteMenuItemsById(id);

    }

    @PermitAll
    @GetMapping("/get/{id}")
    public MenuItemResponse getMenuItemById(@PathVariable Long id) {
        return menuItemService.getMenuItemsById(id);
    }

    @PermitAll
    @GetMapping("/filter")
    public List<MenuItemResponse> getAllMenuItemsFilterByVegetarian(@RequestParam Boolean isVegetarian) {
        return menuItemService.getAllMenuItemsFilterByVegetarian(isVegetarian);
    }

    @PermitAll
    @GetMapping("/ascOrDesc")
    public List<MenuItemResponse> getAllMenuItemsOrderByPrice(@RequestParam String ascOrDesc) {
        return menuItemService.getAllMenuItemsOrderByPrice(ascOrDesc);
    }

    @PermitAll
    @GetMapping("/search")
    public GlobalSearchResponse globalSearchResponse(@RequestParam String word) {
        return menuItemService.globalSearchResponse(word);
    }
    @PermitAll
    @GetMapping("/{id}")
    public MenuItemPaginationResponse getAllByPagination(@PathVariable Long id,
                                                         @RequestParam int page,
                                                         @RequestParam int size) {
        return menuItemService.getPagination(id, page, size);

    }

}
