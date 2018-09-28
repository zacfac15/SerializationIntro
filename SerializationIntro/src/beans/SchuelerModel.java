package beans;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;
import javax.swing.AbstractListModel;

public class SchuelerModel extends AbstractListModel<Schueler>
{

  private List<Schueler> list = new LinkedList<>();

  @Override
  public int getSize()
  {
    return list.size();
  }

  @Override
  public Schueler getElementAt(int index)
  {
    return list.get(index);
  }
  
  public void add(Schueler schueler)
  {
    list.add(schueler);
    
    this.fireIntervalAdded(schueler, 0, list.size()-1);
  }
  
  public void loadData(File f) throws FileNotFoundException, IOException
  {
    BufferedReader br = new BufferedReader(new FileReader(f));
    
    String line;
    while((line = br.readLine()) != null)
    {
      String[] tokens = line.split(";");
      String name = tokens[0];
      String datum = tokens[2];
      String[] datet = datum.split(".");
      
      int jahr = Integer.parseInt(datet[0]);
      int monat = Integer.parseInt(datet[1]);
      int tag = Integer.parseInt(datet[2]);
      
      list.add(new Schueler(name, LocalDate.of(jahr, monat, tag)));
    }
    br.close();
  }
  
  public void saveData(File f) throws FileNotFoundException, IOException
  {
    BufferedWriter wr = new BufferedWriter(new FileWriter(f));
    
    for(Schueler s: list)
    {
      wr.write(s.getName());
      wr.write(";");
      wr.write(s.getBirthday().toString());
      wr.newLine();
    }
    wr.flush();
    wr.close();
  }
  
  public void printList()
  {
    for (int i = 0; i < list.size(); i++)
    {
      list.get(i).toString();
    }
  }

}
