import blocks.Block;
import exception.ParcingException;
import exception.WorkflowException;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class WorkflowExecutor{

    private static final Logger log = LogManager.getLogger();

    private Map<Integer, String> blockDescription;

    private List<String> text;

    public WorkflowExecutor() {
        blockDescription = new TreeMap<>();
    }

    public void run(BufferedReader reader)
            throws ParcingException, WorkflowException, IOException {

        Scanner scanner = new Scanner(reader);
        DescriptionParcer descriptionParcer = new DescriptionParcer(scanner);
        while (descriptionParcer.hasNext()){
            blockDescription.put(descriptionParcer.getID(), descriptionParcer.getCommand());
        }
        log.debug("Blocks' description read successfully");

        log.debug("Parcing execution list...");
        ExecutionListIterator execListIterator = new ExecutionListIterator(scanner);
        Integer commandId = execListIterator.next();
        while (null != commandId){
            String[] curCommand = blockDescription.get(commandId).split(" ");
            String commandName = curCommand[0];
            log.debug("Command" + commandName + "got");
            String[] args = Arrays.copyOfRange(curCommand, 1, curCommand.length);
            Block curBlock = BlockFactory.getInstance().create(commandName);
            log.debug("Class for block found");
            text = curBlock.execute(text, args);
            commandId = execListIterator.next();
        }

    }
}
