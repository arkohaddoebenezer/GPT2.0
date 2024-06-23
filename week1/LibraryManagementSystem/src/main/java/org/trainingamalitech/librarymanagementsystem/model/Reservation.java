package org.trainingamalitech.librarymanagementsystem.model;

import java.util.Date;

public class Reservation {

    private String reservationId;
    private String resourceId;
    private String resourceType;
    private String patronId;
    private Date reservationDate;

    public Reservation() {
    }

    public Reservation(String resourceId,String resourceType, String patronId, Date reservationDate) {
        this.resourceId = resourceId;
        this.resourceType = resourceType;
        this.patronId = patronId;
        this.reservationDate = reservationDate;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getResourceId() {
        return resourceId;
    }
    public String getResourceType() {
        return resourceType;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
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
        return "Reservation [ReservationID=" + reservationId + ", resourceId=" + resourceId + ", PatronID=" + patronId + ", ReservationDate=" + reservationDate + "]";
    }
}

