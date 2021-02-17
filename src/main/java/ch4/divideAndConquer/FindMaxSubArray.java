package ch4.divideAndConquer;

import java.util.function.Supplier;

public class FindMaxSubArray implements Supplier<SubArray> {
    private Integer[] inputs;

    public FindMaxSubArray(Integer[] inputs) {
        this.inputs = inputs;
    }

    @Override
    public SubArray get() {
        return findMaximumSubArray(inputs,0,inputs.length-1);
    }

    private SubArray findMaximumSubArray(Integer[] inputs, int low, int high) {
        SubArray result = null;
        if (low == high){
            result =  new SubArray(low, high, inputs[low]);
        }
        else {
            int mid = (low+high)/2;
            SubArray left = findMaximumSubArray(inputs, low, mid);
            SubArray right = findMaximumSubArray(inputs, mid+1, high);
            SubArray crossing = findCrossingSubArray(inputs, low, mid, high);
            if(left.getSum()>=right.getSum() && left.getSum()>=crossing.getSum()){
                result =  left;
            }
            else if(right.getSum()>=left.getSum() && right.getSum()>=crossing.getSum()){
                result =  right;
            }else if(crossing.getSum()>=left.getSum() && crossing.getSum()>=right.getSum()){
                result =  crossing;
            }
        }
        return result;
    }

    private SubArray findCrossingSubArray(Integer[] inputs, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int maxLeft = low;
        for(int i = mid; i>=low;i--){
            sum += inputs[i];
            if(sum > leftSum){
                maxLeft = i;
                leftSum = sum;
            }
        }
        int maxRight = high;
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        for(int i=mid+1;i<=high;i++){
            sum+=inputs[i];
            if(sum>rightSum){
                rightSum = sum;
                maxRight = i;
            }
        }
        return new SubArray(maxLeft,maxRight, leftSum+rightSum);
    }
}
