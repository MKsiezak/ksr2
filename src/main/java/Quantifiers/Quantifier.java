package Quantifiers;

import AffilationFunctions.AffilationFunction;
import AffilationFunctions.TrapezoidalFuzzyFunction;
import AffilationFunctions.TriangularFuzzyFunction;
import Data.AttributesSpaces;

import java.util.ArrayList;
import java.util.List;


public class Quantifier {
    protected List<AffilationFunction> affilation;
    protected String type;

    public boolean addAffilationFunction(AffilationFunction function) {
        try {
            affilation.add(function);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public AffilationFunction findAffilation(String labelName) {
        try {
            for (int i =0 ; i< affilation.size();i++)
            {
                if (affilation.get(i).getLabel().equals(labelName))
                    return affilation.get(i);
            }
            return null;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public Quantifier(String type) {
        this.type = type;
        this.affilation=new ArrayList<AffilationFunction>();
    }

    public String getType() {
        return type;
    }

    public String quantifies(int numberOfPlayersInGroup, int allPlayers) {
        double maxValue = 0;
        int biggestAffilation = 0;
        if (type.equals("wzgledny")) {
            for (int i = 0; i < affilation.size(); i++) {
                if (affilation.get(i).countMembership((double) numberOfPlayersInGroup / (double) allPlayers) > maxValue) {
                    maxValue = affilation.get(i).countMembership((double) numberOfPlayersInGroup / (double) allPlayers);
                    biggestAffilation = i;
                }
            }
        }
        else{
            for (int i = 0; i < affilation.size(); i++) {
                if (affilation.get(i).countMembership((double) numberOfPlayersInGroup) > maxValue) {
                    maxValue = affilation.get(i).countMembership((double) numberOfPlayersInGroup);
                    biggestAffilation = i;
                }
            }

        }
        return affilation.get(biggestAffilation).getLabel();


    }

    //do wartosci funkcji przynaleznosci
    public double quantifiesValue(int numberOfPlayersInGroup, int allPlayers) {
        double maxValue = 0;
        int biggestAffilation = 0;
        if (type.equals("wzgledny")) {
            for (int i = 0; i < affilation.size(); i++) {
                if (affilation.get(i).countMembership((double) numberOfPlayersInGroup / (double) allPlayers) > maxValue) {
                    maxValue = affilation.get(i).countMembership((double) numberOfPlayersInGroup / (double) allPlayers);
                    biggestAffilation = i;
                }
            }
        }
        else{
            for (int i = 0; i < affilation.size(); i++) {
                if (affilation.get(i).countMembership((double) numberOfPlayersInGroup) > maxValue) {
                    maxValue = affilation.get(i).countMembership((double) numberOfPlayersInGroup);
                    biggestAffilation = i;
                }
            }

        }
        return maxValue;


    }




}




