-- Flight
insert into flight (id, number, departure, destination, date_flight, time_departure, time_arrival, status, price, type_flight) values ('1', 'AA10000', 'Hong Kong (HKG)', 'Kunming (KMG)', '2015-08-05', '10:30:00', '16:20:00', 'available', '450.00', 'HK Express');
insert into flight (id, number, departure, destination, date_flight, time_departure, time_arrival, status, price, type_flight) values ('2', 'AA20000', 'Kunming (KMG)', 'Hong Kong (HKG)', '2015-08-05', '20:30:00', '23:20:00', 'available', '450.00', 'HK Express');

-- Passport
insert into passport (id, number, country, date_expire) values ('1', 'AA12OO', 'Italy', '2017-11-22');

-- CreditCard
insert into credit_card (id, number, credit_card_type, date_expire) values ('1', 'AAAAAABBBBB1010', 'Visa', '2020-11-22');

-- Guest
insert into guest (id, title, first_name, last_name, date_birth, passport_id, credit_card_id) values ('1', 'Mr', 'Mario', 'Rossi', '1973-11-22', '1', '1');

-- Baggage
insert into baggage (id, quantity, type_baggage, price) values ('1', '20kg', 'Sports Equipment', '150.00');
insert into baggage (id, quantity, type_baggage, price) values ('2', '25kg', 'Sports Equipment', '200.00');
insert into baggage (id, quantity, type_baggage, price) values ('3', '30kg', 'Sports Equipment', '250.00');
insert into baggage (id, quantity, type_baggage, price) values ('4', '20kg', 'Personal', '150.00');

-- GuestBaggage
insert into guest_baggage (id, guest_id, baggage_id, flight_id) values ('1', '1', '1', '1');
insert into guest_baggage (id, guest_id, baggage_id, flight_id) values ('2', '1', '4', '2');

-- Booking
insert into booking (id, flight_id, guest_id, seat, date_booking) values ('1', '1', '1', 'A1', '2015-08-01');
insert into booking (id, flight_id, guest_id, seat, date_booking) values ('2', '2', '1', 'A2', '2015-08-01');