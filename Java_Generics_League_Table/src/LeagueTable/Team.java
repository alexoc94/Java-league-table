package LeagueTable;

import java.util.ArrayList;

/**
 * Created by dev on 17/10/2015.
 */
public class Team<T extends Player> implements Comparable<Team<T>> {/*T can be any type that extends from player. Player is the upper
 bound of T. T = bounded type parameter. Can remove cast now. Also, without T cant ensure right team for method*/
    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;


    private ArrayList<T> members = new ArrayList<>();//ArrayList will now work for any type of player. You will define the type of ArrayList later

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player) {//If arraylist is T than this method is T
        if (members.contains(player)) {
            System.out.println(player.getName() + " is already on this team");
            return false;
        } else {
            members.add(player);
            System.out.println(player.getName() + " picked for team " + this.name);
            return true;
        }
    }

    public int numPlayers() {
        return this.members.size();
    }

    public void matchResult(Team<T> opponent, int ourScore, int theirScore) {//match result does take a team object called opponent
//We want to ensure that only the correct team type can be passed to the match result
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
        played++;//
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























