package ch2.gettingstarted;

import java.util.Arrays;
import java.util.function.Supplier;

public class MergeSort implements Supplier<Integer[]> {
    private final Integer[] inputs;

    public MergeSort(Integer[] inputs){
        this.inputs = inputs;
    }
    private void mergeSort(Integer[] a, int start, int end){
        if(start<end){
            int q = (end+start)/2;
            mergeSort(a, start, q);
            mergeSort(a, q+1, end);
            merge(a, start,q,end);
        }

    }

    private void merge(Integer[] a, int start, int q, int end) {
        int n1 = q-start+1;
        int n2= end - q;
        int[] left= new int[n1+1];
        int[] right = new int[n2+1];
        for(int i = 0;i<n1;i++){
            left[i] = a[start+i];

        }
        for(int j = 0; j<n2;j++){
            right[j] = a[q+j+1];

        }
        left[n1] = Integer.MAX_VALUE;
        right[n2] = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        for (int k=start; k<=end; k++){
            if(left[i]<=right[j]){
                a[k] = left[i];
                i++;
            } else{
                a[k] = right[j];
                j++;
            }
        }
        System.out.println(Arrays.toString(a));

    }

    @Override
    public Integer[] get() {
        mergeSort(inputs, 0, inputs.length-1);
        return inputs;
    }
}
