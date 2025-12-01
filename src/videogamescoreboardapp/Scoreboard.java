/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videogamescoreboardapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author hhichri
 */
public class Scoreboard {

    private final int MAX_STUDENTS = 100;
    private int studentCount;
    private Game[] games;
    private Student[] students;
    
    // this is an inner class
    class Stats{
       public int min;
       public int max;
       public double avg;
    }

    // no-argument constructor
    public Scoreboard() {
        this.studentCount = 0;
        this.students = new Student[this.MAX_STUDENTS];
        this.games = new Game[10];
    }

    public Scoreboard(int studentCount, Game[] games, Student[] students) {
        this.studentCount = studentCount;
        this.students = new Student[this.MAX_STUDENTS];
        for (int i = 0; i < students.length; i++) {
            this.students[i] = students[i];
        }
        this.games = new Game[games.length];
        for (int i = 0; i < games.length; i++) {
            this.games[i] = games[i];
        }
    }

    // setters involving arrays
    public void setGames(Game[] games) {
        this.games = new Game[games.length];
        for (int i = 0; i < games.length; i++) {
            this.games[i] = games[i];
        }
    }

    public void loadGames(String filename) throws FileNotFoundException {
        File fileObj = new File(filename);
        Scanner myScanner = new Scanner(fileObj);
        int i = 0;
        while (myScanner.hasNext()) {
            String line = myScanner.nextLine();
            // parse the line into different parts, then create an object 
            Game gameObj2 = Game.fromDataLine(line);
            // put the object in the array games.
            games[i] = gameObj2;
            System.out.println("The line is : " + line);
            System.out.println("Game obj: " + gameObj2);
            i++;
        }
        myScanner.close();
    }

    public void loadScores(String filename) throws FileNotFoundException {
        File fileObj = new File(filename);
        Scanner scannerObj = new Scanner(fileObj);
        int i = 0;
        while (scannerObj.hasNext()) {
            String line = scannerObj.nextLine();
            // parse the line into different parts, then create an object 
            Student studObj = Student.fromDataLine(line);
            // put the object in the array games.
            this.students[i] = studObj;
            System.out.println("The line is : " + line);
            System.out.print("Student obj: " + this.students[i]);
            System.out.println("Student obj: " + this.students[i].scoresToString());
            i++;
        }
        this.studentCount = i;
        scannerObj.close();
    }

    public void listGames() {
        for (Game g : this.games) {
            System.out.println(g);
        }
    }

    public void listStudents() {
        for (int i = 0; i < this.studentCount; i++) {
            Student g = this.students[i];
            System.out.print(g.toString());
            System.out.println("");
            //System.out.println(g.scoresToString());
        }
    }

    public Student findStudentById(String id) {
        Student studentObj = null;
        for (int i = 0; i < this.studentCount; i++) {
            Student s = this.students[i];
            if (id.equals(s.getId())) {
                studentObj = s;
                break;
            }
        }
        return studentObj;
    }

    public int findGameIndexById(int id) {
        int foundIndex = -1;
        for (int i = 0; i < this.games.length; i++) {
            Game s = this.games[i];
            if (id == s.getId()) {
                foundIndex = i;
                break;
            }
        }
        return foundIndex;
    }

    public void updateScore(String studentId, int gameId, int newScore) {
        // find the student object with studentid
        Student foundStudent = this.findStudentById(studentId);
        if (foundStudent == null) {
            System.out.println("Stduent with id: " + studentId + " is not found.");
        } else {
            // update the score for Game with gameId
            int[] scores = foundStudent.getScores();
            scores[gameId] = newScore;
        }
    }

    public Stats computeStatsForGame(int gameIndex) {
        
        // get  scores of all studdents for a particular game 
        for (int i=0; i<this.studentCount; i++){
            Student s = this.students[i];
            int[] allHisScores = s.getScores();
            int score = allHisScores[gameIndex];
            System.out.print(score + ", ");
        }
        
    }
}
