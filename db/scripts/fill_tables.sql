-- Insert mock data into the route table
INSERT INTO delivery_service.route (route_date, route_stat)
VALUES
  ('2023-05-22 09:00:00', 'STARTED'),
  ('2023-05-22 10:30:00', 'DONE'),
  ('2023-05-22 11:45:00', 'NOT_STARTED');

-- Insert mock data into the stops table
INSERT INTO delivery_service.stops (route_id, description, address, latitude, longitude, stop_stat, delivery_radius)
VALUES
  (1, 'Stop 1', 'Address 1', 40.7128, -74.0060, 'NOT_ANSWER', 100),
  (1, 'Stop 2', 'Address 2', 34.0522, -118.2437, 'ANSWER', 150),
  (2, 'Stop 3', 'Address 3', 51.5074, -0.1278, 'ANSWER', 200),
  (2, 'Stop 4', 'Address 4', 48.8566, 2.3522, 'NOT_ANSWER', 120),
  (3, 'Stop 5', 'Address 5', 39.9042, 116.4074, 'NOT_ANSWER', 180),
  (3, 'Stop 6', 'Address 6', 39.9042, 116.4074, 'NOT_ANSWER', 180);
