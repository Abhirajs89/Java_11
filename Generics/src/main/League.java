package main;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {
    String name;
    ArrayList<T> league = new ArrayList<>();
    public League(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addTeam(T team){
        if(league.contains(team)){
            return false;
        }else{
            league.add(team);
            return true;
        }
    }

    public void showLeagueTable() {
        Collections.sort(league);
        for(T t : league) {
            System.out.println(t.getName() + ": " + t.ranking());
        }
    }
}
