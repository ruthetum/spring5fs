package config;

import DI.MemberDao;
import DI.MemberPrinter;
import DI.MemberSummaryPrinter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;

@Configuration
// 정규표현식(REGEX)으로 스캔 대상 제외
@ComponentScan(basePackages = {"DI"},
    excludeFilters = @Filter(type= FilterType.REGEX, pattern = "DI\\..*Dao"))
// AspectJ 패턴으로 스캔 대상 제외 -> 사용할려면 의존 대상에 aspectjweaver 추가
@ComponentScan(basePackages = {"DI"},
    excludeFilters = @Filter(type= FilterType.ASPECTJ, pattern = "DI.*Dao"))
public class AppContextWithExclude {
    @Bean
    public MemberDao memberDao() {
        return new MemberDao();
    }

    @Bean
    @Qualifier("printer")
    public MemberPrinter memberPrinter1() {
        return new MemberPrinter();
    }

    @Bean
    @Qualifier("summaryPrinter")
    public MemberSummaryPrinter memberPrinter2() {
        return new MemberSummaryPrinter();
    }
}
