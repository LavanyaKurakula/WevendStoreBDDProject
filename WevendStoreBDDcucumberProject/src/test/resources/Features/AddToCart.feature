Feature: Validate AddToCart functionality in HomePage
Scenario: Validate AddToCart button 
Given Launch the url "http://wevend.shop/"  
When User navigate to the AddToCart button under any product and click on it ["Mountain Dew", "Water", "Diet Coke"]
Then Product should be added to the cart
