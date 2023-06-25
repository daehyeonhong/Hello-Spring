package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping(value = "/hello")
    public String hello(final Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    // @GetMapping(value = "/hello-mvc") => http get 메소드 요청을 받을 수 있는 API를 만들어줌
    @GetMapping(value = "/hello-mvc")
    // @RequestParam => 외부에서 파라미터를 받는다.
    // @RequestParam(value = "name") => 외부에서 name이라는 이름으로 넘긴 파라미터를 메소드 파라미터 name에 저장
    // @RequestParam(value = "name", required = true) => required = true => 필수 파라미터
    // @RequestParam(value = "name", required = false) => required = false => 필수 파라미터가 아님
    public String helloMvc(@RequestParam(value = "name") final String name,
                           final Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping(value = "/hello-string")
    @ResponseBody
    // ResponseBody => http의 body에 return 값을 직접 넣어주겠다는 의미
    // viewResolver 대신에 HttpMessageConverter가 동작
    // 기본 문자처리: StringHttpMessageConverter
    public String helloString(@RequestParam(value = "name") final String name) {
        return "hello " + name;
    }

    @GetMapping(value = "/hello-api")
    @ResponseBody
    // @ResponseBody => http의 body에 return 값을 직접 넣어주겠다는 의미
    // viewResolver 대신에 HttpMessageConverter가 동작
    // 기본 객체처리: MappingJackson2HttpMessageConverter
    // json과 xml의 차이 => json이 더 간결하고 가볍다.
    // @ResponseBody를 사용하면 기본적으로 json 방식으로 데이터를 만들어서 반환
    public Hello helloApi(@RequestParam(value = "name") final String name) {
        return new Hello(name);
    }

    // JavaBean 표준 방식
    // Property 접근 방식
    static class Hello {
        private String name;

        public Hello(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(final String name) {
            this.name = name;
        }
    }
}
