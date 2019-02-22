import javax.swing.text.html.HTMLDocument;
import java.io.Reader;
import java.util.Iterator;
import java.util.Scanner;

public class DescriptionParcer extends Iterator {

    private Reader reader;
    private Scanner scanner;
    private String curLine;

    DescriptionParcer(Reader reader){
        scanner = new Scanner(reader);
    }

    @Override
    public boolean hasNext() {
        if(!scanner.hasNext()){
            return false;
        }
        curLine = scanner.nextLine();
        if("sced".equals(curLine)){
            return false;
        }
        if(curLine.matches("[0-9]+ = [a-zA-Z0-9]+")){
            throw new WrongSintaxisException();
        }
        return true;
    }

    @Override
    public Object next() {
        return null;
    }
}
