CREATE TABLE IF NOT EXISTS Species(
    id serial PRIMARY KEY,
    name character varying NOT NULL,
    heart_rate_high_limit integer NOT NULL,
    heart_rate_low_limit integer NOT NULL,
    normal_temperature double precision NOT NULL,
    icon_url character varying NOT NULL
);

CREATE TABLE IF NOT EXISTS National_park(
    id serial PRIMARY KEY,
    name character varying NOT NULL,
    country character varying NOT NULL,
    region character varying,
    longitude double precision NOT NULL,
    latitude double precision NOT NULL
);

CREATE TABLE IF NOT EXISTS Animal(
    id serial PRIMARY KEY,
    name character varying NOT NULL,
    date_of_birth date,
    species int NOT NULL,
    national_park_id int,
    FOREIGN KEY (species) REFERENCES Species(id),
    CONSTRAINT fk_national_park FOREIGN KEY (national_park_id) REFERENCES National_park(id),
    CONSTRAINT fk_species_id FOREIGN KEY (species) REFERENCES Species(id)
);



CREATE TABLE IF NOT EXISTS Worker(
  id serial PRIMARY KEY,
  name character varying NOT NULL,
  surname character varying NOT NULL,
  password character varying NOT NULL,
  date_of_birth date NOT NULL,
  national_park_id int NOT NULL,
  role character varying NOT NULL,
  CONSTRAINT fk_national_park FOREIGN KEY (national_park_id) REFERENCES National_park(id)
);

CREATE TABLE IF NOT EXISTS Vaccine(
    id serial PRIMARY KEY,
    name character varying NOT NULL,
    disease character varying NOT NULL,
    periodicity character varying NOT NULL
);

CREATE TABLE IF NOT EXISTS Animal_vaccination(
    id int PRIMARY KEY,
    vaccine_id int NOT NULL,
    animal_id int NOT NULL,
    date date NOT NULL,
    doze double precision NOT NULL,
    CONSTRAINT fk_vaccine FOREIGN KEY (vaccine_id) REFERENCES Vaccine(id),
    CONSTRAINT fk_animal FOREIGN KEY (animal_id) REFERENCES Animal(id)
);

