package Summaries;

import Classifiers.ClassifiersContainer;
import QualityMeasures.T1;
import Quantifiers.Quantifier;
import Sets.FuzzySet;

import java.util.ArrayList;
import java.util.List;

public class SecondSummary {

    public static List<String> generateSummary(List<FuzzySet> left, List<FuzzySet> right, Quantifier quantifier, int numberOfPlayers, ClassifiersContainer allClassifiers, boolean fileSave){

        //FuzzySet zbior = allClassifiers.findClassifier(featureName).createSet(labelName);
        //int numberOfPlayers = zbior.getPlayersWithMembershipValue().size();
        FuzzySet wypadkowy;
        String summary,quality;
        List<String> summaries = new ArrayList<String>();

        for ( int i=0; i< right.size(); i++)
        {
            for ( int k=0; k < left.size();k++)
            {
                wypadkowy = right.get(i).intersectionFuzzySetsWithoutZero(left.get(k));
                summary = quantifier.quantifiesForSecond(wypadkowy, numberOfPlayers,allClassifiers,fileSave,left.get(k), right.get(i)  );
                summaries.add(summary);


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
