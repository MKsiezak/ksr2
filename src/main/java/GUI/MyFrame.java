package GUI;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MyFrame extends JFrame implements ItemListener, ActionListener
{
    JPanel glowny;
    JPanel p1, p2 ,p3;
    JComboBox month;
    JComboBox year;
    JTextField t;
    JLabel lab;

    JButton wydarzenia;			// przycisk otwierajacy wydarzenia
    int selectedday;			// dzien przekazywany do okna otwierajacego wydarzenia

    JButton[] baton=new JButton[31];
    int days[]={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    String weekdays[] = {"Pon", "Wto", "Śro", "Czw", "Pią", "Sob", "Nie"};
    String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    // @SuppressWarnings("deprecation")
    public MyFrame(String title)
    {

        super();
        setTitle(title);
        //   glowny =new JPanel();
        lab= new JLabel();
        p1 = new JPanel();
        p1.setSize(550, 230);
        //p1.setLayout(new FlowLayout());
        month = new JComboBox();

        setVisible(true);
        //setBounds(200, 200, 350, 300);
        setSize(450,620);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);



    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }
}
