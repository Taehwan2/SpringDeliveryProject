package org.delivery.db.user;

import org.delivery.db.user.enums.UserStataus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRespository extends JpaRepository<UserEntity,Long> {
    //select * from user where id = ? and status =? order by id desc limit 1
    Optional<UserEntity> findFirstByIdAndStatusOrderByIdDesc(Long userId, UserStataus userStataus);

    Optional<UserEntity> findFirstByEmailAndPasswordAndStatusOrderByIdDesc(String email,String password, UserStataus userStataus);
}
