import java.io.BufferedReader;
import java.io.IOException;

public class WorkflowExecutor{

    private BlockFactory blockFactory;

    WorkflowExecutor() throws IOException{
        blockFactory = new BlockFactory("/home/paulpaulych/IdeaProjects/WorkflowExecutor/src/config.properties");
    }

    public void run(BufferedReader reader) throws IOException, ClassNotFoundException {
        String command = reader.readLine();
        while("".equals(command)) {
            command = reader.readLine();
        }
        Block curBlock = blockFactory.create(command);
    }
}
