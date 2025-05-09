CREATE TYPE enum_user_role AS ENUM ('ADMIN', 'MANAGER', 'LIBRARIAN', 'WORKER', 'USER');
CREATE TYPE enum_user_status AS ENUM ('ACTIVATED', 'CLOSE', 'REMOVE', 'WORK');

CREATE TABLE IF NOT EXISTS users (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    user_name VARCHAR(25) NOT NULL,
    sur_name VARCHAR(25) NOT NULL,
    address VARCHAR(50) NOT NULL,
    email VARCHAR(25) UNIQUE NOT NULL,
    phone_number VARCHAR(15) NOT NULL
);

CREATE TABLE IF NOT EXISTS users_info(
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES users(id),
    registrate_time TIMESTAMP,
    last_visit_time TIMESTAMP,
    balance MONEY,
    role enum_user_role,
    status enum_user_status
);

CREATE TABLE IF NOT EXISTS user_credential(
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES users(id),
    password_hash varchar(255) NOT NULL
);

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

CREATE TABLE IF NOT EXISTS book_status(
    id INT PRIMARY KEY,
    price INT NOT NULL,
    discount INT,
    location varchar(100) NOT NULL,
    additional_information varchar(255) NOT NULL,
    FOREIGN KEY (id) REFERENCES book(id)
);

CREATE TABLE IF NOT EXISTS users_books(
    user_id INT NOT NULL,
    book_id INT NOT NULL,
    PRIMARY KEY (user_id, book_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (book_id) REFERENCES book(id)
);
