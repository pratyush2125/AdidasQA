
Feature: Update pet

   Scenario: Update the added available pet
    Given I set api with base URL
    Given Pet has been already added with id "7856897"
    When I update the status to "sold" for pet
    Then I assert the status of the pet with id "7856897"

    