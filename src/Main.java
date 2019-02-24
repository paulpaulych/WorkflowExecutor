import java.io.BufferedReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        ArgResolver argResolver = new ArgResolver(args);

        try(BufferedReader reader = argResolver.getReader()){
            WorkflowExecutor executor = new WorkflowExecutor();
            executor.run(reader);
        }
        catch (ParcingException | WorkflowException | IOException | ReflectiveOperationException exc){
            System.out.println(exc.getMessage());
        }
    }
}
