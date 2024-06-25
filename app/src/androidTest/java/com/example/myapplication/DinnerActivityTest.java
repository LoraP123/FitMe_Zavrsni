package com.example.myapplication;

import android.content.Intent;
import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class DinnerActivityTest {

    @Test
    public void testActivityLaunches() {

        try (ActivityScenario<DinnerActivity> scenario = ActivityScenario.launch(DinnerActivity.class)) {
            scenario.onActivity(activity -> {

                assertNotNull(activity);


                assertNotNull(activity.findViewById(R.id.naziv_recept11111));
            });
        }
    }
}
