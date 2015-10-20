package com.company;

import org.junit.*;

public class SmokeTest {
    //    @BeforeClass
//    public static void precondition() {
//        TestHelper.setupChromeAndGo(Gigya.pageQAPGAT);
//        TestHelper.setResolution(1212, 900);
//        LogInPage.newAccount();
//        TestHelper.quit();
//    }
    @Before
    public void preconditions() {
        TestHelper.setupChromeAndGoToCI(Gigya.pageQAPGAT);
        TestHelper.setResolution(1212, 900);
    }
    @After
    public void postconditions() {
        TestHelper.quit();
    }

    @Ignore
    @Test
    public void should() {
        LogInPage.goToAuthorization();
        LogInPage.goToRegistration();
        LogInPage.fillRegForm();
        LogInPage.goToRegistrationStep2();
        LogInPage.goToRegistrationStep3();
        System.out.println(TestHelper.waitElementByCss(".gigya-screen-dialog").getText());
    }

    @Test
    public void shouldMatchLogInFormTexts() {
        LogInPage.goToAuthorization();
        Assert.assertEquals(LogInPage.authFormAllTexts, TestHelper.waitElementByCss(".gigya-screen-dialog").getText());
    }
    @Test
    public void shouldMatchRegFormStep1Texts() {
        LogInPage.goToAuthorization();
        LogInPage.goToRegistration();
        Assert.assertEquals(LogInPage.regFormStep1AllTexts, TestHelper.waitElementByCss(".gigya-screen-dialog").getText());
    }
    @Test
    public void shouldMatchRegFormStep2Texts() {
        LogInPage.goToAuthorization();
        LogInPage.goToRegistration();
        LogInPage.fillRegForm();
        LogInPage.goToRegistrationStep2();
        Assert.assertEquals(LogInPage.regForm2AllTexts, TestHelper.waitElementByCss(".gigya-screen-dialog").getText());
    }
    @Test
    public void shouldMatchRegFormStep3Texts() {
        LogInPage.goToAuthorization();
        LogInPage.goToRegistration();
        LogInPage.fillRegForm();
        LogInPage.goToRegistrationStep2();
        LogInPage.goToRegistrationStep3();
        Assert.assertEquals(LogInPage.regForm3AllTexts, TestHelper.waitElementByCss(".gigya-screen-dialog").getText());
    }
}
