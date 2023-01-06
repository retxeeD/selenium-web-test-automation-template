#language: en
#Author: Pedro Lima
#Version: 1.0
#Encoding: UTF-8

@RegisterUserFeature
Feature: : Register account

  @CT_001 @Positive
  Scenario: Register a new account
    Given that I'm on the index page
    And I have a valid email to register
    When I click the enter button
    Then I'm redirected to the registration page