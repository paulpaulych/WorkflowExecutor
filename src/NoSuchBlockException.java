import blocks.WorkflowException;

public class NoSuchBlockException extends WorkflowException {
    NoSuchBlockException(String s){
        super(s);
    }
}
