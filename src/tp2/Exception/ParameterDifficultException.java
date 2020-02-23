package tp2.Exception;

public class ParameterDifficultException extends Exception{
	public ParameterDifficultException() {super();}
	public ParameterDifficultException(String message) {super(message);}
	public ParameterDifficultException(String message, Throwable cause) {super(message, cause);}
	public ParameterDifficultException(Throwable cause) {super(cause);}
	public ParameterDifficultException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
