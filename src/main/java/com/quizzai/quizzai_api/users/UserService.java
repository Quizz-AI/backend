package com.quizzai.quizzai_api.users;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final IUserRepository userRepository;

    public Page<UserEntity> findAll(Long id, String name, String email, String country, Pageable pageable) {
        return userRepository.findByFilter(id, name, email, country, pageable);
    }
}
