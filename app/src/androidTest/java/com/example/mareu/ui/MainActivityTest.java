package com.example.mareu.ui;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.example.mareu.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.fab), withContentDescription("Ouvrir le menu d'ajout de réunion"), isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction textInputEditText = onView(
                allOf(withId(R.id.edit_text_theme), isDisplayed()));
        textInputEditText.perform(replaceText("ThemeTest"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(
                allOf(withId(R.id.button_confirm_hour), withText("Confirmer heure"), isDisplayed()));
        materialButton.perform(click());

        ViewInteraction appCompatSpinner = onView(
                allOf(withId(R.id.spinner_salle), isDisplayed()));
        appCompatSpinner.perform(click());

        ViewInteraction checkedTextView = onView(
                allOf(withId(android.R.id.text1), withText("Salle B"), isDisplayed()));
        checkedTextView.perform(click());

        ViewInteraction textInputEditText2 = onView(
                allOf(withId(R.id.edit_text_participants), isDisplayed()));
        textInputEditText2.perform(replaceText("participant@lamzone.com"), closeSoftKeyboard());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.button_validate), withText("Valider"), isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction actionMenuItemView = onView(
                allOf(withId(R.id.menu_filter), withText("Filtrer"), isDisplayed()));
        actionMenuItemView.perform(click());

        ViewInteraction materialTextView = onView(
                allOf(withId(androidx.transition.R.id.title), withText("Salle B"), isDisplayed()));
        materialTextView.perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withId(R.id.deleteButton), withContentDescription("deletebtn"), isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction actionMenuItemView2 = onView(
                allOf(withId(R.id.menu_filter), withText("Filtrer"), isDisplayed()));
        actionMenuItemView2.perform(click());

        ViewInteraction materialTextView2 = onView(
                allOf(withId(androidx.transition.R.id.title), withText("Reset"), isDisplayed()));
        materialTextView2.perform(click());
    }
}
