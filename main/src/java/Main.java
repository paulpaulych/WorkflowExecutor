import java.io.BufferedReader;
import java.io.IOException;

import exception.WorkflowExecutorException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger log = LogManager.getLogger();

    public static void main(String[] args) {
        log.debug("java.Main.main() called");
        ArgumentResolver argumentResolver = new ArgumentResolver(args);

        try(BufferedReader reader = argumentResolver.getReader()){
            WorkflowExecutor executor = new WorkflowExecutor();
            executor.run(reader);
        }
        catch (WorkflowExecutorException | IOException exc){
            log.error("Exception caught: ", exc);
            System.err.println(exc.getMessage());
        }
        log.debug("Exit from java.Main.main()");
    }
}
