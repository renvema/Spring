package com.service;

import com.dao.CodeDao;
import com.entity.Code;
import com.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CodeServiceImpl implements CodeService {


    @Autowired
    private CodeDao codeDao;

    @Transactional
    @Override
    public void add(Code code) {
        codeDao.add(code);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Code> getCodeForUser(User user) {
        return codeDao.getCodeForUser(user);
    }
}
