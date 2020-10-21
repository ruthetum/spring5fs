package chap02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration // 스프링 설정 클래스
public class AppContext {

    @Bean // 스프링이 관리하는 빈 객체 등록
    public Greeter greeter() {
        Greeter g = new Greeter();
        g.setFormat("%s, 안녕!");
        return g;
    }
}
