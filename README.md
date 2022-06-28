# Capstone
This is my capstone project for the TekSystems Bootcamp. The goal of this project is to have a functional program that utilizes the tools we learned througout the course.

![FrontPage](/src/main/resources/static/images/frontPage.jpg)

## About project
A web application for social media where users can log in and immediately post and comment on others.
### User Story
"I want to be able to post and comment on mine and others posts, be able to login and check on my posts."

## Technologies Used
Spring Boot

Spring Security

Tailwind CSS

Bootstrap CSS

MariaDB

Thymeleaf

JUnit

## Schema Picture

![SchemaDB](/src/main/resources/static/images/capstoneDB1.jpg)

## Why I Made The Project
I wanted to get a taste of how a social media website works using the tools learned in the course. I wanted to see if I can pull off something like a Reddit-based website or something similar. Ideally I wanted to try async functions and make something like Discord with all the instant messaging and such. However, most of the difficulty of the course is using the techonologies and applying it to the project. The difficulty was high, and the obstacles were even more so.

But even so, the challenges made me learn and understand Spring Boot as well as all the other technologies applied to this project. I am motivated to learn and understand what I did wrong and improve on this site in the near future.

Probably the most difficult challenges were how to use the request methods as well as adding security to the website. I couldn't figure out how to add delete functionality with Thymeleaf despite there being the options to use GET and POST requests. Will ask my fellow students about that later. Because of this, there isn't much besides just GET and POST requests.

Also the security is just for logging in and hashing the password.

I had big plans for this but I had difficulty getting the project to have basic functionality. It does have it now but it still needs more polish.

## What To Add
UPDATE and DELETE requests, keeping track of comments that respond to comments, users being able to chat with other users. If possible also reducing GET and POST requests because Spring Boot is doing this constantly and I get the feeling that there is a more efficient way to approach this. Also add images and videos thru links.