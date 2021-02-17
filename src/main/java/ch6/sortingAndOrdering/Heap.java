package ch6.sortingAndOrdering;

public class Heap    {

    private int heapSize;

    public Integer[] getHeapArr() {
        return heapArr;
    }

    private Integer[] heapArr = null;
    private Integer left(Integer index){
        return index*2+1;
    }
    private Integer right(Integer index){
        return index*2+2;
    }
    public Integer[] maxHeapify(Integer[] heap, Integer index){
        int left = left(index);
        int right = right(index);
        int largest = Integer.MIN_VALUE;
        if(left< this.heapSize && heap[left]>heap[index]){
            largest = left;
        }else {
            largest = index;
        }
        if(right<this.heapSize && heap[right]>heap[largest]){
            largest = right;
        }
        if (largest != index){
            int temp = heap[largest];
            heap[largest] = heap[index];
            heap[index] = temp;
            maxHeapify(heap, largest);
        }
        return heap;
    }
    public static Heap buildMaxHeap(Integer[] heapArr){
        Heap heap = new Heap();
        heap.setHeapSize(heapArr.length);

        for(int i = heapArr.length-1; i>=0;i--){
            heap.maxHeapify(heapArr, i);
        }
        heap.heapArr = heapArr;
        return heap;
    }

    private void setHeapSize(int length) {
        this.heapSize =length;
    }
    private int getHeapSize(){
        return this.heapSize;
    }

    public Integer[] sort(Integer[] heapArr ){
        Heap heap = buildMaxHeap(heapArr);
        for(int i = heapArr.length-1;i>0;i--){
            int temp = heapArr[i];
            heapArr[i]= heapArr[0];
            heapArr[0] = temp;
            heapSize--;
            maxHeapify(this.heapArr, 0);
        }
        return this.heapArr;
    }
}
