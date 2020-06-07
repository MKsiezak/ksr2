package Summaries;

import Classifiers.ClassifiersContainer;
import Quantifiers.Quantifier;
import Sets.FuzzySet;

import java.util.ArrayList;
import java.util.List;

public class SecondSummary {

    public static List<String> generateSummary(List<FuzzySet> left, List<FuzzySet> right, Quantifier quantifier, int numberOfPlayers, ClassifiersContainer allClassifiers){

        //FuzzySet zbior = allClassifiers.findClassifier(featureName).createSet(labelName);
        //int numberOfPlayers = zbior.getPlayersWithMembershipValue().size();
        FuzzySet wypadkowy;
        String quanti;
        List<String> summaries = new ArrayList<String>();
        for ( int i=0; i< right.size(); i++)
        {
            for ( int k=0; k < left.size();k++)
            {
                wypadkowy = right.get(i).intersectionFuzzySetsWithoutZero(left.get(k));
                quanti = quantifier.quantifies(wypadkowy.getPlayersWithMembershipValue().size(),right.get(i).supp().size());
                summaries.add(quanti+ " of " +right.get(i).getLabelName() + " " + right.get(i).getFeatureName()+ " players have "+ left.get(k).getLabelName() + " " + left.get(k).getFeatureName());


            }
        }
        //String quantifier= Quantifier.quantifies(numberOfPlayers, zbior.getNumber_of_all_players(),relative);
        /*
        FuzzySet zbior2 = allClassifiers.findClassifier(secondFeature).createSet(secondLabel);
        FuzzySet wypadkowy = zbior.intersectionFuzzySets(zbior2);
        String quantifier="duzo"; //Quantifier.quantifies(wypadkowy.supp().size(),wypadkowy.getNumber_of_all_players());
        String summary = quantifier+ " of " + labelName +" "+ featureName + " players have " + secondLabel+ " "+secondFeature ;
        return summary;
        */
        return summaries;


    }
}
