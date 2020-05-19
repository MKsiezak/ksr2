package Quantifiers;

import AffilationFunctions.AffilationFunction;
import AffilationFunctions.TrapezoidalFuzzyFunction;
import AffilationFunctions.TriangularFuzzyFunction;
import Data.AttributesSpaces;

import java.util.ArrayList;
import java.util.List;



public class Quantifier {

    // wzgledny to True
    public static String  quantifies(int numberOfPlayersInGroup, int allPlayers, boolean relative){
        List<AffilationFunction> affilation = new ArrayList<AffilationFunction>();

        if (relative) {

            affilation.add(new TrapezoidalFuzzyFunction(-1, 0, 0.05, 0.15, "Almost none"));
            affilation.add(new TriangularFuzzyFunction(0.1, 0.25, 0.3, "About a quarter"));
            affilation.add(new TriangularFuzzyFunction(.28, 0.33, 0.45, "About a third"));
            affilation.add(new TriangularFuzzyFunction(0.4, 0.5, .6, "About half"));
            affilation.add(new TriangularFuzzyFunction(0.59, 0.66, .75, "About two-thirds"));
            affilation.add(new TriangularFuzzyFunction(0.7, 0.8, .9, "Most"));
            affilation.add(new TrapezoidalFuzzyFunction(0.85, .91, 1, 1.1, "Almost all"));

            double maxValue = 0;
            int biggestAffilation = 0;
            for (int i = 0; i < affilation.size(); i++) {
                if (affilation.get(i).countMembership((double) numberOfPlayersInGroup / (double) allPlayers) > maxValue) {
                    maxValue = affilation.get(i).countMembership((double) numberOfPlayersInGroup / (double) allPlayers);
                    biggestAffilation = i;
                }
            }
            return affilation.get(biggestAffilation).getLabel();
        }
        else{

                affilation.add(new TriangularFuzzyFunction(0, 1000,2000 , "około tysiąc"));
                affilation.add(new TriangularFuzzyFunction(.28, 0.33, 0.45, "około jedna trzecia"));
                affilation.add(new TriangularFuzzyFunction(0.4, 0.5, .6, "około połowa"));
                affilation.add(new TriangularFuzzyFunction(0.59, 0.66, .75, "około dwie trzecie"));
                affilation.add(new TriangularFuzzyFunction(0.7, 0.8, .9, "większość"));
                affilation.add(new TrapezoidalFuzzyFunction(0.85, .91, 1, 1.1, "Około 15 tysięcy"));

                double maxValue = 0;
                int biggestAffilation = 0;
                for (int i = 0; i < affilation.size(); i++) {
                    if (affilation.get(i).countMembership((double) numberOfPlayersInGroup / (double) allPlayers) > maxValue) {
                        maxValue = affilation.get(i).countMembership((double) numberOfPlayersInGroup / (double) allPlayers);
                        biggestAffilation = i;
                    }
                }
                return affilation.get(biggestAffilation).getLabel();



        }


    }



}
