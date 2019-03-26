//Encapsulates and manages a single data point in a hurricane track, including its location, radius and wind speed.
//javac --class-path doodlepad.jar Hurricane.java TrackPoint.java Tracker.java
//java --class-path .;doodlepad.jar Tracker ____________(hurricane name in underline).txt 

import java.io.*; //file import
 import java.util.Scanner; //scan import
 import java.io.IOException; // import file exception



public class TrackPoint {
  private double Latitude = 0.0; //instantiating variables to be used later in program
  private double Longitude = 0.0; // ""
  private double Radius = 0.0; // ""
  private double Speed = 0.0; // ""

  public TrackPoint(String line){
     String[] items = line.split(","); //splits the line at the comma

     String trim1 = items[4].trim(); //latitude trimming
     trim1 = trim1.substring(0,trim1.length()-1);
     Latitude = Double.parseDouble(trim1);

     String trim2 = items[5].trim(); //longitude trimming
     trim2 = trim2.substring(0,trim2.length()-1);
     Longitude = Double.parseDouble(trim2);

     String trim3 = items[6].trim(); //speed parsing
     Speed = Double.parseDouble(trim3);

     String trim4 = items[8].trim(); //Radius parsing
     Radius = Double.parseDouble(trim4);

   }
  public double getLatitude(){ //getting the latitude from file
     return Latitude;
   }
  public double getLongitude(){ //getting the longitude from file
     return Longitude;
   }
  public double getSpeed(){ //getting the speed from file
     return Speed;
   }
  public double getRadius(){ //getting the radius from file
     return Radius;
   }
  public static void main(String[] args) {
     //test point
     String line = "20070813, 0600,  , TD, 12.2N,  28.9W,  30, 1006,    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,";
     TrackPoint t = new TrackPoint(line);
     //prints latitude, longitude, speed, and radius values
     System.out.println(t.getLatitude());
     System.out.println(t.getLongitude());
     System.out.println(t.getSpeed());
     System.out.println(t.getRadius());
   }
 }
