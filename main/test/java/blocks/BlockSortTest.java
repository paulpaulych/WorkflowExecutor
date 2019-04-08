package blocks;

import exception.WorkflowException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BlockSortTest {

    @Test
    void execute() throws WorkflowException{
        Block sortBlock = new BlockSort();
        List<String> text = Arrays.asList("cc", "aa bb", "a1", "bb hi");

        assertThrows(WorkflowException.class, () -> sortBlock.execute(text, new String[]{"aad"}));
        assertThrows(WorkflowException.class, () -> sortBlock.execute(null, new String[]{}));

        List<String> expected = Arrays.asList("a1", "aa bb", "bb hi", "cc");
        assertEquals(expected, sortBlock.execute(text, new String[]{}));
    }
}