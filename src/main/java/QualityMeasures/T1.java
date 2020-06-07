package QualityMeasures;

import AffilationFunctions.AffilationFunction;
import Classifiers.ClassifiersContainer;
import Quantifiers.Quantifier;
import Sets.FuzzySet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T1 {

    public static double countT1(FuzzySet result, Quantifier quantifier, int m) {
        double r = 0;
        double degreeOfTruth;

        for (int i = 0; i < result.getPlayersWithMembershipValue().size(); i++) {
            r += result.getPlayersWithMembershipValue().get(i).getMembershipValue();

        }
        degreeOfTruth = quantifier.quantifiesValue((int) r, m);
        return degreeOfTruth;


    }

    public static double countT2First(List<FuzzySet> sets, ClassifiersContainer classifiers) {

        double product = 1;
        double in, range, degree;


        for (int i = 0; i < sets.size(); i++) {
            AffilationFunction function = classifiers.findClassifier(sets.get(i).getFeatureName()).findAffilation(sets.get(i).getLabelName());
            in = function.getLast() - function.getFirst();

            range = classifiers.findClassifier(sets.get(i).getFeatureName()).getAllPlayers().getRangeFor(sets.get(i).getFeatureName());

            product = product * in / range;
        }

        degree = 1 - Math.pow(product, 1.0 / sets.size());
        return degree;
    }


    public static double countT3(FuzzySet result, int numberOfAllPlayers) {

        double product;

        product = (double)result.supp().size()/(double)numberOfAllPlayers;
        return  product;

    }
    public static double countT4(List<FuzzySet> sets, int numberOfAllPlayers, double t3) {
        try {
            double product = 1;
            double degree;


            for (int i = 0; i < sets.size(); i++) {
                product = product * (double) sets.get(i).supp().size() / numberOfAllPlayers;

            }

            degree = Math.abs(product - t3);
            return degree;
        }
        catch (Exception e){
            System.out.println(e);
            System.out.println("blad przy t4");
            return -1;
        }
    }

    public static double countT5(List<FuzzySet> sets) {
        try {
            Set<String> fuzzySets = new HashSet<String>();

            for (int i=0; i< sets.size();i++){
                fuzzySets.add(sets.get(i).getFeatureName());
            }
            return 2.0*Math.pow(0.5,fuzzySets.size());
        }
        catch (Exception e){
            System.out.println(e);
            System.out.println("blad przy t5");
            return -1;
        }
    }

    public static double countT7(Quantifier quantifier, String quantifierValue, int numberOfPlayers) {
        try {
            AffilationFunction afilation = quantifier.findAffilation(quantifierValue);
            double space;
            if (quantifier.getType().equals("wzgledny"))
                space=1;
            else
                space=numberOfPlayers;
            double in = (afilation.getLast() - afilation.getFirst())/space;

            return 1.0-in;


        }
        catch (Exception e){
            System.out.println(e);
            System.out.println("blad przy t7");
            return -1;
        }
    }

    public static double countT6(Quantifier quantifier, String quantifierValue, int numberOfPlayers) {
        try {
            AffilationFunction afilation = quantifier.findAffilation(quantifierValue);
            double space;
            if (quantifier.getType().equals("wzgledny"))
                space = 1.0;
            else
                space = numberOfPlayers;
            double in = (afilation.getLast() - afilation.getFirst()) / space;

            return 1.0 - in;


        } catch (Exception e) {
            System.out.println(e);
            System.out.println("blad przy t7");
            return -1;
        }

    }

    public static double countT8(List<FuzzySet> sets, ClassifiersContainer classifiers) {

        return countT2First(sets,classifiers);
    }

    public static double countT9(FuzzySet w, int numberOfPlayers, boolean isComplex) {

        if( isComplex){
            return 1.0;
        }
        else{
            double in = w.supp().size()/numberOfPlayers;
            return 1- in;
        }
    }

    public static double countT10(FuzzySet w, int numberOfPlayers, boolean isComplex) {

       return countT9(w,numberOfPlayers,isComplex);
    }

    public static double countT11() {

        return 1;
    }




}
