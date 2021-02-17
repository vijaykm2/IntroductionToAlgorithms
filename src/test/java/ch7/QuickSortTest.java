package ch7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuickSortTest {
    @Test
    public void testQuickSort(){
        QuickSort quickSort = new QuickSort(new int[]{2,8,7,1,3,5,6,4});
        Assertions.assertArrayEquals(new int[]{1,2,3,4,5,6,7,8}, quickSort.quickSort());
    }
}
