/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videogamescoreboardapp;

/**
 *
 * @author hhichri
 */
public class Student {

    private  static final int NUMBER_OF_GAMES = 10;
    private  String id;
    private  String name;
    private  int[] scores;

    // no-arg constructor
    public Student() {
        this.id = "";
        this.name = "";
        this.scores = new int[NUMBER_OF_GAMES];
    }

    public Student(String id, String name, int[] scores) {
        this.id = id;
        this.name = name;
        this.scores = new int[NUMBER_OF_GAMES];// create the memory space
        // copy all values
        for (int i = 0; i < this.scores.length; i++) {
            this.scores[i] = scores[i]; // copy the ith value
        }
    }
    // getters

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int[] getScores() {
        return this.scores;
    }
    // setters

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }

    public int getTotal() { // get total of all scores
        int total = 0; // Initialize accumulator
        for (int i = 0; i < this.scores.length; i++) {
            total += this.scores[i];
        }
        return total;
    }

    public double getAverage() {
        double average=0;
        average = 1.0*this.getTotal() / this.scores.length ;
        return average;
    }
    public String toDataLine(){
        String result = this.getId() + ", " + this.getName()  ;
        for (int i=0; i<this.scores.length; i++){
                 result = result + ", " + this.scores[i];
        }
        return result;
    }
    public  static Student fromDataLine(String line){
        //S001 , Arbis  Jaidon , 120 , 95 , 88 , 77 , 130 , 90 , 100 , 85 , 93 , 110
        String[] parts = line.split(",");
        for (int i=0; i<parts.length; i++){
            System.out.println("part["+i+"]: " + parts[i]);
        }
        String studentId = parts[0];
        String studentName = parts[1];
        int[]  studentScores;
        studentScores = new int[Student.NUMBER_OF_GAMES];
        for (int i=2; i<parts.length; i++){
            String str = parts[i].trim();
            int s = Integer.parseInt(str);
            studentScores[  i-2   ] = s;
        }
        Student newStudent = new Student(studentId ,studentName, studentScores);
        return newStudent;
    }
    
    public boolean equals(Student paramObj){
        // compate the this object with the parameter object which also of type Student
        boolean result = this.getId().equalsIgnoreCase(     paramObj.getId()   )      &&
                this.getName().equalsIgnoreCase(           paramObj.getName()      )    && 
                this.getScores()==paramObj.getScores();
        return result;      
    }
    
    public String toString(){
        String result =  this.getId() + " - " + this.getName();
         return result;
    }
    public String scoresToString(){
        String result =  "[";
        for (int i=0; i<this.scores.length; i++){
            result = result + this.scores[i] + ",";
        }
         result = result +  "]";
         return result;
    }
    
}
