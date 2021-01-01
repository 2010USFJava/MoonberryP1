# Moonberry TRMS

## Project Description

The purpose of the TRMS(Tuition Reimbursement Mangement System) is to provide a system that encourages quality knowledge growth relevant to an individual’s expertise. The Moonberry TRMS provides employees with an application to submit reimbursment requests and have them approved.

## Technologies Used

* Java - version 1.8
* Servlets - version 4.0.1
* JDBC - version 4
* PostgreSQL- version 9.1
* HTML/CSS- version 5
* Javascript- version ES6
* Bootstrap- version 3.3.7
* AJAX- version 3.3.1
* JUnit - version 4
* log4j- version 2.8.2
* Tomcat Server - version 9.0
* Spring Tool Suites - version 4.8.0
* DBeaver - version 7.2.4
* Trello 


## Features

List of features ready and TODOs for future development
* Employees or approvers can log in and log out. The session data is saved in cookies.
* Employees can submit forms to mke new reimbursement requests. Validation is performed before the form can be submitted. If the reimbursement is submitted within 2 weeks of the event's start date, the request is marked urgent.
* Approvers can approve or reject the reimbursement requests.

To-do list:
* Provide functionality for the user to request more reimbursement than their yearly $1000 allocation.
* Automatically archive old completed requests so the "pending" requests are more visible.

## Getting Started
   
`git clone https://github.com/2010USFJava/MoonberryP1.git`

`cd MoonberryP1`

* Open STS
* Import MoonberryP1 as a maven project
* Maven -> Update Project
* Run as -> Run on Server
* Replace database.properties with your own database info. Populate with trms_creation.sql.

## Usage

* Run on localhost:8080
* Login as username = blue and password = moon for an employee.
* Login as username = lapp and password = lapp for an approver.

## Contributors

Nadjah Robinson and Michelle Zhang

## License

This project uses the MIT license.
