package com.lddmproject.lddmproject;

import android.app.FragmentTransaction;
import android.content.Intent;
import java.util.Calendar;
import android.provider.CalendarContract;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Iterator;
import android.support.v4.app.DialogFragment;

import static com.lddmproject.lddmproject.R.id.dateEnd;
import static com.lddmproject.lddmproject.R.id.timeBegin;

public class eventRegistration extends AppCompatActivity {

    // Attributes
       private String eventName = "Event Name";
       private listPeople organizers = new listPeople( );
       private listPeople participants = new listPeople( );
       private Calendar calendar = Calendar.getInstance( );
       // Get Calendar Information
       int year = calendar.get(Calendar.YEAR);
       int month = calendar.get(Calendar.MONTH);
       int day = calendar.get(Calendar.DAY_OF_MONTH);
       int hour = calendar.get(Calendar.HOUR_OF_DAY);
       int minute = calendar.get(Calendar.MINUTE);

       private String beginDate = String.format("%02d/%02d/%02d",day,(month+1),year);
       private String beginTime = String.format("%02d:%02d",hour,minute);
       private String endDate = String.format("%02d/%02d/%02d",day,(month+1),year);
       private String endTime = String.format("%02d:%02d",hour,minute);

       public Event event = new Event( );

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
        setContentView(R.layout.activity_event_registration);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent( );
        if(intent != null) {
            Bundle extras = intent.getExtras( );
            String strdata = extras.getString("Uniqid");
            if(strdata.equals("addOrganizer")) {
                eventName = extras.getString(NEW_EVENT_NAME);

                organizers = extras.getParcelable(NEW_ORGANIZER_LIST);
                participants = extras.getParcelable(NEW_PARTICIPANT_LIST);

                beginDate = extras.getString(NEW_BEGIN_DATE);
                beginTime = extras.getString(NEW_BEGIN_TIME);
                endDate   = extras.getString(NEW_END_DATE);
                endTime   = extras.getString(NEW_END_TIME);

                // Capture name of organizers the participants and show on box
                //TextView textView = (TextView) findViewById(R.id.organizersBox);
                //textView.setText(getOrganizerNames( ));

                EditText edittext = (EditText) findViewById(R.id.eventName);
                edittext.setText(eventName);
            }
            if(strdata.equals("addParticipant")) {
                eventName = extras.getString(NEW_EVENT_NAME);

                organizers = extras.getParcelable(NEW_ORGANIZER_LIST);
                participants = extras.getParcelable(NEW_PARTICIPANT_LIST);

                beginDate = extras.getString(NEW_BEGIN_DATE);
                beginTime = extras.getString(NEW_BEGIN_TIME);
                endDate   = extras.getString(NEW_END_DATE);
                endTime   = extras.getString(NEW_END_TIME);

                // Capture name of participants the participants and show on box
                //TextView textView = (TextView) findViewById(R.id.participantsBox);
                //textView.setText(getParticipantsNames( ));

                EditText edittext = (EditText) findViewById(R.id.eventName);
                edittext.setText(eventName);
            }

            TextView textView = (TextView) findViewById(R.id.organizersBox);
            textView.setText(getOrganizerNames( ));
            textView = (TextView) findViewById(R.id.participantsBox);
            textView.setText(getParticipantsNames( ));

            // Set BeginDateButton
            Button bdbutton = (Button) findViewById(R.id.dateBegin);
            bdbutton.setText(beginDate);

            // Set BeginHourButton
            Button bhbutton = (Button) findViewById(timeBegin);
            bhbutton.setText(beginTime);

            // Set EndDateButton
            Button edbutton = (Button) findViewById(dateEnd);
            edbutton.setText(endDate);

            // Set EndHourButton
            Button ehbutton = (Button) findViewById(R.id.timeEnd);
            ehbutton.setText(endTime);
        }
    }

    public void addOrganizer (View view) {
        Intent intent = new Intent(this, addOrganizer.class);
        Bundle extras = new Bundle( );

        EditText edittext = (EditText) findViewById(R.id.eventName);
        String eN = ""+edittext.getText( );

        Button dbbutton = (Button)findViewById(R.id.dateBegin);
        Button tbbutton = (Button)findViewById(R.id.timeBegin);
        Button debutton = (Button)findViewById(R.id.dateEnd);
        Button tebutton = (Button)findViewById(R.id.timeEnd);

        String bD = (String)dbbutton.getText( );
        String bT = (String)tbbutton.getText( );
        String eD = (String)debutton.getText( );
        String eT = (String)tebutton.getText( );

        extras.putString(NEW_EVENT_NAME,eN);
        extras.putParcelable(NEW_ORGANIZER_LIST,organizers);
        extras.putParcelable(NEW_PARTICIPANT_LIST,participants);
        extras.putString(NEW_BEGIN_DATE,bD);
        extras.putString(NEW_BEGIN_TIME,bT);
        extras.putString(NEW_END_DATE,eD);
        extras.putString(NEW_END_TIME,eT);

        intent.putExtras(extras);
        startActivity(intent);
    }

    public void addParticipant (View view) {
        Intent intent = new Intent(this, addParticipant.class);
        Bundle extras = new Bundle( );

        EditText edittext = (EditText) findViewById(R.id.eventName);
        String eN = ""+edittext.getText( );

        Button dbbutton = (Button)findViewById(R.id.dateBegin);
        Button tbbutton = (Button)findViewById(R.id.timeBegin);
        Button debutton = (Button)findViewById(R.id.dateEnd);
        Button tebutton = (Button)findViewById(R.id.timeEnd);

        String bD = (String)dbbutton.getText( );
        String bT = (String)tbbutton.getText( );
        String eD = (String)debutton.getText( );
        String eT = (String)tebutton.getText( );

        extras.putString(NEW_EVENT_NAME,eN);
        extras.putParcelable(NEW_ORGANIZER_LIST,organizers);
        extras.putParcelable(NEW_PARTICIPANT_LIST,participants);
        extras.putString(NEW_BEGIN_DATE,bD);
        extras.putString(NEW_BEGIN_TIME,bT);
        extras.putString(NEW_END_DATE,eD);
        extras.putString(NEW_END_TIME,eT);

        intent.putExtras(extras);
        startActivity(intent);
    }

    public String getOrganizerNames( ) {
        String names = "";

        for (Iterator i = organizers.peopleList.iterator( ); i.hasNext( );) {
            Person p = (Person) i.next( );
            names = names + p.getName( );
            names = names +", ";
        }

        return names;
    }

    public String getParticipantsNames( ) {
        String names = "";

        for (Iterator i = participants.peopleList.iterator( ); i.hasNext( );) {
            Person p = (Person) i.next( );
            names = names + p.getName( );
            names = names +", ";
        }

        return names;
    }

    public void showBeginDatePickerDialog(View view) {
        DialogFragment newFragment = new BeginDatePickerFragment( );
        newFragment.show(getSupportFragmentManager( ), "datePicker");
    }

    public void showBeginTimePickerDialog(View view) {
        DialogFragment newFragment = new BeginTimePickerFragment( );
        newFragment.show(getSupportFragmentManager( ), "timePicker");
    }

    public void showEndDatePickerDialog(View view) {
        DialogFragment newFragment = new EndDatePickerFragment( );
        newFragment.show(getSupportFragmentManager( ), "datePicker");
    }

    public void showEndTimePickerDialog(View view) {
        DialogFragment newFragment = new EndTimePickerFragment( );
        newFragment.show(getSupportFragmentManager( ), "timePicker");
    }

    public void addEvent (View view) {
        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setType("vnd.android.cursor.item/event");

        // Get String Name of Event
        EditText edittext = (EditText) findViewById(R.id.eventName);
        String eventName = ""+edittext.getText( );

        // Get String of Buttons
        Button dbbutton = (Button)findViewById(R.id.dateBegin);
        Button tbbutton = (Button)findViewById(R.id.timeBegin);
        Button debutton = (Button)findViewById(R.id.dateEnd);
        Button tebutton = (Button)findViewById(R.id.timeEnd);

        String bD = (String)dbbutton.getText( );
        String bT = (String)tbbutton.getText( );
        String eD = (String)debutton.getText( );
        String eT = (String)tebutton.getText( );

        // Mount Event
        this.event.setName(eventName);
        this.event.setStartTime(bD,bT);
        this.event.setEndTime(eD,eT);
        //this.event.setName(eventName);
        //this.event.setOrganizers(organizers);
        //this.event.setParticipants(participants);

        long startTime = this.event.getStartTime( );
        long endTime = this.event.getEndTime( );
        //long endTime = this.event.getEndTime( )  + 60 * 60 * 1000;

        intent.putExtra(CalendarContract.Events.TITLE, event.getName( ));
        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startTime);
        intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,endTime);
        intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);
        intent.putExtra(CalendarContract.Events.ORGANIZER, organizers.peopleList.get(0).getEmail( ));
        intent.putExtra(CalendarContract.Events.DESCRIPTION, "Describe the event.");
        intent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Where is your event?");
        intent.putExtra(CalendarContract.Events.RRULE, "FREQ=YEARLY");


        startActivity(intent);
        sendWhatsApp( );
    }

    public void sendWhatsApp ( ) {
        Intent sendIntent = new Intent( );
        String msg = "";

        // Get String Name of Event
        EditText edittext = (EditText) findViewById(R.id.eventName);
        String eventName = ""+edittext.getText( );

        // Get String of Buttons
        Button dbbutton = (Button)findViewById(R.id.dateBegin);
        Button tbbutton = (Button)findViewById(R.id.timeBegin);
        Button debutton = (Button)findViewById(R.id.dateEnd);
        Button tebutton = (Button)findViewById(R.id.timeEnd);

        String bD = (String)dbbutton.getText( );
        String bT = (String)tbbutton.getText( );
        String eD = (String)debutton.getText( );
        String eT = (String)tebutton.getText( );

        // Build msg
        msg = "You are invited for " +event.getName( ) +"\n";
        msg = msg+ "By: "+organizers.peopleList.get(0).getName( ) +"\n";
        msg = msg+ "Event Duration"+"\n"+
                    "Begin: "+bD+" "+bT+"\n";
        msg = msg+  "End: "+eD+" "+eT+"\n";
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, msg);
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

    public void openShare(View view){
        Intent intent = new Intent(this, Share.class);
        intent.putExtra("Uniqid","Share");
        startActivity(intent);
    }

}
