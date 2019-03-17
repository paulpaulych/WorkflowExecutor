import blocks.WorkflowException;

import java.util.Scanner;

class ExecutionListIterator {

    private Scanner lineScanner;

    ExecutionListIterator(Scanner scanner) throws ParcingException {
        if(!scanner.hasNextLine()){
            throw new ParcingException("No execution list");
        }
        String line = scanner.nextLine();

        lineScanner = new Scanner(line).useDelimiter("[ ]*->[ ]*");
    }

    Integer next() throws WorkflowException {
        if(!lineScanner.hasNext()){
            return null;
        }
        try{
            return new Integer(lineScanner.next());
        }catch(NumberFormatException exc){
            throw new WorkflowException("Wrong format of execution list");
        }
    }
}