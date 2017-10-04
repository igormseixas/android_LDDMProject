package com.lddmproject.lddmproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.widget.ShareDialog;

import java.util.Calendar;

public class Share extends AppCompatActivity {

    //Attributes
    public Event event = new Event( );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext( ));
        setContentView(R.layout.activity_share);

        Intent intent = getIntent( );
        Bundle extras = intent.getExtras( );
        String strdata = extras.getString("Uniqid");
        event = extras.getParcelable(eventRegistration.NEW_EVENT);
    }

    public void shareFacebook (View view){
        Calendar calendar = Calendar.getInstance( );

        calendar.setTimeInMillis(event.getStartTime( ));
        String bD = ""+Calendar.DAY_OF_MONTH + Calendar.MONTH + Calendar.YEAR;
        String bT = ""+Calendar.HOUR_OF_DAY+ Calendar.MINUTE;

        calendar.setTimeInMillis(event.getEndTime( ));
        String eD = ""+Calendar.DAY_OF_MONTH + Calendar.MONTH + Calendar.YEAR;
        String eT = ""+Calendar.HOUR_OF_DAY+ Calendar.MINUTE;

        String msg = "You are invited for " +event.getName( ) +"\n";
        msg = msg+ "Event Duration"+"\n"+
                "Begin: "+bD+" "+bT+"\n";
        msg = msg+  "End: "+eD+" "+eT+"\n";

        ShareOpenGraphObject object = new ShareOpenGraphObject.Builder()
                .putString("og:type", "fitness.course")
                .putString("og:title", event.getName( ))
                .putString("og:description", msg)
                .putInt("fitness:duration:value", 100)
                .putString("fitness:duration:units", "s")
                .putInt("fitness:distance:value", 12)
                .putString("fitness:distance:units", "km")
                .putInt("fitness:speed:value", 5)
                .putString("fitness:speed:units", "m/s")
                .build();
        ShareOpenGraphAction action = new ShareOpenGraphAction.Builder()
                .setActionType("fitness.runs")
                .putObject("fitness:course", object)
                .build();
        ShareOpenGraphContent content = new ShareOpenGraphContent.Builder()
                .setPreviewPropertyName("fitness:course")
                .setAction(action)
                .build();

        ShareDialog.show(this, content);
    }

    public void shareLikedin (View view){

    }
}
