package beans;

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
  
  public void loadData()
  {
    
  }
  
  public void saveData()
  {
    
  }

}
