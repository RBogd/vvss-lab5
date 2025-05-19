package org.example.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

@DefaultUrl("http://en.wiktionary.org/wiki/Wiktionary")
//@DefaultUrl("http://www.cs.ubbcluj.ro")
public class DictionaryPage extends PageObject {

    @FindBy(xpath="//*[@id=\"p-search\"]/a/span[1]")
    private WebElementFacade searchIcon;

    @FindBy(id="p-search")
    private WebElementFacade searchBox;

    public void enter_keywords(String keyword) {
        searchIcon.click();
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
}