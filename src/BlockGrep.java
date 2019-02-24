import java.util.Vector;

public class BlockGrep implements Block {

    @Override
    public void execute(TextHolder textHolder, String[] args) throws WorkflowException {
        if(args.length != 1){
            throw new WorkflowException("Wrong number of arguments");
        }
        Vector<String> tmp = new Vector<>();
        for(String s : textHolder.getText()) {
            if (s.contains(args[0])) {
                tmp.add(s);
            }
        }
        textHolder.setText(tmp);
    }
}
