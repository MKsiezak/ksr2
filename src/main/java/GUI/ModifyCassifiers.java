package GUI;

import Classifiers.ClassifierInitialize;
import Classifiers.ClassifiersContainer;
import Sets.FuzzySet;

import javax.swing.*;
import java.util.ArrayList;

public class ModifyCassifiers {
    private JTextField featureName;
    private JPanel mainPanel;

    public ModifyCassifiers(ClassifiersContainer container, String feature, JPanel featuresPanel, JPanel rightFeaturesPanel) {

        JFrame frame = new JFrame("Clasifier");

        featureName.setText(feature);
        featureName.setEditable(false);

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