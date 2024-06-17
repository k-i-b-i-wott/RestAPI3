package biwott.com.runnerz;

import biwott.com.runnerz.run.Location;
import biwott.com.runnerz.run.Run;
import biwott.com.runnerz.run.RunRepository;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class RunnerzApplication {

    private static final Logger log= LoggerFactory.getLogger(RunnerzApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(RunnerzApplication.class, args);

    }

//    @Bean
//    CommandLineRunner runner(RunRepository runRepository){
//        return args ->{
//            Run run= new Run(5,"Morning run", LocalDateTime.now(),LocalDateTime.now().plus(1, ChronoUnit.HOURS), 5,Location.OUTDOOR);
//            runRepository.create(run);
//        };
//    }

}
