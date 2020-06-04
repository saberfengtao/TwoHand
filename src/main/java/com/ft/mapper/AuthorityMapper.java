package com.ft.mapper;

import com.ft.entity.Authority;

import java.util.List;

public interface AuthorityMapper {

    //查询所有权限
    List<Authority> getAllAuthorities();
}
