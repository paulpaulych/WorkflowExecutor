package blocks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BlockSort
    implements Block {

        @Override
        public List<String> execute(List<String> text, String[] args) throws WorkflowException{
            if(text == null){
                throw new WorkflowException("Text is not uploaded");
            }
            return text
                    .stream()
                    .sorted(Comparator.naturalOrder())
                    .collect(Collectors.toCollection(ArrayList::new));
        }
}
