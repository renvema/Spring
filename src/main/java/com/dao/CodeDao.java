package com.dao;

import com.entity.Code;
import com.entity.User;

import java.util.Optional;

public interface CodeDao {

    void add(Code code);

    Optional<Code> getCodeForUser(User user);
}
