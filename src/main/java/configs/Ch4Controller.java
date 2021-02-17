package configs;

import ch4.divideAndConquer.FindMaxSubArray;
import ch4.divideAndConquer.SubArray;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ch4Controller {
    @GetMapping("/findmaxsubarray")
    public SubArray findMaxSubArray(@RequestParam(value="inputs")String inputs){
        String[] ins = inputs.split(",");
        Integer[] integers = new Integer[ins.length];
        for(int i = 0; i<ins.length; i++){
            integers[i] = Integer.parseInt(ins[i].trim());
        }
        FindMaxSubArray findMaxSubArray = new FindMaxSubArray(integers);
        return findMaxSubArray.get();
    }
}
