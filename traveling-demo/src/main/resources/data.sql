-- Flight
insert into flight (number, departure, destination, date_flight, time_departure, time_arrival, status, price, type_flight) values ('AA10000', 'Hong Kong (HKG)', 'Kunming (KMG)', '2015-08-05', '10:30:00', '16:20:00', 'available', '450,00', 'HK Express');
insert into flight (number, departure, destination, date_flight, time_departure, time_arrival, status, price, type_flight) values ('AA20000', 'Kunming (KMG)', 'Hong Kong (HKG)', '2015-08-05', '20:30:00', '23:20:00', 'available', '450,00', 'HK Express');

-- Passport
insert into passport (id, number, country, date_expire) values ('1', 'AA12OO', 'Italy', '2017-11-22');

-- Guest
insert into guest (id, title, first_name, last_name, date_birth, id_passport) values ('1', 'Mr', 'Mario', 'Rossi', '1973-11-22', '1');

-- Baggage
insert into baggage (id, quantity, type_baggage, price) values ('1', '20kg', 'Sports Equipment', 'HKD 150');
insert into baggage (id, quantity, type_baggage, price) values ('2', '25kg', 'Sports Equipment', 'HKD 200');
insert into baggage (id, quantity, type_baggage, price) values ('3', '30kg', 'Sports Equipment', 'HKD 250');
insert into baggage (id, quantity, type_baggage, price) values ('4', '20kg', 'Personal', 'HKD 150');

-- GuestBaggage
insert into guest_baggage (id, id_guest, id_baggage) values ('1', '1', '1');
insert into guest_baggage (id, id_guest, id_baggage) values ('2', '1', '4');
