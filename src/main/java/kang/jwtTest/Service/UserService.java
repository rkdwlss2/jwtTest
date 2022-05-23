package kang.jwtTest.Service;

import kang.jwtTest.Repository.UserRepository;
import kang.jwtTest.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Optional<User> findByIdPw(String id){return userRepository.findById(id);}
}
