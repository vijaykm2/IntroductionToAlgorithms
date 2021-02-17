package ch6.sortingAndOrdering;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
public class HeapTest {

    @Test
    public void testMaxHeapify(){
        Heap heap = new Heap();
        Integer[] heapArr = new Integer[]{16,4,10,14,7,9,3,2,8,1};
        heap.maxHeapify(heapArr, 1);
        Assertions.assertArrayEquals( new Integer[]{16, 14, 10, 8, 7, 9, 3, 2, 4, 1},heapArr );
    }

    @Test
    public void testBuildMaxHeap(){
        Heap heap = Heap.buildMaxHeap(new Integer[]{ 4,1,3,2,16,9,10,14,8,7});
        Assertions.assertArrayEquals(new Integer[]{16, 14, 10, 8, 7, 9, 3, 2, 4, 1}, heap.getHeapArr());
    }

    @Test
    public void sort(){
        Heap heap = Heap.buildMaxHeap(new Integer[]{ 10,9,8,7,6,5,4,3,2,1});
        heap.sort(heap.getHeapArr());
        Assertions.assertArrayEquals(new Integer[]{1,2,3,4,5,6,7,8,9,10}, heap.getHeapArr());
    }

}
