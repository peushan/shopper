package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.ContactPage;
import testBase.BaseClass;
import utilities.ExcelReader;

public class TC01_ValidateCntctPgeErrrorMsgs extends BaseClass {

/*    @DataProvider(name = "contactData")
    public Object[][] contactData() throws Exception {
        String path = System.getProperty("user.dir") + "/testData/TestData.xlsx";
        ExcelReader reader = new ExcelReader(path);
        var result = reader.getContactFormData("ContactFormData", false).stream().map(r -> new Object[]{r[0], r[1], r[2], r[3], r[4]}).toArray(Object[][]::new);
        return result;
    }*/

    @Test()
    public void validateErrorMessages() {
        logger.info("*** Starting validateErrorMessages ***");

 //       try {
            ContactPage cp = new ContactPage(driver);
            cp.clickContactLnk();
            cp.clickSubmitBtn();

            //Validate 'Top banner' error message is displayed
            Assert.assertTrue(cp.isTopErrMsgDisplayed());
            //Validate 'Forename' error message is displayed
            Assert.assertTrue(cp.isForenameErrMsgDisplayed());
            //VerValidate 'Email' error message is displayed
            Assert.assertTrue(cp.isEmailErrMsgDisplayed());
            //Validate error message for 'Message' field is displayed
            Assert.assertTrue(cp.isMessageErrMsgDisplayed());

//        } catch (Exception e) {
//            logger.error("test is failed.." + '\n' + e);
//            Assert.fail();
//        }

        logger.info("*** Finished validateErrorMessages ***");
    }

    @Test()
    public void validateNoErrorsWithValidInputs() {
        logger.info("*** Starting validateNoErrorsWithValidInput ***");


        ContactPage cp = new ContactPage(driver);
        //Enter values to the text fields
        cp.setForename("foreName");
        cp.setSurname("surName");
        cp.setEmail("peus@gmail.com");
        cp.setTelephone("0222121212");
        cp.setMessage("message");

/*
        //Validate 'Top banner' error message is disappeared
        Assert.assertEquals(cp.errorTobBannerExist(), true, "Top banner error message is still exist.");
        //Validate 'ForeName' error message is disappeared
        Assert.assertEquals(cp.errorForeNameExist(), true, "Forename error message is still exist.");
        //Validate 'Email' error message is disappeared
        Assert.assertEquals(cp.errorEmailExist(), true, "Email error message is still exist.");
        //Validate error message of the 'Message' field is disappeared
        Assert.assertEquals(cp.errorMessageExist(), true, "Message error message is still exist.");
*/

        logger.info("*** Finished validateNoErrorsWithValidInput ***");
    }
}
