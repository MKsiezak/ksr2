package Sets;

import AffilationFunctions.AffilationFunction;
import Data.AttributesSpaces;
import Data.Player;
import FuzzyMembership.Membership;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class FuzzySet {

    //czy jak tworze zbior rozmyty np pilkarzy mlodych to czy bedzie to zbior tych pilkarzy dla ktorych  f.przynaleznosci
    //jest najwieksza dla mlodych , czyli np stary zawodnik ktory ma przynaleznosc do mlodych 0 ma byc w zbiorze
    //mlodych z funkcja przynaleznosci = 0 czy nie? jesli tak to jak wtedy policzyc licznosc mlodych?

    // jak liczyc zbior wypukly i wklesly? czy nie wystarczy ze f prznaleznosci jest wypukla/ wklesla ?

    //zmienic na hashmape calego membershipa

    // czy kwantyfikator ma miec wartosci procentowe ( wzgledny ) jesli np bedziemy chcieli mlodych dobrze strzelajacych
    // zawodnikow

    //dalsze podpunkty?
    protected List<Membership> playersWithMembershipValue;
    protected String labelName;

    public FuzzySet(List<Membership> playersWithMembershipValue, String labelName) {
        this.playersWithMembershipValue = playersWithMembershipValue;
        this.labelName = labelName;
    }

    public List<Membership> getPlayersWithMembershipValue() {
        return playersWithMembershipValue;
    }


    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public boolean isEmpty(){
        for (int i=0 ; i<playersWithMembershipValue.size(); i++)
        {
            if ( playersWithMembershipValue.get(i).getMembershipValue()>0)
                return false;
        }
        return true;
    }

    public double getHeight(){
        double maxValue=0;
        for (int i=0 ; i<playersWithMembershipValue.size(); i++)
        {
            if ( playersWithMembershipValue.get(i).getMembershipValue()>maxValue)
                maxValue =  playersWithMembershipValue.get(i).getMembershipValue();
                if (maxValue == 1 )
                    return maxValue;
        }
        return maxValue;
    }

    //dopelnienie
    public List<Membership> complement(){
        List<Membership> playerList = new ArrayList<Membership>();

        for (int i=0 ; i<playersWithMembershipValue.size(); i++)
        {
            playerList.add(new Membership(playersWithMembershipValue.get(i).getPlayer(), 1-  playersWithMembershipValue.get(i).getMembershipValue()));

        }
        return playerList;
    }


    public List<Membership> sumFuzzySets(FuzzySet second){
        List<Membership> playerList = new ArrayList<Membership>();

        for (int i=0 ; i<playersWithMembershipValue.size(); i++)
        {

        }
           // playerList.add(new Membership(playersWithMembershipValue.get(i).getPlayer(), 1-  playersWithMembershipValue.get(i).getMembershipValue()));
        return null;
        }

    }






