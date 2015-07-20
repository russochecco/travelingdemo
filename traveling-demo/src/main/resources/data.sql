-- Flight
insert into flight (flight_id, number, departure, destination, date_flight, time_departure, time_arrival, status, price, flight_type) values ('1', 'AA10000', 'Hong Kong (HKG)', 'Kunming (KMG)', '2015-08-05', '10:30:00', '16:20:00', 'available', '450.00', 'HK Express');
insert into flight (flight_id, number, departure, destination, date_flight, time_departure, time_arrival, status, price, flight_type) values ('2', 'AA20000', 'Kunming (KMG)', 'Hong Kong (HKG)', '2015-08-05', '20:30:00', '23:20:00', 'available', '450.00', 'HK Express');

-- Baggage
insert into baggage (baggage_id, quantity, baggage_type, price) values ('1', '20kg', 'Sports Equipment', '150.00');
insert into baggage (baggage_id, quantity, baggage_type, price) values ('2', '25kg', 'Sports Equipment', '200.00');
insert into baggage (baggage_id, quantity, baggage_type, price) values ('3', '30kg', 'Sports Equipment', '250.00');
insert into baggage (baggage_id, quantity, baggage_type, price) values ('4', '20kg', 'Personal', '150.00');

-- Guest
insert into guest (guest_id, title, first_name, last_name, date_birth) values ('1', 'Mr', 'Mario', 'Rossi', '1973-11-22');
insert into guest (guest_id, title, first_name, last_name, date_birth) values ('2', 'Mr', 'Mario', 'Rossi', '1982-10-12');
insert into guest (guest_id, title, first_name, last_name, date_birth) values ('3', 'Mrs', 'Maria', 'Bianchi', '1970-05-23');
insert into guest (guest_id, title, first_name, last_name, date_birth) values ('4', 'Mr', 'Paolo', 'Neri', '1969-01-21');

-- Passport
insert into passport (passport_id, number, country, date_expire) values ('1', 'AA12OO', 'Italy', '2017-11-22');
insert into passport (passport_id, number, country, date_expire) values ('2', 'AA13OO', 'Italy', '2018-11-21');
insert into passport (passport_id, number, country, date_expire) values ('3', 'AA14OO', 'Italy', '2016-01-20');
insert into passport (passport_id, number, country, date_expire) values ('4', 'AA15OO', 'Italy', '2019-09-12');

-- CreditCard
insert into credit_card (credit_card_id, number, credit_card_type, date_expire) values ('1', 'AAAAAABBBBB1010', 'Visa', '2020-11-22');
insert into credit_card (credit_card_id, number, credit_card_type, date_expire) values ('2', 'EAAAAABBBBB1010', 'Visa', '2020-11-22');
insert into credit_card (credit_card_id, number, credit_card_type, date_expire) values ('3', 'GAAAAABBBBB1010', 'Master Card', '2020-11-22');
insert into credit_card (credit_card_id, number, credit_card_type, date_expire) values ('4', 'AGAAAABBBBB1010', 'Visa', '2020-11-22');

-- GuestFlight
insert into guest_flight (guest_flight_id, guest_id, flight_id) values ('1', '1', '1');
insert into guest_flight (guest_flight_id, guest_id, flight_id) values ('2', '1', '2');
insert into guest_flight (guest_flight_id, guest_id, flight_id) values ('3', '3', '1');

-- GuestBaggage
insert into guest_baggage (guest_baggage_id, guest_id, baggage_id, flight_id) values ('1', '1', '1', '1');
insert into guest_baggage (guest_baggage_id, guest_id, baggage_id, flight_id) values ('2', '1', '4', '2');
insert into guest_baggage (guest_baggage_id, guest_id, baggage_id, flight_id) values ('3', '4', '1', '2');

-- Booking
insert into booking (booking_id, flight_id, guest_id, seat, date_booking, amount_payment, date_payment) values ('1', '1', '1', 'A1', '2015-08-01', '450.0', '2015-08-01');
insert into booking (booking_id, flight_id, guest_id, seat, date_booking, amount_payment, date_payment) values ('2', '2', '1', 'A2', '2015-08-01', null, null);
insert into booking (booking_id, flight_id, guest_id, seat, date_booking, amount_payment, date_payment) values ('3', '2', '4', 'A1', '2015-10-01', null, null);