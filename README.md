# Sing in Sign up Project
This is my first personal project which uses Maven Framework with MySQLConnect and JBCrypt Dependencies. 

1. **BackendMethods Class**. 
In the fields admin - you should enter the name of a root administrator to the database
In the field url - you should enter the url of a database
In the field of passkey - you should enter password to enter the database.
(Also check the functions with SQL querrys to change the name of database and table to use.)
- **userAlreadyExist** - Check if the input of the user in the field username is inside the database and return true if it is. If its not the method returns false
- **checkForPassword** - Check if the input of user in the field password equals to the hashed password in the database. It returns true if it is. If its nor the method returns fale
- **tryToLogin** - uses method userAlreadyExist and checkForPassword. it returns true if the last 2 methods returend true. So login is succesfull. It return false if anyone of the previous methods returned fasle
- **signUp** - Method which use userAlreadyExist method to know if there is already a user with the same username in the database. If its not. Its also check for email field to have symbol "@" and if its true then singUp will be succesfull and the method returns 1. If email field doesnt have "@" inside then method return -1, If user with this username already exists the method returns -2. And if there is any SQL exception it prints stacktrace and returns -3;

2. **Java_Gui Class** - Its the main user interface which user see when the aplication is executed. 
- **actionPerformed method** - Its the backend for when the user presses the "Login" button. It also uses the tryToLogin method from the BackendMethod Class. And if user presses the "Sign up" Button the Java_Register_Gui class starts
- **actionPerformedUser** - Its get the text from the username field. It also checks if the user entered the username with a space at the end ("admin ") and delete it.
- **actionPerformedPassword** - Its get the text from the passwordField. 

3. **Java_Register_Class** - Its the second user Interface which activates when user presses the "Sign up" button. 
- **actionPerformed** - The backend of the "Sign up button" which uses the signUp method from BackednMethod class.
- **actionPerformedUser** - Its get the text from the username field. It also checks if the user entered the username with a space at the end ("admin ") and delete it.

4. **FinalApplication class** - Its starts the whole programm. 