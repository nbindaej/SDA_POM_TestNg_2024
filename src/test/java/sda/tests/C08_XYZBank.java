package sda.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import sda.pages.XYZBank.CustomerPage;
import sda.pages.XYZBank.HomePage;
import sda.pages.XYZBank.ManagerPage;
import sda.utilities.ConfigReader;
import sda.utilities.Driver;

public class C08_XYZBank {
    @Test
    public void test() throws InterruptedException {
    //Open 5 new  Accounts, deposit 100 USD and withdraw 100 USD from any account and delete all accounts you created.

// Go to url https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
        Driver.getDriver().get(ConfigReader.getProperty("xyzBankUrl"));

// Click on "Bank Manager Login" button
        HomePage homePage = new HomePage();
        homePage.managerLogin();

// Click on "Add Customer" button And Fill inputs and click on "Add Customer" submit button
// And Accept alert
// Add 4 more customers
        ManagerPage managerPage =new ManagerPage();
        managerPage.addCustomerInfo();

// Click on "Open Account"  button , Click on "Customer" dropdown , Select customer name
// Click on "Currency" dropdown Select "Dollar"
// Click on "Process" button And Accept alert
// Open 4 more accounts
        managerPage.openNewAccount();

// Click on "Customers" button And Count table row numbers
// Then Assert that you created 5 customers
        managerPage.customersTable();
        Assert.assertEquals(managerPage.customersTable(),10);
// Click on "Home" button
        homePage.backToHome();

// Click on "Customer Login" button
        homePage.customerLogin();

// Click on "Your Name" dropdown And Select any name you created And Click on "Login" button
        CustomerPage customerPage = new CustomerPage();
        customerPage.selectYourName();

// Click on "Deposit" button And Type 100 into "Amount to be Deposited" input , Click on "Deposit"(Submit) button
        customerPage.deposit();

//Then Assert that "Deposit Successful" is displayed

        Assert.assertTrue(customerPage.successfulMessage().contains("Deposit Successful"));

// Click on "Withdrawal" button And Type 100 into "Amount to be Withdrawn" input , Click on "Withdraw"(Submit) button
// Then Assert that "Transaction  Successful" is displayed
        customerPage.withdraw();
        Assert.assertTrue(customerPage.successfulMessage().contains("Transaction successful"));

// Click on "Logout" button
        customerPage.logout();

// Click on "Home" button
        homePage.backToHome();

// Click on "Bank Manager Login" button
        homePage.managerLogin();

// Click on "Customers" button
        managerPage.customersTable();

// Click on each "Delete" button
        managerPage.deleteCustomers();
// And Count table row numbers , Assert that number of customers is 0
        Assert.assertEquals(managerPage.customersTable(),0);

        Driver.closeDriver();
}
    }