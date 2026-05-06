package group2.hw5.minesweeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MinesweeperGameApplication Class for minesweeper
 * 
 * This is the **main entry point** for launching the Minesweeper Spring Boot application.
 *
 * @author Julian Hinojosa
 * @author Nathaniel McPherson
 * @author Kyle Tschida
 */

 @SpringBootApplication  // Marks this class as a Spring Boot application (enables auto-configuration, component scanning)
 public class MinesweeperGameApplication {
 
     /**
      * The main method that starts the Minesweeper web application.
      * 
      * @param args Command-line arguments passed to the application (if any)
      */
     public static void main(String[] args) {
         SpringApplication.run(MinesweeperGameApplication.class, args); // Boots the Spring application
     }
 }