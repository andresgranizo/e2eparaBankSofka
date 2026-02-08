@transfer
Feature: Transfer Funds
  As a logged in user
  I want to transfer money between accounts
  So that I can manage my funds

  Background:
    Given the user is logged into ParaBank
    And the user has at least two accounts

  @successful-transfer
  Scenario: Successful transfer between two accounts
    When the user transfers "100" dollars between accounts
    Then the transfer should be successful
