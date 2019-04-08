package exception;

public class FactoryException extends WorkflowException {

    public FactoryException(String s) {
        super(s);
    }

    public FactoryException(Throwable t) {
        super(t);
    }
}
