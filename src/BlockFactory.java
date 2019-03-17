import blocks.Block;

import java.io.IOException;
import java.util.Properties;

public class BlockFactory {

    private volatile static BlockFactory instance;

    private Properties properties;

    private BlockFactory() throws IOException {
        properties = new Properties();
        properties.load(BlockFactory.class.getResourceAsStream("block.config"));
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
            throw new NoSuchBlockException("Class for command \""+ commandName+ "\" not found");
        }
        Block block;
        try{
            block = (Block) Class
                    .forName(properties.getProperty(commandName))
                    .getDeclaredConstructor()
                    .newInstance();
        }catch (ClassCastException | ReflectiveOperationException exc){
            throw new NoSuchBlockException("Wrong class specified in config file");
        }
        return block;
    }
}
