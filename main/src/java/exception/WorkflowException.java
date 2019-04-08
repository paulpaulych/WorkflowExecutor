package exception;

public class WorkflowException extends WorkflowExecutorException{

    public WorkflowException(String message){
        super(message);
    }

    public WorkflowException(Throwable t) {
        super(t);
    }

}
