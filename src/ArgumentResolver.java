import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

class ArgumentResolver {
    private String[] args;


    private static final Logger log = LogManager.getLogger();

    ArgumentResolver(String[] args){
        this.args = args;
    }

    BufferedReader getReader() throws IOException {
        BufferedReader reader;
        if(args.length > 0){
            reader = new BufferedReader(new FileReader(args[0]));
            log.info(args[0] + "was opened successfully");
        }else{
            reader = new BufferedReader(new InputStreamReader(System.in));
            log.info("input stream was opened successfully");
        }
        return reader;
    }

    BufferedWriter getWriter() throws IOException {
        BufferedWriter writer;
        if(args.length > 1){
            writer = new BufferedWriter(new FileWriter(args[1]));
            log.info(args[1] + "was opened successfully");
        }else{
            writer = new BufferedWriter(new OutputStreamWriter(System.out));
            log.info("output stream was opened successfully");
        }
        return writer;
    }
}
