package org.trainingamalitech.librarymanagementsystem.model;

import java.util.Date;

public class Reservation {

    private String reservationId;
    private String bookIsbn;
    private String patronId;
    private Date reservationDate;

    public Reservation() {
    }

    public Reservation(String reservationId, String bookIsbn, String patronId, Date reservationDate) {
        this.reservationId = reservationId;
        this.bookIsbn = bookIsbn;
        this.patronId = patronId;
        this.reservationDate = reservationDate;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public String getPatronId() {
        return patronId;
    }

    public void setPatronId(String patronId) {
        this.patronId = patronId;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    @Override
    public String toString() {
        return "Reservation [ReservationID=" + reservationId + ", BookISBN=" + bookIsbn + ", PatronID=" + patronId + ", ReservationDate=" + reservationDate + "]";
    }
}

