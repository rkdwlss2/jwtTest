package kang.jwtTest.Repository;

import kang.jwtTest.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findById(String Id);

    Optional<User> findByEmail(String email);
}
