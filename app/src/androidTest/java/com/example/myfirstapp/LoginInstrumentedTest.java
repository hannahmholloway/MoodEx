package com.example.myfirstapp;

import android.support.test.rule.ActivityTestRule;
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
public class LoginInstrumentedTest {

    @Rule
    public ActivityTestRule<LoginActivity> activityTestRule
            = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void login() {
        /*


        onView(withId(R.id.button)).perform(click());
        onView(ViewMatchers.withId(R.id.))
                .check(ViewAssertions.matches(not(ViewMatchers.isDisplayed())));
         */
    }

    @Test
    public void selectForgotPassword() {
        onView(withId(R.id.tvForgotPass)).perform(click());
        onView(ViewMatchers.withId(R.id.pwreset))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void selectSignup() {
        onView(withId(R.id.tvSignIn)).perform(click());
        onView(ViewMatchers.withId(R.id.layout_signup))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void selectLogInSocials() {
        onView(withId(R.id.tvSignIn)).perform(click());
    }
}
