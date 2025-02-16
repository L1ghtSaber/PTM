package com.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    public List<Route> findClosestRoutes(LocalDateTime desiredTime, String transportTypeName) {
        TransportType transportType = TransportType.getByName(transportTypeName);
        return routeRepository.findClosestRoutes(desiredTime, transportType);
    }

    public List<Route> getAllRoutesGroupedByDateTime() {
        return routeRepository.findAllByOrderByDepartureTimeAsc()
                .stream()
                .sorted(Comparator.comparing(Route::getDepartureTime))
                .collect(Collectors.toList());
    }

    // Методы для бронирования и отмены билетов можно добавить здесь
}
