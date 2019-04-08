package exception;

public class ParcingException extends WorkflowExecutorException {

    public ParcingException(String string) {
        super(string);
    }

    public ParcingException(Throwable t) {
        super(t);
    }

}