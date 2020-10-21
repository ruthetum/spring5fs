package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);

        Greeter g1 = ctx.getBean("greeter", Greeter.class);
        Greeter g2 = ctx.getBean("greeter", Greeter.class);

        // 별도 설정을 하지 않을 경우 스프링은 한 개의 빈 객체만 생성 -> Singleton(=단일 객체)
        System.out.println("(g1 == g2) : " + (g1==g2)); // true
        ctx.close();
    }
}
