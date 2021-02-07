ALTER TABLE event ALTER COLUMN id SET DEFAULT uuid_in((md5((random())::text))::cstring);
INSERT INTO event(name, address, city, country, rating, price, discount, duration) VALUES ('Live Concert', 'Somewhere in Bucharest', 'Bucharest', 'Romania',4,40,7,'3h');
INSERT INTO event(name, address, city, country, rating, price, discount, duration) VALUES ('Vernisage', 'Somewhere in London', 'London', 'United Kingdom',5, 35, 10,'3days');
INSERT INTO event(name, address, city, country, rating, price, discount, duration) VALUES ('Movie Picnic', 'Somewhere in New York', 'New York', 'United States of America',3, 30, 20, '2h');
INSERT INTO event(name, address, city, country, rating, price, discount, duration) VALUES ('Music Festival', 'Somewhere in Bucharest', 'Bucharest', 'Romania',4, 20, 2, '5h');
