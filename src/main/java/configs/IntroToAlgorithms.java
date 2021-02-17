package configs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntroToAlgorithms {
    public static void main(String[] args){
        System.out.println(Integer.parseInt("-123"));
        SpringApplication.run(IntroToAlgorithms.class, args);
    }

}
