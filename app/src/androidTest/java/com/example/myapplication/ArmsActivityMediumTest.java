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
public class ArmsActivityMediumTest {

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

        try (ActivityScenario<ArmsActivity> scenario = ActivityScenario.launch(ArmsActivity.class)) {
            scenario.onActivity(activity -> {

                assertNotNull(activity);


                ImageView arms1 = activity.findViewById(R.id.arms1);
                ImageView arms2 = activity.findViewById(R.id.arms2);
                ImageView arms3 = activity.findViewById(R.id.arms3);
                ImageView arms4 = activity.findViewById(R.id.arms4);
                ImageView arms5 = activity.findViewById(R.id.arms5);
                ImageView arms6 = activity.findViewById(R.id.arms6);
                ImageView arms7 = activity.findViewById(R.id.arms7);

                assertNotNull(arms1);
                assertNotNull(arms2);
                assertNotNull(arms3);
                assertNotNull(arms4);
                assertNotNull(arms5);
                assertNotNull(arms6);
                assertNotNull(arms7);


                checkImageLoaded(activity, R.drawable.arms1, arms1);
                checkImageLoaded(activity, R.drawable.arms2, arms2);
                checkImageLoaded(activity, R.drawable.arms3, arms3);
                checkImageLoaded(activity, R.drawable.arms4, arms4);
                checkImageLoaded(activity, R.drawable.arms5, arms5);
                checkImageLoaded(activity, R.drawable.arms6, arms6);
                checkImageLoaded(activity, R.drawable.arms7, arms7);
            });
        }
    }

    private void checkImageLoaded(ArmsActivity activity, int drawableRes, ImageView imageView) {
        idlingResource.increment();

        Glide.with(activity)
                .asGif()
                .load(drawableRes)
                .listener(new RequestListener<GifDrawable>() {
                    @Override
                    public boolean onLoadFailed(GlideException e, Object model, Target<GifDrawable> target, boolean isFirstResource) {
                        idlingResource.decrement();
                        assertTrue("Image load failed", false);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GifDrawable resource, Object model, Target<GifDrawable> target, DataSource dataSource, boolean isFirstResource) {
                        idlingResource.decrement();
                        assertNotNull(resource);
                        return false;
                    }
                })
                .into(imageView);
    }
}
