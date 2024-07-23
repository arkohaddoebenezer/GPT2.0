package org.trainingamalitech.librarymanagementsystem.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ResourceTypeTest {

    @Test
    public void testEnumValues() {
        ResourceType[] expectedValues = {
                ResourceType.BOOK,
                ResourceType.MAGAZINE,
                ResourceType.DVD,
                ResourceType.NEWSPAPER,
                ResourceType.JOURNAL
        };

        assertArrayEquals(expectedValues, ResourceType.values());
    }

    @Test
    public void testEnumValueOf() {
        assertEquals(ResourceType.BOOK, ResourceType.valueOf("BOOK"));
        assertEquals(ResourceType.MAGAZINE, ResourceType.valueOf("MAGAZINE"));
        assertEquals(ResourceType.DVD, ResourceType.valueOf("DVD"));
        assertEquals(ResourceType.NEWSPAPER, ResourceType.valueOf("NEWSPAPER"));
        assertEquals(ResourceType.JOURNAL, ResourceType.valueOf("JOURNAL"));
    }
}
