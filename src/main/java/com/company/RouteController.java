package com.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class RouteController {
    @Autowired
    private RouteService routeService;

    @GetMapping("/search")
    public List<Route> searchRoutes(
            @RequestParam LocalDateTime desiredTime,
            @RequestParam String transportType) {
        return routeService.findClosestRoutes(desiredTime, transportType);
    }

    @GetMapping("/all")
    public List<Route> getAllRoutes() {
        return routeService.getAllRoutesGroupedByDateTime();
    }
}
