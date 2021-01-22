
Feature: PetStore_Findings

  Scenario: Post a new available pet
    Given I set api with base URL
    When I post a new "available" with id-"23578" in the store
    Then I assert the status of the pet with id "78567"
   	
    
    