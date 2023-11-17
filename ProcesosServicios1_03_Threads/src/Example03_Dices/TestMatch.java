package Example03_Dices;

import java.util.ArrayList;
import java.util.List;

public class TestMatch {
	
	public static void main(String[] args) {
		List<Play> players = new ArrayList<Play>();
		
		for (int i = 0; i < 5; i++) players.add(new Play("Jugador " + (i + 1) ));
		Match match = new Match(players);
		
		// play the match
		for (Play play : match.getPlayers()) {
			play.start();
			try {
				play.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // for
		
		match.showScoreBoard();
	}

}
