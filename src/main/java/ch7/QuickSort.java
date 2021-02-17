package ch7;

public class QuickSort {
    private int[] array;
    QuickSort(int[] input){
        this.array = input;
    }

    public int[] quickSort(){
        this.quickSort(array, 0, array.length);
        return this.array;
    }

    private void quickSort(int[] array, int p, int r) {
        if(p<r-1){
            int q = this.partition(p,r);
            this.quickSort(array,p,q-1);
            this.quickSort(array, q+1, r-1);

        }
    }

    private int partition(int p, int r) {
        int x = array[r-1];
        int i = p-1;
        for (int j = p;j<r-1;j++){
            if(array[j]<=x){
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        i++;
        int temp = array[r-1];
        array[r-1] = array[i];
        array[i] = temp;
        return i;
    }
}
