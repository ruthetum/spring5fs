package config;

import controller.HelloContoller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {

    @Bean
    public HelloContoller helloContoller() {
        return new HelloContoller();
    }
}
