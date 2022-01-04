# VersusTool-CI

## About

VersusTool web application to compare professional IT toolsS
Web application created for the Continuous Integration subject of the Master's Degree in Agile Software Development for the Web.
Its purpose is to compare different professional computer tools.
- Manage registered applications
- Manage the comparison criteria for each type of application
- Assign specific characteristics for each application
- In the main screen you can choose the applications to compare among the entire published catalog.
- From main screen you can choose the detailed comparison for each type of tool independently.

![Main screen](https://github.com/Hanxco/VersusTool-CI/blob/main/docGit/Captura.PNG?raw=true)

_**DISCLAIMER: VersusTool IS A PROTOYPE IN PROGRESS.**_ Not all features mentioned below are complete and implemented.

## Installation

The first step it's configure the user and password of your database in script.sh file. Start mysql server.
Distype can be installed via maven.
```sh
sh ./script.sh
mvn package
```