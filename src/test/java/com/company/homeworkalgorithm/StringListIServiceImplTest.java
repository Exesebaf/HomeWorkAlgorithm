package com.company.homeworkalgorithm;

import com.company.homeworkalgorithm.cervice.StringListService;
import com.company.homeworkalgorithm.cervice.StringListServiceImpl;
import com.company.homeworkalgorithm.exeptions.ElementNotFoundException;
import com.company.homeworkalgorithm.exeptions.NullRequestException;
import com.company.homeworkalgorithm.exeptions.OutOfListSizeException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringListIServiceImplTest {
    private StringListService list = new StringListServiceImpl();

    @AfterEach
    public void afterEach() {
        list = new StringListServiceImpl();
    }

    //add(String item);
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

    //add(int index, String item);
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
    void returnOutOfListSizeExceptionAddWithIndexTest3() {
        list.add("1");
        list.add("1");
        assertThrows(OutOfListSizeException.class,
                () -> list.add(7, "2"));
    }

    //set(int index, String item);
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

    //remove(String item);
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

    //remove(int index);
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

    //contains(String item);
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

    //indexOf(String item);
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


    //lastIndexOf(String item)
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

    //get(int index);
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

    //equals(StringList otherList);
    @Test
    void returnTrueIfStringListsAreEqualsEqualsTest1() {
        list.add("1");
        list.add("2");
        list.add("1");
        StringListService expectedListService = new StringListServiceImpl();
        expectedListService.add("1");
        expectedListService.add("2");
        expectedListService.add("1");
        assertTrue(list.equals(expectedListService));
    }

    @Test
    void returnFalseIfStringListsAreNotEqualsEqualsTest2() {
        list.add("2");
        list.add("2");
        list.add("1");
        StringListService expectedListService = new StringListServiceImpl();
        expectedListService.add("1");
        expectedListService.add("2");
        expectedListService.add("1");
        assertFalse(list.equals(expectedListService));
    }

    @Test
    void returnNullRequestExceptionEqualsTest3() {
        list.add("1");
        list.add("1");
        StringListService expectedListService = null;
        assertThrows(NullRequestException.class,
                () -> list.equals(expectedListService));
    }


    //size();
    @Test
    void returnCorrectSizeTest1() {
        list.add("1");
        list.add("1");
        list.add(1, "1");
        list.set(1, "1");
        list.remove(1);

        assertEquals(list.size(), 2);
    }

    //isEmpty();
    @Test
    void returnTrueIsEmptyTest1() {
        assertTrue(list.isEmpty());
    }

    @Test
    void returnFalseIsEmptyTest2() {
        list.add("5");
        assertFalse(list.isEmpty());
    }

    //clear();
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


    //toArray();
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

    //increaseArray();
    @Test
    //при добавлении элементов, большего кол-ва чем длина массива в конструкторе,
    // должен присваивать новый массив с большей длиной и корректно переносить элементы в новый массив.
    void correctlyTransferElementValuesToTheNewArrayWhenTheStorageIsIncremented() {
        for (int i = 0; i < 11; i++) {
            String expected = list.add("1");
        }
        String[] result = list.toArray();
        String[] expectedResult = new String[]{"1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1"};
        assertArrayEquals(expectedResult, result);
    }
}
