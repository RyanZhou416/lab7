package com.example.lab7;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testNameTooLongShowsMessage() {
        Espresso.onView(withId(R.id.first_name)).perform(typeText("this_is_a_long_name"));
        Espresso.onView(withId(R.id.submit_button)).perform(click());
        // Check that the TextView with "Length is too long" is displayed
        Espresso.onView(withId(R.id.message_text_view))
                .check(ViewAssertions.matches(withText("Length is too long")));
    }

    @Test
    public void testNameAcceptedShowsMessage() {
        Espresso.onView(withId(R.id.first_name)).perform(typeText("marc"));
        Espresso.onView(withId(R.id.submit_button)).perform(click());
        // Check that the TextView with "Accepted" is displayed
        Espresso.onView(withId(R.id.message_text_view))
                .check(ViewAssertions.matches(withText("Accepted")));
    }
}
