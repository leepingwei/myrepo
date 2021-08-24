package project15.TestPages;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import project15.Base.BaseDriver;
import project15.Pages.*;
import project15.Util.ItemAndButtonMatchException;

public class PlaceAnOrderTest extends BaseDriver {

    String referenceCode;

    @Test(priority = 1, groups = "regression")
    public void placeOrderSequenceTest() {

        HomePage homePage = new HomePage();
        SummaryPage summaryPage = new SummaryPage();
        AddressPage addressPage = new AddressPage();
        ShippingPage shippingPage = new ShippingPage();
        PaymentPage paymentPage = new PaymentPage();
        PaymentConfirmPage paymentConfirmPage = new PaymentConfirmPage();
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage();
        MyOrdersPage myOrdersPage = new MyOrdersPage();


        /**
         *  Requirement:
         *  You should select a product from HomePage and add to cart
         *  You should complete proceed to checkout process
         *  At the end you should verify success message at the end
         */
        SoftAssert softAssert = new SoftAssert();

        homePage.hoverOverToAProduct();

        try{
            homePage.clickOnAddToCartButton();
        }catch(Exception e){
            throw new ItemAndButtonMatchException("\n****** Product item index is "
                    + HomePage.index + ", 'Add to cart' button index is " + HomePage.buttonIndex
                    + ". ******\n****** Please check both index and make them match. ******");
        }

        homePage.clickOnProceedToCheckoutButton();

        summaryPage.clickOnProceedToCheckoutButton();

        addressPage.clickOnProceedToCheckoutButton();

        shippingPage.clickOnAgreeCheckBox();

        shippingPage.clickOnProceedToCheckoutButton();

        paymentPage.paymentMethodSelector();

        paymentConfirmPage.clickOnConfirmButton();

        referenceCode = orderConfirmationPage.getReferenceCode();

        softAssert.assertTrue(orderConfirmationPage.getOrderCompleteMessage().contains("complete"));


    /**
     *  Requirement:
     *  Also you’ll see order reference value at the end, you should verify that value from “My Orders” page
     */
        homePage.clickOnMyOrdersPageLink();

        for(WebElement code : myOrdersPage.orderReferenceList){
            String actualCode = code.getText();
            softAssert.assertEquals(actualCode, referenceCode);
            break;
        }

        softAssert.assertAll();
    }
}
