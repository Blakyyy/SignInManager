This is a personal project that uses the Maven framework with MySQLConnect and JBCrypt dependencies.

BackendMethods Class
--------------------

The `BackendMethods` class contains the following fields:

-   `admin`: enter the name of a root administrator to the database
-   `url`: enter the URL of a database
-   `passkey`: enter password to enter the database.

Note that you should also check the functions with SQL queries to change the name of the database and table to use.

The following methods are available in the `BackendMethods` class:

-   `userAlreadyExist`: check if the input of the user in the field `username` is inside the database and return `true` if it is. If it's not, the method returns `false`.
-   `checkForPassword`: check if the input of user in the field `password` equals to the hashed password in the database. It returns `true` if it does. If it's not, the method returns `false`.
-   `tryToLogin`: uses the `userAlreadyExist` and `checkForPassword` methods. It returns `true` if the last 2 methods returned `true`, meaning the login is successful. It returns `false` if either of the previous methods returned `false`.
-   `signUp`: this method uses the `userAlreadyExist` method to know if there is already a user with the same username in the database. If there isn't, it also checks the email field to have symbol "@" and if it does, the signUp will be successful and the method returns 1. If the email field doesn't have "@" inside, then the method returns -1. If a user with this username already exists, the method returns -2. If there is any SQL exception, it prints the stack trace and returns -3.

Java_Gui Class
--------------

`Java_Gui` is the main user interface which the user sees when the application is executed. The following methods are available in this class:

-   `actionPerformed`: this is the backend for when the user presses the "Login" button. It also uses the `tryToLogin` method from the `BackendMethod` class. If the user presses the "Sign up" button, the `Java_Register_Gui` class starts.
-   `actionPerformedUser`: this gets the text from the username field. It also checks if the user entered the username with a space at the end ("admin ") and deletes it.
-   `actionPerformedPassword`: this gets the text from the password field.

Java_Register_Class
-------------------

`Java_Register_Class` is the second user interface that activates when the user presses the "Sign up" button. The following methods are available in this class:

-   `actionPerformed`: this is the backend of the "Sign up" button, which uses the `signUp` method from `BackendMethod` class.
-   `actionPerformedUser`: this gets the text from the username field. It also checks if the user entered the username with a space at the end ("admin ") and deletes it.

FinalApplication Class
----------------------

`FinalApplication` class starts the whole program.
