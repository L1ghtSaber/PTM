INSERT INTO route (departure_time, arrival_time, departure_point, arrival_point, transport_type)
VALUES
    ('2023-10-20 08:00:00', '2023-10-20 12:00:00', 'Москва', 'Санкт-Петербург', 'RAILWAY'),
    ('2023-10-20 09:30:00', '2023-10-20 11:30:00', 'Москва', 'Санкт-Петербург', 'AIR');

INSERT INTO route_stops (route_id, arrival_time, departure_time, stop_point, transport_type, stop_type)
VALUES
    (1, '2023-10-20 10:00:00', '2023-10-20 10:15:00', 'Тверь', 'RAILWAY', 'TRANSIT'),
    (1, '2023-10-20 11:30:00', '2023-10-20 11:45:00', 'Вышний Волочек', 'RAILWAY', 'TRANSIT');