package uitestspages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RozetkaAccountPage{
    private static final By ACCOUNT_ICON_ON_ROZETKA_HOME_PAGE = By.xpath("//rz-user//button[@type='button'] [@class='header__button ng-star-inserted']");
    private static final  By LOGIN_ACCOUNT_WINDOW = By.xpath("//div[@class='modal__content']");
    private static final By LOGIN_FIELD_ON_LOGIN_ACCOUNT_WINDOW = By.xpath("//input[@formcontrolname='login']");
    private static final By PASSWORD_FIELD_ON_LOGIN_ACCOUNT_WINDOW = By.xpath("//input[@formcontrolname='password']");
    private static final By LOGIN_BUTTON_ON_LOGIN_ACCOUNT_WINDOW = By.xpath("//div[@class='form__row auth-modal__form-bottom']//button[@class='button button--large button--green auth-modal__submit ng-star-inserted']");



    public RozetkaAccountPage verifyAccountIconIsVisible(){
        $(ACCOUNT_ICON_ON_ROZETKA_HOME_PAGE).shouldBe(visible);
        return this;
    }

    public RozetkaAccountPage clickOnAccountIcon(){
        $(ACCOUNT_ICON_ON_ROZETKA_HOME_PAGE).click();
        return this;
    }

    public RozetkaAccountPage verifyLoginAccountWindowVisibility(){
        $(LOGIN_ACCOUNT_WINDOW).shouldBe(visible);
        return this;
    }

    public RozetkaAccountPage verifyLoginFieldOnLoginAccountWindowVisibility(){
        $(LOGIN_FIELD_ON_LOGIN_ACCOUNT_WINDOW).shouldBe(visible);
        return this;
    }

    public RozetkaAccountPage verifyPasswordFieldOnLoginAccountWindowVisibility(){
        $(PASSWORD_FIELD_ON_LOGIN_ACCOUNT_WINDOW ).shouldBe(visible);
        return this;
    }

    public RozetkaAccountPage verifyLoginButtonOnLoginAccountWindowVisibility(){
        $(LOGIN_BUTTON_ON_LOGIN_ACCOUNT_WINDOW).shouldBe(visible);
        return this;
    }


}
