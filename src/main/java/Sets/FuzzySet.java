package Sets;

import AffilationFunctions.AffilationFunction;
import Data.AttributesSpaces;
import Data.Player;
import FuzzyMembership.Membership;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;


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
    protected String featureName;
    protected int number_of_all_players;

    public FuzzySet(List<Membership> playersWithMembershipValue, String labelName,String featureName, int number_of_all_players) {
        this.playersWithMembershipValue = playersWithMembershipValue;
        this.labelName = labelName;
        this.featureName = featureName;
        this.number_of_all_players= number_of_all_players;
    }

    public String getFeatureName() {
        return featureName;
    }

    public List<Membership> getPlayersWithMembershipValue() {
        return playersWithMembershipValue;
    }


    public String getLabelName() {
        return labelName;
    }

    public int getNumber_of_all_players() {
        return number_of_all_players;
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

    // przyjmuje drugi zbior rozmyty
    public FuzzySet sumFuzzySets(FuzzySet second){
        List<Membership> playerList = new ArrayList<Membership>();

        for (int i=0 ; i<playersWithMembershipValue.size(); i++)
        {
            if (isPresent(second.getPlayersWithMembershipValue(),playersWithMembershipValue.get(i).getPlayer().getId())) {    //System.out.println(second.getPlayersWithMembershipValue().stream().filter(o -> o.getPlayer().getName().equals(playersWithMembershipValue.get(i).getPlayer().getName())).findFirst().get());
                int indeksik = indexOfPlayer(second.getPlayersWithMembershipValue(), playersWithMembershipValue.get(i).getPlayer().getId());
                playerList.add(new Membership(playersWithMembershipValue.get(i).getPlayer(),Math.max(playersWithMembershipValue.get(i).getMembershipValue(),second.getPlayersWithMembershipValue().get(indeksik).getMembershipValue())));
            }
            else{
                playerList.add(playersWithMembershipValue.get(i));
            }
        }

        for (int i=0; i<second.getPlayersWithMembershipValue().size() ; i++)
        {
            if (isPresent(playersWithMembershipValue,second.getPlayersWithMembershipValue().get(i).getPlayer().getId())) {    //System.out.println(second.getPlayersWithMembershipValue().stream().filter(o -> o.getPlayer().getName().equals(playersWithMembershipValue.get(i).getPlayer().getName())).findFirst().get());
                continue;
            }
            else{
                playerList.add(second.getPlayersWithMembershipValue().get(i));
            }

        }
        FuzzySet sumSet = new FuzzySet(playerList,labelName+ " sum "+second.getLabelName(),featureName,number_of_all_players);


        return sumSet;
        }

        //przeciecie - czesc wspolna zbiorow rozmytych
    public FuzzySet intersectionFuzzySets(FuzzySet second){
        List<Membership> playerList = new ArrayList<Membership>();

        for (int i=0 ; i<playersWithMembershipValue.size(); i++)
        {

            if (isPresent(second.getPlayersWithMembershipValue(),playersWithMembershipValue.get(i).getPlayer().getId())) {    //System.out.println(second.getPlayersWithMembershipValue().stream().filter(o -> o.getPlayer().getName().equals(playersWithMembershipValue.get(i).getPlayer().getName())).findFirst().get());
                int indeksik = indexOfPlayer(second.getPlayersWithMembershipValue(), playersWithMembershipValue.get(i).getPlayer().getId());
                playerList.add(new Membership(playersWithMembershipValue.get(i).getPlayer(),Math.min(playersWithMembershipValue.get(i).getMembershipValue(),second.getPlayersWithMembershipValue().get(indeksik).getMembershipValue())));
            }
            else{
                playerList.add(new Membership(playersWithMembershipValue.get(i).getPlayer(),0));
            }
        }

        for (int i=0; i<second.getPlayersWithMembershipValue().size() ; i++)
        {
            if (isPresent(playersWithMembershipValue,second.getPlayersWithMembershipValue().get(i).getPlayer().getId())) {    //System.out.println(second.getPlayersWithMembershipValue().stream().filter(o -> o.getPlayer().getName().equals(playersWithMembershipValue.get(i).getPlayer().getName())).findFirst().get());
                continue;
            }
            else{
                playerList.add(new Membership(second.getPlayersWithMembershipValue().get(i).getPlayer(),0));
            }

        }
        FuzzySet sumSet = new FuzzySet(playerList,labelName+ " and "+second.getLabelName(),featureName,playersWithMembershipValue.size());


        return sumSet;
    }

    //nosnik
    public List<Membership> supp(){
        List<Membership> playerList = new ArrayList<Membership>();

        for (int i=0 ; i<playersWithMembershipValue.size(); i++)
        {
            if (playersWithMembershipValue.get(i).getMembershipValue()>0) {

                playerList.add(playersWithMembershipValue.get(i));
            }


        }
        return playerList;
    }

    //alfa przekrój
    public List<Membership> section(double a){
        List<Membership> playerList = new ArrayList<Membership>();

        for (int i=0 ; i<playersWithMembershipValue.size(); i++)
        {
            if (playersWithMembershipValue.get(i).getMembershipValue()>a) {

                playerList.add(playersWithMembershipValue.get(i));
            }


        }
        return playerList;
    }



    public boolean isPresent(final List<Membership> list, final int id){
        return list.stream().filter(o -> o.getPlayer().getId()==id).findFirst().isPresent();
    }

    public int indexOfPlayer(final List<Membership> list, final int id){


        return list.indexOf(list.stream().filter(o -> o.getPlayer().getId()==id).findFirst().get());

    }



    //przeciecie - czesc wspolna zbiorow rozmytych
    public FuzzySet intersectionFuzzySetsWithoutZero(FuzzySet second){
        List<Membership> playerList = new ArrayList<Membership>();

        for (int i=0 ; i<playersWithMembershipValue.size(); i++)
        {

            if (isPresent(second.getPlayersWithMembershipValue(),playersWithMembershipValue.get(i).getPlayer().getId())) {    //System.out.println(second.getPlayersWithMembershipValue().stream().filter(o -> o.getPlayer().getName().equals(playersWithMembershipValue.get(i).getPlayer().getName())).findFirst().get());
                int indeksik = indexOfPlayer(second.getPlayersWithMembershipValue(), playersWithMembershipValue.get(i).getPlayer().getId());
                playerList.add(new Membership(playersWithMembershipValue.get(i).getPlayer(),Math.min(playersWithMembershipValue.get(i).getMembershipValue(),second.getPlayersWithMembershipValue().get(indeksik).getMembershipValue())));
            }

        }
        FuzzySet sumSet = new FuzzySet(playerList,labelName+ " and "+second.getLabelName(),featureName,playersWithMembershipValue.size());


        return sumSet;
    }





    }






