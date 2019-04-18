package org.szpinc.study.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.szpinc.study.security.entity.User;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserRepository.java
 * @Description TODO
 * @createTime 2019年04月17日 22:22:00
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
