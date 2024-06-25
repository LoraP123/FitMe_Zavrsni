package com.example.myapplication;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class LegsActivityTest {

    @Test
    public void testActivityLaunchesAndViewsAreInitialized() {

        try (ActivityScenario<LegsActivity> scenario = ActivityScenario.launch(LegsActivity.class)) {
            scenario.onActivity(activity -> {

                assertNotNull(activity);


                assertNotNull(activity.findViewById(R.id.legs1));
                assertNotNull(activity.findViewById(R.id.legs2));
                assertNotNull(activity.findViewById(R.id.legs3));
                assertNotNull(activity.findViewById(R.id.legs4));
                assertNotNull(activity.findViewById(R.id.legs5));
                assertNotNull(activity.findViewById(R.id.legs6));
            });
        }
    }
}
