package com.campogianidaniele.roboletrictest;

import android.os.Build;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by campogianid on 8/28/2015.
 */
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)
public class MainActivityTest {

    private MainActivity subjectUnderTest;

    private int fragmentMainId;

    @Before
    public void setUp() throws Exception {
        fragmentMainId = R.id.fragment_main;
        subjectUnderTest = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void mainFragmentIsShown() {
        MainFragment mainFragment = (MainFragment) subjectUnderTest.getSupportFragmentManager().findFragmentById(fragmentMainId);
        assertNotNull(mainFragment);
    }
}