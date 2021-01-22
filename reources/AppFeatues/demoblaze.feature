
Feature: Demoblaze_Findings

    Scenario: Book Orders from Demoblaze
    
    Given I launch driver with "Demoblaze" url
   	When I Navigate to "Laptop" categories
    And I click on "Sony vaio i5" laptop product link
    And I Click on "Add to Cart"
    Then Handle pop-up window
    And Go to "Home" section
    When I Navigate to "Laptop" categories
    And I click on "Dell i7 8gb" laptop product link
    And I Click on "Add to Cart"
    Then Handle pop-up window
    And Go to "Cart" section
    Then Delete product "Dell i7 8gb" from cart 
    And Go to "Place Order" section
    And Fill the order details form
    And I Click on "Purchase" button
    And Capture order details
    And Assert the purchase amount
    And Click on Final OK button 

    