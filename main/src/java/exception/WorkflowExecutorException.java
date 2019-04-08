package exception;

public class WorkflowExecutorException extends Exception{

    public WorkflowExecutorException(String string) {
        super(string);
    }

    public WorkflowExecutorException(Throwable t) {
        super(t);
    }

}
