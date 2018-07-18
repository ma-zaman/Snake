import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class Map
{
  private Object[][] map;
  private Fruit f;

  public Map()
  {
    this.map = new Object [20][20];

    for (int i = 0; i<20; i++)
    {
      for (int j = 0; j<20; j++)
      {
        if(i == 0 || j == 0 || i == 19 || j == 19)
        {
          this.map[j][i] = new Wall();
        }
        else
        {
          this.map[j][i] = null;
        }
      }
    }
    this.map[10][10] = new Membre(true, "WE", 10, 10);

    initialiseFruit();
  }

  public void initialiseFruit()
  {
    Random rand = new Random();
    int x;
    int y;

    do {
      x = rand.nextInt(18)+1;
      y = rand.nextInt(18)+1;
    } while (this.map[x][y] != null);

    this.f = new Fruit(x, y);

    this.map[x][y] = this.f;

  }

  public boolean initialiseMap(Snake s)
  {
    for (int i = 1; i<19; i++)
    {
      for (int j = 1; j<19; j++)
      {
        this.map[j][i] = null;
      }
    }

    for (int i = 0; i < s.getBodySize(); i++)
    {
      this.map[s.getMembre(i).getX()][s.getMembre(i).getY()] = s.getMembre(i);
    }

    this.gameOver();

    if (this.map[this.f.getX()][this.f.getY()] == null)
    {
      this.map[this.f.getX()][this.f.getY()] = this.f;
    }
    else
    {
      Membre m = s.getMembre(s.getBodySize()-1);
      char c = m.getDir().charAt(0);
      if (c == 'S')
      {
        s.addMembre(new Membre(false, "SN", m.getX(), m.getY()+1));
      }

      else if (c == 'N')
      {
        s.addMembre(new Membre(false, "NS", m.getX(), m.getY()-1));
      }

      else if (c == 'E')
      {
        s.addMembre(new Membre(false, "EW", m.getX()+1, m.getY()));
      }

      else if (c == 'W')
      {
        s.addMembre(new Membre(false, "WE", m.getX()-1, m.getY()));
      }
      this.initialiseFruit();
      return true;
    }
    return false;
  }

  public void gameOver()
  {
    for (int i = 0; i<20; i++)
    {
      for (int j = 0; j<20; j++)
      {
        if((i == 0 || j == 0 || i == 19 || j == 19) && this.getCase(i, j) instanceof Membre)
        {
          System.exit(0);
        }
      }
    }
  }

  public Object getCase(int x, int y)
  {
    return this.map[x][y];
  }
}
