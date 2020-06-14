package Quantifiers;

import Classifiers.FuzzyClassifier;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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

    public void generateFunctionDescription(){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("opiskwantyfikatorow.txt"));

            for (int i=0; i< quantifiers.size();i++) {
                writer.write("Etykieta      a       b       c       d");
                writer.append('\n');
                for (int k = 0; k < quantifiers.get(i).getAffilation().size(); k++) {
                    if (quantifiers.get(i).getAffilation().get(k).getD()!=-1) {
                        writer.write(quantifiers.get(i).getAffilation().get(k).getLabel() + "     " + quantifiers.get(i).getAffilation().get(k).getA() + "     " + quantifiers.get(i).getAffilation().get(k).getB() + "     " + quantifiers.get(i).getAffilation().get(k).getC() + "     " + quantifiers.get(i).getAffilation().get(k).getD());
                        writer.append('\n');
                    }
                    else {
                        writer.write(quantifiers.get(i).getAffilation().get(k).getLabel() + "     " + quantifiers.get(i).getAffilation().get(k).getA() + "     " + quantifiers.get(i).getAffilation().get(k).getB() + "     " + quantifiers.get(i).getAffilation().get(k).getC());
                        writer.append('\n');
                    }
                }
                writer.write("Tabela "+ i+ ". Parametry funkcji przynależnośći dla etykiety "+ quantifiers.get(i).getType());
                writer.append('\n');
                writer.append('\n');

                for (int k = 0; k < quantifiers.get(i).getAffilation().size(); k++) {
                    if (quantifiers.get(i).getAffilation().get(k).getD()==-1) {
                        writer.write("Wartość funkcji przynależnosci dla etykiety "+quantifiers.get(i).getAffilation().get(k).getLabel());
                        writer.append('\n');
                        writer.write("Dla x$("+quantifiers.get(i).getAffilation().get(k).getA()+","+ quantifiers.get(i).getAffilation().get(k).getB()+"):");
                        writer.append('\n');
                        writer.write("y="+1/(quantifiers.get(i).getAffilation().get(k).getB()-quantifiers.get(i).getAffilation().get(k).getA())+"x + " +(-1/(quantifiers.get(i).getAffilation().get(k).getB()-quantifiers.get(i).getAffilation().get(k).getA())*quantifiers.get(i).getAffilation().get(k).getA()));

                        writer.append('\n');
                        writer.append('\n');
                        writer.write("Dla x="+quantifiers.get(i).getAffilation().get(k).getB());
                        writer.append('\n');
                        writer.write("y=1");

                        writer.append('\n');
                        writer.append('\n');
                        writer.write("Dla x$("+quantifiers.get(i).getAffilation().get(k).getB()+","+ quantifiers.get(i).getAffilation().get(k).getC()+"):");
                        writer.append('\n');
                        writer.write("y="+1/(quantifiers.get(i).getAffilation().get(k).getB()-quantifiers.get(i).getAffilation().get(k).getC())+"x + " +(-1)*quantifiers.get(i).getAffilation().get(k).getC()*(1/(quantifiers.get(i).getAffilation().get(k).getB()-quantifiers.get(i).getAffilation().get(k).getC())));
                        writer.append('\n');
                        writer.append('\n');


                    }
                    else {
                        writer.write("Wartość funkcji przynależnosci dla etykiety "+quantifiers.get(i).getAffilation().get(k).getLabel());
                        writer.append('\n');
                        writer.write("Dla x$("+quantifiers.get(i).getAffilation().get(k).getA()+","+ quantifiers.get(i).getAffilation().get(k).getB()+"):");
                        writer.append('\n');
                        writer.write("y="+1/(quantifiers.get(i).getAffilation().get(k).getB()-quantifiers.get(i).getAffilation().get(k).getA())+"x + " +(-1/(quantifiers.get(i).getAffilation().get(k).getB()-quantifiers.get(i).getAffilation().get(k).getA())*quantifiers.get(i).getAffilation().get(k).getA()));

                        writer.append('\n');
                        writer.append('\n');
                        writer.write("Dla x$("+quantifiers.get(i).getAffilation().get(k).getB()+","+ quantifiers.get(i).getAffilation().get(k).getC()+"):");
                        writer.append('\n');
                        writer.write("y=1");

                        writer.append('\n');
                        writer.append('\n');
                        writer.write("Dla x$("+quantifiers.get(i).getAffilation().get(k).getC()+","+ quantifiers.get(i).getAffilation().get(k).getD()+"):");
                        writer.append('\n');
                        writer.write("y="+1/(quantifiers.get(i).getAffilation().get(k).getC()-quantifiers.get(i).getAffilation().get(k).getD())+"x + " +(-1)*quantifiers.get(i).getAffilation().get(k).getD()*(1/(quantifiers.get(i).getAffilation().get(k).getC()-quantifiers.get(i).getAffilation().get(k).getD())));
                        writer.append('\n');
                        writer.append('\n');
                    }
                }
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
