package com.example.emergencyphone.model;

import java.util.Locale;

public class TeaItem {

    public final long _id;
    public final String title;
    public final String number;
    public final String location;

    public TeaItem(long _id, String title, String number, String location) {
        this._id = _id;
        this.title = title;
        this.number = number;
        this.location = location;
    }

    @Override
    public String toString() {
        String msg = String.format(
                Locale.getDefault(),
                "%s (%s)",
                this.title,
                this.number
        );
        return msg;
    }
}
