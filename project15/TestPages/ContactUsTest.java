package project15.TestPages;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import project15.Base.BaseDriver;
import project15.Pages.ContactUsConfirmPage;
import project15.Pages.ContactUsPage;
import project15.Pages.HomePage;

public class ContactUsTest extends BaseDriver {

    @Test(dataProvider = "Input Message", groups = "regression")
    public void contactUsSequenceTest(String text) {

        HomePage homePage = new HomePage();
        ContactUsPage contactUsPage = new ContactUsPage();
        ContactUsConfirmPage contactUsConfirmPage = new ContactUsConfirmPage();

        homePage.clickOnContactUsLink();

        contactUsPage.selectSubjectHeading();

        contactUsPage.inputEmailAddress();

        contactUsPage.selectOrderReference();

        contactUsPage.chooseAttachFile();

        contactUsPage.writeMessage(text);

        contactUsPage.clickOnSendButton();

        Assert.assertTrue(contactUsConfirmPage.getConfirmMessage().contains("successfully"));
    }

    /**
     *  Requirement:
     *  You should test this at least 3 different input (use DataProvider)
     */
    @DataProvider(name = "Input Message")
    public Object[][] writeMessage(){
        return new Object[][]{{"TestTestTest"}, {"WriteWriteWrite"}, {"MessageMessageMessage"}};
    }
}
