package com.service;

import com.entity.Code;
import com.entity.User;

import java.util.Optional;

public interface CodeService {

    void add(Code code);

    Optional<Code> getCodeForUser(User user);
}
