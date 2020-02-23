package tp2.Exception;

public class ParameterNumberException extends Exception{
	public ParameterNumberException() {super();}
	public ParameterNumberException(String message) {super(message);}
	public ParameterNumberException(String message, Throwable cause) {super(message, cause);}
	public ParameterNumberException(Throwable cause) {super(cause);}
	public ParameterNumberException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
