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

    Block create(String commandName) throws ClassCastException, ReflectiveOperationException {
        if(!properties.containsKey(commandName)){
            throw new ClassNotFoundException("Class for command \""+ commandName+ "\" not found");
        }
        return (Block) Class
                .forName(properties.getProperty(commandName))
                .getDeclaredConstructor()
                .newInstance();
    }
}
