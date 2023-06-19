@demo
Feature: Place an Order

Scenario:  Place an order using BuyNow button
Given Open url "http://wevend.shop/"  
When User navigates to the BuyNow button under any product and click on it "Water"
And User should be redirected to url "http://wevend.shop/checkout/"
And User clicks on proceed button 
And User selects card payment method and navigates to "https://wevend.world/cardpay"
And User enters card details [ "4111111111111111", "0624",  "123" ]
And User clicks on Pay button
Then Order should be placed and user will be navigated to "http://wevend.shop/checkout/onepage/success/"