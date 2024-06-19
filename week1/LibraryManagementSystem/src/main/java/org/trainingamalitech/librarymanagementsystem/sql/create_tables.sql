-- Create database
CREATE DATABASE LibraryManagement;

-- Use the database
USE LibraryManagement;

-- Create Book table
CREATE TABLE Book (
    isbn VARCHAR(13) PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100),
    publisher VARCHAR(100),
    year INT,
    isAvailable BOOLEAN DEFAULT TRUE
);

-- Create Patron table
CREATE TABLE Patron (
    id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(255),
    phoneNumber VARCHAR(15)
);

-- Create Transaction table
CREATE TABLE Transaction (
    transactionId VARCHAR(10) PRIMARY KEY,
    bookIsbn VARCHAR(13),
    patronId VARCHAR(10),
    borrowDate DATE NOT NULL,
    returnDate DATE,
    FOREIGN KEY (bookIsbn) REFERENCES Book(isbn),
    FOREIGN KEY (patronId) REFERENCES Patron(id)
);

-- Create Reservation table
CREATE TABLE Reservation (
    reservationId VARCHAR(10) PRIMARY KEY,
    bookIsbn VARCHAR(13),
    patronId VARCHAR(10),
    reservationDate DATE NOT NULL,
    FOREIGN KEY (bookIsbn) REFERENCES Book(isbn),
    FOREIGN KEY (patronId) REFERENCES Patron(id)
);
