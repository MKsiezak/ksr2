package Summaries;

import Classifiers.ClassifiersContainer;
import QualityMeasures.T1;
import Quantifiers.Quantifier;
import Sets.FuzzySet;

import java.util.List;

public class FirstSummary {

    public static String generateSummary(ClassifiersContainer allClassifiers, String featureName, String labelName, boolean relative) {
        FuzzySet zbior = allClassifiers.findClassifier(featureName).createSet(labelName);
        int numberOfPlayers = zbior.getPlayersWithMembershipValue().size();
        String quantifier ="srednio" ;//Quantifier.quantifies(numberOfPlayers, zbior.getNumber_of_all_players());
        String summary = quantifier + " of players have " + labelName + " " + featureName;
        return summary;


    }

    public static String generateSummary(List<FuzzySet> sets, Quantifier quantifier, int numberOfPlayers, boolean isSum, ClassifiersContainer allClassifiers, boolean fileSave) {
        FuzzySet result = sets.get(0);
        if (isSum == false) {
            for (int i = 1; i < sets.size(); i++) {
                result = result.intersectionFuzzySetsWithoutZero(sets.get(i));

            }
        }
        else{
            for (int i = 1; i < sets.size(); i++) {
                result = result.sumFuzzySets(sets.get(i));

            }

        }

        String conjunction = " and ";
        if (isSum)
            conjunction = " or ";

        String features = "";
        if (sets.size() == 1)
            features = sets.get(0).getLabelName() + " " + sets.get(0).getFeatureName();
        else {
            for (int i = 0; i < sets.size(); i++) {
                features = features + sets.get(i).getLabelName() + " " + sets.get(i).getFeatureName();
                if (i != sets.size() - 1)
                    features = features + conjunction;

            }
        }
        String quality;
        String quanti = quantifier.quantifies(result.getPlayersWithMembershipValue().size(),numberOfPlayers);
        String summary = quantifier.quantifies(result ,numberOfPlayers, sets, allClassifiers, fileSave, features);
        quality =" [" + Double.toString(countQuality(result,quantifier,numberOfPlayers, allClassifiers, sets,quanti))+"]" ;
        return summary;


    }

    public static double countQuality(FuzzySet result, Quantifier quantifier, int numberOfAllPlayers,ClassifiersContainer allClassifiers,List<FuzzySet> sets, String quantifierValue){
        double t1,t2,t3,t4, t5, t6, t7, t8, t9, t10, t11;
        t1=T1.countT1(result,quantifier,numberOfAllPlayers);
        t2=T1.countT2First(sets, allClassifiers);
        t3= T1.countT3(result,numberOfAllPlayers);
        t4= T1.countT4(sets,numberOfAllPlayers,t3);
        t5 = T1.countT5(sets);
        t6 = T1.countT6(quantifier,quantifierValue,numberOfAllPlayers);
        t7 = T1.countT7(quantifier,quantifierValue,numberOfAllPlayers);
        t8 = T1.countT8(sets,allClassifiers);
        t9 = T1.countT9(result,numberOfAllPlayers,false);
        //t10 = T1.countT10(result,numberOfAllPlayers,false);
        t10 = 1;
        t11 = T1.countT11();



        return (t1+t2+t3+t4+t5+t6+t7+t8+t9+t10+t11)/11;


    }



}
