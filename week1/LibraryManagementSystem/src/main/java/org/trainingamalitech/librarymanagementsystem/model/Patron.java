package org.trainingamalitech.librarymanagementsystem.model;

public class Patron {
        private String id;
        private String name;
        private String address;
        private String phoneNumber;

        public Patron() {}

        public Patron(String id, String name, String address, String phoneNumber) {
            this.id = id;
            this.name = name;
            this.address = address;
            this.phoneNumber = phoneNumber;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        @Override
        public String toString() {
            return "Patron [ID=" + id + ", Name=" + name + ", Address=" + address + ", PhoneNumber=" + phoneNumber + "]";
        }


}
