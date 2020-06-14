package GUI;

import Classifiers.ClassifierInitialize;
import Classifiers.ClassifiersContainer;
import Quantifiers.QuantifierInitialize;
import Quantifiers.QuantifiersContainer;
import Sets.FuzzySet;
import Summaries.FirstSummary;
import Summaries.SecondSummary;

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
    private JTextArea summaries;
    private JCheckBox overall;
    private JCheckBox weak;
    private JCheckBox averageOverall;
    private JCheckBox goodOverall;
    private JCheckBox amazgingOverall;
    private JButton modifyAge;
    private JPanel leftAgePanel;
    private JPanel leftAgeFeatures;
    private JButton modifyHeight;
    private JButton modifyWeight;
    private JButton modifyOverall;
    private JCheckBox value_eur;
    private JCheckBox cheap;
    private JCheckBox moderate;
    private JCheckBox high;
    private JCheckBox pace;
    private JCheckBox paceAverage;
    private JCheckBox paceGood;
    private JCheckBox shooting;
    private JCheckBox weakShooting;
    private JCheckBox averageShooting;
    private JCheckBox goodShooting;
    private JCheckBox passing;
    private JCheckBox weakPassing;
    private JCheckBox averagePassing;
    private JCheckBox goodPassing;
    private JCheckBox dribbling;
    private JCheckBox weakDribbling;
    private JCheckBox averageDribbling;
    private JCheckBox goodDribbling;
    private JCheckBox defending;
    private JCheckBox weakDefending;
    private JCheckBox averageDefending;
    private JCheckBox goodDefending;
    private JCheckBox physic;
    private JCheckBox weakPhysic;
    private JCheckBox averagePhysic;
    private JCheckBox goodPhysic;
    private JButton modifyValue;
    private JButton modifyPace;
    private JButton modifyShooting;
    private JButton modifyPassing;
    private JButton modifyDribbling;
    private JButton modifyDefending;
    private JButton modifyPhysic;
    private JCheckBox paceWeak;
    private JButton ModifyQuantifier;
    private JCheckBox ageRight;
    private JCheckBox youngRight;
    private JCheckBox middleRight;
    private JCheckBox oldRight;
    private JPanel rightAgeFeatures;
    private JCheckBox heightRight;
    private JCheckBox shortRight;
    private JCheckBox mediumRight;
    private JCheckBox tallRight;
    private JCheckBox weightRight;
    private JCheckBox lowWeightRight;
    private JCheckBox averageWeightRight;
    private JCheckBox heavyWeightRight;
    private JCheckBox obeseWeightRight;
    private JCheckBox overallRight;
    private JCheckBox weakOverallRight;
    private JCheckBox averageOverallRight;
    private JCheckBox goodOverallRight;
    private JCheckBox value_eurRight;
    private JCheckBox cheapRight;
    private JCheckBox moderateRight;
    private JCheckBox highRight;
    private JCheckBox paceRight;
    private JCheckBox weakPaceRight;
    private JCheckBox averagePaceRight;
    private JCheckBox goodPaceRight;
    private JCheckBox physicRight;
    private JCheckBox weakPhysicRight;
    private JCheckBox averagePhysicRight;
    private JCheckBox goodPhysicRight;
    private JCheckBox defendingRight;
    private JCheckBox weakDefendingRight;
    private JCheckBox averageDefendingRight;
    private JCheckBox goodDefendingRight;
    private JCheckBox dribblingRight;
    private JCheckBox weakDribblingRight;
    private JCheckBox averageDribblingRight;
    private JCheckBox goodDribblingRight;
    private JCheckBox passingRight;
    private JCheckBox weakPassingRight;
    private JCheckBox averagePassingRight;
    private JCheckBox goodPassingRight;
    private JCheckBox shootingRight;
    private JCheckBox weakShootingRight;
    private JCheckBox averageShootingRight;
    private JCheckBox goodShootingRight;
    private JCheckBox amazingOverallRight;
    private JPanel leftHeightFeatures;
    private JPanel rightHeightFeatures;
    private JCheckBox toFile;
    private JPanel leftWeightFeature;
    private JPanel rightWeightFeatures;
    private JPanel rightOverallFeatures;
    private JPanel rightValueFeatures;
    private JPanel rightPaceFeatures;
    private JPanel rightPhysicFeatures;
    private JPanel rightDefendingFeatures;
    private JPanel rightDribblingFeatures;
    private JPanel rightPassingFeatures;
    private JPanel rightShootingFeatures;
    private JPanel leftOverallFeatures;
    private JPanel leftValueFeatures;
    private JPanel leftPaceFeatures;
    private JPanel leftShootingFeatures;
    private JPanel leftPassingFeatures;
    private JPanel leftDribblingFeatures;
    private JPanel leftDeffendingFeatures;
    private JPanel leftPhysicFeatures;
    private JCheckBox newAge;
    private JCheckBox newAgeRight;
    private JCheckBox newHeight;
    private JCheckBox newWeight;
    private JCheckBox newOverall;
    private JCheckBox newValue;
    private JCheckBox newPace;
    private JCheckBox newShooting;
    private JCheckBox newPassing;
    private JCheckBox newDribbling;
    private JCheckBox newDefending;
    private JCheckBox newPhysic;
    private JCheckBox newHeightRight;
    private JCheckBox newWeightRight;
    private JCheckBox newOverallRight;
    private JCheckBox newValueRight;
    private JCheckBox newPaceRight;
    private JCheckBox newShootingRight;
    private JCheckBox newPassingRight;
    private JCheckBox newDribblingRight;
    private JCheckBox newDefendingRight;
    private JCheckBox newPhysicRight;
    private JScrollBar skrol;

    private List<FuzzySet> jednopodmiote;
    private List<FuzzySet> wielopodmiotowe;

    public MyGui() {

        JFrame frame = new JFrame("Generator podsumowań");

        jednopodmiote = new ArrayList<FuzzySet>();
        wielopodmiotowe = new ArrayList<FuzzySet>();


        ClassifiersContainer allClassifiers = new ClassifiersContainer();
        ClassifierInitialize.initialize(allClassifiers);
        allClassifiers.generateFunctionDescription();

        QuantifiersContainer allQuantifiers = new QuantifiersContainer();
        QuantifierInitialize.initialize(allQuantifiers);
        allQuantifiers.generateFunctionDescription();

        numberOfAllPlayers = allClassifiers.findClassifier("age").getAllPlayers().getListOfPlayers().size();

        sumOr.addItem("And");
        sumOr.addItem("Or");
        jednolubwielo.addItem("single subject summary");
        jednolubwielo.addItem("multi subject summary");

        newAge.setVisible(false);
        newHeight.setVisible(false);
        newWeight.setVisible(false);
        newOverall.setVisible(false);
        newValue.setVisible(false);
        newPace.setVisible(false);
        newShooting.setVisible(false);
        newDefending.setVisible(false);
        newDribbling.setVisible(false);
        newPhysic.setVisible(false);
        newPassing.setVisible(false);

        newAgeRight.setVisible(false);
        newHeightRight.setVisible(false);
        newWeightRight.setVisible(false);
        newOverallRight.setVisible(false);
        newValueRight.setVisible(false);
        newPaceRight.setVisible(false);
        newShootingRight.setVisible(false);
        newDefendingRight.setVisible(false);
        newDribblingRight.setVisible(false);
        newPhysicRight.setVisible(false);
        newPassingRight.setVisible(false);




        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);




        generate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jednopodmiote.clear();
                wielopodmiotowe.clear();

                //jednopodmiotowe:
                if (age.isSelected()) {
                    if (young.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("age").createSet(allClassifiers.findClassifier("age").getAffilation().get(0).getLabel()));
                    }
                    if (middle.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("age").createSet(allClassifiers.findClassifier("age").getAffilation().get(1).getLabel()));
                    }
                    if (old.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("age").createSet(allClassifiers.findClassifier("age").getAffilation().get(2).getLabel()));
                    }
                    if (newAge.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("age").createSet(allClassifiers.findClassifier("age").getAffilation().get(3).getLabel()));
                    }
                }

                if (height.isSelected()) {
                    if (shortHeight.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("height").createSet(allClassifiers.findClassifier("height").getAffilation().get(0).getLabel()));
                    }
                    if (medium.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("height").createSet(allClassifiers.findClassifier("height").getAffilation().get(1).getLabel()));
                    }
                    if (tall.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("height").createSet(allClassifiers.findClassifier("height").getAffilation().get(2).getLabel()));
                    }
                    if (newHeight.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("height").createSet(allClassifiers.findClassifier("height").getAffilation().get(3).getLabel()));
                    }
                }

                if (weight.isSelected()) {
                    if (low.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("weight").createSet(allClassifiers.findClassifier("weight").getAffilation().get(0).getLabel()));
                    }
                    if (average.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("weight").createSet(allClassifiers.findClassifier("weight").getAffilation().get(1).getLabel()));
                    }
                    if (heavy.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("weight").createSet(allClassifiers.findClassifier("weight").getAffilation().get(2).getLabel()));
                    }
                    if (obese.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("weight").createSet(allClassifiers.findClassifier("weight").getAffilation().get(3).getLabel()));
                    }
                    if (newWeight.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("weight").createSet(allClassifiers.findClassifier("weight").getAffilation().get(4).getLabel()));
                    }
                }

                if (overall.isSelected()) {
                    if (weak.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("overall").createSet(allClassifiers.findClassifier("overall").getAffilation().get(0).getLabel()));
                    }
                    if (averageOverall.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("overall").createSet(allClassifiers.findClassifier("overall").getAffilation().get(1).getLabel()));
                    }
                    if (goodOverall.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("overall").createSet(allClassifiers.findClassifier("overall").getAffilation().get(2).getLabel()));
                    }
                    if (amazgingOverall.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("overall").createSet(allClassifiers.findClassifier("overall").getAffilation().get(3).getLabel()));
                    }
                    if (newOverall.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("overall").createSet(allClassifiers.findClassifier("overall").getAffilation().get(4).getLabel()));
                    }
                }

                if (value_eur.isSelected()) {
                    if (cheap.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("value_eur").createSet(allClassifiers.findClassifier("value_eur").getAffilation().get(0).getLabel()));
                    }
                    if (moderate.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("value_eur").createSet(allClassifiers.findClassifier("value_eur").getAffilation().get(1).getLabel()));
                    }
                    if (high.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("value_eur").createSet(allClassifiers.findClassifier("value_eur").getAffilation().get(2).getLabel()));
                    }
                    if (newValue.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("value_eur").createSet(allClassifiers.findClassifier("value_eur").getAffilation().get(3).getLabel()));
                    }
                }

                if (pace.isSelected()) {
                    if (paceWeak.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("pace").createSet(allClassifiers.findClassifier("pace").getAffilation().get(0).getLabel()));
                    }
                    if (paceAverage.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("pace").createSet(allClassifiers.findClassifier("pace").getAffilation().get(1).getLabel()));
                    }
                    if (paceGood.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("pace").createSet(allClassifiers.findClassifier("pace").getAffilation().get(2).getLabel()));
                    }

                    if (newPace.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("pace").createSet(allClassifiers.findClassifier("pace").getAffilation().get(3).getLabel()));
                    }

                }

                if (shooting.isSelected()) {
                    if (weakShooting.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("shooting").createSet(allClassifiers.findClassifier("shooting").getAffilation().get(0).getLabel()));
                    }
                    if (averageShooting.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("shooting").createSet(allClassifiers.findClassifier("shooting").getAffilation().get(1).getLabel()));
                    }
                    if (goodShooting.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("shooting").createSet(allClassifiers.findClassifier("shooting").getAffilation().get(2).getLabel()));
                    }
                    if (newShooting.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("shooting").createSet(allClassifiers.findClassifier("shooting").getAffilation().get(3).getLabel()));
                    }

                }

                if (passing.isSelected()) {
                    if (weakPassing.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("passing").createSet(allClassifiers.findClassifier("passing").getAffilation().get(0).getLabel()));
                    }
                    if (averagePassing.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("passing").createSet(allClassifiers.findClassifier("passing").getAffilation().get(1).getLabel()));
                    }
                    if (goodPassing.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("passing").createSet(allClassifiers.findClassifier("passing").getAffilation().get(2).getLabel()));
                    }
                    if (newPassing.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("passing").createSet(allClassifiers.findClassifier("passing").getAffilation().get(3).getLabel()));
                    }


                }

                if (dribbling.isSelected()) {
                    if (weakDribbling.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("dribbling").createSet(allClassifiers.findClassifier("dribbling").getAffilation().get(0).getLabel()));
                    }
                    if (averageDribbling.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("dribbling").createSet(allClassifiers.findClassifier("dribbling").getAffilation().get(1).getLabel()));
                    }
                    if (goodDribbling.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("dribbling").createSet(allClassifiers.findClassifier("dribbling").getAffilation().get(2).getLabel()));
                    }

                    if (newDribbling.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("dribbling").createSet(allClassifiers.findClassifier("dribbling").getAffilation().get(3).getLabel()));
                    }

                }

                if (defending.isSelected()) {
                    if (weakDefending.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("defending").createSet(allClassifiers.findClassifier("defending").getAffilation().get(0).getLabel()));
                    }
                    if (averageDefending.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("defending").createSet(allClassifiers.findClassifier("defending").getAffilation().get(1).getLabel()));
                    }
                    if (goodDefending.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("defending").createSet(allClassifiers.findClassifier("defending").getAffilation().get(2).getLabel()));
                    }

                    if (newDefending.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("defending").createSet(allClassifiers.findClassifier("defending").getAffilation().get(3).getLabel()));
                    }


                }

                if (physic.isSelected()) {
                    if (weakPhysic.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("physic").createSet(allClassifiers.findClassifier("physic").getAffilation().get(0).getLabel()));
                    }
                    if (averagePhysic.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("physic").createSet(allClassifiers.findClassifier("physic").getAffilation().get(1).getLabel()));
                    }
                    if (goodPhysic.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("physic").createSet(allClassifiers.findClassifier("physic").getAffilation().get(2).getLabel()));
                    }

                    if (newPhysic.isSelected()) {
                        jednopodmiote.add(allClassifiers.findClassifier("physic").createSet(allClassifiers.findClassifier("physic").getAffilation().get(3).getLabel()));
                    }


                }

                //wielopodmiotowe:
                if (ageRight.isSelected()) {
                    if (youngRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("age").createSet(allClassifiers.findClassifier("age").getAffilation().get(0).getLabel()));
                    }
                    if (middleRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("age").createSet(allClassifiers.findClassifier("age").getAffilation().get(1).getLabel()));
                    }
                    if (oldRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("age").createSet(allClassifiers.findClassifier("age").getAffilation().get(2).getLabel()));
                    }
                    if (newAgeRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("age").createSet(allClassifiers.findClassifier("age").getAffilation().get(3).getLabel()));
                    }


                }

                if (heightRight.isSelected()) {
                    if (shortRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("height").createSet(allClassifiers.findClassifier("height").getAffilation().get(0).getLabel()));
                    }
                    if (mediumRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("height").createSet(allClassifiers.findClassifier("height").getAffilation().get(1).getLabel()));
                    }
                    if (tallRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("height").createSet(allClassifiers.findClassifier("height").getAffilation().get(2).getLabel()));
                    }
                    if (newHeightRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("height").createSet(allClassifiers.findClassifier("height").getAffilation().get(3).getLabel()));
                    }

                }

                if (weightRight.isSelected()) {
                    if (lowWeightRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("weight").createSet(allClassifiers.findClassifier("weight").getAffilation().get(0).getLabel()));
                    }
                    if (averageWeightRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("weight").createSet(allClassifiers.findClassifier("weight").getAffilation().get(1).getLabel()));
                    }
                    if (heavyWeightRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("weight").createSet(allClassifiers.findClassifier("weight").getAffilation().get(2).getLabel()));
                    }
                    if (obeseWeightRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("weight").createSet(allClassifiers.findClassifier("weight").getAffilation().get(3).getLabel()));
                    }
                    if (newWeightRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("weight").createSet(allClassifiers.findClassifier("weight").getAffilation().get(4).getLabel()));
                    }
                }

                if (overallRight.isSelected()) {
                    if (weakOverallRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("overall").createSet(allClassifiers.findClassifier("overall").getAffilation().get(0).getLabel()));
                    }
                    if (averageOverallRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("overall").createSet(allClassifiers.findClassifier("overall").getAffilation().get(1).getLabel()));
                    }
                    if (goodOverallRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("overall").createSet(allClassifiers.findClassifier("overall").getAffilation().get(2).getLabel()));
                    }
                    if (amazingOverallRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("overall").createSet(allClassifiers.findClassifier("overall").getAffilation().get(3).getLabel()));
                    }
                    if (newOverallRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("overall").createSet(allClassifiers.findClassifier("overall").getAffilation().get(4).getLabel()));
                    }
                }

                if (value_eurRight.isSelected()) {
                    if (cheapRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("value_eur").createSet(allClassifiers.findClassifier("value_eur").getAffilation().get(0).getLabel()));
                    }
                    if (moderateRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("value_eur").createSet(allClassifiers.findClassifier("value_eur").getAffilation().get(1).getLabel()));
                    }
                    if (highRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("value_eur").createSet(allClassifiers.findClassifier("value_eur").getAffilation().get(2).getLabel()));
                    }
                    if (newValueRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("value_eur").createSet(allClassifiers.findClassifier("value_eur").getAffilation().get(3).getLabel()));
                    }
                }

                if (paceRight.isSelected()) {
                    if (weakPaceRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("pace").createSet(allClassifiers.findClassifier("pace").getAffilation().get(0).getLabel()));
                    }
                    if (averagePaceRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("pace").createSet(allClassifiers.findClassifier("pace").getAffilation().get(1).getLabel()));
                    }
                    if (goodPaceRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("pace").createSet(allClassifiers.findClassifier("pace").getAffilation().get(2).getLabel()));
                    }
                    if (newPaceRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("pace").createSet(allClassifiers.findClassifier("pace").getAffilation().get(3).getLabel()));
                    }

                }

                if (shootingRight.isSelected()) {
                    if (weakShootingRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("shooting").createSet(allClassifiers.findClassifier("shooting").getAffilation().get(0).getLabel()));
                    }
                    if (averageShootingRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("shooting").createSet(allClassifiers.findClassifier("shooting").getAffilation().get(1).getLabel()));
                    }
                    if (goodShootingRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("shooting").createSet(allClassifiers.findClassifier("shooting").getAffilation().get(2).getLabel()));
                    }
                    if (newShootingRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("shooting").createSet(allClassifiers.findClassifier("shooting").getAffilation().get(3).getLabel()));
                    }

                }

                if (passingRight.isSelected()) {
                    if (weakPassingRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("passing").createSet(allClassifiers.findClassifier("passing").getAffilation().get(0).getLabel()));
                    }
                    if (averagePassingRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("passing").createSet(allClassifiers.findClassifier("passing").getAffilation().get(1).getLabel()));
                    }
                    if (goodPassingRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("passing").createSet(allClassifiers.findClassifier("passing").getAffilation().get(2).getLabel()));
                    }
                    if (newPassingRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("passing").createSet(allClassifiers.findClassifier("passing").getAffilation().get(3).getLabel()));
                    }

                }

                if (dribblingRight.isSelected()) {
                    if (weakDribblingRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("dribbling").createSet(allClassifiers.findClassifier("dribbling").getAffilation().get(0).getLabel()));
                    }
                    if (averageDribblingRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("dribbling").createSet(allClassifiers.findClassifier("dribbling").getAffilation().get(1).getLabel()));
                    }
                    if (goodDribblingRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("dribbling").createSet(allClassifiers.findClassifier("dribbling").getAffilation().get(2).getLabel()));
                    }
                    if (newDribblingRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("dribbling").createSet(allClassifiers.findClassifier("dribbling").getAffilation().get(3).getLabel()));
                    }

                }

                if (defendingRight.isSelected()) {
                    if (weakDefendingRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("defending").createSet(allClassifiers.findClassifier("defending").getAffilation().get(0).getLabel()));
                    }
                    if (averageDefendingRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("defending").createSet(allClassifiers.findClassifier("defending").getAffilation().get(1).getLabel()));
                    }
                    if (goodDefendingRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("defending").createSet(allClassifiers.findClassifier("defending").getAffilation().get(2).getLabel()));
                    }
                    if (newDefendingRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("defending").createSet(allClassifiers.findClassifier("defending").getAffilation().get(3).getLabel()));
                    }

                }

                if (physicRight.isSelected()) {
                    if (weakPhysicRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("physic").createSet(allClassifiers.findClassifier("physic").getAffilation().get(0).getLabel()));
                    }
                    if (averagePhysicRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("physic").createSet(allClassifiers.findClassifier("physic").getAffilation().get(1).getLabel()));
                    }
                    if (goodPhysicRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("physic").createSet(allClassifiers.findClassifier("physic").getAffilation().get(2).getLabel()));
                    }
                    if (newPhysicRight.isSelected()) {
                        wielopodmiotowe.add(allClassifiers.findClassifier("physic").createSet(allClassifiers.findClassifier("physic").getAffilation().get(3).getLabel()));
                    }
                }



                    boolean isSum = true;
                    if (sumOr.getSelectedItem().equals("And"))
                        isSum=false;

                boolean saveToFile = false;
                if (toFile.isSelected())
                    saveToFile=true;

                    summaries.setText("");

                    if (jednolubwielo.getSelectedItem().equals("single subject summary")) {
                        String singleSummary = "";
                        if (wzgledny.isSelected())
                            singleSummary = FirstSummary.generateSummary(jednopodmiote, allQuantifiers.getQuantifiers().get(0), numberOfAllPlayers, isSum, allClassifiers,saveToFile);
                        else
                            singleSummary = FirstSummary.generateSummary(jednopodmiote, allQuantifiers.getQuantifiers().get(1), numberOfAllPlayers, isSum, allClassifiers,saveToFile);
                        summaries.setText(singleSummary + "\n");
                        //summaries.setText(summaries.getText() +"\n"+  singleSummary);
                    }
                    else{
                        List<String> multiSummary;
                        multiSummary = SecondSummary.generateSummary(jednopodmiote, wielopodmiotowe, allQuantifiers.getQuantifiers().get(0), numberOfAllPlayers, allClassifiers,saveToFile);
                        for (int z=0; z<multiSummary.size();z++) {
                            summaries.setText(summaries.getText() + "\n" + multiSummary.get(z));
                        }



                    }

            }

            });


        modifyAge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new ModifyCassifiers(allClassifiers, "age", leftAgeFeatures,rightAgeFeatures);
                    }
                });
            }
        });

        modifyHeight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new ModifyCassifiers(allClassifiers, "height", leftHeightFeatures,rightHeightFeatures);
                    }
                });
            }
        });

        modifyWeight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new ModifyCassifiers(allClassifiers, "weight", leftWeightFeature,rightWeightFeatures);
                    }
                });
            }
        });

        modifyOverall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new ModifyCassifiers(allClassifiers, "overall", leftOverallFeatures,rightOverallFeatures);
                    }
                });
            }
        });

        modifyValue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new ModifyCassifiers(allClassifiers, "value_eur", leftValueFeatures,rightValueFeatures);
                    }
                });
            }
        });

        modifyPace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new ModifyCassifiers(allClassifiers, "pace", leftPaceFeatures,rightPaceFeatures);
                    }
                });
            }
        });
        modifyShooting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new ModifyCassifiers(allClassifiers, "shooting", leftShootingFeatures,rightShootingFeatures);
                    }
                });
            }
        });

        modifyPassing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new ModifyCassifiers(allClassifiers, "passing", leftPassingFeatures,rightPassingFeatures);
                    }
                });
            }
        });

        modifyDribbling.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new ModifyCassifiers(allClassifiers, "dribbling", leftDribblingFeatures,rightDribblingFeatures);
                    }
                });
            }
        });

        modifyDefending.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new ModifyCassifiers(allClassifiers, "defending", leftDeffendingFeatures,rightDefendingFeatures);
                    }
                });
            }
        });

        modifyPhysic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new ModifyCassifiers(allClassifiers, "physic", leftPhysicFeatures,rightPhysicFeatures);
                    }
                });
            }
        });


        ModifyQuantifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        if (wzgledny.isSelected())
                            new ModifyCassifiers(allQuantifiers.getQuantifiers().get(0));
                        else
                            new ModifyCassifiers(allQuantifiers.getQuantifiers().get(1));
                    }
                });
            }
        });
    }
    }

