
public class StrategyEvaluator {

	public static int evaluateStrategy(GreedStrategy theStrategy, int turns){
		ComputerGreedStrategyPlayer player 
		= new ComputerGreedStrategyPlayer(theStrategy);
		int score
		= (new GreedGame(false)).evaluatePlayer(player, turns);
		return score;
	}
	
	public static double practiceGreed(){
		return (new GreedGame(true))
				.evaluatePlayer(new HumanGreedPlayer(), 1);
	}
	
	public static void main(String[] args) {
		//System.out.println(practiceGreed());
//		for (double counter = 0; counter < 10; counter+= 0.1) {
//			System.out.println("The result of stupidParameter being "+counter+" is "+evaluateStrategy(new BogoStrategy(counter), 10000));
//		}
		
		System.out.println(evaluateStrategy(new LiPettipawNewellStrategy(),10));
		
		System.out.println(evaluateStrategy(new LiPettipawNewellStrategy(1), 100000));
		System.out.println(evaluateStrategy(new LiPettipawNewellStrategy(2), 100000));
		System.out.println(evaluateStrategy(new LiPettipawNewellStrategy(3), 100000));
		System.out.println(evaluateStrategy(new LiPettipawNewellStrategy(4), 100000));
		System.out.println(evaluateStrategy(new LiPettipawNewellStrategy(5), 100000));
		System.out.println(evaluateStrategy(new LiPettipawNewellStrategy(6), 100000));
	}

}
