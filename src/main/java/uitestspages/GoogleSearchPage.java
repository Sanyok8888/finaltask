package uitestspages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class GoogleSearchPage {

    private static final By GOOGLE_SEARCH_FIELD = By.xpath("//input[@class='gLFyf gsfi']");
    private static final By ROZETKA_SEARCH_RESULT = By.xpath("//h3[contains(@class, 'LC20lb MBeuO DKV0Md') and text()='Интернет-магазин ROZETKA™: официальный сайт самого ...']");

    public GoogleSearchPage verifyGoogleSearchFieldVisibility() {
        $(GOOGLE_SEARCH_FIELD).shouldBe(visible);
        return this;
    }

    public GoogleSearchPage setSearchText(String text) {
        $(GOOGLE_SEARCH_FIELD).setValue(text);
        return this;
    }

    public GoogleSearchPage pressEnter() {
        $(GOOGLE_SEARCH_FIELD).pressEnter();
        return this;
    }

    public GoogleSearchPage tapOnRozetkaSearchResult() {
        $(ROZETKA_SEARCH_RESULT).click();
        return this;
    }
}
