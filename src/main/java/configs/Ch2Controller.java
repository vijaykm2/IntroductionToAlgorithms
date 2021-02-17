package configs;

import ch2.gettingstarted.BubbleSort;
import ch2.gettingstarted.InsertionSort;
import ch2.gettingstarted.MergeSort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class Ch2Controller {

    @GetMapping("/insertionSort")
    public String insertionSort(@RequestParam(value="inputs")String inputs){
        String[] ins = inputs.split(",");
        Integer[] integers = new Integer[ins.length];
        for(int i = 0; i<ins.length; i++){
            integers[i] = Integer.parseInt(ins[i].trim());
        }
        InsertionSort insertionSort = new InsertionSort(integers);
        return Arrays.toString(insertionSort.get());
    }
    @GetMapping("/mergeSort")
    public String mergeSort(@RequestParam(value="inputs")String inputs){
        String[] ins = inputs.split(",");
        Integer[] integers = new Integer[ins.length];
        for(int i = 0; i<ins.length; i++){
            integers[i] = Integer.parseInt(ins[i].trim());
        }
        MergeSort mergeSort = new MergeSort(integers);
        return Arrays.toString(mergeSort.get());
    }
    @GetMapping("/bubbleSort")
    public String bubbleSort(@RequestParam(value="inputs")String inputs){
        String[] ins = inputs.split(",");
        Integer[] integers = new Integer[ins.length];
        for(int i = 0; i<ins.length; i++){
            integers[i] = Integer.parseInt(ins[i].trim());
        }
        BubbleSort bubbleSort = new BubbleSort(integers);
        return Arrays.toString(bubbleSort.get());
    }
}
