import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {
	static boolean playerStatus = true;
	static List<Cards> hand = new ArrayList<>(2);
	private String name;
	private int cash;

	
	public static boolean isPlayerStatus() {
		return playerStatus;
	}

	public static void setPlayerStatus(boolean playerStatus) {
		Player.playerStatus = playerStatus;
	}
	
	public String getName() {
		return name;
	}

	public int getCash() {
		return cash;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	static List<Cards> getHand(){
		//Deck.populateDeck();
		//Deck.shuffleDeck();
		for(int i=0;i<2;i++){
			hand.add(Deck.getDeck().removeFirst());
		}
		return hand;
	}


	void fold(){
		playerStatus=false;
	}

	void call(){
		setCash(getCash()-GameController.getCurrentBet());
		GameController.setBettingPool(GameController.getBettingPool()+GameController.getCurrentBet());
	}

	void raise(int amount){
		GameController.setCurrentBet(GameController.getCurrentBet()+amount);
		setCash(getCash()-GameController.getCurrentBet());
		GameController.setBettingPool(GameController.getBettingPool()+GameController.getCurrentBet());
	}
	void check(){

	}
	void initialBet(int initial){
		GameController.setCurrentBet(initial);//establish current bet
		setCash(getCash()-initial); // removes bet from cash
		GameController.setBettingPool(initial);

	}
	void allIn(){

	}


	public static void main(String[] args){
		Map<Integer,String> handCombo = new HashMap<>();
		System.out.println(handCombo.get(1));
	}
}
