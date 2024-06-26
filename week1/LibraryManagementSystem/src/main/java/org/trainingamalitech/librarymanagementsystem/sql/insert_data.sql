-- Use the database
USE LibraryManagement;

INSERT INTO Book (isbn, title, author, publisher, year) VALUES
('978-0135166307', 'Effective Java', 'Joshua Bloch', 'Addison-Wesley', 2018),
('978-0596009205', 'Head First Java', 'Kathy Sierra, Bert Bates', "O'Reilly Media", 2005),
('978-0321356680', 'Java Concurrency in Practice', 'Brian Goetz', 'Addison-Wesley', 2006);

INSERT INTO Patron (id, name, address, phoneNumber) VALUES
('P001', 'Alice Johnson', '123 Maple St', '555-1234'),
('P002', 'Bob Smith', '456 Oak St', '555-5678'),
('P003', 'Carol White', '789 Pine St', '555-9012');

INSERT INTO Transaction ( resourceId, patronId, borrowDate, returnDate) VALUES
('978-0135166307', 'P001', '2023-01-10', '2023-01-20'),
('978-0596009205', 'P002', '2023-01-15', NULL);

INSERT INTO Reservation ( resourceId, patronId, reservationDate) VALUES
('978-0321356680', 'P003', '2023-01-18');
