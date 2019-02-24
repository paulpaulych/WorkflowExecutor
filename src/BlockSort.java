import java.util.Comparator;
import java.util.Vector;
import java.util.stream.Collectors;

public class BlockSort
    implements Block {

        @Override
        public void execute(TextHolder textHolder, String[] args){
            System.out.println("Sort here");
            textHolder.setText(textHolder.getText()
                    .stream()
                    .sorted(Comparator.naturalOrder())
                    .collect(Collectors.toCollection(Vector::new))
            );
        }
}
