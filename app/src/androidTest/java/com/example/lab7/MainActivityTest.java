package com.example.lab7;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import android.widget.TextView;

import androidx.annotation.UiThread;
import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.nio.file.attribute.AclEntryType;

public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> mActivityTestRule = new ActivityScenarioRule<>(MainActivity.class);
    private  MainActivity mActivity=null;
    private TextView text;

    @Before
    public void setUp() throws Exception{
        try (ActivityScenario<MainActivity> scenario = mActivityTestRule.getScenario()) {
            scenario.onActivity(activity -> {
                mActivity = activity; // Initialize mActivity inside the scenario
            });
        }
    }
    @Test
    @UiThread
    public void checkFirstName() throws Exception{
        assertNotNull(mActivity.findViewById(R.id.message_text_view));
        text=mActivity.findViewById(R.id.first_name);
        text.setText("user1");
        String name = text.getText().toString();
        assertNotEquals("user", name);
    }


}
