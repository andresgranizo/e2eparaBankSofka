@register
Feature: User Registration
  As a new user
  I want to register in ParaBank
  So that I can access banking services

  Background:
    Given the user is on the registration page

  @successful-registration
  Scenario: Successful registration with valid data
    When the user registers with valid data
    Then the registration should be successful

  @failed-registration
  Scenario: Failed registration with empty fields
    When the user tries to register with empty fields
    Then the registration should show an error
