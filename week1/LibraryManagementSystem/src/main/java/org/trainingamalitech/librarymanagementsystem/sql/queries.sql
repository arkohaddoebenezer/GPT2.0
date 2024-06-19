-- Common SQL queries

-- Select all books
SELECT * FROM Book;

-- Select all patrons
SELECT * FROM Patron;

-- Select all transactions
SELECT * FROM Transaction;

-- Select all reservations
SELECT * FROM Reservation;

-- Check available books
SELECT * FROM Book WHERE isAvailable = TRUE;

-- Get transactions by patron
SELECT * FROM Transaction WHERE patronId = 'P001';
