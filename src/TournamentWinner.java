import java.util.ArrayList;
import java.util.HashMap;

public class TournamentWinner {
    final static int HOME_TEAM_WON = 1;
    final static int AWAY_TEAM_WON = 0;
    final static int POINTS_FOR_WIN = 3;
    final static int POINTS_FOR_LOSS = 0;

    public static String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        HashMap<String, Integer> pointsOfTeams = new HashMap<>();
        String currentLeadingTeam = "";
        String winner = "";
        String loser = "";

        for(int i = 0; i < competitions.size(); i++) {
            int result = results.get(i);
            ArrayList<String> competition = competitions.get(i);
            String homeTeam = competition.get(0);
            String awayTeam = competition.get(1);

            switch (result) {
                case HOME_TEAM_WON:
                    winner = homeTeam;
                    loser = awayTeam;
                    break;
                case AWAY_TEAM_WON:
                    winner = awayTeam;
                    loser = homeTeam;
                    break;
            }

            pointsOfTeams.put(winner, pointsOfTeams.getOrDefault(winner, 0) + POINTS_FOR_WIN);
            pointsOfTeams.put(loser, pointsOfTeams.getOrDefault(loser, 0) + POINTS_FOR_LOSS);
            if(pointsOfTeams.get(winner) > pointsOfTeams.getOrDefault(currentLeadingTeam, 0)) {
                currentLeadingTeam = winner;
            }

        }
        return currentLeadingTeam;
    }

    public static void main(String... args) {
        ArrayList<ArrayList<String>> competitions = new ArrayList<>();
        competitions.add(
            new ArrayList<String>() {{
                add("HTML");
                add("C#");
            }}
        );
        competitions.add(
            new ArrayList<String>() {{
                add("C#");
                add("Python");
            }}
        );
        competitions.add(
            new ArrayList<String>() {{
                add("Python");
                add("HTML");
            }}
        );


        ArrayList<Integer> results = new ArrayList<>();
        results.add(0);
        results.add(0);
        results.add(1);

        String tournamentWinner = tournamentWinner(competitions, results);
        System.out.println(tournamentWinner);
    }
}
