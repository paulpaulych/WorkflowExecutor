import exception.ParcingException;
import exception.WorkflowException;
import org.junit.jupiter.api.Test;

import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

class ExecutionListIteratorTest {

    @Test
    void next() throws ParcingException, WorkflowException {
        Scanner scanner1 = new Scanner("0->1->2->3");
        Scanner scanner2 = new Scanner("0 ->  1");
        Scanner scanner3 = new Scanner("->1->2");
        Scanner scanner4 = new Scanner("0->a->2");
        Scanner scanner5 = new Scanner("0->3134567898765434567812345643213456");
        Scanner scanner6 = new Scanner("");

        ExecutionListIterator execList1 = new ExecutionListIterator(scanner1);
        assertEquals(0, execList1.next());
        assertEquals(1, execList1.next());
        assertEquals(2, execList1.next());
        assertEquals(3, execList1.next());
        assertNull(execList1.next());

        ExecutionListIterator execList2 = new ExecutionListIterator(scanner2);
        assertEquals(0, execList2.next());
        assertEquals(1, execList2.next());
        assertNull(execList2.next());

        ExecutionListIterator execList3 = new ExecutionListIterator(scanner3);
        assertEquals(1, execList3.next());
        assertEquals(2, execList3.next());
        assertNull(execList3.next());

        ExecutionListIterator execList4 = new ExecutionListIterator(scanner4);
        assertEquals(0, execList4.next());
        assertThrows(WorkflowException.class, execList4::next);

        ExecutionListIterator execList5 = new ExecutionListIterator(scanner5);
        assertEquals(0, execList5.next());
        assertThrows(WorkflowException.class, execList5::next);

        assertThrows(ParcingException.class, () -> new ExecutionListIterator(scanner6));

    }
}