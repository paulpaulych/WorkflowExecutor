import exception.ParcingException;
import exception.WorkflowException;

import java.io.BufferedReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger log = LogManager.getLogger();

    public static void main(String[] args) {
        log.debug("Main.main() called");
        ArgumentResolver argumentResolver = new ArgumentResolver(args);

        try(BufferedReader reader = argumentResolver.getReader()){
            WorkflowExecutor executor = new WorkflowExecutor();
            executor.run(reader);
        }
        catch (ParcingException | WorkflowException | IOException exc){
            log.error("Exception caught: ", exc);
            System.err.println(exc.getMessage());
        }
        log.debug("Exit from Main.main()");
    }
}
