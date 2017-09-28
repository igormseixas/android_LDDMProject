package com.lddmproject.lddmproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class addOrganizer extends AppCompatActivity {

    private String eventName;

    private listPeople organizers;
    private listPeople participants;

    private String beginDate;
    private String beginTime;
    private String endDate;
    private String endTime;

    public static final String NEW_EVENT_NAME = "com.lddmprojetct.lddmprojetct.listPeople.eventName";
    public static final String NEW_ORGANIZER_LIST = "com.lddmprojetct.lddmprojetct.listPeople.organizer";
    public static final String NEW_PARTICIPANT_LIST = "com.lddmprojetct.lddmprojetct.listPeople.participant";
    public static final String NEW_BEGIN_DATE = "com.lddmprojetct.lddmprojetct.listPeople.begindate";
    public static final String NEW_BEGIN_TIME = "com.lddmprojetct.lddmprojetct.listPeople.begintime";
    public static final String NEW_END_DATE = "com.lddmprojetct.lddmprojetct.listPeople.enddate";
    public static final String NEW_END_TIME = "com.lddmprojetct.lddmprojetct.listPeople.endtime";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_organizer);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent( );
        Bundle extras = intent.getExtras( );

        eventName = extras.getString(NEW_EVENT_NAME);
        organizers = extras.getParcelable(NEW_ORGANIZER_LIST);
        participants = extras.getParcelable(NEW_PARTICIPANT_LIST);
        beginDate = extras.getString(NEW_BEGIN_DATE);
        beginTime = extras.getString(NEW_BEGIN_TIME);
        endDate   = extras.getString(NEW_END_DATE);
        endTime   = extras.getString(NEW_END_TIME);

    }

    public void cancelAdd (View view) {
        Intent intent = new Intent(this, eventRegistration.class);
        Bundle extras = new Bundle( );

        extras.putString("Uniqid","addOrganizer");
        extras.putString(NEW_EVENT_NAME,eventName);
        extras.putParcelable(NEW_ORGANIZER_LIST,organizers);
        extras.putParcelable(NEW_PARTICIPANT_LIST,participants);
        extras.putString(NEW_BEGIN_DATE,beginDate);
        extras.putString(NEW_BEGIN_TIME,beginTime);
        extras.putString(NEW_END_DATE,endDate);
        extras.putString(NEW_END_TIME,endTime);

        intent.putExtras(extras);
        startActivity(intent);
    }

    public void addParticipant (View view) {
        // Attributes
        Intent intent = new Intent(this, eventRegistration.class);
        String tmpname, tmpphone, tmpemail;
        EditText editText;
        // Get name
        editText = (EditText) findViewById(R.id.nameBox);
        tmpname = editText.getText( ).toString( );
        // Get phone
        editText = (EditText) findViewById(R.id.phoneBox);
        tmpphone = editText.getText( ).toString( );
        // Get email
        editText = (EditText) findViewById(R.id.emailBox);
        tmpemail = editText.getText( ).toString( );

        Person p = new Person(tmpname, tmpphone, tmpemail); // Create a new person
        // Add person to list
        organizers.peopleList.add(p);
        // Add list to extra
        //intent.putExtra(NEW_PERSON, p);
        Bundle extras = new Bundle( );

        extras.putString("Uniqid","addOrganizer");
        extras.putString(NEW_EVENT_NAME,eventName);
        extras.putParcelable(NEW_ORGANIZER_LIST,organizers);
        extras.putParcelable(NEW_PARTICIPANT_LIST,participants);
        extras.putString(NEW_BEGIN_DATE,beginDate);
        extras.putString(NEW_BEGIN_TIME,beginTime);
        extras.putString(NEW_END_DATE,endDate);
        extras.putString(NEW_END_TIME,endTime);

        intent.putExtras(extras);
        startActivity(intent);
    }
}
