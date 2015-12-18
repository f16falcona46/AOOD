import java.util.ArrayList;

public class OceanTester {
	public static void main(String[] args) throws Exception {
		ArrayList<Boolean> allTests = new ArrayList<Boolean>();
		
		System.out.println("\nTest 1");
		try {
			Ocean a = new OceanForwarderToOcean();
			System.out.println("Success: instantiated Ocean");
			allTests.add(true);
		}
		catch (Exception e) {
			System.out.println("Failure: failed to instantiate Ocean");
			allTests.add(false);
		}
		
		System.out.println("\nTest 2");
		TestResult[] results_2 = testPlaceBoat(new OceanForwarderToOcean());
		for (TestResult t : results_2) {
			System.out.println(t);
			allTests.add(t.success);
		}
		
		System.out.println("\nTest 3");
		TestResult[] results_3 = testShootAt(new OceanForwarderToOcean());
		for (TestResult t : results_3) {
			System.out.println(t);
			allTests.add(t.success);
		}
		
		System.out.println("\nTest 4");
		TestResult[] results_4 = testHit(new OceanForwarderToOcean());
		for (TestResult t : results_4) {
			System.out.println(t);
			allTests.add(t.success);
		}
		
		System.out.println("\nTest 5");
		TestResult[] results_5 = testBoatInitial(new OceanForwarderToOcean());
		for (TestResult t : results_5) {
			System.out.println(t);
			allTests.add(t.success);
		}
		
		System.out.println("\nTest 6");
		TestResult[] results_6 = testBoatName(new OceanForwarderToOcean());
		for (TestResult t : results_6) {
			System.out.println(t);
			allTests.add(t.success);
		}
		
		System.out.println("\nTest 7");
		TestResult[] results_7 = testSunk(new OceanForwarderToOcean());
		for (TestResult t : results_7) {
			System.out.println(t);
			allTests.add(t.success);
		}
		
		System.out.println("\nTest 8");
		TestResult[] results_8 = testAllSunk(new OceanForwarderToOcean());
		for (TestResult t : results_8) {
			System.out.println(t);
			allTests.add(t.success);
		}
		
		int passed = 0;
		for (boolean t : allTests) if (t) ++passed;
		
		System.out.println("\n\nTotal tests: "+allTests.size());
		System.out.println("Tests passed: "+passed);
		System.out.println("Tests failed: "+(allTests.size()-passed));
	}
	
	public static TestResult[] testPlaceBoat(Ocean o) throws Exception{
	   	 TestResult[] result = new TestResult[9];
	   	 boolean[] threwException = new boolean[9];
	   	 result[0] = new TestResult("3a", "Boat Placed");
	   	 result[1] = new TestResult("3b", "Boat Placed");
	   	 result[3] = new TestResult("3d", "Boat Placed");
	   	 result[4] = new TestResult("3e", "Boat Placed");
	   	 result[6] = new TestResult("3g", "Exception thrown");
	   	 result[7] = new TestResult("3h", "Exception thrown");
	   	 result[8] = new TestResult("3i", "Boat Placed");
	   	 
	   	 try {
	   		 o.placeBoat("Destroyer", "Horizontal", new Position('F', 3)); //valid
	   	 }
	   	 catch(Exception ex) {
	   		 threwException[0] = true;
	   		 result[0].success = false;
	   		 result[0].output = "Exception thrown";
	   	 }
	   	 if (!threwException[0]) {
	   		 result[0].success = true;
	   		 result[0].output = "Boat Placed";
	   	 }
	   	 
	   	 
	   	 
	   	 try {
	   		 o.placeBoat("Aircraft Carrier", "vertical", new Position('A', 10)); //valid
	   	 }
	   	 catch(Exception ex) {
	   		 threwException[1] = true;
	   		 result[1].success = false;
	   		 result[1].output = "Exception thrown";
	   	 }
	   	 if (!threwException[1]) {
	   		 result[1].success = true;
	   		 result[1].output = "Boat Placed";
	   	 }
	   	 result[2] =  new TestResult(result[1]);
	   	 result[2].input = "3c";
	   	 
	   	 try {
	   		 o.placeBoat("Aircraft Carrier", "vertical", new Position('F', 10)); //valid
	   	 }
	   	 catch(Exception ex) {
	   		 threwException[3] = true;
	   		 result[3].success = false;
	   		 result[3].output = "Exception thrown";
	   	 }
	   	 if (!threwException[3]) {
	   		 result[3].success = true;
	   		 result[3].output = "Boat Placed";
	   	 }
	   	 result[5] =  new TestResult(result[2]);
	   	 result[5].input = "3f";
	   	 
	   	 try {
	   		 o.placeBoat("Aircraft Carrier", "vertical", new Position('A', 9)); //valid
	   	 }
	   	 catch(Exception ex) {
	   		 threwException[4] = true;
	   		 result[4].success = false;
	   		 result[4].output = "Exception thrown";
	   	 }
	   	 if (!threwException[4]) {
	   		 result[4].success = true;
	   		 result[4].output = "Boat Placed";
	   	 }
	   	 
	   	 try {
	   		 o.placeBoat("Aircraft Carrier", "vertical", new Position('C', 3)); //invalid
	   	 }
	   	 catch(Exception ex) {
	   		 threwException[6] = true;
	   		 result[6].success = true;
	   		 result[6].output = "Exception thrown";
	   	 }
	   	 if (!threwException[6]) {
	   		 result[6].success = false;
	   		 result[6].output = "Boat Placed";
	   	 }
	   	 
	   	 try {
	   		 o.placeBoat("Aircraft Carrier", "vertical", new Position('H', 9)); //invalid
	   	 }
	   	 catch(Exception ex) {
	   		 threwException[7] = true;
	   		 result[7].success = true;
	   		 result[7].output = "Exception thrown";
	   	 }
	   	 if (!threwException[7]) {
	   		 result[7].success = false;
	   		 result[7].output = "Boat Placed";
	   	 }
	   	 
	   	 try {
	   			 o.placeBoat("Submarine", "Horizontal", new Position('G', 5)); //valid
	   		 }
	   	 catch(Exception ex) {
	   		 threwException[8] = true;
	   		 result[8].success = false;
	   		 result[8].output = "Exception thrown";
	   	 }
	   	 if (!threwException[8]) {
	   		 result[8].success = true;
	   		 result[8].output = "Boat Placed";
	   	 }
	   	 
	   	 return result;
	    }
	
	public static TestResult[] testShootAt(Ocean o) throws Exception {
		TestResult[] results = new TestResult[7];
		
		try
		{
			o.placeBoat("Destroyer", "vertical", new Position(0, 0));//corner
			o.placeBoat("Destroyer", "horizontal", new Position(4, 4));//middle
			o.placeBoat("Destroyer", "vertical", new Position(2, 9));//edge
		}
		catch(Exception e)
		{
			throw e;
		}
		
		try//a
		{
			results[0] = new TestResult(true, "3.a", "no hit", "no hit");
			o.shootAt(new Position(7,8));
		}
		catch(Exception e)
		{
			results[0].success = false;
			results[0].output = "Exception thrown";
		}
		
		try//b
		{
			results[1] = new TestResult(true, "3.b", "no hit", "no hit");
			o.shootAt(new Position(0, 5));
		}
		catch(Exception e)
		{
			results[1].success = false;
			results[1].output = "Exception thrown";
		}
		
		try//c
		{
			results[2] = new TestResult(true, "3.c", "no hit", "no hit");
			o.shootAt(new Position(9, 0));
		}
		catch(Exception e)
		{
			results[2].success = false;
			results[2].output = "Exception thrown";
		}
		
		try//d
		{
			results[3] = new TestResult(true, "3.d", "no hit", "no hit");
			o.shootAt(new Position(4, 6));
		}
		catch(Exception e)
		{
			results[3].success = false;
			results[3].output = "Exception thrown";
		}
		
		try//e
		{
			results[4] = new TestResult(true, "3.e", "hit", "hit");
			o.shootAt(new Position(4, 4));
		}
		catch(Exception e)
		{
			results[4].success = false;
			results[4].output = "Exception thrown";
		}
		
		try//f
		{
			results[5] = new TestResult(true, "3.f", "hit", "hit");
			o.shootAt(new Position(2, 9));
		}
		catch(Exception e)
		{
			results[5].success = false;
			results[5].output = "Exception thrown";
		}
		
		try//g
		{
			results[6] = new TestResult(true, "3.g", "hit", "hit");
			o.shootAt(new Position(0, 0));
		}
		catch(Exception e)
		{
			results[6].success = false;
			results[6].output = "Exception thrown";
		}
		
		return results;
	}
	
	public static TestResult[] testHit(Ocean o) throws Exception {
		ArrayList<TestResult> resultList = new ArrayList<TestResult>();
		o.placeBoat("Aircraft Carrier", "horizontal", new Position('B',2));
		o.placeBoat("Cruiser", "vertical", new Position('D',6));
		
		resultList.add(new TestResult(!o.hit(new Position('E',5)), "4a: o.hit(new Position('E',5))", Boolean.toString(o.hit(new Position('E',5))), "false"));
		
		resultList.add(new TestResult(!o.hit(new Position('A',5)), "4b: o.hit(new Position('A',5))", Boolean.toString(o.hit(new Position('A',5))), "false"));
		resultList.add(new TestResult(!o.hit(new Position('J',5)), "4b: o.hit(new Position('J',5))", Boolean.toString(o.hit(new Position('J',5))), "false"));
		resultList.add(new TestResult(!o.hit(new Position('E',1)), "4b: o.hit(new Position('E',1))", Boolean.toString(o.hit(new Position('E',1))), "false"));
		resultList.add(new TestResult(!o.hit(new Position('E',10)), "4b: o.hit(new Position('E',10))", Boolean.toString(o.hit(new Position('E',10))), "false"));
		
		resultList.add(new TestResult(!o.hit(new Position('A',1)), "4c: o.hit(new Position('A',1))", Boolean.toString(o.hit(new Position('A',1))), "false"));
		resultList.add(new TestResult(!o.hit(new Position('A',10)), "4c: o.hit(new Position('A',10))", Boolean.toString(o.hit(new Position('A',10))), "false"));
		resultList.add(new TestResult(!o.hit(new Position('J',1)), "4c: o.hit(new Position('J',1))", Boolean.toString(o.hit(new Position('J',1))), "false"));
		resultList.add(new TestResult(!o.hit(new Position('J',10)), "4c: o.hit(new Position('J',10))", Boolean.toString(o.hit(new Position('J',10))), "false"));
		
		resultList.add(new TestResult(!o.hit(new Position('B',1)), "4d: o.hit(new Position('B',1))", Boolean.toString(o.hit(new Position('B',1))), "false"));
		resultList.add(new TestResult(!o.hit(new Position('B',7)), "4d: o.hit(new Position('B',7))", Boolean.toString(o.hit(new Position('B',7))), "false"));
		resultList.add(new TestResult(!o.hit(new Position('A',2)), "4d: o.hit(new Position('A',2))", Boolean.toString(o.hit(new Position('A',2))), "false"));
		resultList.add(new TestResult(!o.hit(new Position('C',2)), "4d: o.hit(new Position('C',2))", Boolean.toString(o.hit(new Position('C',2))), "false"));
		
		resultList.add(new TestResult(!o.hit(new Position('B',2)), "4e: o.hit(new Position('B',2))", Boolean.toString(o.hit(new Position('B',2))), "false"));
		resultList.add(new TestResult(!o.hit(new Position('B',3)), "4e: o.hit(new Position('B',3))", Boolean.toString(o.hit(new Position('B',3))), "false"));
		resultList.add(new TestResult(!o.hit(new Position('B',4)), "4e: o.hit(new Position('B',4))", Boolean.toString(o.hit(new Position('B',4))), "false"));
		resultList.add(new TestResult(!o.hit(new Position('B',5)), "4e: o.hit(new Position('B',5))", Boolean.toString(o.hit(new Position('B',5))), "false"));
		resultList.add(new TestResult(!o.hit(new Position('B',6)), "4e: o.hit(new Position('B',6))", Boolean.toString(o.hit(new Position('B',6))), "false"));
		
		o.shootAt(new Position('B',2));
		o.shootAt(new Position('B',3));
		o.shootAt(new Position('B',4));
		o.shootAt(new Position('B',5));
		
		resultList.add(new TestResult(!o.hit(new Position('E',5)), "4a: o.hit(new Position('E',5))", Boolean.toString(o.hit(new Position('E',5))), "false"));
		
		resultList.add(new TestResult(!o.hit(new Position('A',5)), "4b: o.hit(new Position('A',5))", Boolean.toString(o.hit(new Position('A',5))), "false"));
		resultList.add(new TestResult(!o.hit(new Position('J',5)), "4b: o.hit(new Position('J',5))", Boolean.toString(o.hit(new Position('J',5))), "false"));
		resultList.add(new TestResult(!o.hit(new Position('E',1)), "4b: o.hit(new Position('E',1))", Boolean.toString(o.hit(new Position('E',1))), "false"));
		resultList.add(new TestResult(!o.hit(new Position('E',10)), "4b: o.hit(new Position('E',10))", Boolean.toString(o.hit(new Position('E',10))), "false"));
		
		resultList.add(new TestResult(!o.hit(new Position('A',1)), "4c: o.hit(new Position('A',1))", Boolean.toString(o.hit(new Position('A',1))), "false"));
		resultList.add(new TestResult(!o.hit(new Position('A',10)), "4c: o.hit(new Position('A',10))", Boolean.toString(o.hit(new Position('A',10))), "false"));
		resultList.add(new TestResult(!o.hit(new Position('J',1)), "4c: o.hit(new Position('J',1))", Boolean.toString(o.hit(new Position('J',1))), "false"));
		resultList.add(new TestResult(!o.hit(new Position('J',10)), "4c: o.hit(new Position('J',10))", Boolean.toString(o.hit(new Position('J',10))), "false"));
		
		resultList.add(new TestResult(!o.hit(new Position('B',1)), "4d: o.hit(new Position('B',1))", Boolean.toString(o.hit(new Position('B',1))), "false"));
		resultList.add(new TestResult(!o.hit(new Position('B',7)), "4d: o.hit(new Position('B',7))", Boolean.toString(o.hit(new Position('B',7))), "false"));
		resultList.add(new TestResult(!o.hit(new Position('A',2)), "4d: o.hit(new Position('A',2))", Boolean.toString(o.hit(new Position('A',2))), "false"));
		resultList.add(new TestResult(!o.hit(new Position('C',2)), "4d: o.hit(new Position('C',2))", Boolean.toString(o.hit(new Position('C',2))), "false"));
		
		resultList.add(new TestResult(o.hit(new Position('B',2)), "4f: o.hit(new Position('B',2))", Boolean.toString(o.hit(new Position('B',2))), "true"));
		resultList.add(new TestResult(o.hit(new Position('B',3)), "4f: o.hit(new Position('B',3))", Boolean.toString(o.hit(new Position('B',3))), "true"));
		resultList.add(new TestResult(o.hit(new Position('B',4)), "4f: o.hit(new Position('B',4))", Boolean.toString(o.hit(new Position('B',4))), "true"));
		resultList.add(new TestResult(o.hit(new Position('B',5)), "4f: o.hit(new Position('B',5))", Boolean.toString(o.hit(new Position('B',5))), "true"));
		
		resultList.add(new TestResult(!o.hit(new Position('B',6)), "4g: o.hit(new Position('B',6))", Boolean.toString(o.hit(new Position('B',6))), "false"));
		
		return resultList.toArray(new TestResult[0]);
	}
	
	public static TestResult[] testBoatInitial(Ocean o) throws Exception {
		TestResult[] results = new TestResult[6];
		try
		{
			o.placeBoat("Aircraft Carrier", "vertical", new Position(0, 0));
			o.placeBoat("Battleship", "vertical", new Position(0, 1));
			o.placeBoat("Submarine", "vertical", new Position(0, 2));
			o.placeBoat("Cruiser", "vertical", new Position(0, 3));
			o.placeBoat("Destroyer", "vertical", new Position(0, 4));
		}
		catch(Exception e)
		{
			System.out.println("failed to place boats");
			throw e;
		}
		
		char chRes = 0;
		
		try//1
		{
			results[0] = new TestResult(true, "5.a", "", "space");
			chRes = o.boatInitial(new Position(0, 6));
		}
		catch(Exception e)
		{
			results[0].success = false;
			results[0].output = "Exception thrown";
		}
		if(results[0].success)
		{
			if(chRes == ' ')
			{
				results[0].output = "space";
			}
			else
			{
				results[0].output += chRes;
				results[0].success = false;
			}
		}
		
		try//2
		{
			results[1] = new TestResult(true, "5.b", "", "A");
			chRes = o.boatInitial(new Position(0, 0));
		}
		catch(Exception e)
		{
			results[1].success = false;
			results[1].output = "Exception thrown";
		}
		if(results[1].success)
		{
			if(chRes == 'A')
			{
				results[1].output = "A";
			}
			else
			{
				results[1].output += chRes;
				results[1].success = false;
			}
		}
		
		try//3
		{
			results[2] = new TestResult(true, "5.b", "", "B");
			chRes = o.boatInitial(new Position(0, 1));
		}
		catch(Exception e)
		{
			results[2].success = false;
			results[2].output = "Exception thrown";
		}
		if(results[2].success)
		{
			if(chRes == 'B')
			{
				results[2].output = "B";
			}
			else
			{
				results[2].output += chRes;
				results[2].success = false;
			}
		}
		
		try//4
		{
			results[3] = new TestResult(true, "5.b", "", "S");
			chRes = o.boatInitial(new Position(0, 2));
		}
		catch(Exception e)
		{
			results[3].success = false;
			results[3].output = "Exception thrown";
		}
		if(results[3].success)
		{
			if(chRes == 'S')
			{
				results[3].output = "S";
			}
			else
			{
				results[3].output += chRes;
				results[3].success = false;
			}
		}
		
		try//5
		{
			results[4] = new TestResult(true, "5.b", "", "C");
			chRes = o.boatInitial(new Position(0, 3));
		}
		catch(Exception e)
		{
			results[4].success = false;
			results[4].output = "Exception thrown";
		}
		if(results[4].success)
		{
			if(chRes == 'C')
			{
				results[4].output = "C";
			}
			else
			{
				results[4].output += chRes;
				results[4].success = false;
			}
		}
		
		try//6
		{
			results[5] = new TestResult(true, "5.b", "", "D");
			chRes = o.boatInitial(new Position(0, 4));
		}
		catch(Exception e)
		{
			results[5].success = false;
			results[5].output = "Exception thrown";
		}
		if(results[5].success)
		{
			if(chRes == 'D')
			{
				results[5].output = "D";
			}
			else
			{
				results[5].output += chRes;
				results[5].success = false;
			}
		}
		
		return results;
	}
	
	public static TestResult[] testBoatName(Ocean o) throws Exception {
		TestResult[] results = new TestResult[6];
		try
		{
			o.placeBoat("Aircraft Carrier", "vertical", new Position(0, 0));
			o.placeBoat("Battleship", "vertical", new Position(0, 1));
			o.placeBoat("Submarine", "vertical", new Position(0, 2));
			o.placeBoat("Cruiser", "vertical", new Position(0, 3));
			o.placeBoat("Destroyer", "vertical", new Position(0, 4));
		}
		catch(Exception e)
		{
			System.out.println("failed to place boats");
			throw e;
		}
		
		String stRes = "";
		
		try//1
		{
			results[0] = new TestResult(true, "5.a", "", "empty string");
			stRes = o.boatName(new Position(0, 6));
		}
		catch(Exception e)
		{
			results[0].success = false;
			results[0].output = "Exception thrown";
		}
		if(results[0].success)
		{
			if(stRes.equals(""))
			{
				results[0].output = "empty string";
			}
			else
			{
				results[0].output = stRes;
				results[0].success = false;
			}
		}
		
		try//2
		{
			results[1] = new TestResult(true, "5.b", "", "Aircraft Carrier");
			stRes = o.boatName(new Position(0, 0));
		}
		catch(Exception e)
		{
			results[1].success = false;
			results[1].output = "Exception thrown";
		}
		if(results[1].success)
		{
			if(stRes.equals("Aircraft Carrier"))
			{
				results[1].output = stRes;
			}
			else
			{
				results[1].output = stRes;
				results[1].success = false;
			}
		}
		
		try//3
		{
			results[2] = new TestResult(true, "5.b", "", "Battleship");
			stRes = o.boatName(new Position(0, 1));
		}
		catch(Exception e)
		{
			results[2].success = false;
			results[2].output = "Exception thrown";
		}
		if(results[2].success)
		{
			if(stRes.equals("Battleship"))
			{
				results[2].output = stRes;
			}
			else
			{
				results[2].output = stRes;
				results[2].success = false;
			}
		}
		
		try//4
		{
			results[3] = new TestResult(true, "5.b", "", "Submarine");
			stRes = o.boatName(new Position(0, 2));
		}
		catch(Exception e)
		{
			results[3].success = false;
			results[3].output = "Exception thrown";
		}
		if(results[3].success)
		{
			if(stRes.equals("Submarine"))
			{
				results[3].output = stRes;
			}
			else
			{
				results[3].output = stRes;
				results[3].success = false;
			}
		}
		
		try//5
		{
			results[4] = new TestResult(true, "5.b", "", "Cruiser");
			stRes = o.boatName(new Position(0, 3));
		}
		catch(Exception e)
		{
			results[4].success = false;
			results[4].output = "Exception thrown";
		}
		if(results[4].success)
		{
			if(stRes.equals("Cruiser"))
			{
				results[4].output = stRes;
			}
			else
			{
				results[4].output = stRes;
				results[4].success = false;
			}
		}
		
		try//6
		{
			results[5] = new TestResult(true, "5.b", "", "Destroyer");
			stRes = o.boatName(new Position(0, 4));
		}
		catch(Exception e)
		{
			results[5].success = false;
			results[5].output = "Exception thrown";
		}
		if(results[5].success)
		{
			if(stRes.equals("Destroyer"))
			{
				results[5].output = stRes;
			}
			else
			{
				results[5].output = stRes;
				results[5].success = false;
			}
		}
		
		return results;
	}
	
	public static TestResult[] testSunk(Ocean o) throws Exception {
		ArrayList<TestResult> resultList = new ArrayList<TestResult>();
		
		o.placeBoat("Aircraft Carrier", "horizontal", new Position('B',2));
		o.placeBoat("Cruiser", "vertical", new Position('D',6));
		
		resultList.add(new TestResult(!o.sunk(new Position('B',1)), "8a: o.sunk('B',1)", Boolean.toString(o.sunk(new Position('B',1))), "false"));
		resultList.add(new TestResult(!o.sunk(new Position('B',7)), "8a: o.sunk('B',7)", Boolean.toString(o.sunk(new Position('B',7))), "false"));
		resultList.add(new TestResult(!o.sunk(new Position('A',1)), "8a: o.sunk('A',1)", Boolean.toString(o.sunk(new Position('A',1))), "false"));
		resultList.add(new TestResult(!o.sunk(new Position('A',2)), "8a: o.sunk('A',2)", Boolean.toString(o.sunk(new Position('A',2))), "false"));
		resultList.add(new TestResult(!o.sunk(new Position('A',3)), "8a: o.sunk('A',3)", Boolean.toString(o.sunk(new Position('A',3))), "false"));
		resultList.add(new TestResult(!o.sunk(new Position('A',4)), "8a: o.sunk('A',4)", Boolean.toString(o.sunk(new Position('A',4))), "false"));
		resultList.add(new TestResult(!o.sunk(new Position('A',5)), "8a: o.sunk('A',5)", Boolean.toString(o.sunk(new Position('A',5))), "false"));
		resultList.add(new TestResult(!o.sunk(new Position('A',6)), "8a: o.sunk('A',6)", Boolean.toString(o.sunk(new Position('A',6))), "false"));
		resultList.add(new TestResult(!o.sunk(new Position('A',7)), "8a: o.sunk('A',7)", Boolean.toString(o.sunk(new Position('A',7))), "false"));
		resultList.add(new TestResult(!o.sunk(new Position('C',1)), "8a: o.sunk('C',1)", Boolean.toString(o.sunk(new Position('C',1))), "false"));
		resultList.add(new TestResult(!o.sunk(new Position('C',2)), "8a: o.sunk('C',2)", Boolean.toString(o.sunk(new Position('C',2))), "false"));
		resultList.add(new TestResult(!o.sunk(new Position('C',3)), "8a: o.sunk('C',3)", Boolean.toString(o.sunk(new Position('C',3))), "false"));
		resultList.add(new TestResult(!o.sunk(new Position('C',4)), "8a: o.sunk('C',4)", Boolean.toString(o.sunk(new Position('C',4))), "false"));
		resultList.add(new TestResult(!o.sunk(new Position('C',5)), "8a: o.sunk('C',5)", Boolean.toString(o.sunk(new Position('C',5))), "false"));
		resultList.add(new TestResult(!o.sunk(new Position('C',6)), "8a: o.sunk('C',6)", Boolean.toString(o.sunk(new Position('C',6))), "false"));
		resultList.add(new TestResult(!o.sunk(new Position('C',7)), "8a: o.sunk('C',7)", Boolean.toString(o.sunk(new Position('C',7))), "false"));
		
		resultList.add(new TestResult(!o.sunk(new Position('E',10)), "8b: o.sunk('E',10)", Boolean.toString(o.sunk(new Position('E',10))), "false"));
		resultList.add(new TestResult(!o.sunk(new Position('A',1)), "8b: o.sunk('A',1)", Boolean.toString(o.sunk(new Position('A',1))), "false"));

		o.placeBoat("Destroyer", "horizontal", new Position('E',9));
		o.placeBoat("Battleship", "vertical", new Position('A',8));
		o.placeBoat("Submarine", "horizontal", new Position('J',2));
		
		resultList.add(new TestResult(!o.sunk(new Position('B',2)), "8c: o.sunk('B',2)", Boolean.toString(o.sunk(new Position('B',2))), "false"));
		resultList.add(new TestResult(!o.sunk(new Position('B',3)), "8c: o.sunk('B',3)", Boolean.toString(o.sunk(new Position('B',3))), "false"));
		resultList.add(new TestResult(!o.sunk(new Position('B',4)), "8c: o.sunk('B',4)", Boolean.toString(o.sunk(new Position('B',4))), "false"));
		resultList.add(new TestResult(!o.sunk(new Position('B',5)), "8c: o.sunk('B',5)", Boolean.toString(o.sunk(new Position('B',5))), "false"));
		resultList.add(new TestResult(!o.sunk(new Position('B',6)), "8c: o.sunk('B',6)", Boolean.toString(o.sunk(new Position('B',6))), "false"));
		
		resultList.add(new TestResult(!o.sunk(new Position('D',6)), "8c: o.sunk('D',6)", Boolean.toString(o.sunk(new Position('D',6))), "false"));
		resultList.add(new TestResult(!o.sunk(new Position('E',6)), "8c: o.sunk('E',6)", Boolean.toString(o.sunk(new Position('E',6))), "false"));
		resultList.add(new TestResult(!o.sunk(new Position('F',6)), "8c: o.sunk('F',6)", Boolean.toString(o.sunk(new Position('F',6))), "false"));
		
		resultList.add(new TestResult(!o.sunk(new Position('E',9)), "8c: o.sunk('E',9)", Boolean.toString(o.sunk(new Position('E',9))), "false"));
		resultList.add(new TestResult(!o.sunk(new Position('E',10)), "8c: o.sunk('E',10)", Boolean.toString(o.sunk(new Position('E',10))), "false"));
		
		resultList.add(new TestResult(!o.sunk(new Position('A',8)), "8c: o.sunk('A',8)", Boolean.toString(o.sunk(new Position('A',8))), "false"));
		resultList.add(new TestResult(!o.sunk(new Position('B',8)), "8c: o.sunk('B',8)", Boolean.toString(o.sunk(new Position('B',8))), "false"));
		resultList.add(new TestResult(!o.sunk(new Position('C',8)), "8c: o.sunk('C',8)", Boolean.toString(o.sunk(new Position('C',8))), "false"));
		resultList.add(new TestResult(!o.sunk(new Position('D',8)), "8c: o.sunk('D',8)", Boolean.toString(o.sunk(new Position('D',8))), "false"));
		
		resultList.add(new TestResult(!o.sunk(new Position('J',2)), "8c: o.sunk('J',2)", Boolean.toString(o.sunk(new Position('J',2))), "false"));
		resultList.add(new TestResult(!o.sunk(new Position('J',3)), "8c: o.sunk('J',3)", Boolean.toString(o.sunk(new Position('J',3))), "false"));
		resultList.add(new TestResult(!o.sunk(new Position('J',4)), "8c: o.sunk('J',4)", Boolean.toString(o.sunk(new Position('J',4))), "false"));
		
		o.shootAt(new Position('D',6));  //sink cruiser
		o.shootAt(new Position('E',6));
		o.shootAt(new Position('F',6));
		
		o.shootAt(new Position('B',2));
		o.shootAt(new Position('B',3));
		o.shootAt(new Position('B',4));
		o.shootAt(new Position('B',5));
		o.shootAt(new Position('B',6));
		
		o.shootAt(new Position('E',9)); //sink destroyer
		o.shootAt(new Position('E',10));
		o.shootAt(new Position('A',8)); //sink battleship
		o.shootAt(new Position('B',8));
		o.shootAt(new Position('C',8));
		o.shootAt(new Position('D',8));
		o.shootAt(new Position('J',2)); //sink submarine
		o.shootAt(new Position('J',3));
		o.shootAt(new Position('J',4));
		
		resultList.add(new TestResult(o.sunk(new Position('B',2)), "8c: o.sunk('B',2)", Boolean.toString(o.sunk(new Position('B',2))), "true"));
		resultList.add(new TestResult(o.sunk(new Position('B',3)), "8c: o.sunk('B',3)", Boolean.toString(o.sunk(new Position('B',3))), "true"));
		resultList.add(new TestResult(o.sunk(new Position('B',4)), "8c: o.sunk('B',4)", Boolean.toString(o.sunk(new Position('B',4))), "true"));
		resultList.add(new TestResult(o.sunk(new Position('B',5)), "8c: o.sunk('B',5)", Boolean.toString(o.sunk(new Position('B',5))), "true"));
		resultList.add(new TestResult(o.sunk(new Position('B',6)), "8c: o.sunk('B',6)", Boolean.toString(o.sunk(new Position('B',6))), "true"));
		
		resultList.add(new TestResult(o.sunk(new Position('D',6)), "8c: o.sunk('D',6)", Boolean.toString(o.sunk(new Position('D',6))), "true"));
		resultList.add(new TestResult(o.sunk(new Position('E',6)), "8c: o.sunk('E',6)", Boolean.toString(o.sunk(new Position('E',6))), "true"));
		resultList.add(new TestResult(o.sunk(new Position('F',6)), "8c: o.sunk('F',6)", Boolean.toString(o.sunk(new Position('F',6))), "true"));
		
		resultList.add(new TestResult(o.sunk(new Position('E',9)), "8c: o.sunk('E',9)", Boolean.toString(o.sunk(new Position('E',9))), "true"));
		resultList.add(new TestResult(o.sunk(new Position('E',10)), "8c: o.sunk('E',10)", Boolean.toString(o.sunk(new Position('E',10))), "true"));
		
		resultList.add(new TestResult(o.sunk(new Position('A',8)), "8c: o.sunk('A',8)", Boolean.toString(o.sunk(new Position('A',8))), "true"));
		resultList.add(new TestResult(o.sunk(new Position('B',8)), "8c: o.sunk('B',8)", Boolean.toString(o.sunk(new Position('B',8))), "true"));
		resultList.add(new TestResult(o.sunk(new Position('C',8)), "8c: o.sunk('C',8)", Boolean.toString(o.sunk(new Position('C',8))), "true"));
		resultList.add(new TestResult(o.sunk(new Position('D',8)), "8c: o.sunk('D',8)", Boolean.toString(o.sunk(new Position('D',8))), "true"));
		
		resultList.add(new TestResult(o.sunk(new Position('J',2)), "8c: o.sunk('J',2)", Boolean.toString(o.sunk(new Position('J',2))), "true"));
		resultList.add(new TestResult(o.sunk(new Position('J',3)), "8c: o.sunk('J',3)", Boolean.toString(o.sunk(new Position('J',3))), "true"));
		resultList.add(new TestResult(o.sunk(new Position('J',4)), "8c: o.sunk('J',4)", Boolean.toString(o.sunk(new Position('J',4))), "true"));
		
		return resultList.toArray(new TestResult[0]);
	}
	
	public static TestResult[] testAllSunk(Ocean o) throws Exception {
		ArrayList<TestResult> resultList = new ArrayList<TestResult>();
		
		o.placeBoat("Aircraft Carrier", "horizontal", new Position('B',2));
		o.placeBoat("Cruiser", "vertical", new Position('D',6));
		
		resultList.add(new TestResult(!o.allSunk(), "8a: o.allSunk()", Boolean.toString(o.allSunk()), "false"));
		
		o.shootAt(new Position('D',6));
		o.shootAt(new Position('E',6));
		o.shootAt(new Position('F',6));
		o.shootAt(new Position('G',6));
		
		resultList.add(new TestResult(!o.allSunk(), "8b: o.allSunk()", Boolean.toString(o.allSunk()), "false"));
		
		o.shootAt(new Position('B',2));
		o.shootAt(new Position('B',3));
		o.shootAt(new Position('B',4));
		o.shootAt(new Position('B',5));
		o.shootAt(new Position('B',6));
		
		o.placeBoat("Destroyer", "horizontal", new Position('E',9));
		o.placeBoat("Battleship", "vertical", new Position('A',8));
		o.placeBoat("Submarine", "horizontal", new Position('J',2));
		
		o.shootAt(new Position('E',9)); //sink destroyer
		o.shootAt(new Position('E',10));
		o.shootAt(new Position('A',8)); //sink battleship
		o.shootAt(new Position('B',8));
		o.shootAt(new Position('C',8));
		o.shootAt(new Position('D',8));
		o.shootAt(new Position('J',2)); //sink submarine
		o.shootAt(new Position('J',3));
		o.shootAt(new Position('J',4));
		
		resultList.add(new TestResult(o.allSunk(), "8c: o.allSunk()", Boolean.toString(o.allSunk()), "true"));
		
		return resultList.toArray(new TestResult[0]);
	}
}

/*
abstract class Ocean {
	abstract public void placeBoat(String boatName, String direction, Position pos) throws Exception;
	abstract public void shootAt(Position pos);
	abstract public boolean hit(Position pos);
	abstract public char boatInitial(Position pos);
	abstract public String boatName(Position pos);
	abstract public boolean sunk(Position pos);
	abstract public boolean allSunk();
}
*/

class OceanForwarderToOcean extends Ocean {
	private Ocean1 o;
	OceanForwarderToOcean() {
		o = new Ocean1();
	}
	
	@Override
	public void placeBoat(String name, String dir, Position pos) throws Exception { o.placeBoat(name, dir, pos); }
	@Override
	public void shootAt(Position pos) { o.shootAt(pos); }
	@Override
	public boolean hit(Position pos) { return o.hit(pos); }
	@Override
	public char boatInitial(Position pos) { return o.boatInitial(pos); }
	@Override
	public String boatName(Position pos) { return o.boatName(pos); }
	@Override
	public boolean sunk(Position pos) { return o.sunk(pos); }
	@Override
	public boolean allSunk() { return o.allSunk(); }
}

class TestResult {
	TestResult(boolean newSuccess, String newInput, String newOutput, String newExpected) {
		success = newSuccess; input = newInput; output = newOutput; expected = newExpected;
	}
	
	public TestResult(String input, String expected) {
	   	 this.input = input;
	   	 this.expected = expected;
	   	 this.success = false;
	}
	
	public TestResult(TestResult res) {
	   	 this.success = res.success;
	   	 this.input = res.input;
	   	 this.output = res.output;
	   	 this.expected = res.expected;
	 }
	
	public boolean success;
	public String input;
	public String output;
	public String expected;
	
	public String toString() {
		return (success?"Success":"Failure") + "\t\tInput: " + input + "\t\tOutput: " + output + "\t\tExpected: " + expected;
	}
}