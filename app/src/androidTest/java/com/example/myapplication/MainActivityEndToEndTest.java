package com.example.myapplication;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

@RunWith(AndroidJUnit4.class)
public class MainActivityEndToEndTest {

    @Test
    public void testNavigationDrawer() {

        ActivityScenario.launch(MainActivity.class);


        Espresso.onView(ViewMatchers.withContentDescription("Open navigation drawer"))
                .perform(ViewActions.click());


        Espresso.onView(ViewMatchers.withId(R.id.nav_view)).check(matches(isDisplayed()));


        Espresso.pressBack();
    }

    @Test
    public void testBottomNavigation() {

        ActivityScenario.launch(MainActivity.class);


        Espresso.onView(ViewMatchers.withId(R.id.bottomNavigationView)).check(matches(isDisplayed()));


        Espresso.onView(ViewMatchers.withId(R.id.workout)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.recipes)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.home)).perform(ViewActions.click());
    }
}
