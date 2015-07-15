-- Flight
CREATE TABLE Flight (
id INT NOT NULL AUTO_INCREMENT
, number VARCHAR(8)
, departure VARCHAR(60) NOT NULL
, destination VARCHAR(60) NOT NULL    
, date_flight DATE
, time_departure TIME
, time_arrival TIME
, status VARCHAR(20) NOT NULL    
, price VARCHAR(12) NOT NULL
, type_flight VARCHAR(60) NOT NULL    
, UNIQUE uq_flight_1 (number)
, PRIMARY KEY (id)
);

-- Guest
CREATE TABLE Guest (
id INT NOT NULL AUTO_INCREMENT
, title VARCHAR(4)
, first_name VARCHAR(100) NOT NULL
, last_name VARCHAR(100) NOT NULL    
, date_birth DATE
, UNIQUE uq_guest_1 (first_name, last_name, date_birth)
, PRIMARY KEY (id)
);

