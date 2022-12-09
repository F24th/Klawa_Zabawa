import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;


public class Ekran extends  JFrame implements ActionListener {
    JPanel top;
    JLabel question;
    JLabel result;
    JLabel time;
    JPanel panel;
    JPanel pan;
    JLabel txt;
    JPanel bot;
    JButton exit;
    JButton es;
    JButton mid;
    JButton hd;
    Ekran() {



        setSize(1280, 720);
        setTitle("test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        time = new JLabel();
        result = new JLabel();
        question = new JLabel();

        question.setText("question");
        result.setText("result");
        time.setText("Czas: " + "sekund.");

        JPanel top1 = new JPanel();
        JPanel top2 = new JPanel();
        JPanel top3 = new JPanel();
        top1.setLayout(new GridBagLayout());
        top2.setLayout(new GridBagLayout());
        top3.setLayout(new GridBagLayout());
        top2.add(result);
        top1.add(question);
        top3.add(time);

        top = new JPanel();
        top.setLayout(new GridLayout(1, 3));
        top.setPreferredSize(new Dimension(1280, 100));
        top.setBackground(Color.LIGHT_GRAY);
        top.add(top1, BorderLayout.WEST);
        top.add(top2, BorderLayout.CENTER);
        top.add(top3, BorderLayout.EAST);

        txt = new JLabel();
        txt.setText("test");

        pan = new JPanel();
        pan.setBackground(Color.WHITE);
        pan.setLayout(new GridBagLayout());
        pan.add(txt);

        panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1));
        panel.setPreferredSize(new Dimension(1280, 520));
        panel.add(pan, BorderLayout.CENTER);

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
        bot.add(es);
        bot.add(mid);
        bot.add(hd);
        bot.add(exit);

        add(top, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(bot, BorderLayout.SOUTH);


    }



    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == es)
        {
            question.setText(lista_slow.podzial_e());
        }
        if(ae.getSource() == mid)
        {
            question.setText(lista_slow.podzial_m());

        }
        if(ae.getSource() == hd)
        {
            question.setText(lista_slow.podzial_h());
        }
        if(ae.getSource() == exit)
        {
            System.exit(0);
        }
    }


}
