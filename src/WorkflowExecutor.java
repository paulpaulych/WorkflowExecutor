import blocks.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class WorkflowExecutor{

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

        ExecutionListIterator execListIterator = new ExecutionListIterator(scanner);
        Integer commandId = execListIterator.next();
        while (null != commandId){
            String[] curCommand = blockDescription.get(commandId).split(" ");
            Block curBlock = BlockFactory.getInstance().create(curCommand[0]);
            text = curBlock.execute(text, Arrays.copyOfRange(curCommand, 1, curCommand.length));
            commandId = execListIterator.next();
        }

    }
}
