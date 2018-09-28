package beans;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

public class SaveTester
{
  private static String filename = System.getProperty("user.dir")
          + File.separator + "src"
          + File.separator + "res"
          + File.separator + "klassen.csv";
  
  public static void main(String[] args)
  {
    Schueler s1 = new Schueler("Hans H.",LocalDate.of(2000, Month.MARCH, 1));
    Schueler s2 = new Schueler("Hubert F.",LocalDate.of(2000, Month.MARCH, 1));
    
    SchuelerModel sm = new SchuelerModel();
    sm.add(s1);
    sm.add(s2);
    
    try
    {
      sm.saveData(new File(filename));
    }
    catch (IOException ex)
    {
      ex.printStackTrace();
    }
  }
}
