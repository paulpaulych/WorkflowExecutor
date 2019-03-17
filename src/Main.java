import blocks.WorkflowException;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        ArgumentResolver argumentResolver = new ArgumentResolver(args);

        try(BufferedReader reader = argumentResolver.getReader()){
            WorkflowExecutor executor = new WorkflowExecutor();
            executor.run(reader);
        }
        catch (ParcingException | WorkflowException | IOException exc){
            System.err.println(exc.getMessage());
        }
    }
}
