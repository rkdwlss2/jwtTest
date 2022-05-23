package kang.jwtTest.controller;

import kang.jwtTest.Repository.UserRepository;
import kang.jwtTest.domain.User;
import kang.jwtTest.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class UserController {
//    @Autowired
//    private final UserService userService;
    @Autowired
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    //로그인
    @GetMapping("/")
    public String index(){
        return "index";
    }

    //회원가입
    @PostMapping("/join")
    public Long join(@RequestBody Map<String,String> user){
        return userRepository.save(User.builder()
                        .email(user.get("email"))
                        .password(passwordEncoder.encode(user.get("password")))
                        .roles(Collections.singletonList("ROLE_USER"))
                .build()).getId();
    }

    //로그인
    @PostMapping("/login")
    public String login(@RequestBody Map<String,String> user){
        User member = userRepository.findByEmail(user.get("email"))
                .orElseThrow(()->new IllegalArgumentException("가입되지않은 이메일 입니다."));
        if (!passwordEncoder.matches(user.get("password"),member.getPassword())){
            throw new IllegalArgumentException("잘못된비번입니다.");
        }
        return jwtTokenProvider.createToken(member.getUsername(), member.getRoles());
    }

    //로그인완료
    @GetMapping("/success")
    public String success(){
        return "success";
    }

    //로그인실패
    @GetMapping("/fail")
    public String fail(){
        return "fail";
    }

}
