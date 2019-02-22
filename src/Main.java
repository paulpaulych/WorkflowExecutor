import java.io.BufferedReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        BlockReadFile blockReadFile = new BlockReadFile();
        System.out.println(blockReadFile.getClass());
        ArgResolver argResolver = new ArgResolver(args);

        try(BufferedReader reader = argResolver.getReader()){
            WorkflowExecutor executor = new WorkflowExecutor();
            executor.run(reader);
        }
        catch (IOException exc){
            System.out.println(exc.getMessage());
        }
    }
}
