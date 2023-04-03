This is a personal project that uses the Maven framework with MySQLConnect and JBCrypt dependencies.

his is a personal project that utilizes the Maven framework, along with MySQLConnect and JBCrypt dependencies to create a simple user authentication system.

Classes Overview
----------------

### BackendMethods Class

The `BackendMethods` class contains the following fields:

-   `admin`: Enter the root administrator's name for the database.
-   `url`: Enter the URL of the database.
-   `passkey`: Enter the password to access the database.

**Note**: Make sure to update the SQL queries within the functions to match the names of your database and table.
The `BackendMethods` class provides the following methods:

-   `userAlreadyExist`: Checks if the user input in the `username` field already exists in the database. Returns `true` if it does, otherwise `false`.
-   `checkForPassword`: Verifies if the user input in the `password` field matches the hashed password in the database. Returns `true` if it does, otherwise `false`.
-   `tryToLogin`: Utilizes `userAlreadyExist` and `checkForPassword` methods. Returns `true` if both methods return `true`, indicating a successful login. Returns `false` otherwise.
-   `signUp`: Validates the username and email fields before registering a new user. Returns 1 if successful, -1 if the email is invalid, -2 if the username already exists, and -3 if an SQL exception occurs.
### Java_Gui Class

`Java_Gui` serves as the primary user interface that the user sees when the application is executed. This class provides the following methods:

-   `actionPerformed`: Handles the "Login" button click event. It calls the `tryToLogin` method from the `BackendMethods` class. If the "Sign Up" button is clicked, the `Java_Register_Gui` class is launched.
-   `actionPerformedUser`: Retrieves the text from the username field and trims any trailing spaces.
-   `actionPerformedPassword`: Retrieves the text from the password field.

### Java_Register_Class

`Java_Register_Class` is the secondary user interface that appears when the user clicks the "Sign Up" button. This class provides the following methods:
-   `actionPerformed`: Handles the "Sign Up" button click event, utilizing the `signUp` method from the `BackendMethods` class.
-   `actionPerformedUser`: Retrieves the text from the username field and trims any trailing spaces.

### FinalApplication Class

The `FinalApplication` class serves as the entry point for the entire program.
