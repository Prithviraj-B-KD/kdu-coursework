package backend.assignment;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    Map<String,Player> players = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tournment ipl = new Tournment();
        boolean runnning = true;
        while(runnning) {
            LogBack.infoLogger("menu");
            LogBack.infoLogger("1.To Bowlers with more than 40 wickets,Press 1");
            LogBack.infoLogger("2.To get top performers of a team ,Press 2");
            LogBack.infoLogger("3.To get top performers of the tournament ,Press 3");
            LogBack.infoLogger("4.To Exit,Press 4");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    LogBack.infoLogger("Enter team Name");
                    String teamName = scanner.nextLine();
                    ipl.getTopWicketersOfTeam(teamName);
                    break;
                case 2:
                    LogBack.infoLogger("Enter team Name");
                    String teamNam1 = scanner.nextLine();
                    ipl.getPerformerOfTeam(teamNam1);
                    break;
                case 3:
                    ipl.topPerformers();
                    break;
                case 4:runnning = false;
                    break;

                default:
                    LogBack.infoLogger("See and Enter a correct Choice");

            }
        }

    }
}