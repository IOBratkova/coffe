package ru.coffee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.coffee.entity.UserCredential;

import java.util.Optional;

@Repository
public interface UserCredentialRepository extends JpaRepository<UserCredential, Long> {

    boolean existsByUsername(String userName);

    boolean existsByEmail(String email);

    Optional<UserCredential> findByEmail(String email);

    Optional<UserCredential> findByUsername(String username);

}
