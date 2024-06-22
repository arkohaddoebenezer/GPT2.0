-- Create database
CREATE DATABASE LibraryManagement;

-- Use the database
USE LibraryManagement;

CREATE TABLE Resource (
    id VARCHAR(13) PRIMARY KEY,
    type VARCHAR(10) NOT NULL,
);
-- Create Book table
CREATE TABLE Book (
    isbn VARCHAR(13) PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100),
    publisher VARCHAR(100),
    year INT(10),
    date_added VARCHAR(100),
    isAvailable BOOLEAN DEFAULT TRUE
);

CREATE TABLE DVD (
    ISS VARCHAR(13) PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100),
    year INT(10),
    date_added VARCHAR(100),
    isAvailable BOOLEAN DEFAULT TRUE
);

CREATE TABLE Journal (
    ISS VARCHAR(13) PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100),
    publisher VARCHAR(100),
    year INT(10),
    date_added VARCHAR(100),
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
    resourceType VARCHAR(13)
    resourceId VARCHAR(13),
    patronId VARCHAR(10),
    borrowDate VARCHAR(100) NOT NULL,
    returnDate VARCHAR(100),
    FOREIGN KEY (resourceId) REFERENCES Resource(id),
    FOREIGN KEY (patronId) REFERENCES Patron(id)
);

-- Create Reservation table
CREATE TABLE Reservation (
    reservationId VARCHAR(10) PRIMARY KEY,
    resourceType VARCHAR(13),
    resourceId VARCHAR(13),
    patronId VARCHAR(10),
    reservationDate VARCHAR(100) NOT NULL,
    FOREIGN KEY (resourceId) REFERENCES Resource(id),
    FOREIGN KEY (patronId) REFERENCES Patron(id)
);
