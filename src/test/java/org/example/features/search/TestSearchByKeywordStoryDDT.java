package org.example.features.search;


import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.example.steps.serenity.EndUserSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = "src/test/resources/wiki_search_test_data_shorter.csv", separator = ';')
public class TestSearchByKeywordStoryDDT {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps endUser;

    private String searchedTerm;
    private String shouldFind;
    private int expectedResult;

    public void setSearchedTerm(String searchedTerm) {
        this.searchedTerm = searchedTerm;
    }

    public void setShouldFind(String shouldFind) {
        this.shouldFind = shouldFind;
    }

    public void setExpectedResult(int expectedResult) {
        this.expectedResult = expectedResult;
    }

    @Before
    public void maximizeWindow() {
//        ca altfel nu se vede nimic din ce avem nevoie gen, sa nu faci windwu inapoi mic ca iara n-o sa mearga
        webdriver.manage().window().maximize();

        // Optional fallback in case .maximize() is inconsistent
        // driver.manage().window().setSize(new Dimension(1440, 900));
    }

    @Issue("#WIKI-1")
    @Test
    public void searchWikiByKeywordTestDDT() {
        endUser.is_at_the_home_page();
        endUser.looks_for(searchedTerm);
        System.out.println("Expected result: " + expectedResult);
        if (expectedResult != 0) {
            endUser.should_see_definition(shouldFind);
        } else {
            endUser.shouldNotSeeDefinition(shouldFind);
        }
    }
}
