import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class WorkflowExecutor{

    private Map<Integer, String> blockDescription;
    private BlockFactory blockFactory;
    private TextHolder textHolder;

    WorkflowExecutor() throws IOException{
        blockFactory = new BlockFactory("/home/paulpaulych/IdeaProjects/WorkflowExecutor/src/config.properties");
        blockDescription = new TreeMap<>();
        textHolder = new TextHolder();
    }

    public void run(BufferedReader reader)
            throws ParcingException, WorkflowException, ReflectiveOperationException {
        Scanner scanner = new Scanner(reader);
        DescriptionParcer descriptionParcer = new DescriptionParcer(scanner);
        while (descriptionParcer.hasNext()){
            blockDescription.put(descriptionParcer.getID(), descriptionParcer.getCommand());
        }

        for(Map.Entry<Integer, String> me : blockDescription.entrySet()){
            System.out.println(me.getKey() + " == " + me.getValue());
        }

        IdParcer idParcer = new IdParcer(scanner);
        LinkedList<Integer> executionList = new LinkedList<>();
        while (idParcer.hasNext()){
            executionList.addLast(idParcer.next());
        }

        for(Integer commandId: executionList){
            String[] cur = blockDescription.get(commandId).split(" ");
            Block curBlock = blockFactory.create(cur[0]);
            curBlock.execute(textHolder, Arrays.copyOfRange(cur, 1, cur.length));
        }
    }
}
