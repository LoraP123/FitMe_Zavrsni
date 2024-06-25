package com.example.myapplication;

import android.widget.ImageView;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.idling.CountingIdlingResource;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.IdlingRegistry.getInstance;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class LegsActivityMediumTest {

    private CountingIdlingResource idlingResource;

    @Before
    public void setUp() {
        idlingResource = new CountingIdlingResource("Glide_Load");
        getInstance().register(idlingResource);
    }

    @After
    public void tearDown() {
        getInstance().unregister(idlingResource);
    }

    @Test
    public void testImageViewsLoadGifsCorrectly() {
        // Launch the activity
        try (ActivityScenario<LegsActivity> scenario = ActivityScenario.launch(LegsActivity.class)) {
            scenario.onActivity(activity -> {
                // Check if the activity is not null
                assertNotNull(activity);

                // Check if the ImageView components are initialized correctly
                ImageView legs1 = activity.findViewById(R.id.legs1);
                ImageView legs2 = activity.findViewById(R.id.legs2);
                ImageView legs3 = activity.findViewById(R.id.legs3);
                ImageView legs4 = activity.findViewById(R.id.legs4);
                ImageView legs5 = activity.findViewById(R.id.legs5);
                ImageView legs6 = activity.findViewById(R.id.legs6);

                assertNotNull(legs1);
                assertNotNull(legs2);
                assertNotNull(legs3);
                assertNotNull(legs4);
                assertNotNull(legs5);
                assertNotNull(legs6);

                // Load GIFs and check if the loading is successful
                checkImageLoaded(activity, R.drawable.legs1, legs1);
                checkImageLoaded(activity, R.drawable.legs2, legs2);
                checkImageLoaded(activity, R.drawable.legs3, legs3);
                checkImageLoaded(activity, R.drawable.legs4, legs4);
                checkImageLoaded(activity, R.drawable.legs5, legs5);
                checkImageLoaded(activity, R.drawable.legs6, legs6);
            });
        }
    }

    private void checkImageLoaded(LegsActivity activity, int drawableRes, ImageView imageView) {
        idlingResource.increment();  // Increment the idling resource counter before starting the image load

        Glide.with(activity)
                .asGif()
                .load(drawableRes)
                .listener(new RequestListener<GifDrawable>() {
                    @Override
                    public boolean onLoadFailed(GlideException e, Object model, Target<GifDrawable> target, boolean isFirstResource) {
                        idlingResource.decrement();  // Decrement the idling resource counter when the load fails
                        assertTrue("Image load failed", false);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GifDrawable resource, Object model, Target<GifDrawable> target, DataSource dataSource, boolean isFirstResource) {
                        idlingResource.decrement();  // Decrement the idling resource counter when the resource is ready
                        assertNotNull(resource);
                        return false;
                    }
                })
                .into(imageView);
    }
}
