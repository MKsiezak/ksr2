package Summaries;

import Classifiers.ClassifiersContainer;
import Quantifiers.Quantifier;
import Sets.FuzzySet;

import java.util.List;

public class FirstSummary {

    public static String generateSummary(ClassifiersContainer allClassifiers, String featureName, String labelName, boolean relative) {
        FuzzySet zbior = allClassifiers.findClassifier(featureName).createSet(labelName);
        int numberOfPlayers = zbior.getPlayersWithMembershipValue().size();
        String quantifier = Quantifier.quantifies(numberOfPlayers, zbior.getNumber_of_all_players(), relative);
        String summary = quantifier + " of players have " + labelName + " " + featureName;
        return summary;


    }

    public static String generateSummary(List<FuzzySet> sets, boolean relative, int numberOfPlayers, boolean isSum) {
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


        String quantifier = Quantifier.quantifies(result.getPlayersWithMembershipValue().size(), numberOfPlayers, relative);
        String summary = quantifier + " of players have " + features;
        return summary;


    }
}
