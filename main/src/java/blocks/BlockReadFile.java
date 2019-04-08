package blocks;

import exception.WorkflowException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class BlockReadFile
    implements Block {

    private static final Logger log = LogManager.getLogger();

    @Override
    public List<String> execute(List<String> text, String[] args) throws WorkflowException {

        if(args.length != 1){
            throw new WorkflowException("Invalid number of arguments" + this.getClass());
        }
        List<String> newText;
        try( BufferedReader reader = new BufferedReader(new FileReader(args[0])) ){
            newText = reader.lines().collect(Collectors.toList());
        }
        catch (IOException exc){
            log.error("Something goes wrong inside the BlockReadFile");
            throw new WorkflowException(exc.getMessage());
        }
        log.info("BlockReadFile is normally working");
        return newText;
    }
}