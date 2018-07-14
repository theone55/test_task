package by.justfors.softclub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SoftclubApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SoftclubApplication.class, args);
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SoftclubApplication.class);
    }
}
