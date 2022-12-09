import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ekran extends JFrame implements ActionListener {

    //Utworzenie paneli, etykiet, przycisków

    JPanel top;
    JPanel top2;
    JPanel top1;
    public static JLabel question;
    JLabel temp;
    JPanel bot;
    JButton exit;
    JButton es;
    JButton mid;
    JButton hd;
    Panel pane;
   // Image tlo = Toolkit.getDefaultToolkit().createImage("laka.jpg");



    Ekran() {
        //podstawowe parametry JFrame'a
        setSize(1280, 720);
        setTitle("Klawa zabawa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //ustawienia związane z górną częścią ekranu (wyświetlanie czasu i słowa)
        question = new JLabel();
        question.setText("Twoje słowo");

        temp = new JLabel();
        temp.setText("Czas");

        top1 = new JPanel();
        top2 = new JPanel();
        top1.setLayout(new GridBagLayout());
        top2.setLayout(new GridBagLayout());
        top1.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
        top2.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
        top1.add(question);
        top2.add(temp);


        top = new JPanel();
        top.setLayout(new GridLayout(1, 2));
        top.setPreferredSize(new Dimension(1280, 100));
        top.setBackground(Color.LIGHT_GRAY);
        top.add(top1, BorderLayout.WEST);
        top.add(top2, BorderLayout.EAST);

        //ustawienia związane z dolną częścią pola gry (menu graficzne)
        exit = new JButton();
        es = new JButton();
        mid = new JButton();
        hd = new JButton();

        exit.setFocusable(false);
        exit.addActionListener(this);
        exit.setText("EXIT");

        es.setFocusable(false);
        es.addActionListener(this);
        es.setText("EASY");

        mid.setFocusable(false);
        mid.addActionListener(this);
        mid.setText("NORMAL");

        hd.setFocusable(false);
        hd.addActionListener(this);
        hd.setText("HARD");

        bot = new JPanel();
        bot.setPreferredSize(new Dimension(1280, 100));
        bot.setLayout(new GridLayout(1, 4));
        bot.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));

        bot.add(es);
        es.setBackground(Color.GREEN);
        es.setForeground(Color.decode("#ff00e3"));
        es.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));

        bot.add(mid);
        mid.setBackground(Color.YELLOW);
        mid.setForeground(Color.decode("#0600ff"));
        mid.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));

        bot.add(hd);
        hd.setBackground(Color.RED);
        hd.setForeground(Color.decode("#00ffff"));
        hd.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));

        bot.add(exit);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.setBorder(BorderFactory.createLineBorder((Color.WHITE),2));

        //utworzenie głównego panelu gry
        pane = new Panel();

        //dodanie poszczegónych paneli do JFrame'a
        add(top, BorderLayout.NORTH);
        add(pane, BorderLayout.CENTER);
        add(bot, BorderLayout.SOUTH);

    }

//    public void paintComponent(Graphics f)
//    {
//        super.paintComponent(f);
//        f.drawImage(tlo, 0,0,null);
//    }

    //sprawdzanie, czy i który przycisk został naciśnięty oraz wykonanie odpowiednich akcji z tym związanych
    @Override
    public void actionPerformed(ActionEvent ae)
    {

        if(ae.getSource() == es)
        {
            String tmp = lista_slow.podzial_e();
            JOptionPane.showMessageDialog(null,"Twoje słowo to " + tmp, "START", JOptionPane.INFORMATION_MESSAGE);
            question.setText(tmp);
            top2.removeAll();
            top2.revalidate();
            top2.repaint();
            top2.add(new Czas());
            pane.setLayout(null);
            bot.hide();
            pane.borderBottom = pane.borderBottomWithoutButtons;
            pane.pokazLitery(tmp);

        }
        if(ae.getSource() == mid)
        {
            String tmp = lista_slow.podzial_m();
            JOptionPane.showMessageDialog(null,"Twoje słowo to " + tmp, "START", JOptionPane.INFORMATION_MESSAGE);
            question.setText(tmp);
            top2.removeAll();
            top2.revalidate();
            top2.repaint();
            top2.add(new Czas());
            pane.setLayout(null);
            bot.hide();
            pane.borderBottom = pane.borderBottomWithoutButtons;
            pane.pokazLitery(tmp);
        }
        if(ae.getSource() == hd)
        {
            String tmp = lista_slow.podzial_h();
            JOptionPane.showMessageDialog(null,"Twoje słowo to " + tmp, "START", JOptionPane.INFORMATION_MESSAGE);
            question.setText(tmp);
            top2.removeAll();
            top2.revalidate();
            top2.repaint();
            top2.add(new Czas());
            pane.setLayout(null);
            bot.hide();
            pane.borderBottom = pane.borderBottomWithoutButtons;
            pane.pokazLitery(tmp);
        }
        if(ae.getSource() == exit)
        {
            System.exit(0);
        }
    }

}
