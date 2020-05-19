package Classifiers;

import java.util.ArrayList;
import java.util.List;

public class ClassifiersContainer {
     protected List<FuzzyClassifier> classifiers;

    public ClassifiersContainer() {
        this.classifiers = new ArrayList<FuzzyClassifier>();
    }

    public FuzzyClassifier findClassifier (String name){
        for (int i =0; i<classifiers.size(); i++){
            if (classifiers.get(i).getFeatureName().equals(name))
                return classifiers.get(i);
        }
        return null;
    }

    public List<FuzzyClassifier> getClassifiers() {
        return classifiers;
    }

    public void setClassifiers(List<FuzzyClassifier> classifiers) {
        this.classifiers = classifiers;
    }

    public void addClassifier(FuzzyClassifier classi){
        classifiers.add(classi);
    }
}
