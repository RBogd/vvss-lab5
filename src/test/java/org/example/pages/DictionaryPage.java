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

@DefaultUrl("http://en.wiktionary.org/wiki/Wiktionary")
public class DictionaryPage extends PageObject {

    @FindBy(id = "p-search")
    private WebElementFacade searchBox;

    public void enter_keywords(String keyword) {
        searchBox.click();
        searchBox.sendKeys(keyword);
        searchBox.sendKeys(Keys.ENTER);
    }

    public List<String> getDefinitions() {
        WebElementFacade searchList = find(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/ol[1]"));
        return searchList.findElements(By.xpath(".//li")).stream().map(WebElement::getText).collect(Collectors.toList());
        /*
        WebElementFacade definitionList = find(By.tagName("ol"));
        return definitionList.findElements(By.tagName("li")).stream()
                .map( element -> element.getText() )
                .collect(Collectors.toList());
      */
    }

    @FindBy(id = "skin-client-pref-skin-theme-value-night")
    public WebElementFacade darkmodeButton;

    public void makeDarkmode(){
        darkmodeButton.click();
    }

    @FindBy(id = "skin-client-pref-skin-theme-value-day")
    public WebElementFacade lightmodeButton;

    public void makeLightmode(){
        lightmodeButton.click();
    }

    @FindBy(tagName = "body")
    private WebElementFacade body;

    public String getBodyColor() {
        return body.getCssValue("color");
    }
    public String getBodyBackgroundColor() {
        return body.getCssValue("background-color");
    }
}