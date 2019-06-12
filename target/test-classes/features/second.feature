Feature: secure.smartbear login

  Scenario: Verify login to application
   Given launch browser and open application
   When Enter username and Enter password
   And click on login button 
    
  Scenario: open Practice section
  Given launch browser and open application
  When  I Open Practice section
  Then Verify practice page Title
  

   