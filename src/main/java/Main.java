import AffilationFunctions.TriangularFuzzyFunction;
import Classifiers.ClassifierInitialize;
import Classifiers.ClassifiersContainer;
import Classifiers.FuzzyClassifier;
import Data.AttributesSpaces;
import Data.ReadData;
import Quantifiers.Quantifier;
import Sets.FuzzySet;
import Summaries.FirstSummary;
import Summaries.SecondSummary;
import com.fuzzylite.Engine;
import com.fuzzylite.variable.InputVariable;

public class Main {
    public static void main(String[] args) {
        try {

            //szukac po id a nie po nazwiskach !!!!!!sa takie same niektore
            ClassifiersContainer allClassifiers =new ClassifiersContainer();
            ClassifierInitialize.initialize(allClassifiers);

            String sumary = FirstSummary.generateSummary(allClassifiers,"pace","weak",true);
            String summary2 = SecondSummary.generateSummary(allClassifiers,"physic","good","pace","weak");


            /*
            allClassifiers.addClassifier(new FuzzyClassifier(a,"age"));
            allClassifiers.addClassifier(new FuzzyClassifier(a,"age"));




            FuzzyClassifier testset = new FuzzyClassifier(a,"age");
            testset.addAffilationFunction(new TriangularFuzzyFunction(15,18,22,"young"));
            testset.addAffilationFunction(new TriangularFuzzyFunction(21,24,27,"mid"));
            testset.addAffilationFunction(new TriangularFuzzyFunction(25,30,36,"old"));

            FuzzySet young = testset.createSet("young");
            FuzzySet mid = testset.createSet("mid");
            young.sumFuzzySets(mid);
            FuzzySet czescwspolna = young.intersectionFuzzySets(mid);
            czescwspolna.supp();
            young.complement();
            young.getHeight();
            young.isEmpty();

             */

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}