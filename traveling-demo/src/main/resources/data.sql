-- Flight
insert into Flight (number, departure, destination, date_flight, time_departure, time_arrival, status, price, type_flight, seats) values ('AA10000', 'Hong Kong (HKG)', 'Kunming (KMG)', '2015-08-05', '10:30:00', '16:20:00', 'available', '450,00', 'HK Express', 200);
insert into Flight (number, departure, destination, date_flight, time_departure, time_arrival, status, price, type_flight, seats) values ('AA20000', 'Kunming (KMG)', 'Hong Kong (HKG)', '2015-08-05', '20:30:00', '23:20:00', 'available', '450,00', 'HK Express', 200);

-- Guest
insert into Guest (id, title, first_name, last_name, date_birth, id_document) values ('1', 'Mr', 'Mario', 'Rossi', '1973-11-22', '1');

-- Document
insert into Document (id, number, country, date_expire) values ('1', 'AA12OO', 'Italy', '2017-11-22');

-- Baggage
insert into Baggage (id, quantity, type_baggage, price) values ('1', '20kg', 'Sports Equipment', 'HKD 150');
insert into Baggage (id, quantity, type_baggage, price) values ('2', '25kg', 'Sports Equipment', 'HKD 200');
insert into Baggage (id, quantity, type_baggage, price) values ('3', '30kg', 'Sports Equipment', 'HKD 250');