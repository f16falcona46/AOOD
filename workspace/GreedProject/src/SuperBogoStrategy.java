public class LiPettipawNewellStrategy extends GreedStrategy {
	
//	double offset = 0;
//	int runsSinceLastBank = 0;
	
	public LiPettipawNewellStrategy() {
//		offset = 0;
	}
	
//	public LiPettipawNewellStrategy(double x) {
//		offset = x;
//	}

	@Override
	public int choose(GreedOption[] options, int[] dice, int bank) {
		//System.out.println("Bank: "+bank);
		if (bank > 2700) {
			//System.out.print(options[findWithOptionType(0,options)]);
			return findWithOptionType(0,options);
		}
		if (dice.length < 1) {
			return findWithOptionType(1,options);
		}
		else {
//			if (bank == 0) {
//				runsSinceLastBank = 0;
//			}
//			else {
//				runsSinceLastBank++;
//			}
//			if (runsSinceLastBank > (offset+)) {
//				runsSinceLastBank = 0;
//				return findWithOptionType(1,options);
//			}
//			{
				if (findMaxForLength(6,options) == -1) {
					if (dice.length > 2) {
						return findWithOptionType(1,options);
					}
					else {
						return findWithOptionType(0,options);
					}
				}
				else {
					if (((ScoringCombination)options[findMaxForLength(6,options)]).getValue()<(100) && dice.length>3) {
						return findWithOptionType(1,options);
					}
				}
				return findMaxForLength(6,options);
//			}
		}
	}

	@Override
	public String playerName() {
		return "Dr. Bogus";
	}

	@Override
	public String author() {
		return "Dr. BogoBogus";
	}
	
	private int findMaxForLength(int maxLength, GreedOption[] options) {
		int maxValue = -1;
		int maxValueIndex = -1;
		
		for (int counter = 0; counter < options.length; counter++) {
			if (options[counter].getClass() == ScoringCombination.class) {
				if (((ScoringCombination)options[counter]).getValue()>maxValue && ((ScoringCombination)options[counter]).numDice() <= maxLength) {
					maxValueIndex = counter;
					maxValue = ((ScoringCombination)options[counter]).getValue();
				}
			}
		}
		return maxValueIndex;
	}
	
	private int findWithOptionType(int optionType, GreedOption[] options) {
		for (int counter = 0; counter < options.length; counter++) {
			if (options[counter].optionType()==optionType) {
				return counter;
			}
		}
		return -1;
	}
}
