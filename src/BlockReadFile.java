import java.io.*;
import java.util.Scanner;

public class BlockReadFile
    implements Block{

    @Override
    public void execute(TextHolder textHolder, String[] args) throws WorkflowException{
        System.out.println("beep beep ur ReadFileBlock here");

        if(args.length != 1){
            throw new WorkflowException("Invalid number of aguments");
        }

        try( BufferedReader reader = new BufferedReader(new FileReader(args[0])) ){
            Scanner scanner = new Scanner(reader);
            while(scanner.hasNextLine()){
                textHolder.getText().add(scanner.nextLine());
            }
        }
        catch (IOException exc){
            throw new WorkflowException(exc.getMessage());
        }
        for(String s : textHolder.getText()){
            s = s + "pisya";
        }
    }
}