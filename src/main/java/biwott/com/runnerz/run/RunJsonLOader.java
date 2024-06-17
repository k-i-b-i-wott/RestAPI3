package biwott.com.runnerz.run;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aot.hint.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
@Component
public class RunJsonLOader implements CommandLineRunner {

    private static final Logger log= LoggerFactory.getLogger(RunJsonLOader.class);

    private final RunRepository runRepository;
    private final ObjectMapper objectMapper;


    public RunJsonLOader(RunRepository runRepository, ObjectMapper objectMapper) {
        this.runRepository = runRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception{
        if(runRepository.count() == 0){
            try(InputStream inputStream= TypeReference.class.getResourceAsStream("/data/runs.json")){
                Runs allRuns= objectMapper.readValue(inputStream,Runs.class);

                log.info("Reading {} Runs from JSON data and saving them in the database",allRuns.runs().size());
                runRepository.saveAll(allRuns.runs());

            }
            catch (IOException e){
                throw new RuntimeException("Failed to read JSON data",e);
            }
        }
        else {
            log.info("Not reading data from JSON because the collection contains data");
        }
    }
}
