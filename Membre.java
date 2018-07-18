import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class Membre
{
  private boolean head;
  private String dir;
  private Image img;
  private int x;
  private int y;

  public Membre(boolean h, String d, int x, int y)
  {
    this.head = h;
    this.dir = d;
    this.x = x;
    this.y = y;
    this.setImg();
  }

  public Membre(Membre m)
  {
    this.head = m.getHead();
    this.dir = m.getDir();
    this.x = m.getX();
    this.y = m.getY();
    this.img = m.getImg();
  }

  public boolean getHead()
  {
    return this.head;
  }

  public String getDir()
  {
    return this.dir;
  }

  public void setDir(String d)
  {
    this.dir = d;
  }

  public Image getImg()
  {
    return this.img;
  }

  public void setImg()
  {
    ImageIcon picIcon;
    if (this.head)
    {
      picIcon = new ImageIcon("img/head"+this.dir+".png");
    }
    else
    {
      picIcon = new ImageIcon("img/body"+this.dir+".png");
    }
    Image pic = picIcon.getImage();
	  this.img = pic.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH);
  }

  public int getX()
  {
    return this.x;
  }

  public void setX(int x)
  {
    this.x = x;
  }

  public int getY()
  {
    return this.y;
  }

  public void setY(int y)
  {
    this.y = y;
  }
}
