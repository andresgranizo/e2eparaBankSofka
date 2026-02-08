@login
Feature: User Login
  As a registered user
  I want to log into ParaBank
  So that I can access my accounts

  Background:
    Given the user is on the ParaBank home page

  @successful-login
  Scenario: Successful login with valid credentials
    Given a registered user exists
    When the user logs in with valid credentials
    Then the login should be successful
    And the user should see the accounts overview

  @failed-login
  Scenario: Failed login with invalid credentials
    When the user logs in with invalid credentials
    Then the login should fail
    And an error message should be displayed
