import java.io.BufferedReader;
import java.io.IOException;

public class WorkflowExecutor{
    BlockFactory blockFactory;

    WorkflowExecutor() throws IOException{
        blockFactory = new BlockFactory("/home/paulpaulych/IdeaProjects/WorkflowExecutor/src/config.properties");
        blockFactory.write();
    }

    public void run(BufferedReader reader) throws IOException {
        String command = reader.readLine();
        while("".equals(command)){
            command = reader.readLine();
        }
    }
}
