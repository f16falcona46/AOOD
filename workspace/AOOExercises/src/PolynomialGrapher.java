
public abstract class PolynomialGrapher extends FunctionGrapher {
	abstract public double[] coefficients();

	@Override
	public double yValue(double xValue) {
		double accum = 0;
		for (int i = 0; i < this.coefficients().length; ++i) {
			accum += this.coefficients()[i]*Math.pow(xValue, i);
		}
		return accum;
	}
}
