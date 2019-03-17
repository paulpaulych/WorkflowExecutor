import java.util.Scanner;

class DescriptionParcer {

    private Scanner scanner;
    private String curLine;

    DescriptionParcer(Scanner scanner) throws ParcingException {
        this.scanner = scanner;
        if(!scanner.hasNextLine()){
            throw new ParcingException("No any block description found");
        }
        curLine = scanner.nextLine();
        while("".equals(curLine) & scanner.hasNextLine()){
            curLine = scanner.nextLine();
        }
        if(!"desc".equals(curLine)){
            throw new ParcingException("No any block description found");
        }
    }

    boolean hasNext() {
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

    int getID() throws ParcingException {
        if(!curLine.matches("[0-9]+[ ]*=[ ]*[a-zA-Z0-9. ]+")){
            throw new ParcingException("wrong description: " + curLine);
        }
        Scanner lineScanner = new Scanner(curLine);
        return lineScanner.nextInt();
    }

    String getCommand()  throws ParcingException {
        if(!curLine.matches("[0-9]+[ ]*=[ ]*[a-zA-Z0-9. ]+")){
            throw new ParcingException("wrong description: " + curLine);
        }
        return curLine.replaceFirst("[0-9]+[ ]*=[ ]*", "");
    }
}
