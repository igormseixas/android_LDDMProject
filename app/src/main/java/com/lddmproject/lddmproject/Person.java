package com.lddmproject.lddmproject;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Igor Machado Seixas on 9/17/2017.
 */

class Person implements Parcelable{
    // Attributes
       private String name;
       private String phone;
       private String email;

    // Builders

    /**
     *  Standard Builder
     */
    Person() {
         this("","","");
     }

    /**
     *  Alternative Builder
     *  @param n - Person name
     *  @param p - Person phone
     *  @param e - Person email
     */
    Person(String n, String p, String e) {
         this.name = n;
         this.phone = p;
         this.email = e;
     }

    // Access Methods

    /**
     * Method to get Name of Person
     */
    public String getName ( ) {
        return this.name;
    }

    /**
     * Method to implements Parcelable
     * @param in
     */

    protected Person(Parcel in) {
        name = in.readString( );
        phone = in.readString( );
        email = in.readString( );
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(phone);
        parcel.writeString(email);
    }

    public String getEmail() {
        return email;
    }
}
