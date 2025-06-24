@PetStorePet
Feature: validate the pet services works ok
  As a tester
  I want to use the pet services
  To validate the right works of them

  Background:
    Given that the services of the pet store are available

  @STO011 @userLogin
  Scenario: the tester needs to login as a user
    When the tester send a get request to login as a user
    Then the tester should obtain a status ok
    And the tester in the response headers obtain two specific headers