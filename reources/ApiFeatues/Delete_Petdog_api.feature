
Feature: PetStore_Findings

    Scenario: Delete the pet
    
    Given I set api with base URL
   	Given Pet has been already added with id "12202125"
    When I delete the pet with id "12202125" and api_key "anyString"
    Then I assert the status of the pet with id "12202125"
    
    
    