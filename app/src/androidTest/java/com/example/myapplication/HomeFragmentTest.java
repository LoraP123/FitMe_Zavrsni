package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(AndroidJUnit4.class)
public class HomeFragmentTest {

    @Test
    public void onCreateView_inflatesLayout() {

        LayoutInflater inflater = mock(LayoutInflater.class);


        ViewGroup container = mock(ViewGroup.class);


        HomeFragment fragment = new HomeFragment();


        View view = fragment.onCreateView(inflater, container, null);


        verify(inflater).inflate(R.layout.fragment_home, container, false);


        assertNotNull(view);
    }
}
