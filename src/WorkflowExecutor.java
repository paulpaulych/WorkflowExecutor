import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class WorkflowExecutor{
    private Map<Integer, String> blockNames;
    private BlockFactory blockFactory;

    WorkflowExecutor() throws IOException{
        blockFactory = new BlockFactory("/home/paulpaulych/IdeaProjects/WorkflowExecutor/src/config.properties");
        blockNames = new TreeMap<>();
    }

    void readBlocksDesc(BufferedReader reader) throws IOException{
        Scanner streamScanner = new Scanner(reader);
        while(streamScanner.hasNextLine() && !streamScanner.nextLine().equals("csed")){
            String curLine = streamScanner.nextLine();
            if(curLine.matches("[0-9]+ = [a-zA-Z0-9= ]+")){
                throw new IOException("Wrong input format");
            }
            Scanner lineScanner = new Scanner(curLine);
            blockNames.put(new Integer(lineScanner.next()),
                    curLine.substring(curLine.indexOf("[a-zA-Z0-9]+")));
        }

    }

    public void run(BufferedReader reader) throws IOException {

        while(streamScanner.hasNextLine()) {
            String curLine = streamScanner.nextLine();
            if("desc".equals(curLine)){
                readBlocksDesc(reader);
            }

            while(commandProvider.hasNext()){

            }
            Pattern pattern = Pattern.compile("[^а-яА-Яa-zA-Z0-9]+");
            Scanner lineScanner = new Scanner(curLine).useDelimiter(pattern);

            String commandName;
            if (!lineScanner.hasNext()) {
                continue;
            }
            commandName = lineScanner.next();

            List<String> argsList = new LinkedList<>();
            while (lineScanner.hasNext()){
                argsList.add(lineScanner.next());
            }
            try {
                Block curBlock = blockFactory.create(commandName);
                curBlock.execute(argsList.stream().toArray(String[]::new));
            } catch (ReflectiveOperationException exc) {
                System.err.println("wrong command \"" + commandName + "\"");
            }
        }
    }
}
