import exception.ParcingException;
import exception.WorkflowException;

import java.util.Scanner;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

class ExecutionListIterator {

    private static final Logger log = LogManager.getLogger();

    private Scanner lineScanner;

    ExecutionListIterator(Scanner scanner) throws ParcingException {
        if (!scanner.hasNextLine()) {
            throw new ParcingException("No execution list");
        }
        String line = scanner.nextLine();

        lineScanner = new Scanner(line).useDelimiter("[ ]*->[ ]*");
        log.debug("ExecutionListIterator created");
    }

    Integer next() throws WorkflowException {
        if(!lineScanner.hasNext()){
            log.debug("ExecutionListIterator created");
            return null;
        }
        try{
            return new Integer(lineScanner.next());
        }catch(NumberFormatException exc){
            throw new WorkflowException("Wrong format of execution list");
        }
    }
}