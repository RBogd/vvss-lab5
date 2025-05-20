package org.example.steps.serenity;

import org.example.pages.DictionaryPage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps {

    DictionaryPage dictionaryPage;

    @Step
    public void should_see_definition(String definition) {
        assertThat(dictionaryPage.getDefinitions(), hasItem(containsString(definition)));
    }
    @Step public void shouldNotSeeDefinition(String definition) {
        assertThat(dictionaryPage.getDefinitions(), not(hasItem(containsString(definition))));
    }

    @Step
    public void is_at_the_home_page() {
        dictionaryPage.open();
    }

    @Step
    public void looks_for(String keyword) {
        dictionaryPage.enter_keywords(keyword);
    }


    @Step
    public void changeLanguage(String language) {
        dictionaryPage.changeLanguage(language);
    }
    @Step
    public void shouldSeeLanguage(String language) {
        assertThat(dictionaryPage.getTitleInLanguage(), containsString(language));
    }

}