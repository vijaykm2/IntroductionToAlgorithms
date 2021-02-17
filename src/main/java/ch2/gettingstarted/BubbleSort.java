package ch2.gettingstarted;

import java.util.function.Supplier;

public class BubbleSort implements Supplier<Integer[]> {
    private Integer[] inputs;
    public BubbleSort(Integer[] inputs){
        this.inputs = inputs;
    }
    @Override
    public Integer[] get() {
        for(int i = 0;i<inputs.length-2; i++){
            for(int j=inputs.length-1;j>i;j--){
                if(inputs[j]<inputs[j-1]){
                    int temp = Integer.valueOf(inputs[j]);
                    inputs[j] = inputs[j-1];
                    inputs[j-1] = temp;
                }
            }
        }
        return inputs;
    }
}
