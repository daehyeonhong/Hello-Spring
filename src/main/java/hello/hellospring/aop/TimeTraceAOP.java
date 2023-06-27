package hello.hellospring.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component // SpringConfig.java에서 @Bean으로 등록하지 않고 @Component로 등록
public class TimeTraceAOP {
    private static final Logger log = LogManager.getLogger(TimeTraceAOP.class);


    @Around("execution(* hello.hellospring..*(..))")
    public Object execute(final ProceedingJoinPoint joinPoint) throws Throwable {
        final long start = System.currentTimeMillis();
        log.info("START: {}", joinPoint);
        try {
            return joinPoint.proceed();
        } finally {
            final long finish = System.currentTimeMillis();
            final long timeMs = finish - start;
            log.info("END: {} {}ms", joinPoint, timeMs);
        }
    }
}
