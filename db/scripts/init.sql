CREATE SCHEMA IF NOT EXISTS delivery_service
    AUTHORIZATION postgres;

-- Create the route table if it doesn't already exist
CREATE TABLE IF NOT EXISTS delivery_service.route(
  id SERIAL PRIMARY KEY,
  route_date TIMESTAMP,
  route_stat varchar
);


-- Create the stops table if it doesn't already exist-- Create the route table if it doesn't already exist
CREATE TABLE IF NOT EXISTS delivery_service.stops (
  id SERIAL PRIMARY KEY,
  route_id INT not null,
  description varchar,
  address varchar,
  latitude FLOAT,
  longitude FLOAT,
  stop_stat varchar,
  delivery_radius INT,
  FOREIGN KEY (route_id) REFERENCES delivery_service.route(id)
);