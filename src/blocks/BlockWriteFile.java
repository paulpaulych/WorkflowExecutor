package blocks;

import exception.WorkflowException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class BlockWriteFile implements Block {

    private static final Logger log = LogManager.getLogger();

    @Override
    public List<String> execute(List<String> text, String[] args) throws WorkflowException {
        if(args.length < 1){
            throw new WorkflowException("Invalid number of arguments for " + this.getClass());
        }
        if(text == null){
            throw new WorkflowException("Text is not uploaded");
        }
        for(String fname : args){
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(fname))){
                for (String s: text) {
                    writer.write(s);
                    writer.newLine();
                }
                writer.flush();
            }catch (IOException exc){
                throw new WorkflowException(exc.getMessage());
            }
        }
        log.info("BlockWriteFile is normally working");
        return text;
    }

}
