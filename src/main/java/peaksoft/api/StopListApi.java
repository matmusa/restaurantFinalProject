package peaksoft.api;

import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.StopListRequest;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.dto.response.StopListResponse;
import peaksoft.service.StopListService;

import java.util.List;

@RestController
@RequestMapping("/stopLists")
@RequiredArgsConstructor
public class StopListApi {
    private final StopListService service;

    @PermitAll
    @GetMapping
    public List<StopListResponse> getAllStopList() {
        return service.getAllStopList();
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','CHEF')")
    @PostMapping("/{id}")
    public SimpleResponse saveStopList(@PathVariable Long id,
                                       @RequestBody StopListRequest stopListRequest) {
        return service.saveStopList(id, stopListRequest);
    }

    @PermitAll
    @GetMapping("/{id}")
    public StopListResponse getStopListById(@PathVariable Long id) {
        return service.getStopListById(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','CHEF')")
    @PutMapping("/{id}")
    public SimpleResponse updateStopListById(@PathVariable Long id,
                                             @RequestBody StopListRequest stopListRequest) {
        return service.updateStopListById(id, stopListRequest);
    }
    @PreAuthorize("hasAnyAuthority('ADMIN','CHEF')")
    @DeleteMapping("/{id}")
    public SimpleResponse deleteStopListById(@PathVariable Long id) {
        return service.deleteStopListById(id);

    }
}
