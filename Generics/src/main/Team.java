package main;

import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>>{
    String name;
    int played;
    int lost;
    int won;
    int tied;

    ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addMember(T player){
        if(members.contains(player)){
            System.out.println(this.name + " already contains "+ player.getName());
            return false;
        }else{
            members.add(player);
            System.out.println(player.getName() +" Added to main.Team " +this.name);
            return true;
        }
    }

    public int totalTeamMembers(){
        return members.size();
    }

    public void matchResult(Team<T> opponent,int ourScore, int theirScore ){
        String message;

        if(ourScore > theirScore) {
            won++;
            message = " beat ";
        } else if(ourScore == theirScore) {
            tied++;
            message = " drew with ";

        } else {
            lost++;
            message = " lost to ";
        }
        played++;
        if(opponent != null) {
            System.out.println(this.getName() + message + opponent.getName());
            opponent.matchResult(null, theirScore, ourScore);
        }
    }

    public int ranking() {
        return (won * 2) + tied;
    }

    @Override
    public int compareTo(Team<T> team) {
        if(this.ranking() > team.ranking()) {
            return -1;
        } else if(this.ranking() < team.ranking()) {
            return 1;
        } else {
            return 0;
        }
    }
}
