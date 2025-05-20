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
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.fail;

@RunWith(SerenityParameterizedRunner.class)
// 1 inseamna dark; 0 inseamna light
@UseTestDataFrom(value = "src/test/resources/wiki_darkmode_test_data.csv")
public class TestDarkmodeDDT {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps endUser;


    // 1 inseamna dark; 0 inseamna light
    private int action;
    public void setAction(int action) {
        this.action = action;
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
        System.out.println("action to take : " + action);
        System.out.println(webdriver.getPageSource());

        if (action ==  1) {
            endUser.makeDarkmode();
            endUser.shouldSeeDarkmode();
        } else if (action == 0) {
            endUser.makeLightmode();
            endUser.shouldSeeLightmode();
        }
        else{
            fail("Invalid action: " + action);
        }
    }
}
