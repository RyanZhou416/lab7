package com.example.lab7;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

public class MainActivityTest2 {
    @Rule
    public ActivityScenarioRule<MainActivity>mainActivityTestRule = new ActivityScenarioRule<>(MainActivity.class);
    @Test
    public void testNameTooLongShowMessage() {
        Espresso.onView(withId(R.id.last_name)).perform(typeText("this_is_a_long_name"));
        Espresso.onView(withId(R.id.submit_button)).perform(click());

        Espresso.onView(withId(R.id.message_text_view)).check(ViewAssertions.matches(withText("Length is too long")));

    }
    @Test
    public void testNameAcceptedShowMessages() {
        Espresso.onView(withId(R.id.last_name)).perform(typeText("marc"));
        Espresso.onView(withId(R.id.message_text_view)).check(ViewAssertions.matches(withText("Accepted")));
    }
}
