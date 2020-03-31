package com.example.myfirstapp.activitiesmoodstate;

import android.animation.Animator;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.myfirstapp.R;
import com.example.myfirstapp.activitiesrest.MoodHistory;
import com.example.myfirstapp.alertdialog.AlertDialogCreator;
import com.example.myfirstapp.broadcastreceiver.BroadcastDataUpdate;
import com.example.myfirstapp.database.DatabaseContract;
import com.example.myfirstapp.database.DatabaseHelper;
import com.example.myfirstapp.database.DatabaseValues;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //Variable for gesture detector
    GestureDetectorCompat mGestureDetector;

    //Variables for buttons
    ImageButton image_button_normal_face;
    ImageButton image_button_sad_face;
    ImageButton image_button_super_happy_face;
    ImageButton image_button_disappointed_face;
    ImageButton image_button_happy_face;
    ImageButton image_button_history;
    ImageButton image_button_add_note;

    //Variable for database helper. Used for creating the database the first time
    DatabaseHelper dbH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_main);

        //Database Helper
        dbH = new DatabaseHelper(this);

        //Gesture detector
        /**
         * This code is used for creating the two tables of the database.
         * It will only run the first time the app is launched
         */
        if (dbH.isTableEmpty(DatabaseContract.Database.DAYS_TABLE_NAME)) {
            for (int i = 0; i < DatabaseValues.days.length; i++){
                dbH.insertFirstDataDays(DatabaseValues.days[i],6,"");
            }

            /** We create the alarm for updating the mood history*/
            createAlarm();

            Toast.makeText(MainActivity.this,
                    getResources().getString(R.string.toast_swipe_to_change),
                    Toast.LENGTH_LONG)
                    .show();
        }

        if (dbH.isTableEmpty(DatabaseContract.Database.STATES_TABLE_NAME)) {
            for (int i = 0; i < DatabaseValues.states.length; i++) {
                dbH.insertFirstDataStates(DatabaseValues.states[i]);
            }
        }

        /** Button Listeners
         *  */
        image_button_happy_face = (ImageButton) findViewById(R.id.happy_face_button);
        image_button_happy_face.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP) //Used for animation (Animator animator)

            @Override
            public void onClick(View v) {

                //Used for feedback to the user
                Toast.makeText(MainActivity.this, getString(R.string.day_set_happy), Toast.LENGTH_LONG).show();

                //UPDATES the state of the day
                dbH.updateDataDaysStateInToday(4);

            }
        });


        /** Tapping the mood history button will take the used to that activity
         * */
        image_button_history = findViewById(R.id.mood_history_button_main);
        image_button_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, getString(R.string.mood_history_toast), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MoodHistory.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left);

            }
        });

        /** Tapping the add_note button will create a dialog for the user to
         * introduce a comment
         * */
        image_button_add_note = findViewById(R.id.custom_note_button_main);
        image_button_add_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialogCreator alertDialog = new AlertDialogCreator();
                alertDialog.createAlertDialog(MainActivity.this, dbH);

            }
        });

        image_button_normal_face = findViewById(R.id.normal_face_button);
        image_button_normal_face.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {


                Toast.makeText(MainActivity.this, getString(R.string.day_set_normal), Toast.LENGTH_SHORT).show();

                dbH.updateDataDaysStateInToday(3);

            }
        });




        image_button_disappointed_face = findViewById(R.id.disappointed_face_button);
        image_button_disappointed_face.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, getString(R.string.day_set_disappointed), Toast.LENGTH_SHORT).show();

                dbH.updateDataDaysStateInToday(2);

            }
        });



        image_button_sad_face = findViewById(R.id.sad_face_button);
        image_button_sad_face.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, getString(R.string.day_set_sad), Toast.LENGTH_SHORT).show();

                dbH.updateDataDaysStateInToday(1);

            }
        });


        image_button_super_happy_face = findViewById(R.id.super_happy_face_button);
        image_button_super_happy_face.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, getString(R.string.day_set_superhappy), Toast.LENGTH_LONG).show();

                dbH.updateDataDaysStateInToday(5);

            }
        });

    }



    /** This method creates an alarm used to update
     * the information every day at midnight. It calls
     * a broadcast receiver*/
    private void createAlarm () {

        //CREATION OF A CALENDAR to get time in millis and pass it to the AlarmManager to set
        //the time when the alarm has to start working (same day the app runs for the first time
        //at midnight).
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);

        //DECLARATION OF the AlarmManager and
        // the Intent and PendingIntent necessary for the AlarmManager.setRepeating method.
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, BroadcastDataUpdate.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        //timeInMillis: specifies when we have to start the alarm (calendar gives this information).
        //INTERVAL_DAY: makes the alarm be repeated every day.
        if (alarmManager != null) {
            alarmManager.setInexactRepeating(
                    AlarmManager.RTC_WAKEUP,
                    calendar.getTimeInMillis(),
                    AlarmManager.INTERVAL_DAY,
                    pendingIntent);
        }
    }
}