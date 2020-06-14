package Quantifiers;

import AffilationFunctions.AffilationFunction;
import AffilationFunctions.TrapezoidalFuzzyFunction;
import AffilationFunctions.TriangularFuzzyFunction;
import Classifiers.ClassifiersContainer;
import Data.AttributesSpaces;
import QualityMeasures.T1;
import Sets.FuzzySet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
                    System.out.println("");
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

    public String quantifies(FuzzySet result, int allPlayers, List<FuzzySet> sets, ClassifiersContainer allClassifiers, boolean fileSave, String features) {
        double t1,t2,t3,t4,t5,t6, t7, t8,t9,t10,t11;
        double maxValue = 0;
        int biggestAffilation = 0;
        String quality, summary;
        List<String> summaries = new ArrayList<String>();
        List<String> values = new ArrayList<String>();
        List<Double> avg = new ArrayList<Double>();
            for (int i = 0; i < affilation.size(); i++) {
                // zaczynamy
                t1 = T1.countT1new(result, this, allPlayers, affilation.get(i));
                t2 = T1.countT2First(sets, allClassifiers);
                t3 = T1.countT3(result, allPlayers);
                t4 = T1.countT4(sets, allPlayers, t3);
                t5 = T1.countT5(sets);
                t6 = T1.countT6(this, affilation.get(i).getLabel(), allPlayers);
                t7 = T1.countT7(this, affilation.get(i).getLabel(), allPlayers);
                t8 = T1.countT8(sets, allClassifiers);
                t9 = T1.countT9(result, allPlayers, false);
                t10 = T1.countT10(result, allPlayers, false, affilation.get(i), this);
                t11 = T1.countT11();

                quality =" [" + Double.toString((t1+t2+t3+t4+t5+t6+t7+t8+t9+t10+t11)/11.0)+"]";
                avg.add((t1+t2+t3+t4+t5+t6+t7+t8+t9+t10+t11)/11.0);
                values.add(t1 + " " + t2+ " " + t3+ " " + t4+ " " + t5+ " " + t6+ " " + t7+ " " + t8+ " "+ t9+ " " + t10+ " " + t11);
                summary = affilation.get(i).getLabel() + " of players have " + features+ quality;
                summaries.add(summary);

            }

            int maxIndex=0;
            for (int k=1; k< avg.size(); k++){
                if (avg.get(k) > avg.get(maxIndex))
                {
                    maxIndex = k;
                }
            }

            if (fileSave){
                BufferedWriter writer = null;
                try {
                    writer = new BufferedWriter(new FileWriter("summaries.txt"));

                for (int i =0; i<summaries.size();i++) {
                    writer.write(summaries.get(i));
                    writer.write(" "+values.get(i));
                    writer.append('\n');
                }

                BufferedWriter writer2 = new BufferedWriter(new FileWriter("summaryOptimal.txt"));
                    writer2.write(summaries.get(maxIndex));

                writer.close();
                writer2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

    return summaries.get(maxIndex);


    }

    public List<AffilationFunction> getAffilation() {
        return affilation;
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


    public String quantifiesForSecond(FuzzySet result, int allPlayers, ClassifiersContainer allClassifiers, boolean fileSave, FuzzySet left, FuzzySet qualifier) {
        double t1,t2,t3,t4,t5,t6, t7, t8,t9,t10,t11;
        double maxValue = 0;
        int biggestAffilation = 0;
        List<FuzzySet> sets = new ArrayList<FuzzySet>();
        sets.add(left);
        sets.add(qualifier);
        String quality, summary;
        List<String> summaries = new ArrayList<String>();
        List<String> values = new ArrayList<String>();
        List<Double> avg = new ArrayList<Double>();
        for (int i = 0; i < affilation.size(); i++) {
            // zaczynamy
            t1 = T1.countT1new(result, this, qualifier.getPlayersWithMembershipValue().size(), affilation.get(i));
            t2 = T1.countT2First(sets, allClassifiers);
            t3 = T1.countT3(result,  qualifier.getPlayersWithMembershipValue().size());
            t4 = T1.countT4(sets, allPlayers, t3);
            t5 = T1.countT5(sets);
            t6 = T1.countT6(this, affilation.get(i).getLabel(), allPlayers);
            t7 = T1.countT7(this, affilation.get(i).getLabel(), allPlayers);
            t8 = T1.countT8(sets, allClassifiers);
            t9 = T1.countT9(qualifier, allPlayers, true);
            t10 = T1.countT10(qualifier, allPlayers, true, affilation.get(i), this);
            t11 = T1.countT11();

            quality =" [" + Double.toString((t1+t2+t3+t4+t5+t6+t7+t8+t9+t10+t11)/11.0)+"]";
            avg.add((t1+t2+t3+t4+t5+t6+t7+t8+t9+t10+t11)/11.0);
            values.add(t1 + " " + t2+ " " + t3+ " " + t4+ " " + t5+ " " + t6+ " " + t7+ " " + t8+ " "+ t9+ " " + t10+ " " + t11);
            summary = affilation.get(i).getLabel() +  " of " +qualifier.getLabelName() + " " + qualifier.getFeatureName()+ " players have "+ left.getLabelName() + " " + left.getFeatureName()+ quality;
            summaries.add(summary);

        }

        int maxIndex=0;
        for (int k=1; k< avg.size(); k++){
            if (avg.get(k) > avg.get(maxIndex))
            {
                maxIndex = k;
            }
        }

        if (fileSave){
            BufferedWriter writer = null;
            try {
                Long start = System.nanoTime();
                writer = new BufferedWriter(new FileWriter("summaries"+ Long.toString(start)+".txt"));

                for (int i =0; i<summaries.size();i++) {
                    writer.write(summaries.get(i));
                    writer.write(" "+values.get(i));
                    writer.append('\n');
                }

                BufferedWriter writer2 = new BufferedWriter(new FileWriter("summaryOptimal"+ Long.toString(start)+".txt"));
                writer2.write(summaries.get(maxIndex));

                writer.close();
                writer2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return summaries.get(maxIndex);


    }





}




