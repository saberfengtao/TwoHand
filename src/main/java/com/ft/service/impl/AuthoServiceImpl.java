package com.ft.service.impl;

import com.ft.entity.Authority;
import com.ft.mapper.AuthorityMapper;
import com.ft.service.AuthoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional(rollbackFor = Exception.class)
public class AuthoServiceImpl implements AuthoService {

    @Resource
    AuthorityMapper authorityMapper;

    @Override
    public List<Authority> getAllAuthorities() {
        return authorityMapper.getAllAuthorities();
    }
}
