public class BlockReplace implements Block {

    @Override
    public void execute(TextHolder textHolder, String[] args) throws WorkflowException {
        System.out.println("replace here");
        if(args.length != 2){
            throw new WorkflowException("Wrong number of arguments");
        }
        for(String s: textHolder.getText()){
            s = s.replace(args[0], args[1]);
        }
    }
}
