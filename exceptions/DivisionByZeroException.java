
public class DivisionByZeroException extends Exception
{
    /**
     *
     */
    //private static final long serialVersionUID = 1L;

    public DivisionByZeroException()
    {
        super("Division by Zero!");
    }

    public DivisionByZeroException(String message)
    {
        super(message);
    }
}
