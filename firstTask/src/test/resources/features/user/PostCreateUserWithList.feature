@PetStoreUser
Feature: validate the pet services works ok
  As a tester
  I want to use the pet services
  To validate the right works of them

  Background:
    Given that the services of the pet store are available

  @STO010 @userWithList
  Scenario: the tester needs to place an order
    When the tester send a post request to create with list endpoint with valid user info
    Then the tester should obtain a status ok
    And the tester in the response body should get the same request body