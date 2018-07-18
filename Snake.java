import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class Snake
{
  private ArrayList<Membre> body;

  public Snake()
  {
    this.body = new ArrayList<Membre>();
  }

  public void addMembre(Membre m)
  {
    this.body.add(m);
  }


  public Membre getMembre(int x, int y)
  {
    for(int i=0; i< this.body.size(); i++)
    {
      if (this.body.get(i).getX() == x && this.body.get(i).getY() == y)
      {
        return this.body.get(i);
      }
    }
    return null;
  }

  public Membre getMembre(int i)
  {
    return this.body.get(i);
  }

  public int getBodySize()
  {
    return this.body.size();
  }

  public void moveKey(String s)
  {
  /*  Membre m1 = new Membre(this.body.get(this.body.size()-1));
    for (int i = this.body.size()-1; i>2; i--)
    {
      m = new Membre(this.getMembre(i-1));
      this.body.set(i-1, m1);
      m1 = m;
    }*/
    char d = this.body.get(0).getDir().charAt(0);
    if(s.equals("SN"))
    {
      this.body.get(0).setDir("SN");
      if (this.getMembre(this.body.get(0).getX(), this.body.get(0).getY()-1) instanceof Membre)
      {
        System.exit(0);
      }
      else
      {
        this.body.get(0).setY(this.body.get(0).getY()-1);
      }
    }
    else if(s.equals("NS"))
    {
      this.body.get(0).setDir("NS");
      if (this.getMembre(this.body.get(0).getX(), this.body.get(0).getY()+1) instanceof Membre)
      {
        System.exit(0);
      }
      else
      {
        this.body.get(0).setY(this.body.get(0).getY()+1);
      }
    }
    else if(s.equals("EW"))
    {
      this.body.get(0).setDir("EW");
      if (this.getMembre(this.body.get(0).getX()-1, this.body.get(0).getY()) instanceof Membre)
      {
        System.exit(0);
      }
      else
      {
        this.body.get(0).setX(this.body.get(0).getX()-1);
      }
    }
    else if(s.equals("WE"))
    {
      this.body.get(0).setDir("WE");
      if (this.getMembre(this.body.get(0).getX()+1, this.body.get(0).getY()) instanceof Membre)
      {
        System.exit(0);
      }
      else
      {
        this.body.get(0).setX(this.body.get(0).getX()+1);
      }
    }
    this.body.get(0).setImg();
    if (this.body.size() > 1)
    {
      Membre m1 = new Membre(this.body.get(1));
      Membre m;
      for (int i = 2; i<this.body.size(); i++)
      {
        m = new Membre(this.getMembre(i));
        this.body.get(i).setX(m1.getX());
        this.body.get(i).setY(m1.getY());
        this.body.get(i).setDir(m1.getDir()); /////////////////////////////////////////////////// ERREUR : Ligne à modifier : si 180 alors pb dir : ERREUR ///////////////////////////////////////////////////

        this.body.get(i).setImg();
        m1 = m;
      }
////////////////////////////////////////////////////////////////////////////////////////////////////////
      if(s.equals("SN"))
      {
        if(d != 'N')
        {
          this.body.get(1).setDir(""+d+"N");
          this.body.get(1).setX(this.body.get(0).getX());
          this.body.get(1).setY(this.body.get(0).getY()+1);
        }
      }
      else if(s.equals("NS"))
      {
        if(d != 'S')
        {
          this.body.get(1).setDir(""+d+"S");
          this.body.get(1).setX(this.body.get(0).getX());
          this.body.get(1).setY(this.body.get(0).getY()-1);
        }
      }
      else if(s.equals("EW"))
      {
        if(d != 'W')
        {
          this.body.get(1).setDir(""+d+"W");
          this.body.get(1).setX(this.body.get(0).getX()+1);
          this.body.get(1).setY(this.body.get(0).getY());
        }
      }
      else if(s.equals("WE"))
      {
        if(d != 'E')
        {
          this.body.get(1).setDir(""+d+"E");
          this.body.get(1).setX(this.body.get(0).getX()-1);
          this.body.get(1).setY(this.body.get(0).getY());
        }
      }
      this.body.get(1).setImg();
    }
  }
}


////////////////////////////////////////
// 7  / 6  / 5  / 4  / 3  / 2  / 1 / 0 //
////////////////////////////////////////
