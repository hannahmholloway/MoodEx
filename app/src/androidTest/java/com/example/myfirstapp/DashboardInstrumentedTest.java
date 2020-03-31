package com.example.myfirstapp;

import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
//import static android.support.test.espresso.intent.Intents.intended;
//import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static org.hamcrest.core.IsNot.not;



@RunWith(AndroidJUnit4.class)
@LargeTest
public class DashboardInstrumentedTest {

    @Rule
    public ActivityTestRule<Dashboard> activityScenarioRule
            = new ActivityTestRule<>(Dashboard.class);


    @Test
    public void selectExercise() {
        onView(withId(R.id.button)).perform(click());
        onView(ViewMatchers.withId(R.id.activity_main))
                .check(ViewAssertions.matches(not(ViewMatchers.isDisplayed())));
    }


    @Test
    public void selectWaterIntake() {
        onView(withId(R.id.button2)).perform(click());
        onView(ViewMatchers.withId(R.id.activity_main))
                .check(ViewAssertions.matches(not(ViewMatchers.isDisplayed())));

       // Intents.init();
        //intended(hasComponent(MainWaterActivity.class.getName()));
    }

    @Test
    public void selectCalorieTracker() {
        onView(withId(R.id.button3)).perform(click());
        onView(ViewMatchers.withId(R.id.activity_main))
                .check(ViewAssertions.matches(not(ViewMatchers.isDisplayed())));
    }

    @Test
    public void selectMood() {
        onView(withId(R.id.button4)).perform(click());
        onView(ViewMatchers.withId(R.id.activity_main))
                .check(ViewAssertions.matches(not(ViewMatchers.isDisplayed())));
    }

}
