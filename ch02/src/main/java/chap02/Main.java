package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // @Bean 설정 정보를 읽어와서 Greeter 객체 생성 및 초기화
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);

        // @Bean 검색 후 객체 리턴
        Greeter g = context.getBean("greeter", Greeter.class);

        String msg = g.greet("홍길동");
        System.out.println(msg);

        context.close();
    }
}
