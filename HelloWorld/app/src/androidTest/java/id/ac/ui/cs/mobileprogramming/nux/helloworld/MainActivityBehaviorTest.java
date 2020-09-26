package id.ac.ui.cs.mobileprogramming.nux.helloworld;

import android.app.Activity;
import android.app.Instrumentation;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.MediumTest;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;


@RunWith(AndroidJUnit4.class)
@MediumTest
public class MainActivityBehaviorTest {

    private String mDefaultString;

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule
            = new ActivityScenarioRule<>(MainActivity.class);


    @Before
    public void init_DefaultString(){
        mDefaultString = "Hello World!";
    }

    @Test
    public void defaultTextOn_TextView(){
        onView(withId(R.id.text_hello_world)).check(matches(withText(mDefaultString)));
    }

    @Test
    public void changeTextOn_TextView(){
        // click change_text button to change default TextView
        onView(withId(R.id.change_text)).perform(click());
        onView(withId(R.id.text_hello_world)).check(matches(not(withText(mDefaultString))));
    }

    @Test
    public void testLaunchSendMessage_Activity(){
        onView(withId(R.id.button_launch_send_message_activity)).perform(click());
        onView(withId(R.id.message_text_bar)).check(matches(isDisplayed()));
    }
}
