@withdraw
Feature: Bill Payment (Withdrawal)
  As a logged in user
  I want to make a bill payment
  So that I can withdraw money from my account

  Background:
    Given the user is logged into ParaBank

  @successful-withdrawal
  Scenario: Successful bill payment withdrawal
    When the user makes a bill payment of "50" dollars
    Then the bill payment should be successful
