
Feature: PetStore_Findings

  Scenario: Get all available pets
    Given I set api with base URL
    When I GET all dogs with "available" status 
    Then I assert the count of available pets in store
