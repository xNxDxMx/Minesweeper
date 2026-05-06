Minesweeper Game

A web-based implementation of the classic Minesweeper game built with Java, Spring Boot, and Thymeleaf. This project was developed as part of an ICS 372 coursework assignment focused on object-oriented design, MVC architecture, and interactive web application development.

Project Overview

This Minesweeper application recreates the traditional Minesweeper experience with:

 - Interactive grid-based gameplay
 - Random mine generation
 - Recursive flood reveal logic
 - Flag placement system
 - Win/Loss detection
 - Responsive web interface using Thymeleaf and CSS

Technologies Used
  Backend:
     - Java 21
     - Spring Boot 3.4.4
     - Thymeleaf
     - Maven
  Frontend:
     - HTML5
     - CSS3
     - Thymeleaf Templates
  Testing:
     - JUnit 5

Project dependencies are managed using Maven.

Project Structure

src/
├── main/
│   ├── java/
│   │       ├── Cell.java
│   │       ├── Flag.java
│   │       ├── Grid.java
│   │       ├── Mine.java
│   │       ├── Minesweeper.java
│   │       └── MinesweeperGameApplication.java
│   │
│   └── resources/
│       ├── templates/
│       │   ├── index.html
│       │   └── game.html
│       ├── static/
│       │   ├── style.css
│

Features

Core Gameplay:
 - 8x8 beginner board with 10 mines
 - 16x16 advanced board with 40 mines
 - Randomized mine placement
 - Adjacent mine counting
 - Recursive empty-cell reveal (flood fill)
 - Game over detection
 - Win condition tracking
Flag System:
 - Place and remove flags on unrevealed cells
 - Prevent revealing flagged cells
Web Interface:
 - Interactive browser-based gameplay
 - Dynamic board rendering with Thymeleaf
 - Styled UI using CSS

How the Game Works

Grid Generation:

 - The Grid class initializes the board, places mines randomly, and calculates adjacent mine counts for each cell.

Reveal Logic:
 - When a player clicks a cell:
 - If the cell contains a mine → game over
 - If the cell is empty (0 adjacent mines) → neighboring cells are recursively revealed
 - If all safe cells are revealed → player wins

This recursive reveal behavior is implemented using a flood fill algorithm.

Flagging:
 - Players can toggle flags on unrevealed cells to mark suspected mines.

Running the Project:

Prerequisites:

Make sure you have installed:
 - Java 21
 - Maven

Clone the Repository:

 - git clone <your-repository-url>
 - cd minesweeper

Run the Application

Using Maven:
 - mvn spring-boot:run

Or run the packaged JAR:
 - mvn clean package
 - java -jar target/minesweeper-0.0.1-SNAPSHOT.jar

Access the Game
After starting the application, open your browser and go to:
 - http://localhost:8080



