package blocks;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class BlockReadFile
    implements Block {

    @Override
    public List<String> execute(List<String> text, String[] args) throws WorkflowException {

        if(args.length != 1){
            throw new WorkflowException("Invalid number of arguments" + this.getClass());
        }
        try( BufferedReader reader = new BufferedReader(new FileReader(args[0])) ){
            return reader.lines().collect(Collectors.toList());
        }
        catch (IOException exc){
            throw new WorkflowException(exc.getMessage());
        }
    }
}