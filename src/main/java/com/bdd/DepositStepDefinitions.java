package com.bdd;

import static org.junit.Assert.assertTrue;

public class DepositStepDefinitions {
    private  Account account;

   // @Given("^a UserDetails has no money in their account$")
    public void a_user_has_no_money_in_their_current_account() {
        User user = new User();
        account = new Account();
        user.setAccount(account);
        assertTrue("The balance is not zero.", account.getBalance() == 0);
    }

   // @When("^£(\\d+) is deposited in to the account$")
    public void £_is_deposited_in_to_the_account(int arg1) {

        account.deposit(arg1);
    }

  //  @Then("^the balance should be £(\\d+)$")
    public void the_balance_should_be_£(int expectedBalance) {
        int currentBalance = account.getBalance();
        assertTrue("The expected balance was £100, but actually was: " + currentBalance, currentBalance == expectedBalance);
    }

    private class User {
        private Account account;

        public void setAccount(Account account) {
            this.account = account;
        }
    }

    private class Account {
        private int balance;

        private Account() {
            this.balance = 0;
        }

        public int getBalance() {
            return balance;
        }

        public void deposit(int arg1) {
            this.balance += arg1;
        }
    }
}
