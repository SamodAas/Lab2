package com.example.myapplication;

import android.content.Context;

import androidx.test.filters.MediumTest;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@MediumTest
@RunWith(AndroidJUnit4.class)
public class MainActivityAndroidTest {
    @Rule
    public ActivityTestRule<MainActivity> activityScenarioRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testWhenTextEnteredToMainText() {
        final String givenString = "Laba diena, sveiki atvyke.";
        final String expectedResult = "4";

        onView(withId(R.id.textForCalc)).perform(click(), replaceText(givenString));
        onView(withId(R.id.theButton)).perform(click());
        onView(withId(R.id.calcResult)).check(matches(withText(expectedResult)));

    }
    @Test
    public void testWhenEmptyStringToWordCounter() {
        final String givenString = "" ;
        final String expectedResult = "0";

        onView(withId(R.id.textForCalc)).perform(click(), replaceText(givenString));
        onView(withId(R.id.theButton)).perform(click());
        onView(withId(R.id.calcResult)).check(matches(withText(expectedResult)));

    }
    @Test
    public void testWhenEnteredStringWithMultipleWordsCommasAndDots() {
        final String givenString = "laba diena, sveiki atvyke. Siandien oras gal ir ne pats graziausias, bet pats linksmiausias. Gal." ;
        final String expectedResult = "15";

        onView(withId(R.id.textForCalc)).perform(click(), replaceText(givenString));
        onView(withId(R.id.theButton)).perform(click());
        onView(withId(R.id.calcResult)).check(matches(withText(expectedResult)));

    }
    @Test
    public void testWhenTextEnteredToMainTextInCharCounter() {
        final String givenString = "Laba diena, sveiki atvyke.";
        final String expectedResult = "26";
        onView(withId(R.id.optionSpinner)).perform(click());
        onView(withText("By characters")).perform(click());
        onView(withId(R.id.textForCalc)).perform(click(), replaceText(givenString));
        onView(withId(R.id.theButton)).perform(click());
        onView(withId(R.id.calcResult)).check(matches(withText(expectedResult)));

    }
    @Test
    public void testWhenEmptyStringToCharCounter() {
        final String givenString = "" ;
        final String expectedResult = "0";
        onView(withId(R.id.optionSpinner)).perform(click());
        onView(withText("By characters")).perform(click());
        onView(withId(R.id.textForCalc)).perform(click(), replaceText(givenString));
        onView(withId(R.id.theButton)).perform(click());
        onView(withId(R.id.calcResult)).check(matches(withText(expectedResult)));

    }
    @Test
    public void testWhenEnteredStringWithMultipleWordsCommasAndDotsInCharCounter() {
        final String givenString = "laba diena, sveiki atvyke. Siandien oras gal ir ne pats graziausias, bet pats linksmiausias. Gal." ;
        final String expectedResult = "97";
        onView(withId(R.id.optionSpinner)).perform(click());
        onView(withText("By characters")).perform(click());
        onView(withId(R.id.textForCalc)).perform(click(), replaceText(givenString));
        onView(withId(R.id.theButton)).perform(click());
        onView(withId(R.id.calcResult)).check(matches(withText(expectedResult)));

    }

}