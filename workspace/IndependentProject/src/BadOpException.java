public class BadOpException extends Throwable {
	private static final long serialVersionUID = -2571726566956061925L;

	@Override
	public void printStackTrace()
	{
		System.out.println("(BadOpException exception) Error! That operation is invalid.");
	}
}