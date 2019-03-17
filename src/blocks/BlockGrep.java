package blocks;

import java.util.ArrayList;
import java.util.List;

public class BlockGrep implements Block {

    @Override
    public List<String> execute(List<String> text, String[] args) throws WorkflowException {
        if(args.length != 1){
            throw new WorkflowException("Wrong number of arguments" + this.getClass());
        }
        if(text == null){
            throw new WorkflowException("Text is not uploaded");
        }
        List<String> newText = new ArrayList<>();
        for(String s : text) {
            if (s.contains(args[0])) {
                newText.add(s);
            }
        }
        return newText;
    }
}
