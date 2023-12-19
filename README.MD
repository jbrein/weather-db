# Weather Database w/ CLI
This application was constructed with Java using RestTemplate to consume the openweathermap.org API and store the latest
results inside a database. The application will update tables so only the latest query per user will be stored. 
Authentication of the user is required. 
## Note
The application uses a constant called **API_KEY** inside the weather services clas within the services package. 
Currently it is set to *"Your API Key here!"*. To have the application launch successfully, you must visit 
https://home.openweathermap.org/users/sign_up to get a free api key and replace the contents of the constant with your 
own.
## Instructions
* User should create the database via the create.sh file inside the database folder.
* Upon running the application, the user should create a username and password.
  * The user can play around with the app while unauthenticated to see what works and what doesn't
* After creating a username and password, the user should log into the application.
* The user can then test the rest of the functionality.