public interface Block {

    void execute(TextHolder textHolder, String[] args) throws WorkflowException;

}
