# Using SonarCloud and Travis-CI

## Set Up GitHub Repo
1. Create a github repository for your source code -- for example a repository hosting an angular application such as this one https://github.com/carolynrehm/angular-test
2. this repository will need to include a file which provides instructions to Travis-CI on how to build and scan the application - a .travis.yml file should be placed in the root directory
    
**Example .travis.yml file for an angular application**

```yml
language: node_js
node_js:
    - "6.9"

branches:
    only:
        - master

before_script:
    - npm install -g @angular/cli

script:
    - ng build --prod
    - npm install sonar-scanner
    - sonar-scanner -Dsonar.projectKey=angular-demo-2 -Dsonar.organization=carolynrehm-github -Dsonar.sources=src -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=$SONAR_TOKEN
```
- this .travis.yml will use node to install angular, build the application, install sonar-scanner and then scan the application - the source code is limited to the src folder
- make sure to chnage projectKey and organization to the appropriate values for your application
- $SONAR_TOKEN is an environment variable that we provide that allows Travis authorization to our Sonar account
- remove the before script and the build command to just do static code analysis without the build

## Set Up Travis
1. Use GitHub to log into travis-ci.org (travis-ci.com is the paid version which allows for access to private repositories)
2. Navigate to https://travis-ci.org/account/repositories and activate the repository you're working with
    - if you don't see the repository listed click on the "Sync Account" button on the left (it may take a minute for it to be available)
    - you may also have to add authorization to an additional organization if the repository is in another organization

#### Provide Travis webhook to GitHub
1. In the repository go to Settings > Webhooks. Add http://notify.travis-ci.org/ 

## Set Up Sonar
1. Sign into sonarcloud.io using GitHub
2. Analyze a new project (+ on the top right)
3. Go to Setup manually and choose the organization corresponding to the appropriate source code and give it a name (name of your repo) - click setup
4. At this point the last step is to provide Travis with the authorization for this project. Go to "configure analysis" under the project on your dashboard and generate a token and click continue. Don't worry about the "Run anaysis on your project portion" (although this would give you instructions for )

#### Provide Sonar Authentication to Travis
1. Go back to travis and navigate to the appropriate repository. Go to More options > Settings and add the token as an environment variable (in this case "SONAR_TOKEN")

