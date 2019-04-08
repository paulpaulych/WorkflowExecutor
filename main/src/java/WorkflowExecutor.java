import blocks.Block;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

import exception.WorkflowExecutorException;
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
            throws WorkflowExecutorException, IOException {

        Scanner scanner = new Scanner(reader);

        DescriptionParcer descriptionParcer = new DescriptionParcer(scanner);
        while (descriptionParcer.hasNext()) {
            blockDescription.put(descriptionParcer.getID(), descriptionParcer.getCommand());
        }
        log.debug("Blocks' description read successfully");

        log.debug("Parcing execution list...");
        ExecutionListIterator execListIterator = new ExecutionListIterator(scanner);
        Integer commandId = execListIterator.next();
        while (null != commandId) {
            String[] curCommand = blockDescription.get(commandId).split(" ");
            String commandName = curCommand[0];
            log.debug("Command \"{0}\" got", commandName);
            String[] args = Arrays.copyOfRange(curCommand, 1, curCommand.length);
            Block curBlock = BlockFactory.getInstance().create(commandName);
            log.debug("Class for block found");
            text = curBlock.execute(text, args);
            commandId = execListIterator.next();
        }
    }
}
