package com.company.homeworkalgorithm;

import com.company.homeworkalgorithm.exeptions.ElementNotFoundException;
import com.company.homeworkalgorithm.exeptions.NullRequestException;
import com.company.homeworkalgorithm.exeptions.OutOfListSizeException;
import com.company.homeworkalgorithm.service.IntegerList;
import com.company.homeworkalgorithm.service.IntegerListImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerListImplTest {
    private IntegerList list = new IntegerListImpl();

    @AfterEach
    public void afterEach() {
        list = new IntegerListImpl();
    }

    //add(Integer item);
    @Test
    void returnCorrectValueAddTest1() {
        Integer expected = list.add(1);
        Assertions.assertEquals(expected, 1);
    }

    @Test
    void returnCorrectValueAddTest2() {
        list.add(2);
        Integer[] result = list.toArray();
        Integer[] expectedResult = new Integer[]{2};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void returnNullRequestExceptionAddTest3() {
        assertThrows(NullRequestException.class,
                () -> list.add(null));
    }

    //add(int index, Integer item);
    @Test
    void returnCorrectValueAddWithIndexTest1() {
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1, 2);
        Integer[] result = list.toArray();
        Integer[] expectedResult = new Integer[]{1, 2, 1, 1};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void returnNullRequestExceptionAddWithIndexTest2() {
        list.add(1);
        list.add(1);
        assertThrows(NullRequestException.class,
                () -> list.add(1, null));
    }

    @Test
    void returnCorrectValueAddWithIndexTest3() {
        list.add(1);
        list.add(1, 2);
        Integer[] result = list.toArray();
        Integer[] expectedResult = new Integer[]{1, 2};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void returnOutOfListSizeExceptionAddWithIndexTest4() {
        list.add(1);
        list.add(1);
        assertThrows(OutOfListSizeException.class,
                () -> list.add(7, 2));
    }

    //set(int index, Integer item);
    @Test
    void returnCorrectValueSetTest1() {
        list.add(1);
        list.add(1);
        list.add(1);
        list.set(1, 2);
        Integer[] result = list.toArray();
        Integer[] expectedResult = new Integer[]{1, 2, 1};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void returnOutOfListSizeExceptionSetTest2() {
        list.add(1);
        list.add(1);
        assertThrows(OutOfListSizeException.class,
                () -> list.set(7, 2));
    }

    //remove(Integer item);
    @Test
    void returnCorrectValueRemoveTest1() {
        list.add(1);
        list.add(2);
        list.add(1);
        list.removeItem(2);
        Integer[] result = list.toArray();
        Integer[] expectedResult = new Integer[]{1, 1};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void returnElementNotFoundExceptionRemoveTest2() {
        list.add(1);
        list.add(1);
        assertThrows(ElementNotFoundException.class,
                () -> list.removeItem(2));
    }

    //remove(int index);
    @Test
    void returnCorrectValueRemoveWithIndexTest1() {
        list.add(1);
        list.add(2);
        list.add(1);
        list.remove(1);
        Integer[] result = list.toArray();
        Integer[] expectedResult = new Integer[]{1, 1};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void returnOutOfListSizeExceptionRemoveTest2() {
        list.add(1);
        list.add(1);
        assertThrows(OutOfListSizeException.class,
                () -> list.remove(7));
    }

    //sort();
    @Test
    void returnCorrectValueSortTest1() {
        list.add(5);
        list.add(2);
        list.add(1);
        list.add(4);
        list.add(3);
        list.sort();
        Integer[] result = list.toArray();
        Integer[] expectedResult = new Integer[]{1, 2, 3, 4, 5};
        assertArrayEquals(expectedResult, result);
    }


    //contains(Integer item);
    @Test
    void returnTrueContainsTest1() {
        list.add(7);
        list.add(9);
        list.add(1);
        list.add(0);
        list.add(3);
        list.add(4);
        list.add(1);
        list.add(2);
        list.add(5);
        assertTrue(list.contains(2));
    }

    @Test
    void returnFalseContainsTest2() {
        list.add(1);
        list.add(2);
        list.add(1);
        assertFalse(list.contains(5));
    }

    //indexOf(Integer item);
    @Test
    void returnCorrectIndexOfItemIndexOfTest1() {
        list.add(1);
        list.add(2);
        list.add(1);
        assertEquals(list.indexOf(2), 1);
    }

    @Test
    void returnMinusOneIfThereAreNoItemIndexOfTest1() {
        list.add(1);
        list.add(2);
        list.add(1);
        assertEquals(list.indexOf(3), -1);
    }


    //lastIndexOf(Integer item)
    @Test
    void returnCorrectIndexOfItemLastIndexOfTest1() {
        list.add(1);
        list.add(2);
        list.add(1);
        assertEquals(list.lastIndexOf(1), 2);
    }

    @Test
    void returnMinusOneIfThereAreNoItemLastIndexOfTest1() {
        list.add(1);
        list.add(2);
        list.add(1);
        assertEquals(list.lastIndexOf(3), -1);
    }

    //get(int index);
    @Test
    void returnCorrectValueGetTest1() {
        list.add(1);
        list.add(2);
        list.add(1);
        Assertions.assertEquals(list.get(1), 2);
    }

    @Test
    void returnOutOfListSizeExceptionGetTest2() {
        list.add(1);
        list.add(1);
        assertThrows(OutOfListSizeException.class,
                () -> list.get(7));
    }

    //equals(StringList otherList);
    @Test
    void returnTrueIfStringListsAreEqualsEqualsTest1() {
        list.add(1);
        list.add(2);
        list.add(1);
        IntegerList expectedList = new IntegerListImpl();
        expectedList.add(1);
        expectedList.add(2);
        expectedList.add(1);
        assertTrue(list.equals(expectedList));
    }

    @Test
    void returnFalseIfStringListsAreNotEqualsEqualsTest2() {
        list.add(2);
        list.add(2);
        list.add(1);
        IntegerList expectedList = new IntegerListImpl();
        expectedList.add(1);
        expectedList.add(2);
        expectedList.add(1);
        assertFalse(list.equals(expectedList));
    }

    @Test
    void returnNullRequestExceptionEqualsTest3() {
        list.add(1);
        list.add(1);
        IntegerList expectedList = null;
        assertThrows(NullRequestException.class,
                () -> list.equals(expectedList));
    }


    //size();
    @Test
    void returnCorrectSizeTest1() {
        list.add(1);
        list.add(1);
        list.add(1, 1);
        list.set(1, 1);
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
        list.add(5);
        assertFalse(list.isEmpty());
    }

    //clear();
    @Test
    void removeAllItemsAndDecreaseSizeClearTest() {
        list.add(1);
        list.add(2);
        list.add(1);
        list.clear();
        Integer[] result = list.toArray();
        Integer[] expectedResult = new Integer[]{};
        assertArrayEquals(expectedResult, result);
    }


    //toArray();
    @Test
    void returnCorrectValueToArrayTest1() {
        Integer[] result = list.toArray();
        Integer[] expectedResult = new Integer[]{};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void returnCorrectValueToArrayTest2() {
        list.add(1);
        Integer[] result = list.toArray();
        Integer[] expectedResult = new Integer[]{1};
        assertArrayEquals(expectedResult, result);
    }

    //increaseArray();
    @Test
    //при добавлении элементов, большего кол-ва чем длина массива в конструкторе,
    // должен присваивать новый массив с большей длиной и корректно переносить элементы в новый массив.
    void correctlyTransferElementValuesToTheNewArrayWhenTheStorageIsIncremented() {
        for (int i = 0; i < 11; i++) {
            Integer expected = list.add(1);
        }
        Integer[] result = list.toArray();
        Integer[] expectedResult = new Integer[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        assertArrayEquals(expectedResult, result);
    }
}
