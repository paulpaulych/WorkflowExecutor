package blocks;

import exception.WorkflowException;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BlockGrepTest {

    @Test
    public void execute() throws WorkflowException{
        Block grepBlock = new BlockGrep();
        List<String> text = Arrays.asList("hi", "hi hi", "ho", "ho hi");

        assertThrows(WorkflowException.class, () -> grepBlock.execute(text, new String[]{}));
        assertThrows(WorkflowException.class, () -> grepBlock.execute(text, new String[]{"aad", "casdf"}));
        assertThrows(WorkflowException.class, () -> grepBlock.execute(null, new String[]{"a"}));

        List<String> expected = Arrays.asList("hi", "hi hi", "ho hi");
        assertEquals(expected, grepBlock.execute(text, new String[]{"hi"}));
    }
}