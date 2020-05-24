package GUI;

import Classifiers.ClassifierInitialize;
import Classifiers.ClassifiersContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test1 extends JFrame implements ActionListener {

    private JButton greenButton;
    private JButton blueButton;
    private JButton redButton;

    private JCheckBox ageLeft = new JCheckBox("Age");
    private JCheckBox youngLeft = new JCheckBox("young");
    private JCheckBox middleLeft = new JCheckBox("middle-aged");
    private JCheckBox oldLeft = new JCheckBox("old");


    private JCheckBox heightLeft = new JCheckBox("Height");
    private JCheckBox shortLeft = new JCheckBox("young");
    private JCheckBox mediumLeft = new JCheckBox("medium");
    private JCheckBox tallLeft = new JCheckBox("tall");

    private JCheckBox weightLeft = new JCheckBox("Weight");
    private JCheckBox overallLeft = new JCheckBox("overall");
    private JCheckBox value_eurLeft = new JCheckBox("value_eur");

    private JCheckBox paceLeft = new JCheckBox("pace");
    private JCheckBox shootingLeft = new JCheckBox("shooting");
    private JCheckBox passingLeft = new JCheckBox("passing");
    private JCheckBox dribblingLeft = new JCheckBox("dribbling");
    private JCheckBox defendingLeft = new JCheckBox("defending");
    private JCheckBox physicLeft = new JCheckBox("physic");

    private JLabel height = new JLabel("Height");





    public Test1() {
        super("Generator Podsumowań");

        //ClassifiersContainer allClassifiers =new ClassifiersContainer();
        //ClassifierInitialize.initialize(allClassifiers);



        JPanel mainPanel =new JPanel();
        JPanel attributes = new JPanel();  // waga wzrost szybkosc itp
        JPanel featuresAge = new JPanel();
        JPanel featuresHeight = new JPanel();

        mainPanel.setLayout(new GridLayout(2,2,1,1));

        attributes.setLayout(new GridLayout(0,2,1,1));

        featuresAge.setLayout(new GridLayout(3,1,2,2));
        featuresAge.add(youngLeft);
        featuresAge.add(middleLeft);
        featuresAge.add(oldLeft);

        featuresHeight.setLayout(new GridLayout(3,1,2,2));
        featuresAge.add(shortLeft);
        featuresAge.add(mediumLeft);
        featuresAge.add(tallLeft);


        Container c=getContentPane();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocation(350,50);
        attributes.add(ageLeft);
        attributes.add(featuresAge);
        attributes.add(heightLeft);
        attributes.add(featuresHeight);
        attributes.add(weightLeft);
        attributes.add(overallLeft);
        attributes.add(value_eurLeft);
        attributes.add(paceLeft);
        attributes.add(shootingLeft);
        attributes.add(passingLeft);
        attributes.add(dribblingLeft);
        attributes.add(defendingLeft);
        attributes.add(physicLeft);
        mainPanel.add(attributes);
        c.add(mainPanel);



        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}