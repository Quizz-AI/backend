package com.quizzai.quizzai_api.users;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository<UserEntity, Long> {


    @Query("SELECT u FROM UserEntity u WHERE u.userId = :id" +
            " OR u.name = :name" +
            " OR u.email = :email" +
            " OR u.country = :country")
    Page<UserEntity> findByFilter(@Param("id") Long id,
                                  @Param("name") String name,
                                  @Param("email") String email,
                                  @Param("country") String country,
                                  Pageable pageable);
}