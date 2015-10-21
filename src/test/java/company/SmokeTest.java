package java.company;

import main.java.company.Gigya;
import main.java.company.LogInPage;
import main.java.company.ProfilePage;
import main.java.company.TestHelper;
import org.junit.*;

public class SmokeTest {
        @BeforeClass
    public static void precondition() {
        TestHelper.setupChromeAndGo(Gigya.pageQAPGAT);
        TestHelper.setResolution(1212, 900);
        LogInPage.newAccount();
        TestHelper.quit();
    }
    @Before
    public void preconditions() {
        TestHelper.setupChromeAndGo(Gigya.pageQAPGAT);
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
        LogInPage.passAuthorization();
        ProfilePage.goToProfile();
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
    @Test
    public void shouldMatchProfileFormTexts() {
        LogInPage.goToAuthorization();
        LogInPage.passAuthorization();
        ProfilePage.goToProfile();
        Assert.assertEquals(ProfilePage.profileFormAllTexts, TestHelper.waitElementByCss(".gigya-screen-dialog").getText());
    }
}
