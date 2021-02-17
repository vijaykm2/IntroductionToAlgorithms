package ch2.gettingstarted;

import java.util.function.Supplier;

public class InsertionSort implements Supplier<Integer[]> {
    private Integer[] inputs;
    public InsertionSort(Integer[] inputs){
        this.inputs = inputs;
    }
    @Override
    public Integer[] get() {
        for(int j = 1; j<inputs.length; j++){
            Integer key = inputs[j];
            int i = j-1;
            while (i>=0 && inputs[i]>key){
                inputs[i+1] = inputs[i];
                i -= 1;

            }
            inputs[i+1] = key;
        }
        return inputs;
    }
}
