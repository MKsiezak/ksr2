package Summaries;

import Classifiers.ClassifiersContainer;
import Quantifiers.Quantifier;
import Sets.FuzzySet;

public class FirstSummary {

    public static String generateSummary(ClassifiersContainer allClassifiers, String featureName, String labelName,boolean relative ){
        FuzzySet zbior = allClassifiers.findClassifier(featureName).createSet(labelName);
        int numberOfPlayers = zbior.getPlayersWithMembershipValue().size();
        String quantifier= Quantifier.quantifies(numberOfPlayers, zbior.getNumber_of_all_players(),relative);
        String summary = quantifier+ " of players have " + labelName+ " "+ featureName ;
        return summary;



    }
}
