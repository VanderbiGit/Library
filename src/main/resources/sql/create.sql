CREATE TABLE IF NOT EXISTS users (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    user_name VARCHAR(25) NOT NULL,
    sur_name VARCHAR(25) NOT NULL,
    address VARCHAR(50) NOT NULL,
    email VARCHAR(25) UNIQUE NOT NULL,
    phone_number VARCHAR(15) NOT NULL
);

insert into users (user_name, sur_name, address, email, phone_number)
values ('Tom', 'Wilson', 'New York, 1st, 4/3', 'tomi.bro@gmail.com', '4700122444');
insert into users (user_name, sur_name, address, email, phone_number)
values ('Jack', 'Smit', 'New York, 3ave, 76, apartment 45', 'jajo@gmail.com', '047-411-32-54');

CREATE TYPE enum_user_role AS ENUM ('ADMIN', 'MANAGER', 'LIBRARIAN', 'WORKER', 'USER');
CREATE TYPE enum_user_status AS ENUM ('ACTIVATED', 'CLOSE', 'REMOVE', 'WORK');
select enum_range(null::enum_user_role);
drop type enum_user_role;

CREATE TABLE IF NOT EXISTS users_info(
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES users(id),
    registrate_time TIMESTAMP,
    last_visit_time TIMESTAMP,
    balance MONEY,
    role enum_user_role,
    status enum_user_status
);


insert into users_info values (1, '2016-06-22 19:10:25-07', '2016-06-22 20:10:25-07', 100, 'ADMIN', 'ACTIVATED');
insert into users_info values (2, '2016-06-22 19:10:25-07', '2016-06-22 20:10:25-07', 100, 'MANAGER', 'ACTIVATED');

CREATE TABLE IF NOT EXISTS user_credential(
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES users(id),
    password_hash varchar(255) NOT NULL
);

insert into user_credential (id, password_hash)
values (1, 'qwerty1_need_hash'), (2, 'qwerty2_need_hash');

CREATE TABLE IF NOT EXISTS book(
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name varchar(255) NOT NULL,
    genre varchar(25) NOT NULL,
    annotations varchar(255) NOT NULL,
    printed_date TIMESTAMP NOT NULL,
    publisher varchar(50) NOT NULL,
    language_book varchar(25) NOT NULL,
    page_size INT NOT NULL
);

CREATE TABLE IF NOT EXISTS author(
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name varchar(255) NOT NULL,
    sur_name varchar(25) NOT NULL,
    birthday TIMESTAMP NOT NULL,
    date_death TIMESTAMP NOT NULL,
    short_bio varchar(500) NOT NULL,
    address varchar(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS books_authors(
    author_id INT NOT NULL,
    book_id INT NOT NULL,
    PRIMARY KEY (author_id, book_id),
    FOREIGN KEY (author_id) REFERENCES author(id),
    FOREIGN KEY (book_id) REFERENCES book(id)
);

INSERT INTO book (name, genre, annotations, printed_date, publisher, language_book, page_size)
VALUES
('The Great Gatsby', 'Fiction', 'A classic novel set in the 1920s.', '1925-04-10 00:00:00', 'Scribner', 'English', 180),
('To Kill a Mockingbird', 'Fiction', 'A novel about racial injustice in the American South.', '1960-07-11 00:00:00', 'J.B. Lippincott & Co.', 'English', 281),
('Moby-Dick', 'Adventure', 'A story about a captains obsession with a great white whale.', '1851-10-18 00:00:00', 'Harper & Brothers', 'English', 635);

INSERT INTO author (name, sur_name, birthday, date_death, short_bio, address)
VALUES
('F. Scott', 'Fitzgerald', '1896-09-24 00:00:00', '1940-12-21 00:00:00', 'An American novelist, widely regarded as one of the greatest writers of the 20th century.', 'Minnesota, USA'),
('Harper', 'Lee', '1926-04-28 00:00:00', '2016-02-19 00:00:00', 'An American author best known for her novel "To Kill a Mockingbird."', 'Monroeville, Alabama, USA'),
('Herman', 'Melville', '1819-08-01 00:00:00', '1891-09-28 00:00:00', 'An American novelist, short story writer, and poet of the American Renaissance period.', 'New York City, USA');


INSERT INTO books_authors (author_id, book_id)
VALUES (1, 1),(2, 2), (3, 3);


CREATE TABLE IF NOT EXISTS book_status(
    id INT PRIMARY KEY,
    price INT NOT NULL,
    discount INT,
    location varchar(100) NOT NULL,
    additional_information varchar(255) NOT NULL,
    FOREIGN KEY (id) REFERENCES book(id)
);

INSERT INTO book_status(id, price, discount, location, additional_information)
VALUES (1, 100, 20, 'User', 'This book took user'),
(2, 1000, 3, 'Storage', 'This book palace in storage, not library'),
(3, 200, 5, 'Library', 'Flor 1, Section B, Shelf 23');

CREATE TABLE IF NOT EXISTS users_books(
    user_id INT NOT NULL,
    book_id INT NOT NULL,
    PRIMARY KEY (user_id, book_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (book_id) REFERENCES book(id)
);

INSERT INTO users_books(user_id, book_id)
VALUES (1,1),(2,2);

