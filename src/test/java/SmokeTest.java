import company.Gigya;
import company.LogInPage;
import company.ProfilePage;
import company.TestHelper;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.qatools.ashot.AShot;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class SmokeTest {
    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
            { "1+2", new Integer(1) },
            { "3*2", new Integer(3) }
        });
    }
    private String input;
    private double result;
    public SmokeTest(String input, double result) {
        this.input = input;
        this.result = result;
    }
    @Test
    public void test() {
        Assert.assertEquals(result, );
    }

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
        new AShot().takeScreenshot(TestHelper.driver, TestHelper.waitElementByCss(".gigya-screen-dialog"));
    }

    @Test
    public void shouldMatchLogInFormTexts() {
        LogInPage.goToAuthorization();
        Assert.assertEquals(LogInPage.authFormTexts(), LogInPage.getListAuthFormTexts());
    }
    @Test
    public void galen() {

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
