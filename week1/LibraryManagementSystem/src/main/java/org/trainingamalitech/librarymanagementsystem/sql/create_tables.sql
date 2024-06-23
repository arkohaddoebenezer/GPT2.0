-- Create database
CREATE DATABASE LibraryManagement;

-- Use the database
USE LibraryManagement;

-- Create
CREATE TABLE Resource (
    resourceType VARCHAR(13),
    resourceId VARCHAR(13)
);
-- Create Book table
CREATE TABLE Book (
    isbn VARCHAR(13) PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100),
    publisher VARCHAR(100),
    year INT(10),
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    isAvailable BOOLEAN DEFAULT TRUE
);

CREATE TABLE DVD (
    ISS VARCHAR(13) PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100),
    year INT(10),
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    isAvailable BOOLEAN DEFAULT TRUE
);

CREATE TABLE Journal (
    ISS VARCHAR(13) PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100),
    publisher VARCHAR(100),
    year INT(10),
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    isAvailable BOOLEAN DEFAULT TRUE
);

-- Create Patron table
CREATE TABLE Patron (
    id int AUTO_INCREMENT PRIMARY KEY ,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(255),
    phoneNumber VARCHAR(15),
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Create Transaction table
CREATE TABLE Transaction (
    transactionId int AUTO_INCREMENT PRIMARY KEY,
    resourceType VARCHAR(13),
    resourceId VARCHAR(13),
    patronId VARCHAR(10),
    borrowDate VARCHAR(100) NOT NULL,
    returnDate VARCHAR(100),
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (resourceId) REFERENCES Resource(resourceId),
    FOREIGN KEY (patronId) REFERENCES Patron(id)
);

-- Create Reservation table
CREATE TABLE Reservation (
    reservationId int AUTO_INCREMENT PRIMARY KEY,
    resourceType VARCHAR(13),
    resourceId VARCHAR(13),
    patronId VARCHAR(10),
    reservationDate VARCHAR(100) NOT NULL,
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (resourceId) REFERENCES Resource(resourceId),
    FOREIGN KEY (patronId) REFERENCES Patron(id)
);

