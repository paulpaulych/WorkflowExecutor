import exception.ParcingException;

import java.net.PasswordAuthentication;
import java.util.Scanner;

class DescriptionParcer {

    private Scanner scanner;
    private String curLine;
    private Integer ID;
    private String command;

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

    boolean hasNext() throws ParcingException{
        if(!scanner.hasNextLine()){
            throw new ParcingException("no end of description (csed)");
        }
        while(scanner.hasNextLine()){
            curLine = scanner.nextLine();
            if(!"".equals(curLine)){
                break;
            }
        }
        if("csed".equals(curLine)){
            return false;
        }
        if(curLine.matches("[0-9]+[ ]*=[ ]*[a-zA-Z0-9. ]+")) {
            Scanner lineScanner = new Scanner(curLine);
            try{
                ID = lineScanner.nextInt();
            }catch (Throwable e){
                throw new ParcingException("wrong id in line " + curLine);
            }
            command = curLine.replaceFirst("[0-9]+[ ]*=[ ]*", "");
            return true;
        }else{
            throw new ParcingException("wrong description: " + curLine);
        }
    }

    int getID() {
        return ID;
    }

    String getCommand() {
        return command;
    }
}
