package com.ibm.training.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ibm.training.model.Login;


@Repository
public class LoginDaoImpl  {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Login valid_login(String id,String password) {
        try {
    String sql="select * from login where id=? and password=?";
    return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Login>(Login.class),id,password);
        }catch(EmptyResultDataAccessException e)
        {
            return null;
        }
        }

}