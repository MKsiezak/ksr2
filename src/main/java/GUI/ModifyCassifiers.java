package GUI;

import Classifiers.ClassifierInitialize;
import Classifiers.ClassifiersContainer;
import Sets.FuzzySet;

import javax.swing.*;
import java.util.ArrayList;

public class ModifyCassifiers {
    private JTextField featureName;
    private JPanel mainPanel;
    private JTextField label0;
    private JTextField label1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField label2;

    public ModifyCassifiers(ClassifiersContainer container, String feature, JPanel featuresPanel, JPanel rightFeaturesPanel) {

        JFrame frame = new JFrame("Clasifier");

        featureName.setText(feature);
        featureName.setEditable(false);

        int featNumber=0;
        for (int i=0; i<featuresPanel.getComponentCount(); i ++)
        {
            if (featuresPanel.getComponent(i) instanceof JCheckBox) {

                if (0==featNumber)
                    label0.setText(container.findClassifier(feature).getAffilation().get(featNumber).getLabel());
                if (1==featNumber)
                    label1.setText(container.findClassifier(feature).getAffilation().get(featNumber).getLabel());
                if (2==featNumber)
                    label2.setText(container.findClassifier(feature).getAffilation().get(featNumber).getLabel());
            featNumber++;
            }
        }

        container.findClassifier(feature).getAffilation().get(0).setLabel("szczawik");
        JCheckBox first = (JCheckBox) featuresPanel.getComponent(0);
        first.setText("szczawik");

        JCheckBox second = (JCheckBox) rightFeaturesPanel.getComponent(0);
        second.setText("szczawik");


        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setVisible(true);

    }

}