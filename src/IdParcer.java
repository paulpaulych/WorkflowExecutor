import java.util.Iterator;
import java.util.Scanner;

public class IdParcer implements Iterator {

    private Scanner lineScanner;

    public IdParcer(Scanner scanner) throws ParcingException {
        if(!scanner.hasNextLine()){
            throw new ParcingException("No execution string");
        }
        String line = scanner.nextLine();
        if(!line.matches("[0-9]+(->[0-9]+)*")){
            throw new ParcingException("Wrong execution string");
        }
        lineScanner = new Scanner(line).useDelimiter("->");
    }

    @Override
    public boolean hasNext() {
        return lineScanner.hasNext();
    }

    @Override
    public Integer next() {
        return new Integer(lineScanner.next());
    }
}
