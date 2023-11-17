package Example03_Dices;

import java.util.Collections;
import java.util.List;

@SuppressWarnings("unchecked")
public class Match {
	
	List<Play> players;
	
	public List<Play> getPlayers() {
		return players;
	}

	public void setPlayers(List<Play> players) {
		this.players = players;
	}

	Match(List<Play> players){
		this.players = players;
	}

	// initialize method
	
	// sorting method based on points
	public void sortListOnPoints() {
		Collections.sort(players);
	}
	
	public void showScoreBoard() {
		sortListOnPoints();
		System.out.println("FINAL SCORE BOARD:");
		for (Play play : players)
			System.out.println(play.toString());
	}
	
}
