package Quantifiers;

import AffilationFunctions.TrapezoidalFuzzyFunction;
import AffilationFunctions.TriangularFuzzyFunction;
import Classifiers.ClassifiersContainer;
import Classifiers.FuzzyClassifier;
import Data.AttributesSpaces;

public class QuantifierInitialize {


    public static boolean initialize(QuantifiersContainer allquantifiers) {
        try {
            Quantifier wzgledny = new Quantifier("wzgledny");

            wzgledny.addAffilationFunction(new TrapezoidalFuzzyFunction(-1, 0, 0.05, 0.15, "Almost none"));
            wzgledny.addAffilationFunction(new TriangularFuzzyFunction(0.1, 0.25, 0.3, "About a quarter"));
            wzgledny.addAffilationFunction(new TriangularFuzzyFunction(.28, 0.33, 0.45, "About a third"));
            wzgledny.addAffilationFunction(new TriangularFuzzyFunction(0.4, 0.5, .6, "About half"));
            wzgledny.addAffilationFunction(new TriangularFuzzyFunction(0.59, 0.66, .75, "About two-thirds"));
            wzgledny.addAffilationFunction(new TriangularFuzzyFunction(0.7, 0.8, .9, "Most"));
            wzgledny.addAffilationFunction(new TrapezoidalFuzzyFunction(0.85, .91, 1, 1.1, "Almost all"));

            Quantifier bezwzgledny = new Quantifier("bezwzgledny");

            bezwzgledny.addAffilationFunction(new TriangularFuzzyFunction(0, 1000, 2000, "About a thousand"));
            bezwzgledny.addAffilationFunction(new TriangularFuzzyFunction(1500, 5000, 8000, "About five thousands"));
            bezwzgledny.addAffilationFunction(new TriangularFuzzyFunction(7500, 10000, 13000, "About ten thousands"));
            bezwzgledny.addAffilationFunction(new TriangularFuzzyFunction(12000, 15000, 20000, "About fifteen thousands"));

            allquantifiers.addQuantifier(wzgledny);
            allquantifiers.addQuantifier(bezwzgledny);
            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

}
