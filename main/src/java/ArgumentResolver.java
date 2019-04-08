import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class ArgumentResolver {

    private String[] args;

    private static final Logger log = LogManager.getLogger();

    ArgumentResolver(String[] args){
        this.args = args;
    }

    BufferedReader getReader() throws IOException {
        BufferedReader reader;
        if(args.length > 0){
            reader = new BufferedReader(new FileReader(args[0]));
            log.debug(args[0] + "was opened successfully");
        }else{
            reader = new BufferedReader(new InputStreamReader(System.in));
            log.debug("input stream was opened successfully");
        }
        return reader;
    }
}
