package beans;

import java.io.File;
import java.io.IOException;

public class LoadTester
{
        private static String filename = System.getProperty("user.dir")
          + File.separator + "src"
          + File.separator + "res"
          + "klassen.csv";
  public static void main(String[] args)
  {

      
    SchuelerModel sm = new SchuelerModel();
    try
    {
      sm.loadData(new File(filename));
    }
    catch (IOException ex)
    {
      ex.printStackTrace();
    }
    
    sm.printList();
  }
}
