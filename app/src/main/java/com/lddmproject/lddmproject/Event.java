package com.lddmproject.lddmproject;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Calendar;

/**
 * Created by Igor Machado Seixas on 9/21/2017.
 */

public class Event implements Parcelable {
    // Attributes
    private listPeople organizer;
    private listPeople participants;
    private String name;
    private long startTime;
    private long endTime;
    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;

    // Builders

    /**
     *  Standard Builder
     */
    public Event( ) {
        this(null, null, null, 0, 0, 0 );
    }

    /**
     * Alternative Builder
     * @param o - Event Organizer
     * @param p - Event Participant
     * @param n - Event name
     */
    public Event(listPeople o, listPeople p, String n, int d, int m, int y ) {
        this.organizer = o;
        this.participants = p;
        this.name = n;
        this.day = d;
        this.month = m;
        this.year = y;
    }

    /**
     * Alternative Builder
     * @param o - Event Organizer
     * @param p - Event Participant
     * @param n - Event name
     */
    public Event(listPeople o, listPeople p, String n ) {
        this.organizer = o;
        this.participants = p;
        this.name = n;
        this.day = 0;
        this.month = 0;
        this.year = 0;
    }

    // Get and Set Methods

    protected Event(Parcel in) {
        organizer = in.readParcelable(listPeople.class.getClassLoader());
        participants = in.readParcelable(listPeople.class.getClassLoader());
        name = in.readString();
        startTime = in.readLong();
        endTime = in.readLong();
        day = in.readInt();
        month = in.readInt();
        year = in.readInt();
        hour = in.readInt();
        minute = in.readInt();
    }

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

    /**
     * Set Start Time
     */
    public void setStartTime (String bD, String bT ) {
        Calendar calendar = Calendar.getInstance( );

        this.day = Integer.parseInt(bD.substring(0,2));
        this.month = Integer.parseInt(bD.substring(3,5))-1;
        this.year = Integer.parseInt(bD.substring(6,10));
        this.hour = Integer.parseInt(bT.substring(0,2));
        this.minute = Integer.parseInt(bT.substring(3,5));

        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.HOUR_OF_DAY,hour);
        calendar.set(Calendar.MINUTE,minute);

        this.startTime = calendar.getTimeInMillis( );
    }

    /**
     * Set End Time
     */
    public void setEndTime (String bD, String bT) {
        Calendar calendar = Calendar.getInstance( );

        this.day = Integer.parseInt(bD.substring(0,2));
        this.month = Integer.parseInt(bD.substring(3,5))-1;
        this.year = Integer.parseInt(bD.substring(6,10));
        this.hour = Integer.parseInt(bT.substring(0,2));
        this.minute = Integer.parseInt(bT.substring(3,5));

        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.HOUR_OF_DAY,hour);
        calendar.set(Calendar.MINUTE,minute);

        this.endTime = calendar.getTimeInMillis( );
    }

    public String getName( ) {
        return name;
    }

    public long getStartTime( ) {
        return startTime;
    }

    public long getEndTime( ) {
        return endTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(organizer, i);
        parcel.writeParcelable(participants, i);
        parcel.writeString(name);
        parcel.writeLong(startTime);
        parcel.writeLong(endTime);
        parcel.writeInt(day);
        parcel.writeInt(month);
        parcel.writeInt(year);
        parcel.writeInt(hour);
        parcel.writeInt(minute);
    }
}
