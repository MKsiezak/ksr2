package GUI;

import Classifiers.ClassifierInitialize;
import Classifiers.ClassifiersContainer;
import Sets.FuzzySet;
import Summaries.FirstSummary;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;
import java.util.List;

public class MyGui {
    private int numberOfAllPlayers;
    private JPanel mainPanel;
    private JCheckBox age;
    private JCheckBox young;
    private JCheckBox middle;
    private JCheckBox old;
    private JPanel leftleft;
    private JScrollBar scrollBar1;
    private JButton generate;
    private JButton wielopodmiotowy;
    private JCheckBox wzgledny;
    private JCheckBox height;
    private JCheckBox shortHeight;
    private JCheckBox medium;
    private JCheckBox tall;
    private JPanel left;
    private JPanel right;
    private JCheckBox weight;
    private JCheckBox low;
    private JCheckBox average;
    private JCheckBox heavy;
    private JCheckBox obese;
    private JComboBox sumOr;
    private JComboBox jednolubwielo;
    private JTextField summaries;
    private JScrollBar skrol;

    private List<FuzzySet> jednopodmiote;

    public MyGui() {

        JFrame frame = new JFrame("Generator podsumowań");

        jednopodmiote = new ArrayList<FuzzySet>();


        ClassifiersContainer allClassifiers = new ClassifiersContainer();
        ClassifierInitialize.initialize(allClassifiers);

        numberOfAllPlayers = allClassifiers.findClassifier("age").getAllPlayers().getListOfPlayers().size();

        sumOr.addItem("And");
        sumOr.addItem("Or");
        jednolubwielo.addItem("single subject summary");
        jednolubwielo.addItem("multi subject summary");



        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);




        generate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jednopodmiote.clear();

                if (age.isSelected()) {
                    if (young.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("age").createSet("young"));
                    }
                    if (middle.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("age").createSet("middle-aged"));
                    }
                    if (old.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("age").createSet("old"));
                    }
                }

                if (height.isSelected()) {
                    if (shortHeight.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("height").createSet("short"));
                    }
                    if (medium.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("height").createSet("medium"));
                    }
                    if (tall.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("height").createSet("tall"));
                    }
                }

                if (weight.isSelected()) {
                    if (low.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("weight").createSet("low"));
                    }
                    if (average.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("weight").createSet("average"));
                    }
                    if (heavy.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("weight").createSet("heavy"));
                    }
                    if (obese.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("weight").createSet("obese"));
                    }
                }
                    boolean isSum = true;
                    if (sumOr.getSelectedItem().equals("And"))
                        isSum=false;

                    summaries.setText("");
                    String singleSummary = FirstSummary.generateSummary(jednopodmiote, true, numberOfAllPlayers, isSum);
                    summaries.setText(singleSummary);

            }

            });



        }
    }

