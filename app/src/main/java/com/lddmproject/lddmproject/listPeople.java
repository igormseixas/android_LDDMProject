package com.lddmproject.lddmproject;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Igor Machado Seixas on 9/18/2017.
 */

public class listPeople extends Person implements Parcelable {

    // Attributes
       List<Person> peopleList;

    // Builders

    /**
     * Standard Builder
     */
    public listPeople( ) {
        peopleList = new ArrayList<>( );
    }

    /**
     * Alternative builder
     * @param p - Person to be added in initialization
     */
    public listPeople(Person p) {
        peopleList = new ArrayList<>( );
        peopleList.add(p);
    }

    protected listPeople(Parcel in) {
        super(in);
        peopleList = in.createTypedArrayList(Person.CREATOR);
    }

    public listPeople clone( ) {
        listPeople clone = new listPeople( );
        clone.peopleList = this.peopleList;
        return clone;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeTypedList(peopleList);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<listPeople> CREATOR = new Creator<listPeople>() {
        @Override
        public listPeople createFromParcel(Parcel in) {
            return new listPeople(in);
        }

        @Override
        public listPeople[] newArray(int size) {
            return new listPeople[size];
        }
    };
}
