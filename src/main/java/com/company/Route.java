package com.company;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Тип транспорта обязателен")
    @Enumerated(EnumType.STRING)
    private TransportType transportType;

    @NotNull(message = "Время отправления обязательно")
    private LocalDateTime departureTime;

    @NotNull(message = "Время прибытия обязательно")
    private LocalDateTime arrivalTime;

    @NotBlank(message = "Пункт отправления обязателен")
    private String departurePoint;

    @NotBlank(message = "Пункт прибытия обязателен")
    private String arrivalPoint;

    @ElementCollection
    @CollectionTable(name = "route_stops", joinColumns = @JoinColumn(name = "route_id"))
    private List<RouteStop> stops;

    public Route() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDeparturePoint() {
        return departurePoint;
    }

    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    public String getArrivalPoint() {
        return arrivalPoint;
    }

    public void setArrivalPoint(String arrivalPoint) {
        this.arrivalPoint = arrivalPoint;
    }

    public List<RouteStop> getStops() {
        return stops;
    }

    public void setStops(List<RouteStop> stops) {
        this.stops = stops;
    }

    @Embeddable
    public static class RouteStop {
        @NotNull(message = "Время прибытия обязательно")
        private LocalDateTime arrivalTime;

        @NotNull(message = "Время отправления обязательно")
        private LocalDateTime departureTime;

        @NotBlank(message = "Пункт остановки обязателен")
        private String stopPoint;

        @Enumerated(EnumType.STRING)
        private TransportType transportType;

        @Enumerated(EnumType.STRING)
        private StopType stopType;

        public LocalDateTime getArrivalTime() {
            return arrivalTime;
        }

        public void setArrivalTime(LocalDateTime arrivalTime) {
            this.arrivalTime = arrivalTime;
        }

        public LocalDateTime getDepartureTime() {
            return departureTime;
        }

        public void setDepartureTime(LocalDateTime departureTime) {
            this.departureTime = departureTime;
        }

        public String getStopPoint() {
            return stopPoint;
        }

        public void setStopPoint(String stopPoint) {
            this.stopPoint = stopPoint;
        }

        public TransportType getTransportType() {
            return transportType;
        }

        public void setTransportType(TransportType transportType) {
            this.transportType = transportType;
        }

        public StopType getStopType() {
            return stopType;
        }

        public void setStopType(StopType stopType) {
            this.stopType = stopType;
        }
    }
}
