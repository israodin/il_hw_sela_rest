package il.hw.sela.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by israo on 6/23/2017.
 */
@SpringBootApplication
@ImportResource(value = {"classpath:application-context.xml","classpath:application-db.xml"})
public class Application {
    public static void main (String [] args){
        SpringApplication.run(Application.class,args);
    }
}
