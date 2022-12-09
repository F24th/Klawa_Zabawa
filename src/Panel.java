import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;

public class Panel extends JPanel implements ActionListener, KeyListener {

    Timer timer = new Timer(10, this);
    public int borderBottom = 462, borderBottomWithoutButtons = 555;
    int x, vx, y, vy = 0;
    public static int licznikIteracji = 0;
    String podzielone;
    JLabel myLabebl = new JLabel("");
    JLabel myLabebl2 = new JLabel("");
    int randX = 1000, randY = 1000, randXBad = 1000, randYBad = 1000;
    Image zd = Toolkit.getDefaultToolkit().createImage("lud_c.png");

    //Ogólne ustawienia głównego panelu gry
    Panel()
    {
     setBounds(0,100,1280,520);
     setBackground(Color.WHITE);
     setLayout(new GridLayout());
     setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
     timer.start();
     addKeyListener(this);
     setFocusable(true);
     setFocusTraversalKeysEnabled(false);
     this.add(myLabebl);
     this.add(myLabebl2);
    }

    //paintComponent odpowiedzialny za rysowanie postaci
    public void paintComponent(Graphics d)
    {
        super.paintComponent(d);
        d.drawImage(zd, x, y,null);
    }

    FileWriter fw = null;
    BufferedWriter bw = null;
    PrintWriter pw = null;
    Date date = new Date();

    //kontrolowanie "na żywo" położenia postaci oraz czy koliduje ona z literą
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (goodIntersection(x, y, randX, randY)) {
            System.out.println("good intersection");
            if (podzielone.length() > licznikIteracji) pokazLitery(podzielone);
            else {JOptionPane.showMessageDialog(null, "Wygrałeś, zajęło Ci to " + Czas.Cz() + " sekund!!", "Wygrana!", JOptionPane.INFORMATION_MESSAGE);
                try
                  {
                      fw = new FileWriter("Wynki.txt", true);
                      bw = new BufferedWriter(fw);
                      pw = new PrintWriter(bw);

                      pw.println("Czas potrzebny do zapisania słowa '" + podzielone + "' to " + Czas.Cz() + " sekund, czas gry: " + date);
                      pw.flush();
                  } catch (IOException ex) {
                      throw new RuntimeException(ex);
                  }
                System.exit(0);
                 };
        }
        if (badIntersection(x, y, randXBad, randYBad)) {
            System.out.println("bad intersection");
            JOptionPane.showMessageDialog(null, "Niestety, to zła litera! Spróbuj ponownie!!!", "Porażka...", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);

        }

        //Ograniczenie poruszania do pola gry
        if(x<0)
        {
            x=0;
            vx=0;
        }
        if(x>1245)
        {
            x=1245;
            vx=0;
        }
        if(y<0)
        {
            y=0;
            vy=0;
        }
        if(y>borderBottom)
        {
            y=borderBottom;
            vy=0;
        }

        x = x+vx;
        y = y+vy;
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    //Poruszanie się po ekranie (1)
    @Override
    public void keyPressed(KeyEvent e)
    {
        int c = e.getKeyCode();
        if(c == KeyEvent.VK_LEFT)
        {vx=-5; vy=0;}
        if(c == KeyEvent.VK_RIGHT)
        { vx=5; vy=0; }
        if(c == KeyEvent.VK_UP)
        { vy=-5; vx=0; }
        if(c == KeyEvent.VK_DOWN)
        { vy=5; vx=0; }

    }
    //Poruszanie się po ekranie (2)
    @Override
    public void keyReleased(KeyEvent e)
    {
        int c = e.getKeyCode();
        if(c == KeyEvent.VK_LEFT) { vx=0; }
        if(c == KeyEvent.VK_RIGHT) { vx=0; }
        if(c == KeyEvent.VK_UP) { vy=0; }
        if(c == KeyEvent.VK_DOWN) { vy=0; }
    }
    //Sprawdzanie kolizji z błędną literą
    public boolean badIntersection(int x, int  y, int randXBad, int randYBad){

        Rectangle goodLabel = new Rectangle(randXBad, randYBad, 40, 40);

        Rectangle result = SwingUtilities.computeIntersection(x, y, 20, 20, goodLabel);

        return (result.getWidth() > 0 && result.getHeight() > 0);
    }

    //Sprawdzanie kolizji ze dobrą literą
    public boolean goodIntersection(int x, int  y, int randX, int randY){

        Rectangle goodLabel = new Rectangle(randX, randY, 40, 40);

        Rectangle result = SwingUtilities.computeIntersection(x, y, 20, 20, goodLabel);

        return (result.getWidth() > 0 && result.getHeight() > 0);
    }

    //zmienna X dla dobrej litery
    public int randX(){
        int x;
        Random rand = new Random();
        x = rand.nextInt(1100)+50;
        randX = x;
        return x;
    }

    //zmienna Y dla dobrej litery
    public int randY(){
        int y;
        Random rand = new Random();
        y = rand.nextInt(borderBottomWithoutButtons - 100)+50;
        randY = y;
        return y;
    }

    //zmienna X dla złej litery
    public int randXBad(){
        int x;
        Random rand = new Random();
        x = rand.nextInt(1100)+50;
        randXBad = x;
        return x;
    }

    //zmienna Y dla złej litery
    public int randYBad(){
        int y;
        Random rand = new Random();
        y = rand.nextInt(borderBottomWithoutButtons - 100)+50;
        randYBad = y;
        return y;
    }

    public void pokazLitery(String tmp){

        podzielone = tmp;
        String[] podzielone = tmp.split("");

        myLabebl.setText(podzielone[licznikIteracji]);
        myLabebl.setLocation(this.randX(), this.randY());
        myLabebl.setSize(40,40);
        myLabebl.setFont(new Font("Arial", Font.BOLD, 40));
        myLabebl.setForeground(Color.decode("#8C14A9"));

        char[] zle = {'x', 'ą', 'ó', 'v', 'ń', 'q', 'ć', 'ś'};
        int z;
        int d = zle.length;
        Random rand = new Random();
        z = rand.nextInt(d - 0);

        myLabebl2.setText(String.valueOf(zle[z])); // losowanie litery zlej
        myLabebl2.setLocation(this.randXBad(), this.randYBad());
        myLabebl2.setSize(40,40);
        myLabebl2.setFont(new Font("Arial", Font.BOLD, 40));
        myLabebl2.setForeground(Color.decode("#8C14A9"));

        licznikIteracji++;
    }

}
