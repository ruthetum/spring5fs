package config;

import DI.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {

    @Bean
    public MemberDao memberDao(){
        return new MemberDao();
    }

    @Bean
    public MemberRegisterService memberRegisterService() {
        return new MemberRegisterService();
    }

    // 의존을 주입하지 않아도 스프링이 @Autowired가 붙인 필드에 해당 타입의 빈 객체 주입
    @Bean
    public ChangePasswordService changePasswordService(){
        return new ChangePasswordService();
    }

    @Bean
    public MemberPrinter memberPrinter() {
        return new MemberPrinter();
    }

    @Bean
    public MemberListPrinter memberListPrinter() {
        return new MemberListPrinter();
    }

    // settor 필요없이 @Autowired로 자동 주입
    @Bean
    public MemberInfoPrinter memberInfoPrinter() {
        return new MemberInfoPrinter();
    }
}
