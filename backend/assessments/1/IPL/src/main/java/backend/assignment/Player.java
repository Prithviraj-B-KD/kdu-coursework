package backend.assignment;

public class Player {
    String playerName;
    String teamName;
    String role;
    int matchesPlayed;
    int runs;
    double average;
    double sr;
    int wickets;

    public Player(String name, String teamName,String role,int matchesPlayed,int runs,double average,double sr,int wickets){
        this.playerName = name;
        this.teamName = teamName;
        this.role = role;
        this.matchesPlayed = matchesPlayed;
        this.runs = runs;
        this.average = average;
        this.sr =sr;
        this.wickets = wickets;
    }

    void setPlayerName(String playerName){
        this.playerName = playerName;
    }
    String getPlayerName(){
        return playerName;
    }
    void setTeamName(String teamName){
        this.teamName = teamName;
    }
    String getTeamName(){
        return this.teamName;
    }
    void setRole(String role){
        this.role = role;
    }
    String getRole(){
        return this.role;
    }
    void setMatchesPlayed(int matchesPlayed){
        this.matchesPlayed =   matchesPlayed;
    }
    int getMatchesPlayed(){
        return matchesPlayed;
    }
    void setRuns(int runs){
        this.runs = runs;
    }
    int getRuns(){
        return this.runs;
    }
    void setAverage(double average){
        this.average = average;
    }
    double getAverage(){
        return this.average;
    }
    void setSr(double sr){
        this.sr = sr;
    }
    double getSr(){
        return this.sr;
    }
    void setWickets(int wickets){
      this.wickets = wickets;
    }
    int getWickets(){
       return this.wickets;
    }
}
