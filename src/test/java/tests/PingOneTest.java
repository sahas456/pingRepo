package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.*;
import utils.DriverFactory;

import static utils.Config.USERNAME;
import static utils.Config.PASSWORD;
import static utils.Config.URL;
import static utils.Config.PROFILEUSER;
import static utils.Config.DOCKUSERNAME1;
import static utils.Config.DOCKPASSWORD1;
import static utils.Config.DOCKUSERNAME2;
import static utils.Config.DOCKPASSWORD2;

public class PingOneTest {

    public LoginPage loginPage;
    public DashBoardPage dashBoardPage;
    public SettingsPage settingsPage;
    public DockPage dockPage;
    public DockLoginPage dockLoginPage;
    public static String dockUrl;

    @BeforeClass(alwaysRun = true)
    public void setUp(){
        WebDriver driver=DriverFactory.getDriver();
        driver.get(URL);

        loginPage = new LoginPage();
    }

    @Test (description = "Test 1 :: verify Admin Dashboard login functionality for Admin")
    public void verifyLoginToAdminPortal() throws Exception {
        dashBoardPage = loginPage.login(USERNAME, PASSWORD);
        dashBoardPage.verifyHomePage(PROFILEUSER);
        dockUrl = dashBoardPage.getDockUrl();
        settingsPage = dashBoardPage.gotoUserSettingsPage();
    }

    @Test(description = "Test 2 :: verify the Dock with Admin", dependsOnMethods = {"verifyLoginToAdminPortal"})
    public void verifyDockWithAdminLogin() {
        dockLoginPage = dashBoardPage.goToDock(dockUrl);
        dockPage = dockLoginPage.dockLogin(USERNAME, PASSWORD);
        dockPage.checkAdminDetails();
        dockLoginPage = dockPage.logOut();
    }

    @Test(description = "Test 3 :: verify the Dock with Enduser1", dependsOnMethods = {"verifyDockWithAdminLogin"})
    public void verifyDockWithEndUser1Login() {
        dockLoginPage = dashBoardPage.goToDock(dockUrl);
        dockPage = dockLoginPage.dockLogin(DOCKUSERNAME1, DOCKPASSWORD1);
        dockPage.checkEndUserDetails();
        dockLoginPage = dockPage.logOut();
    }

    @Test(description = "Test 4 :: verify the Dock with Enduser2", dependsOnMethods = {"verifyDockWithAdminLogin"})
    public void verifyDockWithEndUser2Login() {
        dockLoginPage = dashBoardPage.goToDock(dockUrl);
        dockPage = dockLoginPage.dockLogin(DOCKUSERNAME2, DOCKPASSWORD2);
        dockPage.checkEndUserDetails();
        dockLoginPage = dockPage.logOut();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        DriverFactory.closeDriver();

    }

}
