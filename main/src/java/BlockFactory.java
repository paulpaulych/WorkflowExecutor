
import blocks.Block;
import exception.NoSuchBlockException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

public class BlockFactory {

    private static final Logger log = LogManager.getLogger();

    private volatile static BlockFactory instance;
    private Properties properties;

    private BlockFactory() throws IOException {
        properties = new Properties();
        String configFileName = "blockFactory.properties";
        properties.load(BlockFactory.class.getResourceAsStream(configFileName));
        log.info("java.BlockFactory created with " + configFileName + " as config file");
    }

    public static synchronized BlockFactory getInstance() throws IOException{
        if(instance == null){
            synchronized (BlockFactory.class){
                if(instance == null){
                    instance = new BlockFactory();
                }
            }
        }
        return instance;
    }

    Block create(String commandName) throws NoSuchBlockException {
        if(!properties.containsKey(commandName)){
            log.error("Class for command \"{}\" not found: ", commandName);
            throw new NoSuchBlockException("Class for command \""+ commandName+ "\" not found");
        }
        Block block;
        try{
            block = (Block) Class
                    .forName(properties.getProperty(commandName))
                    .getDeclaredConstructor()
                    .newInstance();
        }catch (ClassCastException | ReflectiveOperationException exc){
            log.error("Wrong class specified in config file for command\"{}\": ", commandName);
            throw new NoSuchBlockException("Wrong class specified in config file");
        }
        return block;
    }
}
