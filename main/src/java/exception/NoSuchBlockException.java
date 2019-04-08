package exception;

public class NoSuchBlockException extends FactoryException {

    public NoSuchBlockException(String s){
        super(s);
    }

    public NoSuchBlockException(Throwable t) {
        super(t);
    }
}
