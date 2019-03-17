package blocks;

import java.util.ArrayList;
import java.util.List;

public class BlockReplace implements Block {

    @Override
    public List<String> execute(List<String> text, String[] args) throws WorkflowException {
        if(args.length != 2){
            throw new WorkflowException("Wrong number of arguments" + this.getClass());
        }
        if(text == null){
            throw new WorkflowException("Text is not uploaded");
        }
        List<String> newText = new ArrayList<>();
        for(String s: text){
            newText.add(s.replace(args[0], args[1]));
        }
        return newText;
    }
}
