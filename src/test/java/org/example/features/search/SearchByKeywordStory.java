package org.example.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import org.example.steps.serenity.EndUserSteps;

@RunWith(SerenityRunner.class)
public class SearchByKeywordStory {

    @Managed(uniqueSession = true )
    public WebDriver webdriver;

    @Steps
    public EndUserSteps anna;

    @Issue("#WIKI-1")
    @Test
    public void searching_by_keyword_apple_should_display_the_corresponding_article() {
        anna.isAtWiktionaryMainPage();
        anna.searchesWiktionary("apple");
        anna.shouldSeeDefinition("A common, firm, round fruit produced by a tree of the genus Malus.");
    }

    @Test
    public void searching_by_keyword_banana_should_display_the_corresponding_article() {
        anna.isAtWiktionaryMainPage();
        anna.searchesWiktionary("pear");
        anna.shouldSeeDefinition("An edible fruit produced by the pear tree, similar to an apple but typically elongated towards the stem.");
                                   // An edible fruit produced by the pear tree, similar to an apple but typically elongated towards the stem.
    }

    @Test
    public void searching_by_keyword_orange_should_display_the_corresponding_article() {
        anna.isAtWiktionaryMainPage();
        anna.searchesWiktionary("orange");
        anna.shouldSeeDefinition("(countable) An evergreen tree of the genus Citrus such as Citrus sinensis which yields orange");
    }

    @Test
    public void searching_by_keyword_strawberry_should_display_the_corresponding_article() {
        anna.isAtWiktionaryMainPage();
        anna.searchesWiktionary("strawberry");
        anna.shouldSeeDefinition("The sweet, usually red, edible accessory fruit of certain plants of the genus Fragaria.");
    }

    @Pending @Test
    public void searching_by_ambiguious_keyword_should_display_the_disambiguation_page() {
    }

} 