package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

@DefaultUrl("https://www.wiktionary.org")
public class WiktionaryMainPage extends PageObject {
    public void clickLanguage(String language) {
        WebElementFacade readWikiInYourLang = find(By.id("js-lang-list-button"));
        readWikiInYourLang.waitUntilClickable().click();
        WebElementFacade languageLink = find(By.cssSelector("a[lang='" + language + "']"));
        languageLink.waitUntilClickable().click();
    }

    public String getText() {
        WebElementFacade hugeText = find(By.xpath("//*[@id=\"vector-page-tools-dropdown-label\"]/span"));
        return hugeText.getText();
    }
}