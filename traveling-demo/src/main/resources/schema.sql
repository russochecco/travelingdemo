-- Flight
CREATE TABLE Flight (
id INT NOT NULL AUTO_INCREMENT
, number VARCHAR(8)
, departure VARCHAR(60) NOT NULL
, destination VARCHAR(60) NOT NULL    
, date_flight DATE NOT NULL
, time_departure VARCHAR(8) NOT NULL
, time_arrival VARCHAR(8) NOT NULL
, status VARCHAR(20) NOT NULL    
, price VARCHAR(8) NOT NULL
, type_flight VARCHAR(60) NOT NULL
, seats INT NOT NULL
, UNIQUE uq_flight (number)
, PRIMARY KEY (id)
);

-- Guest
CREATE TABLE Guest (
id INT NOT NULL AUTO_INCREMENT
, title VARCHAR(4)
, first_name VARCHAR(100) NOT NULL
, last_name VARCHAR(100) NOT NULL    
, date_birth DATE NOT NULL
, id_document INT NOT NULL
, UNIQUE uq_guest (first_name, last_name, date_birth)
, PRIMARY KEY (id)
);

-- Document
CREATE TABLE Document (
id INT NOT NULL AUTO_INCREMENT
, number VARCHAR(10) NOT NULL
, country  VARCHAR(20) NOT NULL
, date_expire DATE NOT NULL
, UNIQUE uq_document (number)
, PRIMARY KEY (id)
);

-- Baggage
CREATE TABLE Baggage (
id INT NOT NULL AUTO_INCREMENT
, quantity VARCHAR(4) NOT NULL
, type_baggage VARCHAR(16) NOT NULL
, price VARCHAR(8) NOT NULL
, PRIMARY KEY (id)
);

-- GuestBaggage
CREATE TABLE GuestBaggage (
id INT NOT NULL AUTO_INCREMENT
, id_guest INT NOT NULL
, id_baggage INT NOT NULL
, PRIMARY KEY (id)
);

-- Booking
CREATE TABLE Booking (
id INT NOT NULL AUTO_INCREMENT
, id_flight INT NOT NULL
, id_guest INT NOT NULL
, id_seat INT NOT NULL
, date_booking DATE NOT NULL
, PRIMARY KEY (id)
);
