//Description: Encapsulates and manages the entire record of a single hurricane track, including the hurricane name and all data points that describe how it behaved over time.
///javac --class-path doodlepad.jar Hurricane.java TrackPoint.java Tracker.java
//java --class-path .;doodlepad.jar Tracker ____________(hurricane name in underline).txt 
 */

 import java.io.*; //file import
 import java.util.Scanner; //scan import
 import java.io.IOException; // import file exception
 import doodlepad.*; //import doodlepad
 import java.util.*; //import arrayList and other things

public class Hurricane {

  private ArrayList<TrackPoint> list1 = new ArrayList<TrackPoint>(); //declaring and instantiating an array object
  private String name;

  public Hurricane(String dataFile){
    try (Scanner  sc = new Scanner(new File(dataFile))){ //opens HURDAT2-formatted file

        String line = sc.nextLine();
        String[] items = line.split(","); //splits the line at the comma
        name = items[1].trim();

        while (sc.hasNext()) { //reads al lines of data from HURDAT2-formatted file
          line = sc.nextLine();
          TrackPoint tp1 = new TrackPoint(line); //passes each data line read from file to TrackPoint object cnostructor
          list1.add(tp1);
        }
    }

    catch (FileNotFoundException ex) {
      System.out.println("Error:" + ex);

    }
  }
  public String getName(){ //returns name of hurricane parsed from first line of file
    return name;
  }
  public int getNumPoints(){ //returns the number of TrackPoint objects
    return list1.size();
  }
  public TrackPoint getPoint(int index){ // returns the TrackPoint object stored in the internal ArrayList<> at index.
    return list1.get(index);
  }
  public static void main(String[] args) { //prints number of TrackPoint objects in DEAN
    Hurricane dh = new Hurricane("DEAN.txt");
    System.out.println(dh.getNumPoints());
  }
}
