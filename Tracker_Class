//Description: Encapsulates all the visual aspects of the hurricane tracker,
                including the main window and animated hurricane map.
 ///javac --class-path doodlepad.jar Hurricane.java TrackPoint.java Tracker.java
 //java --class-path .;doodlepad.jar Tracker ____________(hurricane name in underline).txt
 */

 import java.io.*; //file import
 import java.util.Scanner; //scan import
 import java.io.IOException; // import file exception
 import doodlepad.*; //import doodlepad



public class Tracker extends Pad{
  // Chart pixel coordinate extents
  private double minx =38; //Minimum chart x-pixel coordinated
  private double maxx = 1237;    // Maximum chart x-pixel coordinate
  private double miny = 42;      // Minimum chart y-pixel coordinate
  private double maxy = 718;     // Maximum chart y-pixel coordinate

  // Chart latitude and longitude extents
  private double minlon = 22;    // Minimum chart longitude
  private double maxlon = 99;    // Maximum chart longitude
  private double minlat = 7;     // Minimum chart latitude
  private double maxlat = 45;    // Maximum chart latitude

  private int index = 0; //instantiating an index variable
  private Image t1; //instantiating an Image object
  private Hurricane h1;

  public Tracker(String dataFile){

    super("Tracker", 1275, 825); //declaring the super class constructor

    h1 = new Hurricane (dataFile);

    t1 = new Image("chart_1275x825.png", 0, 0); //loads image
    setTickRate(10);
    startTimer();
    redraw();
  }
  public void onTick(long when){
    TrackPoint tp2 = h1.getPoint(index);
    double latitude = tp2.getLatitude();
    double longitude = tp2.getLongitude();
    double speed = tp2.getSpeed();
    double radius = tp2.getRadius();

    //System.out.print("draw TrackPoint" + index);
    // Convert latitude and longitude to pixel coordinates
    double x = (maxlon-longitude)/(maxlon-minlon) * (maxx-minx) + minx;
    double y = (maxlat- latitude)/(maxlat-minlat) * (maxy-miny) + miny;

    Oval o1 = new Oval(x,y,radius*0.5,radius*0.5); //changes radius of oval in correspondance to radius of hurricane
    o1.setFillColor(speed,0,0); // //changes color of oval in correspondance to radius of oval
    //System.out.println(Radius);
    //System.out.println(Speed);
    index++; //when value of index exceeds number of TrackPoint objects managed by Hurricane obkect, timer stops
    if (index >= h1.getNumPoints()){
      stopTimer();
    }
  }
  public static void main(String[] args){ //retreives individual file and allows program to read them
    Tracker t = new Tracker(args[0]);

  }

}
