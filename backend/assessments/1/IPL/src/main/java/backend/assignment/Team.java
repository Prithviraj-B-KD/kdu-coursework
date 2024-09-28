package backend.assignment;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Team {
    String teamName;
    Map<String,Player> players = new HashMap<>();

    Team(String teamName){
     this.teamName = teamName;
    }

    String getTeamName(){
        return this.teamName;
    }

    void addPlayer(String playerName,Player player){
        this.players.put(playerName,player);
    }

    /**
     *
     * @param n we can use this get how many
     */
    void topWicketTakers(int n){
        List<Player> topWicketTakers = players.values().stream().sorted(Comparator.comparing(Player::getWickets).reversed()).limit(n).toList();
        for(Player player : topWicketTakers){
            LogBack.infoLogger(player.getPlayerName());
        }
    }

    void topRunGetters(int n){
        List<Player> topRunGetters = players.values().stream().sorted(Comparator.comparing(Player::getRuns).reversed()).limit(n).toList();
        for(Player player : topRunGetters){
            LogBack.infoLogger(player.getPlayerName());
        }
    }

    void goodWicketTakers(){
        List<Player> goodWicketTakers = players.values().stream().filter(player-> player.getWickets() > 39).toList();
        for(Player player : goodWicketTakers){
            LogBack.infoLogger(player.getPlayerName());
        }
    }



}
