package com.example.myfirstapp.moodtrackertests;

import android.app.Activity;
import android.app.Instrumentation;
import android.database.Cursor;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.view.View;

import com.example.myfirstapp.R;
import com.example.myfirstapp.activitiesrest.MoodHistory;
import com.example.myfirstapp.database.DatabaseContract;
import com.example.myfirstapp.database.DatabaseHelper;
import com.example.myfirstapp.activitiesmoodstate.MainActivity;


import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class MainActivityTest {

    /** This RULE specifies that this activity is launched */
    //Always make this public
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);

    private MainActivity mActivity = null;

    Instrumentation.ActivityMonitor moodHistoryMonitor =
            getInstrumentation().addMonitor(
                    MoodHistory.class.getName(),
                    null,
                    false);

    DatabaseHelper dbH;
    Cursor mCursor;

    @Before
    public void setUp() throws Exception {

        /** With this, we get the context! */
        mActivity = mainActivityActivityTestRule.getActivity();

        dbH = new DatabaseHelper(mActivity);
        mCursor = dbH.getAllDataFromDaysTable();

    }

    @Test
    public void testThatViewsAreNotNull() {

        /** If we can find the views, we can conclude that the activity is launched successfully */

        View view1 = mActivity.findViewById(R.id.happy_face_button);
        View view2 = mActivity.findViewById(R.id.mood_history_button_main);
        View view3 = mActivity.findViewById(R.id.custom_note_button_main);

        assertNotNull(view1);
        assertNotNull(view2);
        assertNotNull(view3);

    }


    @Test
    public void testThatMoodHistoryIsLaunched () {

        /** Checking that MoodHistory is launched properly */

        View view2 = mActivity.findViewById(R.id.mood_history_button_main);
        assertNotNull(view2);

        onView(withId(R.id.mood_history_button_main)).perform(click());

        Activity moodHistory = getInstrumentation().waitForMonitorWithTimeout(moodHistoryMonitor, 5000);

        assertNotNull(moodHistory);

        moodHistory.finish();

    }

    @Test
    public void testThatCommentDialogIsLaunchedAndTextMustBeAdded () {

        View view3 = mActivity.findViewById(R.id.custom_note_button_main);
        assertNotNull(view3);

        onView(withId(R.id.custom_note_button_main)).perform(click());

        /** We check that the dialog appears checking that a view (in this case two) with a
         * specific text is shown */

        onView(withText(R.string.alert_dialog_box_ok)).check(matches(isDisplayed()));
        onView(withText(R.string.alert_dialog_box_cancel)).check(matches(isDisplayed()));

        onView(withText(R.string.alert_dialog_box_ok)).perform(click());

        onView(withText(R.string.alert_dialog_box_ok)).check(matches(isDisplayed()));

    }

    @Test
    public void testThatCommentDialogIsLaunchedAndClosedWhenTextIsAdded () {

        View view3 = mActivity.findViewById(R.id.custom_note_button_main);
        assertNotNull(view3);

        onView(withId(R.id.custom_note_button_main)).perform(click());

        /** We check that the dialog appears checking that a view (in this case two) with a
         * specific text is shown */

        onView(withText(R.string.alert_dialog_box_ok)).check(matches(isDisplayed()));
        onView(withText(R.string.alert_dialog_box_cancel)).check(matches(isDisplayed()));

        onView(withId(R.id.alertDialogComment)).perform(typeText("This is a test"));

        onView(withText(R.string.alert_dialog_box_ok)).perform(click());

        onView(withId(R.id.happy_face_button)).check(matches(isClickable()));

    }

    @Test
    public void testThatClickingTheFaceButtonUpdatesTheDatabase (){

        DatabaseHelper dbH = new DatabaseHelper(mActivity);
        Cursor mCursor = dbH.getAllDataFromDaysTable();

        onView(withId(R.id.happy_face_button)).perform(click());

        mCursor.moveToFirst();
        int state = mCursor.getInt(mCursor.getColumnIndex(DatabaseContract.Database.STATE_ID));

        assertTrue(state == 4);

    }


    @After
    public void tearDown() throws Exception {

        dbH.updateDataDaysStateInToday(6);

        dbH = null;
        mCursor = null;

        /** With this, we nullify the activity (that was launched) */
        mActivity = null;



    }

}