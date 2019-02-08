# Multi-user Budgeting App

## Setup
Step 1: Fork this repository in GitHub

Forking means to copy a repository that someone else owns in order for you to start 
working on it without affecting the original. For more information, see 
[here](https://help.github.com/articles/fork-a-repo/).

Step 2: Clone the repository locally

On your machine, open up the Git Bash terminal.
```bash
git clone https://github.com/your-github-username/budgeting-app.git
cd budgeting-app/
# start working...
```

Step 3: Import the project into workspace
* File > Open Projects From File System... (this will auto-detect which kind of project you're importing)
* Click "Directory" and find the location of the folder
* Note: your workspace directory must be different than the project directory.

## Starting the application
1. Click "Play" in your IDE (Eclipse / STS)
2. Your application should be starting up. You will see logs printing on your console

How do I know my application is running?
1. Open Chrome
2. Enter "localhost:9595/actuator/health" in the navigation bar
3. If the text displayed is: "status": "UP" in JSON data, then your application is running

## Endpoints
To see documentation on which endpoints (URLs) you can access from the front-end, 
visit http://localhost:9595/swagger-ui.html while your app is running.

The front-end of your application can be accessed at http://localhost:9595/index.html.
**Note that your Java back-end must be running to access this!**

## Working on the application
**Important: you are only to work on the classes defined in `src/main/java` in the `com.revature.spark.todo` package. 
Touching anything outside this package can cause detrimental effects on the application**

You can also edit the `src/main/resources/static` folder for your HTML, CSS, and JavaScript files.

Implement the methods within the `AssociateImplementation` class.

## Project requirements
### Java back-end
* Implement Java methods to return the min, max, average, and median expenses by their cost.
* Note: these methods are to be implemented in the `com.revature.spark.todo.AssociateImplementation` class.
* **Do not use any APIs to complete these methods.**

### Front-end
Implement the user interface with HTML/CSS and connect to the back-end using JavaScript and AJAX.

User should be able to: 
* Retrieve all expenses and show the min, max, average, and median costs.
* Retrieve all expenses and view in a table
* Create an expense and assign it to a user
* Update an expense
* Delete an expense
* BONUS: show the highest expense category for each user

Good luck :)
