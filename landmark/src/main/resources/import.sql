ALTER TABLE location ALTER COLUMN id SET DEFAULT uuid_in((md5((random())::text))::cstring);
INSERT INTO location (name, address, city, country, rating, price, discount) VALUES ('Rijksmuseum', 'Museumstraat 1', 'Amsterdam', 'Netherlands',4,40,7);
INSERT INTO location(name, address, city, country, rating, price, discount) VALUES ('Van Gogh Museum', 'Museumstraat 6', 'Amsterdam', 'Netherlands',5, 35, 10);
INSERT INTO location(name, address, city, country, rating, price, discount) VALUES ('Hermitage Amsterdam', 'Amstel 51', 'Amsterdam', 'Netherlands',3, 30, 20);
INSERT INTO location(name, address, city, country, rating, price, discount) VALUES ('National Art Museum', 'Calea Victoriei 49-53', 'Bucharest', 'Romania',4, 20, 2);
INSERT INTO location(name, address, city, country, rating, price, discount) VALUES ('National Gallery', 'Trafalgar Square', 'London', 'United Kingdom',4, 30, 8);
INSERT INTO location(name, address, city, country, rating, price, discount) VALUES ('Metropolitan Museum of Art', '1000 5th Ave', 'New York', 'United States',5, 25, 9);