package Classifiers;

import AffilationFunctions.TrapezoidalFuzzyFunction;
import AffilationFunctions.TriangularFuzzyFunction;
import Data.AttributesSpaces;

public class ClassifierInitialize {

    public static boolean initialize(ClassifiersContainer allClassifiers){
        try {
            AttributesSpaces a = new AttributesSpaces();

            FuzzyClassifier age = new FuzzyClassifier(a, "age");
            FuzzyClassifier height = new FuzzyClassifier(a, "height");
            FuzzyClassifier weight = new FuzzyClassifier(a, "weight");
            FuzzyClassifier overall = new FuzzyClassifier(a, "overall");
            FuzzyClassifier value_eur = new FuzzyClassifier(a, "value_eur");
            FuzzyClassifier pace = new FuzzyClassifier(a, "pace");
            FuzzyClassifier shooting = new FuzzyClassifier(a, "shooting");
            FuzzyClassifier passing = new FuzzyClassifier(a, "passing");
            FuzzyClassifier dribbling = new FuzzyClassifier(a, "dribbling");
            FuzzyClassifier defending = new FuzzyClassifier(a, "defending");
            FuzzyClassifier physic = new FuzzyClassifier(a, "physic");

            age.addAffilationFunction(new TrapezoidalFuzzyFunction(16, 17, 20, 24, "young"));
            age.addAffilationFunction(new TriangularFuzzyFunction(22, 27, 31, "middle-aged"));
            age.addAffilationFunction(new TrapezoidalFuzzyFunction(29, 32, 40, 43,"old"));

            height.addAffilationFunction(new TrapezoidalFuzzyFunction(155, 157, 170, 175, "short"));
            height.addAffilationFunction(new TriangularFuzzyFunction(170, 180, 185, "medium"));
            height.addAffilationFunction(new TrapezoidalFuzzyFunction(183, 190, 205, 206, "tall"));

            weight.addAffilationFunction(new TrapezoidalFuzzyFunction(49, 50, 60, 70, "low"));
            weight.addAffilationFunction(new TriangularFuzzyFunction(65, 75, 85, "average"));
            weight.addAffilationFunction(new TriangularFuzzyFunction(84, 95, 105, "heavy"));
            weight.addAffilationFunction(new TrapezoidalFuzzyFunction(100, 101, 110, 111, "obese"));

            overall.addAffilationFunction(new TrapezoidalFuzzyFunction(47, 48, 70, 75, "weak"));
            overall.addAffilationFunction(new TriangularFuzzyFunction(72, 80, 83, "average"));
            overall.addAffilationFunction(new TriangularFuzzyFunction(82, 88, 90, "good"));
            overall.addAffilationFunction(new TrapezoidalFuzzyFunction(89, 90, 94, 95, "amazing"));

            value_eur.addAffilationFunction(new TrapezoidalFuzzyFunction(0, 5000000, 10000000, 12000000, "cheap"));
            value_eur.addAffilationFunction(new TriangularFuzzyFunction(110000000, 50000000, 70000000, "moderate"));
            value_eur.addAffilationFunction(new TrapezoidalFuzzyFunction(60000000, 80000000, 105000000, 110000000, "high"));

            pace.addAffilationFunction(new TrapezoidalFuzzyFunction(23, 24, 65, 75, "weak"));
            pace.addAffilationFunction(new TriangularFuzzyFunction(70, 75, 85, "average"));
            pace.addAffilationFunction(new TrapezoidalFuzzyFunction(83, 88, 96, 97, "good"));

            shooting.addAffilationFunction(new TrapezoidalFuzzyFunction(14, 15, 70, 75, "weak"));
            shooting.addAffilationFunction(new TriangularFuzzyFunction(72, 80, 85, "average"));
            shooting.addAffilationFunction(new TrapezoidalFuzzyFunction(83, 88, 93, 94, "good"));

            passing.addAffilationFunction(new TrapezoidalFuzzyFunction(23, 24, 65, 70, "weak"));
            passing.addAffilationFunction(new TriangularFuzzyFunction(68, 75, 80, "average"));
            passing.addAffilationFunction(new TrapezoidalFuzzyFunction(78, 85, 92, 94, "good"));

            dribbling.addAffilationFunction(new TrapezoidalFuzzyFunction(22, 24, 65, 70, "weak"));
            dribbling.addAffilationFunction(new TriangularFuzzyFunction(68, 75, 83, "average"));
            dribbling.addAffilationFunction(new TrapezoidalFuzzyFunction(80, 85, 96, 97, "good"));

            defending.addAffilationFunction(new TrapezoidalFuzzyFunction(14, 15, 55, 60, "weak"));
            defending.addAffilationFunction(new TriangularFuzzyFunction(59, 75, 85, "average"));
            defending.addAffilationFunction(new TrapezoidalFuzzyFunction(83, 86, 90, 92, "good"));

            physic.addAffilationFunction(new TrapezoidalFuzzyFunction(25, 26, 60, 70, "weak"));
            physic.addAffilationFunction(new TriangularFuzzyFunction(65, 80, 83, "average"));
            physic.addAffilationFunction(new TrapezoidalFuzzyFunction(81, 86, 90, 92, "good"));

            allClassifiers.addClassifier(age);
            allClassifiers.addClassifier(height);
            allClassifiers.addClassifier(weight);
            allClassifiers.addClassifier(value_eur);
            allClassifiers.addClassifier(overall);
            allClassifiers.addClassifier(pace);
            allClassifiers.addClassifier(passing);
            allClassifiers.addClassifier(defending);
            allClassifiers.addClassifier(dribbling);
            allClassifiers.addClassifier(physic);
            allClassifiers.addClassifier(shooting);

            return true;
        }
        catch (Exception e){
            return  false;
        }
    }

}
