package blocks;

import exception.WorkflowException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class BlockGrep implements Block {

    private static final Logger log = LogManager.getLogger();

    @Override
    public List<String> execute(List<String> text, String[] args) throws WorkflowException {
        if(args.length != 1){
            throw new WorkflowException("Wrong number of arguments" + this.getClass());
        }
        if(text == null){
            throw new WorkflowException("Text is not uploaded");
        }
        log.info("BlockGep is normally working");

        return text.stream().filter(o -> o.contains(args[0])).collect(Collectors.toList());
    }
}
