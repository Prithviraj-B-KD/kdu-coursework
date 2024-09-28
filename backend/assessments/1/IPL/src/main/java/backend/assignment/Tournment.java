package backend.assignment;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.util.*;

public class Tournment {
    Map<String,Team> teams = new HashMap<>();
    Map<String , Player> players = new HashMap<>();

    Tournment(){
        CSVParser playersCSVParser = null;
        int playersCount = 0;
        try{
            playersCSVParser = CsvUtil.getCSVContent(Constants.PLAYER_CSV);
        } catch (IOException e){
            LogBack.errorLogger("IO exception occured while passing Players CSV.");
        }

        if(playersCSVParser != null){

            for (CSVRecord csvRecord : playersCSVParser) {
                 String playerName = csvRecord.get(0);
                 String teamName = csvRecord.get(1);
                Player player = new Player(playerName,teamName,csvRecord.get(2), Integer.parseInt(csvRecord.get(3)),
                        Integer.parseInt(csvRecord.get(4)),
                        Double.parseDouble(csvRecord.get(5)),
                        Double.parseDouble(csvRecord.get(6)),
                        Integer.parseInt(csvRecord.get(7))
                );
                this.players.put(playerName,player);
                Team team = null;
                if (!this.teams.containsKey(teamName)){
                   team = new Team(teamName);
                   this.teams.put(teamName,team);
                }
               team = this.teams.get(teamName);
                team.addPlayer(playerName,player);
                playersCount++;
            }
        }
        String formattedmessage = String.format("players paresed from input csv:%d",playersCount);
        LogBack.debugLogger(formattedmessage);
    }

    void matchFixture(){
        Set<String> teams = this.teams.keySet();


    }

    void topPerformers(){
        LogBack.infoLogger("Top 3 highest Run Scorers:");
        List<Player> topRunGetters = players.values().stream().sorted(Comparator.comparing(Player::getRuns).reversed()).limit(3).toList();
        for(Player player : topRunGetters){
            LogBack.infoLogger(player.getPlayerName());
        }
        LogBack.infoLogger("Top 3 highest Wicket Takers:");
        List<Player> topWicketTakers = players.values().stream().sorted(Comparator.comparing(Player::getWickets).reversed()).limit(3).toList();
        for(Player player : topWicketTakers){
            LogBack.infoLogger(player.getPlayerName());
        }
    }


    void getTopWicketersOfTeam(String teamName){
        Team team = teams.get(teamName);
        LogBack.infoLogger("Bowler with more than 40 wickets:");
        team.goodWicketTakers();
    }

    void getPerformerOfTeam(String teamName){
        Team team = teams.get(teamName);
        LogBack.infoLogger("Highest Wicket Taker:");
        team.topWicketTakers(1);
        LogBack.infoLogger("Highest Run Scorer:");
        team.topRunGetters(1);
    }

}
