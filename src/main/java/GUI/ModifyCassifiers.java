package GUI;

import AffilationFunctions.AffilationFunction;
import AffilationFunctions.TrapezoidalFuzzyFunction;
import AffilationFunctions.TriangularFuzzyFunction;
import Classifiers.ClassifierInitialize;
import Classifiers.ClassifiersContainer;
import Quantifiers.Quantifier;
import Quantifiers.QuantifiersContainer;
import Sets.FuzzySet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ModifyCassifiers {
    private JTextField featureName;
    private JPanel mainPanel;
    private JTextField label0;
    private JTextField label1;
    private JTextField label0b;
    private JTextField label0d;
    private JTextField label0c;
    private JTextField label0a;
    private JTextField label2;
    private JTextField label3;
    private JTextField label4;
    private JButton label0Delete;
    private JButton label0Modify;
    private JTextField label1a;
    private JTextField label1b;
    private JTextField label1c;
    private JTextField label1d;
    private JButton label1Modify;
    private JButton label1Delete;
    private JTextField label2a;
    private JTextField label2b;
    private JTextField label2c;
    private JTextField label2d;
    private JButton label2Modify;
    private JButton label2Delete;
    private JTextField label3a;
    private JTextField label3b;
    private JTextField label3c;
    private JTextField label3d;
    private JButton label3Modify;
    private JButton label3Delete;
    private JTextField label4a;
    private JTextField label4b;
    private JTextField label4c;
    private JTextField label4d;
    private JButton label4Modify;
    private JButton label4Delete;
    private JTextField add;
    private JTextField addA;
    private JTextField addB;
    private JTextField addC;
    private JTextField addD;
    private JButton addNew;
    private JTextField label5;
    private JTextField label5a;
    private JTextField label5b;
    private JTextField label5c;
    private JTextField label5d;
    private JButton label5Modify;
    private JTextField label6;
    private JTextField label6a;
    private JTextField label6b;
    private JTextField label6c;
    private JTextField label6d;
    private JButton label6Modify;
    private JTextField label7;
    private JTextField label7a;
    private JTextField label7b;
    private JTextField label7c;
    private JTextField label7d;
    private JButton label7Modify;

    public ModifyCassifiers(ClassifiersContainer container, String feature, JPanel featuresPanel, JPanel rightFeaturesPanel) {

        JFrame frame = new JFrame("Clasifier");

        featureName.setText(feature);
        featureName.setEditable(false);
        List<Integer> featureNumbers= new ArrayList<Integer>();

        int featNumber=0;
        for (int i=0; i<featuresPanel.getComponentCount(); i ++)
        {
            if (featuresPanel.getComponent(i) instanceof JCheckBox) {

                if (0==i) {
                    featureNumbers.add(i);
                }

                if (1==i) {
                    featureNumbers.add(i);
                }
                if (2==i) {
                    featureNumbers.add(i);

                }
                if (3==i) {
                    featureNumbers.add(i);

                }
                if (4==i){
                    featureNumbers.add(i);

                }
            featNumber++;
            }
        }


        List<AffilationFunction> setToDisplay = container.findClassifier(feature).getAffilation();

        for ( int i=0; i< setToDisplay.size(); i++){
            if (0==i) {
                label0.setText(container.findClassifier(feature).getAffilation().get(i).getLabel());
                label0a.setText(Double.toString(container.findClassifier(feature).getAffilation().get(i).getA()));
                label0b.setText(Double.toString(container.findClassifier(feature).getAffilation().get(i).getB()));
                label0c.setText(Double.toString(container.findClassifier(feature).getAffilation().get(i).getC()));
                if (container.findClassifier(feature).getAffilation().get(i).getD() != -1.0)
                    label0d.setText(Double.toString(container.findClassifier(feature).getAffilation().get(i).getD()));
            }
            if (1==i) {
                label1.setText(container.findClassifier(feature).getAffilation().get(i).getLabel());
                label1a.setText(Double.toString(container.findClassifier(feature).getAffilation().get(i).getA()));
                label1b.setText(Double.toString(container.findClassifier(feature).getAffilation().get(i).getB()));
                label1c.setText(Double.toString(container.findClassifier(feature).getAffilation().get(i).getC()));
                if (container.findClassifier(feature).getAffilation().get(i).getD() != -1.0)
                    label1d.setText(Double.toString(container.findClassifier(feature).getAffilation().get(i).getD()));
            }

            if (2==i) {
                label2.setText(container.findClassifier(feature).getAffilation().get(i).getLabel());
                label2a.setText(Double.toString(container.findClassifier(feature).getAffilation().get(i).getA()));
                label2b.setText(Double.toString(container.findClassifier(feature).getAffilation().get(i).getB()));
                label2c.setText(Double.toString(container.findClassifier(feature).getAffilation().get(i).getC()));
                if (container.findClassifier(feature).getAffilation().get(i).getD() != -1.0)
                    label2d.setText(Double.toString(container.findClassifier(feature).getAffilation().get(i).getD()));
            }
            if (3==i) {
                label3.setText(container.findClassifier(feature).getAffilation().get(i).getLabel());
                label3a.setText(Double.toString(container.findClassifier(feature).getAffilation().get(i).getA()));
                label3b.setText(Double.toString(container.findClassifier(feature).getAffilation().get(i).getB()));
                label3c.setText(Double.toString(container.findClassifier(feature).getAffilation().get(i).getC()));
                if (container.findClassifier(feature).getAffilation().get(i).getD() != -1.0)
                    label3d.setText(Double.toString(container.findClassifier(feature).getAffilation().get(i).getD()));
            }
            if (4==i) {
                label4.setText(container.findClassifier(feature).getAffilation().get(i).getLabel());
                label4a.setText(Double.toString(container.findClassifier(feature).getAffilation().get(i).getA()));
                label4b.setText(Double.toString(container.findClassifier(feature).getAffilation().get(i).getB()));
                label4c.setText(Double.toString(container.findClassifier(feature).getAffilation().get(i).getC()));
                if (container.findClassifier(feature).getAffilation().get(i).getD() != -1.0)
                    label4d.setText(Double.toString(container.findClassifier(feature).getAffilation().get(i).getD()));
            }

        }


        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setVisible(true);

        label0Modify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                container.findClassifier(feature).getAffilation().get(0).setLabel(label0.getText());
                if (label0a.equals("") == false && label0b.equals("")==false && label0c.equals("")==false) {
                    if (label0d.getText().equals("")) {
                        container.findClassifier(feature).getAffilation().set(0, new TriangularFuzzyFunction(Double.parseDouble(label0a.getText()), Double.parseDouble(label0b.getText()), Double.parseDouble(label0c.getText()),label0.getText()));

                    } else {
                        container.findClassifier(feature).getAffilation().set(0, new TrapezoidalFuzzyFunction(Double.parseDouble(label0a.getText()), Double.parseDouble(label0b.getText()), Double.parseDouble(label0c.getText()), Double.parseDouble(label0d.getText()),label0.getText()));

                    }
                }
                JCheckBox first = (JCheckBox) featuresPanel.getComponent(featureNumbers.get(0));
                first.setText(label0.getText());

                JCheckBox second = (JCheckBox) rightFeaturesPanel.getComponent(featureNumbers.get(0));
                second.setText(label0.getText());
            }
        });

        label1Modify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                container.findClassifier(feature).getAffilation().get(1).setLabel(label1.getText());
                if (label1a.equals("") == false && label1b.equals("")==false && label1c.equals("")==false) {
                    if (label1d.getText().equals("")) {
                        container.findClassifier(feature).getAffilation().set(1, new TriangularFuzzyFunction(Double.parseDouble(label1a.getText()), Double.parseDouble(label1b.getText()), Double.parseDouble(label1c.getText()),label1.getText()));

                    } else {
                        container.findClassifier(feature).getAffilation().set(1, new TrapezoidalFuzzyFunction(Double.parseDouble(label1a.getText()), Double.parseDouble(label1b.getText()), Double.parseDouble(label1c.getText()), Double.parseDouble(label1d.getText()),label1.getText()));

                    }
                }
                JCheckBox first = (JCheckBox) featuresPanel.getComponent(featureNumbers.get(1));
                first.setText(label1.getText());

                JCheckBox second = (JCheckBox) rightFeaturesPanel.getComponent(featureNumbers.get(1));
                second.setText(label1.getText());
            }
        });

        label2Modify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                container.findClassifier(feature).getAffilation().get(2).setLabel(label2.getText());
                if (label2a.equals("") == false && label2b.equals("")==false && label2c.equals("")==false) {
                    if (label2d.getText().equals("")) {
                        container.findClassifier(feature).getAffilation().set(2, new TriangularFuzzyFunction(Double.parseDouble(label2a.getText()), Double.parseDouble(label2b.getText()), Double.parseDouble(label2c.getText()),label2.getText()));

                    } else {
                        container.findClassifier(feature).getAffilation().set(2, new TrapezoidalFuzzyFunction(Double.parseDouble(label2a.getText()), Double.parseDouble(label2b.getText()), Double.parseDouble(label2c.getText()), Double.parseDouble(label2d.getText()),label2.getText()));

                    }
                }
                JCheckBox first = (JCheckBox) featuresPanel.getComponent(featureNumbers.get(2));
                first.setText(label2.getText());

                JCheckBox second = (JCheckBox) rightFeaturesPanel.getComponent(featureNumbers.get(2));
                second.setText(label2.getText());
            }
        });
        label3Modify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                container.findClassifier(feature).getAffilation().get(3).setLabel(label3.getText());
                if (label3a.equals("") == false && label3b.equals("")==false && label3c.equals("")==false) {
                    if (label3d.getText().equals("")) {
                        container.findClassifier(feature).getAffilation().set(3, new TriangularFuzzyFunction(Double.parseDouble(label3a.getText()), Double.parseDouble(label3b.getText()), Double.parseDouble(label3c.getText()),label3.getText()));

                    } else {
                        container.findClassifier(feature).getAffilation().set(3, new TrapezoidalFuzzyFunction(Double.parseDouble(label3a.getText()), Double.parseDouble(label3b.getText()), Double.parseDouble(label3c.getText()), Double.parseDouble(label3d.getText()),label3.getText()));

                    }
                }
                JCheckBox first = (JCheckBox) featuresPanel.getComponent(featureNumbers.get(3));
                first.setText(label3.getText());

                JCheckBox second = (JCheckBox) rightFeaturesPanel.getComponent(featureNumbers.get(3));
                second.setText(label3.getText());
            }
        });
        label4Modify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                container.findClassifier(feature).getAffilation().get(4).setLabel(label4.getText());
                if (label4a.equals("") == false && label4b.equals("")==false && label4c.equals("")==false) {
                    if (label4d.getText().equals("")) {
                        container.findClassifier(feature).getAffilation().set(4, new TriangularFuzzyFunction(Double.parseDouble(label4a.getText()), Double.parseDouble(label4b.getText()), Double.parseDouble(label4c.getText()),label4.getText()));

                    } else {
                        container.findClassifier(feature).getAffilation().set(4, new TrapezoidalFuzzyFunction(Double.parseDouble(label4a.getText()), Double.parseDouble(label4b.getText()), Double.parseDouble(label4c.getText()), Double.parseDouble(label4d.getText()),label4.getText()));

                    }
                }
                JCheckBox first = (JCheckBox) featuresPanel.getComponent(featureNumbers.get(4));
                first.setText(label4.getText());

                JCheckBox second = (JCheckBox) rightFeaturesPanel.getComponent(featureNumbers.get(4));
                second.setText(label4.getText());
            }
        });

        addNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (addA.equals("") == false && addB.equals("")==false && addC.equals("")==false) {
                    if (label4d.getText().equals("")) {
                        container.findClassifier(feature).getAffilation().add( new TriangularFuzzyFunction(Double.parseDouble(addA.getText()), Double.parseDouble(addB.getText()), Double.parseDouble(addC.getText()),add.getText()));

                    } else {
                        container.findClassifier(feature).getAffilation().add( new TrapezoidalFuzzyFunction(Double.parseDouble(addA.getText()), Double.parseDouble(addB.getText()), Double.parseDouble(addC.getText()), Double.parseDouble(addD.getText()),add.getText()));

                    }
                }
                JCheckBox newComponent = (JCheckBox)featuresPanel.getComponent(featuresPanel.getComponentCount()-1);
                newComponent.setText(add.getText());
                newComponent.setVisible(true);

                JCheckBox newComponentR = (JCheckBox)rightFeaturesPanel.getComponent(rightFeaturesPanel.getComponentCount()-1);
                newComponentR.setText(add.getText());
                newComponentR.setVisible(true);


            }
        });
    }


    public ModifyCassifiers(Quantifier quantifier) {

        JFrame frame = new JFrame("Clasifier");

        featureName.setText(quantifier.getType());
        featureName.setEditable(false);
        List<Integer> featureNumbers = new ArrayList<Integer>();

        for (int i = 0; i < quantifier.getAffilation().size(); i++)
        {
            if (i==0) {
                label0.setText(quantifier.getAffilation().get(i).getLabel());
                label0a.setText(Double.toString(quantifier.getAffilation().get(i).getA()));
                label0b.setText(Double.toString(quantifier.getAffilation().get(i).getB()));
                label0c.setText(Double.toString(quantifier.getAffilation().get(i).getC()));
                if (quantifier.getAffilation().get(i).getD() != -1.0)
                    label0d.setText(Double.toString(quantifier.getAffilation().get(i).getD()));
            }

            if (i==1) {
                label1.setText(quantifier.getAffilation().get(i).getLabel());
                label1a.setText(Double.toString(quantifier.getAffilation().get(i).getA()));
                label1b.setText(Double.toString(quantifier.getAffilation().get(i).getB()));
                label1c.setText(Double.toString(quantifier.getAffilation().get(i).getC()));
                if (quantifier.getAffilation().get(i).getD() != -1.0)
                    label1d.setText(Double.toString(quantifier.getAffilation().get(i).getD()));
            }
            if (i==2) {
                label2.setText(quantifier.getAffilation().get(i).getLabel());
                label2a.setText(Double.toString(quantifier.getAffilation().get(i).getA()));
                label2b.setText(Double.toString(quantifier.getAffilation().get(i).getB()));
                label2c.setText(Double.toString(quantifier.getAffilation().get(i).getC()));
                if (quantifier.getAffilation().get(i).getD() != -1.0)
                    label2d.setText(Double.toString(quantifier.getAffilation().get(i).getD()));
            }

            if (i==3) {
                label3.setText(quantifier.getAffilation().get(i).getLabel());
                label3a.setText(Double.toString(quantifier.getAffilation().get(i).getA()));
                label3b.setText(Double.toString(quantifier.getAffilation().get(i).getB()));
                label3c.setText(Double.toString(quantifier.getAffilation().get(i).getC()));
                if (quantifier.getAffilation().get(i).getD() != -1.0)
                    label3d.setText(Double.toString(quantifier.getAffilation().get(i).getD()));
            }
            if (i==4) {
                label4.setText(quantifier.getAffilation().get(i).getLabel());
                label4a.setText(Double.toString(quantifier.getAffilation().get(i).getA()));
                label4b.setText(Double.toString(quantifier.getAffilation().get(i).getB()));
                label4c.setText(Double.toString(quantifier.getAffilation().get(i).getC()));
                if (quantifier.getAffilation().get(i).getD() != -1.0)
                    label4d.setText(Double.toString(quantifier.getAffilation().get(i).getD()));
            }
            if (i==5) {
                label5.setText(quantifier.getAffilation().get(i).getLabel());
                label5a.setText(Double.toString(quantifier.getAffilation().get(i).getA()));
                label5b.setText(Double.toString(quantifier.getAffilation().get(i).getB()));
                label5c.setText(Double.toString(quantifier.getAffilation().get(i).getC()));
                if (quantifier.getAffilation().get(i).getD() != -1.0)
                    label5d.setText(Double.toString(quantifier.getAffilation().get(i).getD()));
            }
            if (i==6) {
                label6.setText(quantifier.getAffilation().get(i).getLabel());
                label6a.setText(Double.toString(quantifier.getAffilation().get(i).getA()));
                label6b.setText(Double.toString(quantifier.getAffilation().get(i).getB()));
                label6c.setText(Double.toString(quantifier.getAffilation().get(i).getC()));
                if (quantifier.getAffilation().get(i).getD() != -1.0)
                    label6d.setText(Double.toString(quantifier.getAffilation().get(i).getD()));
            }
            if (i==7) {
                label7.setText(quantifier.getAffilation().get(i).getLabel());
                label7a.setText(Double.toString(quantifier.getAffilation().get(i).getA()));
                label7b.setText(Double.toString(quantifier.getAffilation().get(i).getB()));
                label7c.setText(Double.toString(quantifier.getAffilation().get(i).getC()));
                if (quantifier.getAffilation().get(i).getD() != -1.0)
                    label7d.setText(Double.toString(quantifier.getAffilation().get(i).getD()));
            }
        }




        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setVisible(true);



        label0Modify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quantifier.getAffilation().get(0).setLabel(label0.getText());
                if (label0a.equals("") == false && label0b.equals("")==false && label0c.equals("")==false) {
                    if (label1d.getText().equals("")) {
                        quantifier.getAffilation().set(0, new TriangularFuzzyFunction(Double.parseDouble(label0a.getText()), Double.parseDouble(label0b.getText()), Double.parseDouble(label0c.getText()),label0.getText()));

                    } else {
                        quantifier.getAffilation().set(0, new TrapezoidalFuzzyFunction(Double.parseDouble(label0a.getText()), Double.parseDouble(label0b.getText()), Double.parseDouble(label0c.getText()), Double.parseDouble(label0d.getText()),label0.getText()));

                    }
                }

            }
        });

        label1Modify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quantifier.getAffilation().get(1).setLabel(label1.getText());
                if (label1a.equals("") == false && label1b.equals("")==false && label1c.equals("")==false) {
                    if (label1d.getText().equals("")) {
                        quantifier.getAffilation().set(1, new TriangularFuzzyFunction(Double.parseDouble(label1a.getText()), Double.parseDouble(label1b.getText()), Double.parseDouble(label1c.getText()),label1.getText()));

                    } else {
                        quantifier.getAffilation().set(1, new TrapezoidalFuzzyFunction(Double.parseDouble(label1a.getText()), Double.parseDouble(label1b.getText()), Double.parseDouble(label1c.getText()), Double.parseDouble(label1d.getText()),label1.getText()));

                    }
                }

            }
        });

        label2Modify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quantifier.getAffilation().get(2).setLabel(label2.getText());
                if (label2a.equals("") == false && label2b.equals("")==false && label2c.equals("")==false) {
                    if (label1d.getText().equals("")) {
                        quantifier.getAffilation().set(2, new TriangularFuzzyFunction(Double.parseDouble(label2a.getText()), Double.parseDouble(label2b.getText()), Double.parseDouble(label2c.getText()),label2.getText()));

                    } else {
                        quantifier.getAffilation().set(2, new TrapezoidalFuzzyFunction(Double.parseDouble(label2a.getText()), Double.parseDouble(label2b.getText()), Double.parseDouble(label2c.getText()), Double.parseDouble(label2d.getText()),label2.getText()));

                    }
                }

            }
        });

        label3Modify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quantifier.getAffilation().get(3).setLabel(label3.getText());
                if (label3a.equals("") == false && label3b.equals("")==false && label3c.equals("")==false) {
                    if (label1d.getText().equals("")) {
                        quantifier.getAffilation().set(3, new TriangularFuzzyFunction(Double.parseDouble(label3a.getText()), Double.parseDouble(label3b.getText()), Double.parseDouble(label3c.getText()),label3.getText()));

                    } else {
                        quantifier.getAffilation().set(3, new TrapezoidalFuzzyFunction(Double.parseDouble(label3a.getText()), Double.parseDouble(label3b.getText()), Double.parseDouble(label3c.getText()), Double.parseDouble(label3d.getText()),label3.getText()));

                    }
                }

            }
        });

        label4Modify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quantifier.getAffilation().get(4).setLabel(label4.getText());
                if (label4a.equals("") == false && label4b.equals("")==false && label4c.equals("")==false) {
                    if (label4d.getText().equals("")) {
                        quantifier.getAffilation().set(4, new TriangularFuzzyFunction(Double.parseDouble(label4a.getText()), Double.parseDouble(label4b.getText()), Double.parseDouble(label4c.getText()),label4.getText()));

                    } else {
                        quantifier.getAffilation().set(4, new TrapezoidalFuzzyFunction(Double.parseDouble(label4a.getText()), Double.parseDouble(label4b.getText()), Double.parseDouble(label4c.getText()), Double.parseDouble(label4d.getText()),label4.getText()));

                    }
                }

            }
        });

        label5Modify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quantifier.getAffilation().get(5).setLabel(label5.getText());
                if (label5a.equals("") == false && label5b.equals("")==false && label5c.equals("")==false) {
                    if (label5d.getText().equals("")) {
                        quantifier.getAffilation().set(5, new TriangularFuzzyFunction(Double.parseDouble(label5a.getText()), Double.parseDouble(label5b.getText()), Double.parseDouble(label5c.getText()),label5.getText()));

                    } else {
                        quantifier.getAffilation().set(5, new TrapezoidalFuzzyFunction(Double.parseDouble(label5a.getText()), Double.parseDouble(label5b.getText()), Double.parseDouble(label5c.getText()), Double.parseDouble(label5d.getText()),label5.getText()));

                    }
                }

            }
        });

        label6Modify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quantifier.getAffilation().get(6).setLabel(label6.getText());
                if (label6a.equals("") == false && label6b.equals("")==false && label6c.equals("")==false) {
                    if (label6d.getText().equals("")) {
                        quantifier.getAffilation().set(6, new TriangularFuzzyFunction(Double.parseDouble(label6a.getText()), Double.parseDouble(label6b.getText()), Double.parseDouble(label6c.getText()),label6.getText()));

                    } else {
                        quantifier.getAffilation().set(6, new TrapezoidalFuzzyFunction(Double.parseDouble(label6a.getText()), Double.parseDouble(label6b.getText()), Double.parseDouble(label6c.getText()), Double.parseDouble(label6d.getText()),label6.getText()));

                    }
                }

            }
        });
        /*
        label1Modify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                container.findClassifier(feature).getAffilation().get(1).setLabel(label1.getText());
                if (label1a.equals("") == false && label1b.equals("")==false && label1c.equals("")==false) {
                    if (label1d.getText().equals("")) {
                        container.findClassifier(feature).getAffilation().set(1, new TriangularFuzzyFunction(Double.parseDouble(label1a.getText()), Double.parseDouble(label1b.getText()), Double.parseDouble(label1c.getText()),label1.getText()));

                    } else {
                        container.findClassifier(feature).getAffilation().set(1, new TrapezoidalFuzzyFunction(Double.parseDouble(label1a.getText()), Double.parseDouble(label1b.getText()), Double.parseDouble(label1c.getText()), Double.parseDouble(label1d.getText()),label1.getText()));

                    }
                }
                JCheckBox first = (JCheckBox) featuresPanel.getComponent(featureNumbers.get(1));
                first.setText(label1.getText());

                JCheckBox second = (JCheckBox) rightFeaturesPanel.getComponent(featureNumbers.get(1));
                second.setText(label1.getText());
            }
        });
            */

        addNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (addA.equals("") == false && addB.equals("")==false && addC.equals("")==false) {
                    if (addD.getText().equals("")) {
                        quantifier.addAffilationFunction( new TriangularFuzzyFunction(Double.parseDouble(addA.getText()), Double.parseDouble(addB.getText()), Double.parseDouble(addC.getText()),add.getText()));

                    } else {
                        quantifier.addAffilationFunction( new TrapezoidalFuzzyFunction(Double.parseDouble(addA.getText()), Double.parseDouble(addB.getText()), Double.parseDouble(addC.getText()), Double.parseDouble(addD.getText()),add.getText()));

                    }
                }

            }
        });

    }
}