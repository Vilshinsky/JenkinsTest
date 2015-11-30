import company.Gigya;
import company.LogInPage;
import company.ProfilePage;
import company.TestHelper;
import org.junit.*;

public class SmokeTest1 {
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

    @Test
    public void shouldMatchLogInFormTexts() {
        LogInPage.goToAuthorization();
        Assert.assertEquals(LogInPage.authFormTexts(), LogInPage.getListAuthFormTexts());
    }

    @Ignore
    @Test
    public void shouldMatchRegFormStep1Texts() {
        LogInPage.goToAuthorization();
        LogInPage.goToRegistration();
        Assert.assertEquals(LogInPage.regFormStep1AllTexts, TestHelper.waitElementByCss(".gigya-screen-dialog").getText());
    }
    @Ignore
    @Test
    public void shouldMatchRegFormStep2Texts() {
        LogInPage.goToAuthorization();
        LogInPage.goToRegistration();
        Gigya.generateNewEmail();
        LogInPage.fillRegForm();
        LogInPage.goToRegistrationStep2();
        Assert.assertEquals(LogInPage.regForm2AllTexts, TestHelper.waitElementByCss(".gigya-screen-dialog").getText());
    }
    @Ignore
    @Test
    public void shouldMatchRegFormStep3Texts() {
        LogInPage.goToAuthorization();
        LogInPage.goToRegistration();
        Gigya.generateNewEmail();
        LogInPage.fillRegForm();
        LogInPage.goToRegistrationStep2();
        LogInPage.goToRegistrationStep3();
        Assert.assertEquals(LogInPage.regForm3AllTexts, TestHelper.waitElementByCss(".gigya-screen-dialog").getText());
    }
    @Ignore
    @Test
    public void shouldMatchProfileFormTexts() {
        LogInPage.newAccount();
        ProfilePage.goToProfile();
        Assert.assertEquals(ProfilePage.profileFormAllTexts, TestHelper.waitElementByCss(".gigya-screen-dialog").getText());
    }
}
