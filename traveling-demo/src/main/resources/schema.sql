-- Flight
CREATE TABLE flight (
flight_id BIGINT NOT NULL AUTO_INCREMENT
, number VARCHAR(8) NOT NULL
, departure VARCHAR(60) NOT NULL
, destination VARCHAR(60) NOT NULL    
, date_flight DATE NOT NULL
, time_departure VARCHAR(8) NOT NULL
, time_arrival VARCHAR(8) NOT NULL
, status VARCHAR(20) NOT NULL    
, price VARCHAR(8) NOT NULL
, flight_type VARCHAR(60) NOT NULL
, UNIQUE uq_flight (number)
, PRIMARY KEY (flight_id)
);

-- Baggage
CREATE TABLE baggage (
baggage_id BIGINT NOT NULL AUTO_INCREMENT
, quantity VARCHAR(4) NOT NULL
, baggage_type VARCHAR(16) NOT NULL
, price VARCHAR(8) NOT NULL
, PRIMARY KEY (baggage_id)
);

-- Guest
CREATE TABLE guest (
guest_id BIGINT NOT NULL AUTO_INCREMENT
, title VARCHAR(4) NOT NULL
, first_name VARCHAR(100) NOT NULL
, last_name VARCHAR(100) NOT NULL    
, date_birth DATE NOT NULL
, UNIQUE uq_guest_1 (first_name, last_name, date_birth)
, PRIMARY KEY (guest_id)
);

-- Passport
CREATE TABLE passport (
passport_id BIGINT NOT NULL AUTO_INCREMENT
, number VARCHAR(10) NOT NULL
, country  VARCHAR(20) NOT NULL
, date_expire DATE NOT NULL
, UNIQUE uq_passport (number)
, PRIMARY KEY (passport_id)
);

-- CreditCard
CREATE TABLE credit_card (
credit_card_id BIGINT NOT NULL
, number VARCHAR(20) NOT NULL
, credit_card_type  VARCHAR(20) NOT NULL
, date_expire DATE NOT NULL
, UNIQUE uq_credit_card (number)
, PRIMARY KEY (credit_card_id)
);

-- GuestBaggage
CREATE TABLE guest_baggage (
guest_baggage_id BIGINT NOT NULL AUTO_INCREMENT
, guest_id BIGINT NOT NULL
, baggage_id BIGINT NOT NULL
, flight_id BIGINT NOT NULL
, PRIMARY KEY (guest_baggage_id)
, CONSTRAINT fk_guest_baggage_1 FOREIGN KEY (guest_id) REFERENCES guest (guest_id)
);

-- GuestFlight
CREATE TABLE guest_flight (
guest_flight_id BIGINT NOT NULL AUTO_INCREMENT
, guest_id BIGINT NOT NULL
, flight_id BIGINT NOT NULL
, PRIMARY KEY (guest_flight_id)
);

-- Booking
CREATE TABLE booking (
booking_id BIGINT NOT NULL AUTO_INCREMENT
, flight_id BIGINT NOT NULL
, guest_id BIGINT NOT NULL
, seat VARCHAR(6) NOT NULL
, date_booking DATE NOT NULL
, amount_payment VARCHAR(6)
, date_payment DATE NULL
, UNIQUE uq_booking (flight_id, guest_id, seat)
, PRIMARY KEY (booking_id)
);

-- Payment
CREATE TABLE payment (
payment_id BIGINT NOT NULL
, amount VARCHAR(6) NOT NULL
, date_payment DATE NOT NULL
, PRIMARY KEY (payment_id)
);