package com.campogianidaniele.roboletrictest;

import android.os.Build;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by campogianid on 8/28/2015.
 */
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)
public class MainFragmentTest {

    private MainFragment subjectUnderTest;
    private String helloWorld;

    @Before
    public void setUp() throws Exception {
        helloWorld = "Hello world!";
        subjectUnderTest = MainFragment.newInstance();
        SupportFragmentTestUtil.startFragment(subjectUnderTest);
    }

    @Test
    public void welcomeMessageIsShown() {
        TextView mainTextView = getMainTextView(subjectUnderTest);
        assertNotNull(mainTextView);
    }

    private TextView getMainTextView(MainFragment parentFragment) {
        int textViewMainId = R.id.text_view_main;
        return (TextView) parentFragment.getView().findViewById(textViewMainId);
    }

    @Test
    public void welcomeMessageIsHelloWorld() {
        String shownMessage = getMainTextView(subjectUnderTest).getText().toString();
        assertEquals(helloWorld, shownMessage);
    }
}