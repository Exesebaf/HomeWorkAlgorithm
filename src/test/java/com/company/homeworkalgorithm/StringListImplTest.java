package com.company.homeworkalgorithm;

import com.company.homeworkalgorithm.service.StringList;
import com.company.homeworkalgorithm.service.StringListImpl;
import com.company.homeworkalgorithm.exeptions.ElementNotFoundException;
import com.company.homeworkalgorithm.exeptions.NullRequestException;
import com.company.homeworkalgorithm.exeptions.OutOfListSizeException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringListImplTest {
    private StringList list = new StringListImpl();

    @AfterEach
    public void afterEach() {
        list = new StringListImpl();
    }

    @Test
    void returnCorrectValueAddTest1() {
        String expected = list.add("1");
        Assertions.assertEquals(expected, "1");
    }

    @Test
    void returnCorrectValueAddTest2() {
        list.add("Test");
        String[] result = list.toArray();
        String[] expectedResult = new String[]{"Test"};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void returnNullRequestExceptionAddTest3() {
        assertThrows(NullRequestException.class,
                () -> list.add(null));
    }

    @Test
    void returnCorrectValueAddWithIndexTest1() {
        list.add("1");
        list.add("1");
        list.add("1");
        list.add(1, "2");
        String[] result = list.toArray();
        String[] expectedResult = new String[]{"1", "2", "1", "1"};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void returnNullRequestExceptionAddWithIndexTest2() {
        list.add("1");
        list.add("1");
        assertThrows(NullRequestException.class,
                () -> list.add(1, null));
    }

    @Test
    void returnCorrectValueAddWithIndexTest3() {
        list.add("1");
        list.add(1, "2");
        String[] result = list.toArray();
        String[] expectedResult = new String[]{"1", "2"};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void returnOutOfListSizeExceptionAddWithIndexTest4() {
        list.add("1");
        list.add("1");
        assertThrows(OutOfListSizeException.class,
                () -> list.add(7, "2"));
    }

    @Test
    void returnCorrectValueSetTest1() {
        list.add("1");
        list.add("1");
        list.add("1");
        list.set(1, "2");
        String[] result = list.toArray();
        String[] expectedResult = new String[]{"1", "2", "1"};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void returnOutOfListSizeExceptionSetTest2() {
        list.add("1");
        list.add("1");
        assertThrows(OutOfListSizeException.class,
                () -> list.set(7, "2"));
    }

    @Test
    void returnCorrectValueRemoveTest1() {
        list.add("1");
        list.add("2");
        list.add("1");
        list.remove("2");
        String[] result = list.toArray();
        String[] expectedResult = new String[]{"1", "1"};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void returnElementNotFoundExceptionRemoveTest2() {
        list.add("1");
        list.add("1");
        assertThrows(ElementNotFoundException.class,
                () -> list.remove("2"));
    }

    @Test
    void returnCorrectValueRemoveWithIndexTest1() {
        list.add("1");
        list.add("2");
        list.add("1");
        list.remove(1);
        String[] result = list.toArray();
        String[] expectedResult = new String[]{"1", "1"};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void returnOutOfListSizeExceptionRemoveTest2() {
        list.add("1");
        list.add("1");
        assertThrows(OutOfListSizeException.class,
                () -> list.remove(7));
    }

    @Test
    void returnCorrectValueSortTest1() {
        list.add("Dog");
        list.add("Animal");
        list.add("Cat");
        list.add("Bird");
        list.sort();
        String[] result = list.toArray();
        String[] expectedResult = new String[]{"Animal", "Bird", "Cat", "Dog"};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void returnCorrectValueSortTest2() {
        list.add("5");
        list.add("2");
        list.add("3");
        list.add("9");
        list.sort();
        String[] result = list.toArray();
        String[] expectedResult = new String[]{"2", "3", "5", "9"};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void returnTrueContainsTest1() {
        list.add("1");
        list.add("2");
        list.add("1");
        assertTrue(list.contains("2"));
    }

    @Test
    void returnFalseContainsTest2() {
        list.add("1");
        list.add("2");
        list.add("1");
        assertFalse(list.contains("5"));
    }

    @Test
    void returnCorrectIndexOfItemIndexOfTest1() {
        list.add("1");
        list.add("2");
        list.add("1");
        assertEquals(list.indexOf("2"), 1);
    }

    @Test
    void returnMinusOneIfThereAreNoItemIndexOfTest1() {
        list.add("1");
        list.add("2");
        list.add("1");
        assertEquals(list.indexOf("3"), -1);
    }


    @Test
    void returnCorrectIndexOfItemLastIndexOfTest1() {
        list.add("1");
        list.add("2");
        list.add("1");
        assertEquals(list.lastIndexOf("1"), 2);
    }

    @Test
    void returnMinusOneIfThereAreNoItemLastIndexOfTest1() {
        list.add("1");
        list.add("2");
        list.add("1");
        assertEquals(list.lastIndexOf("3"), -1);
    }

    @Test
    void returnCorrectValueGetTest1() {
        list.add("1");
        list.add("2");
        list.add("1");
        Assertions.assertEquals(list.get(1), "2");
    }

    @Test
    void returnOutOfListSizeExceptionGetTest2() {
        list.add("1");
        list.add("1");
        assertThrows(OutOfListSizeException.class,
                () -> list.get(7));
    }

    @Test
    void returnTrueIfStringListsAreEqualsEqualsTest1() {
        list.add("1");
        list.add("2");
        list.add("1");
        StringList expectedList = new StringListImpl();
        expectedList.add("1");
        expectedList.add("2");
        expectedList.add("1");
        assertTrue(list.equals(expectedList));
    }

    @Test
    void returnFalseIfStringListsAreNotEqualsEqualsTest2() {
        list.add("2");
        list.add("2");
        list.add("1");
        StringList expectedList = new StringListImpl();
        expectedList.add("1");
        expectedList.add("2");
        expectedList.add("1");
        assertFalse(list.equals(expectedList));
    }

    @Test
    void eturnNullRequestExceptionEqualsTest3() {
        list.add("1");
        list.add("1");
        StringList expectedList = null;
        assertThrows(NullRequestException.class,
                () -> list.equals(expectedList));
    }

    @Test
    void returnCorrectSizeTest1() {
        list.add("1");
        list.add("1");
        list.add(1, "1");
        list.set(1, "1");
        list.remove(1);

        assertEquals(list.size(), 2);
    }

    @Test
    void returnTrueIsEmptyTest1() {
        assertTrue(list.isEmpty());
    }

    @Test
    void returnFalseIsEmptyTest2() {
        list.add("5");
        assertFalse(list.isEmpty());
    }

    @Test
    void removeAllItemsAndDecreaseSizeClearTest() {
        list.add("1");
        list.add("2");
        list.add("1");
        list.clear();
        String[] result = list.toArray();
        String[] expectedResult = new String[]{};
        assertArrayEquals(expectedResult, result);
    }


    @Test
    void returnCorrectValueToArrayTest1() {
        String[] result = list.toArray();
        String[] expectedResult = new String[]{};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void returnCorrectValueToArrayTest2() {
        list.add("1");
        String[] result = list.toArray();
        String[] expectedResult = new String[]{"1"};
        assertArrayEquals(expectedResult, result);
    }

    @Test

    void correctlyTransferElementValuesToTheNewArrayWhenTheStorageIsIncremented() {
        for (int i = 0; i < 11; i++) {
            String expected = list.add("1");
        }
        String[] result = list.toArray();
        String[] expectedResult = new String[]{"1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1"};
        assertArrayEquals(expectedResult, result);
    }
}
