DROP SCHEMA public CASCADE;
CREATE SCHEMA public;

--CREATE SECTION
CREATE TYPE enum_account_status AS ENUM ('ACTIVATED', 'CLOSED', 'REMOVED');
CREATE TYPE enum_user_role AS ENUM ('ADMIN', 'MANAGER', 'USER');

CREATE TABLE IF NOT EXISTS address(
    id INT PRIMARY KEY,
    country varchar(100) NOT NULL,
    city varchar(100) NOT NULL,
    street varchar(100) NOT NULL,
    house varchar(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS users (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(25) NOT NULL,
    surname VARCHAR(25) NOT NULL,
    email VARCHAR(25) UNIQUE NOT NULL,
    phone_number VARCHAR(15) NOT NULL,
    address_id INTEGER REFERENCES address(id)
);

CREATE TABLE IF NOT EXISTS book(
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name varchar(255) NOT NULL,
    genre varchar(25) NOT NULL,
    annotations varchar(255) NOT NULL,
    realize TIMESTAMP NOT NULL,
    publisher varchar(50) NOT NULL,
    language_book varchar(25) NOT NULL,
    pages INT NOT NULL
);

CREATE TABLE IF NOT EXISTS author(
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name varchar(255) NOT NULL,
    surname varchar(25) NOT NULL,
    birthday TIMESTAMP NOT NULL,
    date_death TIMESTAMP NOT NULL,
    short_bio varchar(500) NOT NULL,
    address_id INTEGER REFERENCES address(id)
);

CREATE TABLE IF NOT EXISTS users_info(
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES users(id),
    registered TIMESTAMP,
    last_visit TIMESTAMP,
    role enum_user_role,
    status enum_account_status
);

CREATE TABLE IF NOT EXISTS user_credential(
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES users(id),
    password_hash varchar(512) NOT NULL
);

CREATE TABLE IF NOT EXISTS books_authors(
    author_id INT NOT NULL,
    book_id INT NOT NULL,
    PRIMARY KEY (author_id, book_id),
    FOREIGN KEY (author_id) REFERENCES author(id),
    FOREIGN KEY (book_id) REFERENCES book(id)
);

CREATE TABLE IF NOT EXISTS book_info(
    id INT PRIMARY KEY,
    price INT,
    location varchar(100) NOT NULL,
    note varchar(512) NOT NULL,
    FOREIGN KEY (id) REFERENCES book(id)
);

CREATE TABLE IF NOT EXISTS users_books(
    user_id INT NOT NULL,
    book_id INT NOT NULL,
    PRIMARY KEY (user_id, book_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (book_id) REFERENCES book(id)
);

--INSERT SECTION
INSERT INTO address (id, country, city, street, house)
VALUES
    (1, 'USA', 'New York', 'Broadway', '101A'),
    (2, 'USA', 'New York', 'Manhattan', '56D'),
    (3, 'USA', 'New York', 'Brooklyn', '138W'),
    (4, 'USA', 'New York', 'Bronx', '38W'),
    (5, 'USA', 'New York', 'Queens', '23T'),
    (6, 'USA', 'New York', 'Bronx', '94S');

INSERT INTO users (name, surname, email, phone_number, address_id)
VALUES
    ('John', 'Doe', 'john.doe@example.com', '+1234567890', 1),
    ('Anna', 'Doe', 'anna.doe@example.com', '+1234567890', 2),
    ('Tom', 'Doe', 'tom.doe@example.com', '+1234567890', 3);

INSERT INTO book (name, genre, annotations, realize, publisher, language_book, pages)
VALUES
    ('The Great Gatsby', 'Fiction', 'A classic novel set in the 1920s.', '1925-04-10 00:00:00', 'Scribner', 'English', 180),
    ('To Kill a Mockingbird', 'Fiction', 'A novel about racial injustice in the American South.', '1960-07-11 00:00:00', 'J.B. Lippincott & Co.', 'English', 281),
    ('Moby-Dick', 'Adventure', 'A story about a captains obsession with a great white whale.', '1851-10-18 00:00:00', 'Harper & Brothers', 'English', 635);

INSERT INTO author (name, surname, birthday, date_death, short_bio, address_id)
VALUES
    ('F. Scott', 'Fitzgerald', '1896-09-24 00:00:00', '1940-12-21 00:00:00', 'An American novelist, widely regarded as one of the greatest writers of the 20th century.', 4),
    ('Harper', 'Lee', '1926-04-28 00:00:00', '2016-02-19 00:00:00', 'An American author best known for her novel "To Kill a Mockingbird."', 5),
    ('Herman', 'Melville', '1819-08-01 00:00:00', '1891-09-28 00:00:00', 'An American novelist, short story writer, and poet of the American Renaissance period.', 6);

INSERT INTO users_info
VALUES
    (1, '2016-06-22 19:10:25-07', '2016-06-22 20:10:25-07', 'ADMIN', 'ACTIVATED'),
    (2, '2016-06-22 19:10:25-07', '2016-06-22 20:10:25-07', 'MANAGER', 'ACTIVATED'),
    (3, '2016-06-22 19:10:25-07', '2016-06-22 20:10:25-07', 'USER', 'ACTIVATED');

INSERT INTO user_credential (id, password_hash)
VALUES
    (1, 'qwerty1_need_hash'),
    (2, 'qwerty2_need_hash'),
    (3, 'qwerty3_need_hash');

INSERT INTO books_authors (author_id, book_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);

INSERT INTO book_info(id, price, location, note)
VALUES
    (1, 20, 'User', 'This book took user'),
    (2, 3, 'Storage', 'This book palace in storage, not library'),
    (3, 5, 'Library', 'Flor 1, Section B, Shelf 23');

INSERT INTO users_books(user_id, book_id)
VALUES
    (1,1),
    (2,2);

