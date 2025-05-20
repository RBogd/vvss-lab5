package org.example.features.search;


import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.example.steps.serenity.EndUserSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = "src/test/resources/wiki_change_language_data.csv", separator = ';')
public class TestLanguageDDT {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps endUser;

    private String language;
    private String expectedText;

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setExpectedText(String expectedText) {
        this.expectedText = expectedText;
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
    public void seeIfLanguageChanges() {
        endUser.is_at_the_home_page();
        endUser.changesLanguage(language);
        endUser.shouldSeeHugeText(expectedText);
    }
}
