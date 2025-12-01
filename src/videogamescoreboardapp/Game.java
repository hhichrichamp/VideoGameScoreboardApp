/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videogamescoreboardapp;

/**
 *
 * @author hhichri
 */
public class Game {
//    int id 
//o String title 
//o String genre 
//o String publisher

    private int id;
    private String genre;
    private String title;
    private String publisher;
    // No-argument constructor
    public Game() {
        this.id = 0;
        this.genre = "";
        this.title = "";
        this.publisher = "";
    }
    // all-argument constructor
    public Game(int id, String g, String t, String p) {
        this.id = id;
        this.genre = g;
        this.title = t;
        this.publisher = p;
    }
    // getters
    public int getId() {
        return this.id;
    }
    public String getTitle() {
        return this.title;
    }
    public String getGenre() {
        return this.genre;
    }
    public String getPublisher() {
        return this.publisher;
    }
    // setters
    public void setId(int id) {
         this.id  = id;
    }
    public void setTitle(String title) {
         this.title=title;
    }
    public void setGenre( String genre) {
         this.genre = genre;
    }
    public void setPublisher( String publisher) {
         this.publisher = publisher;
    }
    
    public String toString(){
        String result = "";
        result = String.format("%5d - %20s (%15s, %15s)",
                this.getId(), this.getTitle(), this.getGenre(), this.getPublisher());
        return result;
    }
    
    public boolean equals(Game parameterObject){
        // compare this object to the parameter object
        boolean result = true;
        result = this.getTitle().equalsIgnoreCase(parameterObject.getTitle()       )     &&
                this.getGenre().equalsIgnoreCase(              parameterObject.getGenre()        )       &&
                this.getPublisher().equalsIgnoreCase(           parameterObject.getPublisher()             )      ;
        return result;
    }
    public   String toDataLine() {
        // output like this 1,Galaxy Wars,Shooter,NovaSoft
        String result = this.getId() +"," + this.getTitle()+"," + 
                this.getGenre()+"," + this.getPublisher();
        return result;
    }
    public static Game fromDataLine(String line) {
        // line is like this 1,Galaxy Wars,Shooter,NovaSoft
        String[] parts = line.split(",");
        for(int i=0; i<parts.length ; i++){
            System.out.println("part " + i + ": "+ parts[i]);
        }
        int id =  Integer.parseInt(  parts[0]  )  ;
        Game gameObj = new Game( id , parts[1], parts[2], parts[3] );
        return gameObj;
    }
    
}
