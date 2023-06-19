Feature: Validate Payment method 
@demo1
Scenario: Validate Payment method on review and payment page 
Given Open this url "http://wevend.shop/"  
When User navigate to the BuyNow button under any product and click on it "Water"
And User should be redirected to "http://wevend.shop/checkout/"
Then Payment method should be present on the page as "weVend Gateway"