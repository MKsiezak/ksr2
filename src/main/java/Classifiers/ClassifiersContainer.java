package Classifiers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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

    public void generateFunctionDescription(){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("opis.txt"));

            for (int i=0; i< classifiers.size();i++) {
                writer.write("Etykieta      a       b       c       d");
                writer.append('\n');
                for (int k = 0; k < classifiers.get(i).getAffilation().size(); k++) {
                    if (classifiers.get(i).getAffilation().get(k).getD()!=-1) {
                        writer.write(classifiers.get(i).getAffilation().get(k).getLabel() + "     " + classifiers.get(i).getAffilation().get(k).getA() + "     " + classifiers.get(i).getAffilation().get(k).getB() + "     " + classifiers.get(i).getAffilation().get(k).getC() + "     " + classifiers.get(i).getAffilation().get(k).getD());
                        writer.append('\n');
                    }
                    else {
                        writer.write(classifiers.get(i).getAffilation().get(k).getLabel() + "     " + classifiers.get(i).getAffilation().get(k).getA() + "     " + classifiers.get(i).getAffilation().get(k).getB() + "     " + classifiers.get(i).getAffilation().get(k).getC());
                        writer.append('\n');
                    }
                }
                writer.write("Tabela "+ i+ ". Parametry funkcji przynależnośći dla etykiety "+ classifiers.get(i).getFeatureName());
                writer.append('\n');
                writer.append('\n');

                for (int k = 0; k < classifiers.get(i).getAffilation().size(); k++) {
                    if (classifiers.get(i).getAffilation().get(k).getD()==-1) {
                        writer.write("Wartość funkcji przynależnosci dla etykiety "+classifiers.get(i).getAffilation().get(k).getLabel());
                        writer.append('\n');
                        writer.write("Dla x$("+classifiers.get(i).getAffilation().get(k).getA()+","+ classifiers.get(i).getAffilation().get(k).getB()+"):");
                        writer.append('\n');
                        writer.write("y="+1/(classifiers.get(i).getAffilation().get(k).getB()-classifiers.get(i).getAffilation().get(k).getA())+"x + " +(-1/(classifiers.get(i).getAffilation().get(k).getB()-classifiers.get(i).getAffilation().get(k).getA())*classifiers.get(i).getAffilation().get(k).getA()));

                        writer.append('\n');
                        writer.append('\n');
                        writer.write("Dla x="+classifiers.get(i).getAffilation().get(k).getB());
                        writer.append('\n');
                        writer.write("y=1");

                        writer.append('\n');
                        writer.append('\n');
                        writer.write("Dla x$("+classifiers.get(i).getAffilation().get(k).getB()+","+ classifiers.get(i).getAffilation().get(k).getC()+"):");
                        writer.append('\n');
                        writer.write("y="+1/(classifiers.get(i).getAffilation().get(k).getB()-classifiers.get(i).getAffilation().get(k).getC())+"x + " +(-1)*classifiers.get(i).getAffilation().get(k).getC()*(1/(classifiers.get(i).getAffilation().get(k).getB()-classifiers.get(i).getAffilation().get(k).getC())));
                        writer.append('\n');
                        writer.append('\n');


                    }
                    else {
                        writer.write("Wartość funkcji przynależnosci dla etykiety "+classifiers.get(i).getAffilation().get(k).getLabel());
                        writer.append('\n');
                        writer.write("Dla x$("+classifiers.get(i).getAffilation().get(k).getA()+","+ classifiers.get(i).getAffilation().get(k).getB()+"):");
                        writer.append('\n');
                        writer.write("y="+1/(classifiers.get(i).getAffilation().get(k).getB()-classifiers.get(i).getAffilation().get(k).getA())+"x + " +(-1/(classifiers.get(i).getAffilation().get(k).getB()-classifiers.get(i).getAffilation().get(k).getA())*classifiers.get(i).getAffilation().get(k).getA()));

                        writer.append('\n');
                        writer.append('\n');
                        writer.write("Dla x$("+classifiers.get(i).getAffilation().get(k).getB()+","+ classifiers.get(i).getAffilation().get(k).getC()+"):");
                        writer.append('\n');
                        writer.write("y=1");

                        writer.append('\n');
                        writer.append('\n');
                        writer.write("Dla x$("+classifiers.get(i).getAffilation().get(k).getC()+","+ classifiers.get(i).getAffilation().get(k).getD()+"):");
                        writer.append('\n');
                        writer.write("y="+1/(classifiers.get(i).getAffilation().get(k).getC()-classifiers.get(i).getAffilation().get(k).getD())+"x + " +(-1)*classifiers.get(i).getAffilation().get(k).getD()*(1/(classifiers.get(i).getAffilation().get(k).getC()-classifiers.get(i).getAffilation().get(k).getD())));
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

