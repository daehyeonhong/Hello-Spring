package hello.hellospring.controller;

import hello.hellospring.damain.Member;
import hello.hellospring.service.MemberService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    private static final Logger log = LogManager.getLogger(MemberController.class);
    private final MemberService memberService;

    public MemberController(final MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(value = "/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping(value = "/members/new")
    public String create(final MemberForm form) {
        log.info("form={}", form);
        final var member = new Member();
        member.setName(form.name());
        log.info("member={}", member);
        this.memberService.join(member);
        return "redirect:/";
    }

    @GetMapping(value = "/members")
    public String list(final Model model) {
        final var members = this.memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
