package com.company;

import com.company.TestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ProfilePage {
    public static String avatarArea = "//*[contains(@class,'user-menu')]/div";
    public static String welcomeMessage = "//span[@class='welcome-user-name']";
    public static String manageProfileLink = "//*[contains(@class,'user-menu')]//a[@data-action='profile']";
    public static String notificationsLink = "//*[contains(@class,'user-menu')]//a[@data-action='notification-settings']";
    public static String favoritesLink = "//*[contains(@class,'user-menu')]//a[@data-action='favorite-players']";
    public static String changePassLink = "//*[contains(@class,'user-menu')]//a[@data-action='change-password']";
    public static String logoutLink = "//*[contains(@class,'user-menu')]//a[@data-action='logout']";

    public static String emailInput = "//*[@id='gigya-profile-form']//input[@name='email']";
    public static String firstnameInput = "//*[@id='gigya-profile-form']//input[@name='profile.firstName']";
    public static String lastnameInput = "//*[@id='gigya-profile-form']//input[@name='profile.lastName']";
    public static String passwordInput = "//*[@id='gigya-profile-form']//input[@name='password']";
    public static String passConfirmInput = "//*[@id='gigya-profile-form']//input[@name='passwordRetype']";
    public static String nicknameInput = "//*[@id='gigya-profile-form']//input[@name='profile.nickname']";
    public static String zipcodeInput = "//*[@id='gigya-profile-form']//input[@name='profile.zip']";
    public static String checkbox = "//*[@id='gigya-profile-form']//input[@name='data.terms']";
    public static String birthYearSelect = "//*[@id='gigya-profile-form']//select[@name='profile.birthYear']";
    public static String birthMonthSelect = "//*[@id='gigya-profile-form']//select[@name='profile.birthMonth']";
    public static String birthDaySelect = "//*[@id='gigya-profile-form']//select[@name='profile.birthDay']";
    public static String countrySelect = "//*[@id='gigya-profile-form']//select[@name='profile.country']";
    public static String submitProfileButton = "//*[@id='gigya-profile-form']//*[@class='gigya-input-submit']";

    public static String findPlayerInput = "//*[@id='gigya-profile-form3']//input[@name='data.findPlayer']";
    public static String selectPlayersSelect = "//*[@id='gigya-profile-form3']//select[@name='data.players']";
    public static String favoritesList = "//*[@id='myFavoritePlayersList']/following::div[@class='player-item']";
    public static String anyFavoriteInList = "//*[@class='player-item']";


    public static void cursorOverAvatar() {
        TestHelper.waitSec(2);
        TestHelper.waitElementByXpath(avatarArea);
        Actions actions = new Actions(TestHelper.driver);
        actions.moveToElement(TestHelper.waitElementByXpath(avatarArea)).build().perform();
    }
    public static String getWelcomeMessage() {
        cursorOverAvatar();
        return TestHelper.waitElementByXpath(welcomeMessage).getText();
    }
    public static void goToProfile() {
        cursorOverAvatar();
        TestHelper.waitElementByXpath(manageProfileLink).click();
    }
    public static void goToNotifications() {
        cursorOverAvatar();
        TestHelper.waitElementByXpath(notificationsLink).click();
    }
    public static void goToFavorites() {
        cursorOverAvatar();
        TestHelper.waitElementByXpath(favoritesLink).click();
    }
    public static void goToChangePass() {
        cursorOverAvatar();
        TestHelper.waitElementByXpath(changePassLink).click();
    }
    public static void clearInput(String input) {
        TestHelper.waitElementByXpath(input).clear();
    }
    public static void submitChangesInProfile() {
        TestHelper.waitElementByXpath(submitProfileButton);
        TestHelper.waitElementByXpath(submitProfileButton).click();
        TestHelper.waitElementNotExistByXpath(submitProfileButton);
    }
    public static void logOut() {
        cursorOverAvatar();
        TestHelper.waitElementByXpath(logoutLink).click();
    }
    public static boolean favoritesListEmpty() {
        TestHelper.waitElementByXpath(selectPlayersSelect);
        TestHelper.waitSec(2);
        if (TestHelper.driver.findElements(By.xpath(favoritesList)).size() == 0) {
            return true;
        } else {
            System.out.println("FAIL: List isn't empty!");
            return false;
        }
    }
    public static int sizeOfList() {
        TestHelper.waitElementByXpath(anyFavoriteInList);
        List<WebElement> list = TestHelper.driver.findElements(By.xpath(anyFavoriteInList));
        return list.size();
    }
    public static boolean checkPlayerNamesInDropdown() {
        String[] expected =
                {"Blake Adams", "John Adams", "Sam Adams", "Joe Affrunti", "Steven Alker", "Manage/Add favorites"};
        List<WebElement> actualPlayers = TestHelper.driver.findElements(By.xpath("//*[@class='players-list']/li"));
        cursorOverAvatar();
        for(int i = 0; i <= 5; i++) {
            if(expected[i].equals(actualPlayers.get(i).getText().replace("\n?", ""))) {
            } else {
                return false;
            }
        }
        return true;
    }
    public static void delExpectedFavoritePlayers(int totalnumber) {
        TestHelper.waitElementByXpath(anyFavoriteInList);
        for (int i = totalnumber; i > 1; i--) {
            TestHelper.driver.findElement(By.xpath(LogInPage.deleteFavPlayerButton)).click();
        }
    }
}
