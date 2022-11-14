package tests.ui.rozetkauitests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.ui.BaseUiTest;
import uitestspages.GoogleSearchPage;
import uitestspages.IphoneSearchOnRozetkaPage;
import uitestspages.RozetkaAccountPage;


public class RozetkaUiTests extends BaseUiTest {

    @BeforeMethod
    public void preCondition(){
        GoogleSearchPage googleSearchPage = new GoogleSearchPage();
        googleSearchPage.verifyGoogleSearchFieldVisibility();
        googleSearchPage.setSearchText("Rozetka");
        googleSearchPage.pressEnter();
        googleSearchPage.tapOnRozetkaSearchResult();
    }


    @Test
    public void iphoneSearchTest(){
        IphoneSearchOnRozetkaPage iphoneSearchOnRozetkaPage = new IphoneSearchOnRozetkaPage();

        iphoneSearchOnRozetkaPage.verifyRozetkaSearchFieldVisibility();
        iphoneSearchOnRozetkaPage.setSearchTextInRozetkaSearchField("Iphone 13 pro");
        iphoneSearchOnRozetkaPage.pressEnterOnRozetkaSearchField();
        iphoneSearchOnRozetkaPage.verifyVisibilityOfFoundIphone();
        iphoneSearchOnRozetkaPage.clickOnFoundIphone();
        iphoneSearchOnRozetkaPage.buyButtonVisibilityVerification();
        iphoneSearchOnRozetkaPage.verifyBuyButtonIsActive();
    }

    @Test
    public void accountPopUpVerification(){
        RozetkaAccountPage rozetkaAccountPage = new RozetkaAccountPage();

        rozetkaAccountPage.verifyAccountIconIsVisible();
        rozetkaAccountPage.clickOnAccountIcon();
        rozetkaAccountPage.verifyLoginAccountWindowVisibility();
        rozetkaAccountPage.verifyLoginFieldOnLoginAccountWindowVisibility();
        rozetkaAccountPage.verifyPasswordFieldOnLoginAccountWindowVisibility();
        rozetkaAccountPage.verifyLoginButtonOnLoginAccountWindowVisibility();
    }

}
