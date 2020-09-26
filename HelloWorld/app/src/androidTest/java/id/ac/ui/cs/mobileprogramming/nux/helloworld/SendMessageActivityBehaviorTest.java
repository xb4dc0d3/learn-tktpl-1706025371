package id.ac.ui.cs.mobileprogramming.nux.helloworld;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.JMock1Matchers.equalTo;

public class SendMessageActivityBehaviorTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testLaunchSendMessage_Activity(){
        onView(withId(R.id.button_launch_send_message_activity)).perform(click());
        onView(withId(R.id.message_text_bar)).check(matches(isDisplayed()));
    }

    @Test
    public void testSendMessage_Feature(){
        onView(withId(R.id.button_launch_send_message_activity)).perform(click());
        onView(withId(R.id.message_text_bar)).check(matches(isDisplayed()));
        onView(withId(R.id.message_text_bar)).perform(typeText("Please reply my message..."));
        onView(withId(R.id.send_button)).perform(click());
    }
}
