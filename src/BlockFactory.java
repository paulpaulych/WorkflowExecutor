import org.omg.CORBA.portable.InputStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

public class BlockFactory {
    private Map<Integer, String> IBlockCreator;
    private Properties properties;

    BlockFactory(String confFileName) throws IOException {
        properties = new Properties();
        FileInputStream fis = new FileInputStream(confFileName);
        properties.load(fis);

    }

    Block create(String className) throws ClassNotFoundException {
        Class instance = new Class.forName();

        return new Class.forName(commandName);
    }
}
