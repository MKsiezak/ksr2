import AffilationFunctions.TriangularFuzzyFunction;
import Classifiers.FuzzyClassifier;
import Data.AttributesSpaces;
import Data.ReadData;
import Sets.FuzzySet;
import com.fuzzylite.Engine;
import com.fuzzylite.variable.InputVariable;

public class Main {
    public static void main(String[] args) {
        try {
          System.out.println("abc");
            AttributesSpaces a = new AttributesSpaces();
            FuzzyClassifier testset = new FuzzyClassifier(a,"age");
            testset.addAffilationFunction(new TriangularFuzzyFunction(15,18,22,"young"));
            testset.addAffilationFunction(new TriangularFuzzyFunction(21,24,27,"mid"));
            testset.addAffilationFunction(new TriangularFuzzyFunction(25,30,36,"old"));

            FuzzySet young = testset.createSet("young");
            young.complement();
            young.getHeight();
            young.isEmpty();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}