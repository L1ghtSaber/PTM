package com.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

    // Поиск ближайших маршрутов по времени и типу транспорта
    @Query("SELECT r FROM Route r WHERE r.transportType = :transportType " +
            "ORDER BY ABS(EXTRACT(EPOCH FROM (r.departureTime - :desiredTime)) ASC")
    List<Route> findClosestRoutes(LocalDateTime desiredTime, TransportType transportType);

    // Все маршруты, сгруппированные по дате/времени (группировка на уровне сервиса)
    List<Route> findAllByOrderByDepartureTimeAsc();
}
