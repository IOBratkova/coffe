package ru.coffee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.coffee.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
