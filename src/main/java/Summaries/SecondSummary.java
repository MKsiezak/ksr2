package Summaries;

import Classifiers.ClassifiersContainer;
import Quantifiers.Quantifier;
import Sets.FuzzySet;

public class SecondSummary {

    public static String generateSummary(ClassifiersContainer allClassifiers, String featureName, String labelName,String secondFeature, String secondLabel ){
        boolean relative = true;
        FuzzySet zbior = allClassifiers.findClassifier(featureName).createSet(labelName);
        int numberOfPlayers = zbior.getPlayersWithMembershipValue().size();

        //String quantifier= Quantifier.quantifies(numberOfPlayers, zbior.getNumber_of_all_players(),relative);
        FuzzySet zbior2 = allClassifiers.findClassifier(secondFeature).createSet(secondLabel);
        FuzzySet wypadkowy = zbior.intersectionFuzzySets(zbior2);
        String quantifier= Quantifier.quantifies(wypadkowy.supp().size(),wypadkowy.getNumber_of_all_players() ,relative);
        String summary = quantifier+ " z zawodników  " + labelName + " jest " + secondLabel ;
        return summary;



    }
}
