package blocks;

import exception.WorkflowException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BlockReplaceTest {

    @Test
    void execute() throws WorkflowException {
        Block replaceBlock = new BlockReplace();
        List<String> text = Arrays.asList("hi", "hi hi", "ho", "ho hi");

        assertThrows(WorkflowException.class, () -> replaceBlock.execute(text, new String[]{}));
        assertThrows(WorkflowException.class, () -> replaceBlock.execute(text, new String[]{"aad"}));
        assertThrows(WorkflowException.class, () -> replaceBlock.execute(text, new String[]{"aad", "aad", "casdf"}));
        assertThrows(WorkflowException.class, () -> replaceBlock.execute(null, new String[]{"a", "v"}));

        List<String> expected = Arrays.asList("By", "By By", "ho", "ho By");
        assertEquals(expected, replaceBlock.execute(text, new String[]{"hi", "By"}));
    }

}