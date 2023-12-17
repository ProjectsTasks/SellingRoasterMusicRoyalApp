package com.example.sellingmusicroyalapp;

import com.google.firebase.database.Exclude;

public class UserBooking {
    String bookingName;
    String bookingPrice;

    public String mKey;

    public UserBooking() {
    }

    public UserBooking(String bookingName, String bookingPrice) {
        this.bookingName = bookingName;
        this.bookingPrice = bookingPrice;
    }

    public String getBookingName() {
        return bookingName;
    }

    public void setBookingName(String bookingName) {
        this.bookingName = bookingName;
    }

    public String getBookingPrice() {
        return bookingPrice;
    }

    public void setBookingPrice(String bookingPrice) {
        this.bookingPrice = bookingPrice;
    }

    @Exclude
    public String getKey() {
        return mKey;
    }
    @Exclude
    public void setKey(String Key) {
        mKey = Key;
    }
}
