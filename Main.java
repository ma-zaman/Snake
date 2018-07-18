import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class Main extends JFrame
{
  private Map m;
  private Snake s;
  private String move;
  private boolean flag;
  private int score;

  public Main()
  {
    super("Snake (BETA)");

    this.setSize(500,500);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setVisible(true);

    initialiseMain();
    this.setSize(10, 10);
    this.revalidate();
    this.setSize(500, 500);
    this.revalidate();

    this.setFocusable(true);

    KListener lis = new KListener();
    this.addKeyListener(lis);

    this.move = "WE";
    this.flag = true;

    this.movement();
  }

  public void initialiseMain()
  {
    m = new Map();
    s = new Snake();
    s.addMembre((Membre)m.getCase(10, 10));
    this.affichage();
  }

  public void movement()
  {
    try
    {
        //m.initialiseMap(s);
        if (300-(this.getScore()*10) < 10)
        {
          Thread.sleep(10);
        }
        else
        {
          Thread.sleep(300-(this.getScore()*10));
        }
        s.moveKey(move);
        if(m.initialiseMap(s))
        {
          this.addScore();
          System.out.println("Score : "+this.getScore());
        }
        this.affichage();
        this.repaint();
        this.flag = true;
        this.movement();
    }
    catch(InterruptedException ex)
    {
        Thread.currentThread().interrupt();
    }
  }

  public void moveK(char c)
  {
    if(this.flag && c == 'Z' && !move.equals("NS"))
    {
      move = "SN";
      this.flag = false;
    }
    else if(this.flag && c == 'S' && !move.equals("SN"))
    {
      move = "NS";
      this.flag = false;
    }
    else if(this.flag && c == 'Q' && !move.equals("WE"))
    {
      move = "EW";
      this.flag = false;
    }
    else if(this.flag && c == 'D' && !move.equals("EW"))
    {
      move = "WE";
      this.flag = false;
    }
  }

  public int getScore()
  {
    return this.score;
  }

  public void addScore()
  {
    this.score ++;
  }

  public void affichage()
  {
    this.getContentPane().removeAll();
    ImageIcon groundIcon = new ImageIcon("img/ground.png");
    Image ground = groundIcon.getImage();
	  Image groundnew = ground.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);

    ImageIcon wallIcon = new ImageIcon("img/wall.png");
    Image wall = wallIcon.getImage();
	  Image wallnew = wall.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);

    ImageIcon appleIcon = new ImageIcon("img/apple.png");
    Image apple = appleIcon.getImage();
	  Image applenew = apple.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
    for (int i = 0; i<500; i += 25)
    {
      for (int j = 0; j<500; j += 25)
      {
        JLabel jlbl;
        if(m.getCase(j/25, i/25) instanceof Fruit)
        {
          jlbl = new JLabel(new ImageIcon(applenew));
          this.placeLabel(jlbl, i, j);
        }
        else if(m.getCase(j/25, i/25) instanceof Membre)
        {
          jlbl = new JLabel(new ImageIcon(s.getMembre(j/25, i/25).getImg()));
          this.placeLabel(jlbl, i, j);
        }
        if(m.getCase(j/25, i/25) instanceof Wall)
        {
          jlbl = new JLabel(new ImageIcon(wallnew));
        }
        else
        {
          jlbl = new JLabel(new ImageIcon(groundnew));
        }
        this.placeLabel(jlbl, i, j);
      }
    }
  }

  public void placeLabel(JLabel jlbl, int i, int j)
  {
    jlbl.setLocation(j, i);
    jlbl.setSize(25, 25);
    this.add(jlbl);
  }

  class KListener implements KeyListener
  {
    public void keyReleased(KeyEvent e)
    {
      moveK((char)e.getKeyCode());
    }
    public void keyPressed(KeyEvent e)
    {
      return;
    }
    public void keyTyped(KeyEvent e)
    {
      return;
    }
  }

  public static void main(String[] args) {
    new Main();
  }
}
