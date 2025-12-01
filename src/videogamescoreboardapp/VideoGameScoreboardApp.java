/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package videogamescoreboardapp;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author hhichri
 */
public class VideoGameScoreboardApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        //Create Scoreboard 
        Scoreboard myScoreboard = new Scoreboard();
        
        myScoreboard.loadGames("D:\\420-N12-Java1\\coding\\VideoGameScoreboardApp\\src\\videogamescoreboardapp\\games.txt");
        myScoreboard.loadScores("D:\\420-N12-Java1\\coding\\VideoGameScoreboardApp\\src\\videogamescoreboardapp\\scores.txt");
       

//  Load data files on start, we will call two methods here to read data from files
// Show menu loop and collect user’s choice with Scanner 
        while (true) {
            int choice = -1;
            do {
                printMenu();
                choice = Utilities.getUserChoice("Please, enter choice: ");
            } while ((choice < 0) || (choice > 8));
            switch (choice) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    hanleListGames(myScoreboard);
                case 2:
                    handleListStudents(myScoreboard);
                    break;
                case 3:
                    handleStudentReport();
                    break;
                case 4:
                    handleTopNforAgame();
                    break;
                case 5:
                    handleUpdateStudentScore();
                    break;
                case 6:
                    handleGameStats();
                    break;
                case 7:
                    handleAddNewStudent();
                    break;
                case 8:
                    handeSaveData();
                    break;
            }
        }
// Validate inputs (IDs exist, scores >= 0) 
// Save on command or exit
    }

    private static void printMenu() {
        System.out.println("""
                           1. handleListGames 
                           2. handleListStudents 
                           3. handleStudentReport 
                           4. handleTopNforAgame 
                           5. handleUpdateStudentScore 
                           6. handleGameStats 
                           7. handleAddNewStudent 
                           8. HandeSaveData
                           0. Exit
                           """);
    }

    public static void hanleListGames(Scoreboard sb) {
        System.out.println("Handling List Game choice.");
        sb.listGames();
    }

    public static void handleListStudents(Scoreboard sb) {
        System.out.println("Handling List Studnents choice.");
        sb.listStudents();
    }

    public static void handleStudentReport() {
        System.out.println("Handling Show Student Report choice.");
    }

    public static void handleTopNforAgame() {
        System.out.println("Handling Top N for a game choice.");
    }

    public static void handleUpdateStudentScore() {
        System.out.println("Handling update Student Score choice.");
    }

    public static void handleGameStats() {
        System.out.println("Handling Game Stats choice.");
    }

    public static void handleAddNewStudent() {
        System.out.println("Handling Add New Student choice.");
    }

    public static void handeSaveData() {
        System.out.println("Handling Save Data choice.");
    }

}
