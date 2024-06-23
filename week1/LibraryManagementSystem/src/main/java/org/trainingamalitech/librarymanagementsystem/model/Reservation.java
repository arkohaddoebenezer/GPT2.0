package org.trainingamalitech.librarymanagementsystem.model;

import java.util.Date;

public class Reservation {

    private int reservationId;
    private String resourceId;
    private String resourceType;
    private String patronId;
    private String reservationDate;

    public Reservation(){}

    public Reservation(int reservationId, String resourceId, String resourceType, String patronId,
            String reservationDate) {
        this.reservationId = reservationId;
        this.resourceId = resourceId;
        this.resourceType = resourceType;
        this.patronId = patronId;
        this.reservationDate = reservationDate;
    }

    public Reservation(String resourceId, String resourceType, String patronId, String reservationDate) {
        this.resourceId = resourceId;
        this.resourceType = resourceType;
        this.patronId = patronId;
        this.reservationDate = reservationDate;
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

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    @Override
    public String toString() {
        return "Reservation [ReservationID=" + reservationId + ", resourceId=" + resourceId + ", PatronID=" + patronId
                + ", ReservationDate=" + reservationDate + "]";
    }

    public void setReservationId(int reservationId) {
        this.reservationId =reservationId;
    }
}
