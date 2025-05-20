package org.example.features.search;


import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.example.steps.serenity.EndUserSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = "src/test/resources/test_data.csv", separator = ';')
public class TestSearchByKeywordStoryDDT {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps endUser;

    private String searchedTerm;
    private String shouldFind;

    public void setSearchedTerm(String searchedTerm) {
        this.searchedTerm = searchedTerm;
    }

    public void setShouldFind(String shouldFind) {
        this.shouldFind = shouldFind;
    }

    @Qualifier
    public String getQualifier() {
        return searchedTerm + "=>" + shouldFind;
    }

    @Issue("#WIKI-1")
    @Test
    public void searchWikiByKeywordTestDDT() {
        endUser.is_at_the_home_page();
        endUser.looks_for(searchedTerm);
        endUser.should_see_definition(shouldFind);
    }
}
