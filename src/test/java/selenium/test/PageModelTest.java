package selenium.test;


import logconf.Log;
import org.junit.Assert;
import org.junit.Test;
import selenium.base.DriverBase;
import selenium.pagemodel.PageModel;
import org.apache.log4j.Logger;

import java.util.List;

public class PageModelTest extends DriverBase
{


    PageModel pageModel;
    @Test
    public void gittiGidiyorTestCase()
    {
        try {
            Log.info("Test starting.");
            pageModel = new PageModel(getDriver());
            Log.info("Driver is opened");
            Assert.assertTrue(pageModel.getMainPageStatus());
            pageModel.hoverLoginIcon();
            pageModel.clickLoginButton();
            Log.info("Login page is opened");
            pageModel.setEmail();
            pageModel.setPassword();
            pageModel.clickLogin();
            Log.info("Login successful");
            pageModel.searchBar();
            pageModel.searchButton();
            pageModel.secondPageButton();
            pageModel.randomProduct();
            pageModel.addToBasket();
            Log.info("Item added to the basket");
            List<String> prices = pageModel.getPrices();
            Assert.assertEquals(prices.get(0), prices.get(1));
            pageModel.setQuantity();
            pageModel.deleteProductsFromBasket();
            Log.info("Item deleted from the basket");
            Assert.assertFalse(pageModel.getBasketEmptyStatus());
        }
        catch (Exception e)
        {
           Log.error(e.getMessage());
           throw e;
        }



    }


}
