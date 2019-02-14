import java.io.*;

class ArgResolver {
    private String[] args;

    ArgResolver(String[] args){
        this.args = args;
    }

    BufferedReader getReader() throws IOException {
        BufferedReader reader;
        if(args.length > 0){
            reader = new BufferedReader(new FileReader(args[0]));
        }else{
            reader = new BufferedReader(new InputStreamReader(System.in));
        }
        return reader;
    }

    BufferedWriter getWriter() throws IOException {
        BufferedWriter writer;
        if(args.length > 1){
                writer = new BufferedWriter(new FileWriter(args[1]));
        }else{
            writer = new BufferedWriter(new OutputStreamWriter(System.out));
        }
        return writer;
    }
}
