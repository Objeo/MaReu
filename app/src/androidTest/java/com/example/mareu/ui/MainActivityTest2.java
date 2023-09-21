package com.example.mareu.ui;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.contrib.PickerActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.example.mareu.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest2 {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    /**
     * Méthode de test générée par Espresso Recorder.
     * Espresso Recorder est réglé avec les valeurs minimum, càd 1
     * (Max UI Depth, ScrollView detection depth et assertion depth)
     */
    @Test
    public void mainActivityTest2() {
        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.fab), withContentDescription("Ouvrir le menu d'ajout de réunion"), isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction textInputEditText = onView(
                allOf(withId(R.id.edit_text_theme), isDisplayed()));
        textInputEditText.perform(replaceText("T1"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(
                allOf(withId(R.id.button_confirm_hour), withText("Confirmer heure"), isDisplayed()));
        materialButton.perform(click());

        ViewInteraction appCompatSpinner = onView(
                allOf(withId(R.id.spinner_salle), isDisplayed()));
        appCompatSpinner.perform(click());

        ViewInteraction checkedTextView = onView(
                allOf(withId(android.R.id.text1), withText("Salle A"), isDisplayed()));
        checkedTextView.perform(click());

        ViewInteraction textInputEditText2 = onView(
                allOf(withId(R.id.edit_text_participants), isDisplayed()));
        textInputEditText2.perform(replaceText("phpons@gmail.com"), closeSoftKeyboard());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.button_validate), withText("Valider"), isDisplayed()));
        materialButton2.perform(click());

        // Ici, j'ai du modifier et remettre l'heure par défaut(avec le recorder j'avais sélectionné 13:00,
        // mais la sélection du time picker n'est pas prise en compte(apparement))
        ViewInteraction textView = onView(
                allOf(withId(R.id.textView_salle_heure_theme), withText("T1 - 08:00 - Salle A"), isDisplayed()));
        textView.check(matches(withText("T1 - 08:00 - Salle A")));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.textView_participants), withText("phpons@gmail.com. "), isDisplayed()));
        textView2.check(matches(withText("phpons@gmail.com. ")));
    }

    /**
     *  Avec une petite modification pour réellement sélectionner une heure sur le TimePicker
     */
    @Test
    public void mainActivityTest3() {
        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.fab), withContentDescription("Ouvrir le menu d'ajout de réunion"), isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction textInputEditText = onView(
                allOf(withId(R.id.edit_text_theme), isDisplayed()));
        textInputEditText.perform(replaceText("T1"), closeSoftKeyboard());

        // Sélectionner l'heure de la réunion
        // Les PickerAction ne sont disponibles que si la dépendence suivante est activée dans Gradle :
        // androidTestImplementation "androidx.test.espresso:espresso-contrib:3.5.1"
        onView(withId(R.id.time_picker)).perform(PickerActions.setTime(13, 00));

        ViewInteraction materialButton = onView(
                allOf(withId(R.id.button_confirm_hour), withText("Confirmer heure"), isDisplayed()));
        materialButton.perform(click());

        ViewInteraction appCompatSpinner = onView(
                allOf(withId(R.id.spinner_salle), isDisplayed()));
        appCompatSpinner.perform(click());

        ViewInteraction checkedTextView = onView(
                allOf(withId(android.R.id.text1), withText("Salle A"), isDisplayed()));
        checkedTextView.perform(click());

        ViewInteraction textInputEditText2 = onView(
                allOf(withId(R.id.edit_text_participants), isDisplayed()));
        textInputEditText2.perform(replaceText("phpons@gmail.com"), closeSoftKeyboard());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.button_validate), withText("Valider"), isDisplayed()));
        materialButton2.perform(click());

        // Il faut ici que le message corresponde à l'heure sélectionnée plus haut!
        ViewInteraction textView = onView(
                allOf(withId(R.id.textView_salle_heure_theme), withText("T1 - 13:00 - Salle A"), isDisplayed()));
        textView.check(matches(withText("T1 - 13:00 - Salle A")));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.textView_participants), withText("phpons@gmail.com. "), isDisplayed()));
        textView2.check(matches(withText("phpons@gmail.com. ")));
    }

}
