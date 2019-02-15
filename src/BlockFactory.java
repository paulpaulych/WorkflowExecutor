import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BlockFactory {
    private Properties properties;

    BlockFactory(String confFileName) throws IOException {
        properties = new Properties();
        FileInputStream fis = new FileInputStream(confFileName);
        properties.load(fis);
    }

    Block create(String commandName) throws ClassNotFoundException {
        if(properties.containsKey(commandName)){
            return Class.forName(properties.getProperty(commandName)).getDeclaringClass().asSubclass();
        }
        else{
            throw new ClassNotFoundException("Class for command \""+ commandName+ "\" not found");
        }
    }
}
