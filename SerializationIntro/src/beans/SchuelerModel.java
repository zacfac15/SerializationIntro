package beans;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
  
  public void loadData() throws FileNotFoundException
  {
    BufferedReader br = new BufferedReader(new FileReader(""));
  }
  
  public void saveData(File f) throws FileNotFoundException, IOException
  {
    BufferedWriter wr = new BufferedWriter(new FileWriter(f));
    
  }

}
