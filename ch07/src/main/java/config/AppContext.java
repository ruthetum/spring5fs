package config;

import aspect.ExeTimeAspect;
import chap07.Calculator;
import chap07.ExeTimeCalculator;
import chap07.RecCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppContext {
    @Bean
    public ExeTimeAspect exeTimeCalculator() {
        return new ExeTimeAspect();
    }

    @Bean
    public Calculator calculator() {
        return new RecCalculator();
    }
}
