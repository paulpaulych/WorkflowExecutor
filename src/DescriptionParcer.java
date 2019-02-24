import java.util.Scanner;

public class DescriptionParcer {

    private Scanner scanner;
    private String curLine;

    DescriptionParcer(Scanner scanner) throws ParcingException {
        this.scanner = scanner;
        while(scanner.hasNextLine()){
            curLine = scanner.nextLine();
            if("".equals(curLine)){
                continue;
            }
            if(!"desc".equals(curLine)){
                throw new ParcingException("No blocks description");
            }
            return;
        }
    }

    public boolean hasNext() {
        if(!scanner.hasNextLine()){
            return false;
        }
        while(scanner.hasNextLine()){
            curLine = scanner.nextLine();
            if(!"".equals(curLine)){
                break;
            }
        }
        return !"csed".equals(curLine);
    }

    public int getID() throws ParcingException {
        if(!curLine.matches("[0-9]+[ ]*=[ ]*[a-zA-Z0-9. ]+")){
            throw new ParcingException("wrong description: " + curLine);
        }
        Scanner lineScanner = new Scanner(curLine);
        return lineScanner.nextInt();
    }

    public String getCommand()  throws ParcingException {
        if(!curLine.matches("[0-9]+[ ]*=[ ]*[a-zA-Z0-9. ]+")){
            throw new ParcingException("wrong description: " + curLine);
        }
        return curLine.replaceFirst("[0-9]+[ ]*=[ ]*", "");
    }
}
