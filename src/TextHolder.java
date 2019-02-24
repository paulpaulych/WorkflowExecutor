import java.util.Vector;

public class TextHolder {

    private Vector<String> text;

    TextHolder(){
        text = new Vector<String>();
    }

    Vector<String> getText(){
        return text;
    }

    void setText(Vector<String> text){
        this.text = text;
    }
}
