package hello.hellospring;

import hello.hellospring.aop.TimeTraceAOP;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    private final MemberRepository memberRepository;

    public SpringConfig(final MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(this.memberRepository);
    }

//    @Bean
//    public TimeTraceAOP timeTraceAop() {
//        return new TimeTraceAOP();
//    }
}
