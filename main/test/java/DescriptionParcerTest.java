import exception.ParcingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class DescriptionParcerTest {


    private DescriptionParcer descriptionParcer1;
    private DescriptionParcer descriptionParcer2;
    private DescriptionParcer descriptionParcer3;
    private DescriptionParcer descriptionParcer4;
    private DescriptionParcer descriptionParcer5;
    private DescriptionParcer descriptionParcer6;


    @BeforeEach
    void setUp() throws IOException, ParcingException {
        descriptionParcer1 = new DescriptionParcer(
                new Scanner(new BufferedReader(new FileReader("main/test/resources/descTest1.txt"))));
        descriptionParcer2 = new DescriptionParcer(
                new Scanner(new BufferedReader(new FileReader("main/test/resources/descTest2.txt"))));
        descriptionParcer3 = new DescriptionParcer(
                new Scanner(new BufferedReader(new FileReader("main/test/resources/descTest3.txt"))));
        descriptionParcer4 = new DescriptionParcer(
                new Scanner(new BufferedReader(new FileReader("main/test/resources/descTest4.txt"))));
        descriptionParcer5 = new DescriptionParcer(
                new Scanner(new BufferedReader(new FileReader("main/test/resources/descTest5.txt"))));
        descriptionParcer6 = new DescriptionParcer(
                new Scanner(new BufferedReader(new FileReader("main/test/resources/descTest6.txt"))));
    }

// hasNext(), getID(), GetCommand() are usually used together, so it's not necessary to test them separately
    @Test
    void hasNext() throws ParcingException{

        assertTrue(descriptionParcer1.hasNext());
        assertEquals(4, descriptionParcer1.getID());
        assertEquals("writefile out.txt", descriptionParcer1.getCommand());
        assertFalse(descriptionParcer1.hasNext());

        assertFalse(descriptionParcer2.hasNext());

        assertThrows(ParcingException.class, () -> descriptionParcer3.hasNext());

        assertTrue(descriptionParcer4.hasNext());
        assertEquals(0, descriptionParcer4.getID());
        assertEquals("readxfile in.txt", descriptionParcer4.getCommand());
        assertTrue(descriptionParcer4.hasNext());
        assertEquals(1, descriptionParcer4.getID());
        assertEquals("sort", descriptionParcer4.getCommand());
        assertThrows(ParcingException.class, () -> descriptionParcer4.hasNext());

        assertTrue(descriptionParcer5.hasNext());
        assertEquals(0, descriptionParcer5.getID());
        assertEquals("readxfile in.txt", descriptionParcer5.getCommand());
        assertTrue(descriptionParcer5.hasNext());
        assertEquals(1, descriptionParcer5.getID());
        assertEquals("sort", descriptionParcer5.getCommand());
        assertFalse(descriptionParcer5.hasNext());

        assertTrue(descriptionParcer6.hasNext());
        assertEquals(0, descriptionParcer6.getID());
        assertEquals("readxfile in.txt", descriptionParcer6.getCommand());
        assertTrue(descriptionParcer6.hasNext());
        assertEquals(1, descriptionParcer6.getID());
        assertEquals("sort", descriptionParcer6.getCommand());
        assertThrows(ParcingException.class, () -> descriptionParcer6.hasNext());

    }
}