package org.example.steps.serenity;

import org.example.pages.WiktionaryDefinitions;
import org.example.pages.WiktionaryMainPage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps {

    WiktionaryMainPage wiktionaryMainPage;
    WiktionaryDefinitions wiktionaryDefinitions;

    @Step
    public void isAtWiktionaryDefinitionsPage() {
        wiktionaryDefinitions.open();
    }
    @Step
    public void searchesWiktionary(String keyword) {
        wiktionaryDefinitions.enter_keywords(keyword);
    }
    @Step
    public void shouldSeeDefinition(String definition) {
        assertThat(wiktionaryDefinitions.getDefinitions(), hasItem(containsString(definition)));
    }

    @Step public void shouldNotSeeDefinition(String definition) {
        assertThat(wiktionaryDefinitions.getDefinitions(), not(hasItem(containsString(definition))));
    }

    @Step
    public void isAtWiktionaryMainPage() {
        wiktionaryMainPage.open();
    }

    @Step
    public void changesLanguage(String language) {
        wiktionaryMainPage.clickLanguage(language);
    }

    @Step
    public void shouldSeeTextInRightLanguage(String expectedText) {
        assertThat(wiktionaryMainPage.getText(), containsString(expectedText));
    }

    @Step
    public void shouldNotSeeTextInRightLanguage(String expectedText) {
        assertThat(wiktionaryMainPage.getText(), not(containsString(expectedText)));
    }

}