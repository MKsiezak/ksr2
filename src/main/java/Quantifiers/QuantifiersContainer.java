package Quantifiers;

import Classifiers.FuzzyClassifier;

import java.util.ArrayList;
import java.util.List;

public class QuantifiersContainer {
    protected List<Quantifier> quantifiers;

    public QuantifiersContainer() {
        this.quantifiers = new ArrayList<Quantifier>();
    }

    public Quantifier findQuantifier (String type){
        for (int i =0; i<quantifiers.size(); i++){
            if (quantifiers.get(i).getType().equals(type))
                return quantifiers.get(i);
        }
        return null;
    }


    public List<Quantifier> getQuantifiers() {
        return quantifiers;
    }



    public void addQuantifier(Quantifier quantifier){
        quantifiers.add(quantifier);
    }
}
