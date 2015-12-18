
public class RunXYTester {
	public static void alivenessTest(){
		class myGrapher extends XYGrapher{
			public double xRange(){return 500;}
			public double yRange(){return 500;}
			public Coordinate xyStart()
			{return new Coordinate(0,0);}
			public Coordinate getPoint(int n)
			{return new Coordinate(n,n);} 
		}
		new myGrapher().drawGraph(0,0,500,500);
	}
	public static void main(String[] args){
		(new XYTester()).drawGraph(0,0,500,500);
	}
}
