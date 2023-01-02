import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Czas extends JLabel implements ActionListener {
    Timer timer = new Timer(1000, this);
    static int s = 0;
    //ustawienia panelu "czas" na ekranie gry
    Czas()
    {
        setText("Czas: 0");
        s = 0;
        timer.restart();
    }
    //zwiększanie licznika o 1 co sekundę
    @Override
    public void actionPerformed(ActionEvent w)
    {
     s++;
     setText("Czas: " + s);
    }
    static public int Cz()
    {
        return s;
    }
}