-- Flight
CREATE TABLE flight (
id BIGINT NOT NULL AUTO_INCREMENT
, number VARCHAR(8)
, departure VARCHAR(60) NOT NULL
, destination VARCHAR(60) NOT NULL    
, date_flight DATE NOT NULL
, time_departure VARCHAR(8) NOT NULL
, time_arrival VARCHAR(8) NOT NULL
, status VARCHAR(20) NOT NULL    
, price VARCHAR(8) NOT NULL
, type_flight VARCHAR(60) NOT NULL
, UNIQUE uq_flight (number)
, PRIMARY KEY (id)
);

-- Guest
CREATE TABLE guest (
id BIGINT NOT NULL AUTO_INCREMENT
, title VARCHAR(4)
, first_name VARCHAR(100) NOT NULL
, last_name VARCHAR(100) NOT NULL    
, date_birth DATE NOT NULL
, passport_id BIGINT NOT NULL
, credit_card_id BIGINT NOT NULL
, UNIQUE uq_guest (first_name, last_name, date_birth)
, PRIMARY KEY (id)
);

-- Passport
CREATE TABLE passport (
id BIGINT NOT NULL AUTO_INCREMENT
, number VARCHAR(10) NOT NULL
, country  VARCHAR(20) NOT NULL
, date_expire DATE NOT NULL
, UNIQUE uq_passport (number)
, PRIMARY KEY (id)
);

-- CreditCard
CREATE TABLE credit_card (
id BIGINT NOT NULL AUTO_INCREMENT
, number VARCHAR(20) NOT NULL
, credit_card_type  VARCHAR(20) NOT NULL
, date_expire DATE NOT NULL
, UNIQUE uq_credit_card (number)
, PRIMARY KEY (id)
);

-- Baggage
CREATE TABLE baggage (
id BIGINT NOT NULL AUTO_INCREMENT
, quantity VARCHAR(4) NOT NULL
, type_baggage VARCHAR(16) NOT NULL
, price VARCHAR(8) NOT NULL
, PRIMARY KEY (id)
);

-- GuestBaggage
CREATE TABLE guest_baggage (
id BIGINT NOT NULL AUTO_INCREMENT
, guest_id BIGINT NOT NULL
, baggage_id BIGINT NOT NULL
, flight_id BIGINT NOT NULL
, PRIMARY KEY (id)
);

-- Booking
CREATE TABLE booking (
id BIGINT NOT NULL AUTO_INCREMENT
, flight_id BIGINT NOT NULL
, guest_id BIGINT NOT NULL
, seat VARCHAR(6) NOT NULL
, date_booking DATE NOT NULL
, payment_id BIGINT
, UNIQUE uq_booking (flight_id, guest_id, seat)
, PRIMARY KEY (id)
);

-- Payment
CREATE TABLE payment (
id BIGINT NOT NULL AUTO_INCREMENT
, amount VARCHAR(6) NOT NULL
, date_payment DATE NOT NULL
, PRIMARY KEY (id)
);