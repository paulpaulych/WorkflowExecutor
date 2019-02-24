import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BlockWriteFile implements Block {

    @Override
    public void execute(TextHolder textHolder, String[] args) throws WorkflowException{
        System.out.println("writeBlock");
        if(args.length < 1){
            throw new WorkflowException("Invalid number of aguments");
        }
        for(String fname : args){
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(fname))){

                for (String s: textHolder.getText()) {
                    writer.write(s);
                    writer.newLine();
                }

            }catch (IOException exc){
                throw new WorkflowException(exc.getMessage());
            }
        }
    }

}
