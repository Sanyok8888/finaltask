package uitestspages;

import com.codeborne.selenide.CollectionCondition;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class IphoneSearchOnRozetkaPage {

    private static final By ROZETKA_SEARCH_FIELD = By.xpath("//input[@name='search']");
    private static final By FOUND_IPHONE_AFTER_SEARCH = By.xpath("//div[@class='goods-tile__inner']");
    private static final By BUY_BUTTON_ON_IPHONE_PAGE = By.xpath("//button[@class='buy-button button button--with-icon button--green button--medium ng-star-inserted']");

    public IphoneSearchOnRozetkaPage verifyRozetkaSearchFieldVisibility() {
        $(ROZETKA_SEARCH_FIELD).shouldBe(visible);
        return this;
    }

    public IphoneSearchOnRozetkaPage setSearchTextInRozetkaSearchField(String text) {
        $(ROZETKA_SEARCH_FIELD).setValue(text);
        return this;
    }

    public IphoneSearchOnRozetkaPage pressEnterOnRozetkaSearchField() {
        $(ROZETKA_SEARCH_FIELD).pressEnter();
        return this;
    }

    public IphoneSearchOnRozetkaPage verifyVisibilityOfFoundIphone() {
        $$(FOUND_IPHONE_AFTER_SEARCH)
                .shouldHave(CollectionCondition.sizeGreaterThan(1))
                .get(2)
                .shouldBe(visible);
        return this;
    }

    public IphoneSearchOnRozetkaPage clickOnFoundIphone() {
        $$(FOUND_IPHONE_AFTER_SEARCH)
                .shouldHave(CollectionCondition.sizeGreaterThan(0))
                .get(1)
                .click();
        return this;
    }

    public IphoneSearchOnRozetkaPage buyButtonVisibilityVerification() {
        $(BUY_BUTTON_ON_IPHONE_PAGE).shouldBe(visible);
        return this;
    }

    public IphoneSearchOnRozetkaPage verifyBuyButtonIsActive(){
        $(BUY_BUTTON_ON_IPHONE_PAGE).isEnabled();
        return this;
    }


}
