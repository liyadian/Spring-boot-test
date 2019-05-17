package com.lyd.springboot.Dao.impl;

import com.lyd.springboot.Dao.UserDao;
import com.lyd.springboot.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Integer insertUser(UserEntity userEntity){
        String sql = "insert into userinfo(username, password, isAllowedGrant, isAllowedUp, isAllowedDele, isAllowedCheck) values(?, ?, ?, ?, ?, ?)";
        Object args[] = {userEntity.getUsername(), userEntity.getPassword(), userEntity.getIsAllowedGrant(), userEntity.getIsAllowedUp(), userEntity.getIsAllowedDele(), userEntity.getIsAllowedCheck()};
        int temp = jdbcTemplate.update(sql, args);
        if(temp > 0)
            return 1;
        return 0;
        /*
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id"});
                ps.setString(1, userEntity.getUsername());
                ps.setString(2, userEntity.getPassword());
                ps.setInt(3, userEntity.getIsAllowedGrant());
                ps.setInt(4, userEntity.getIsAllowedUp());
                ps.setInt(5, userEntity.getIsAllowedDele());
                ps.setInt(6, userEntity.getIsAllowedCheck());
                return ps;
            }
        }, keyHolder);
        return keyHolder.getKey().intValue();
         */
    }

    @Override
    public Boolean checkByUsername(String username){
        String sql = "select * from userinfo where username = ?";
        Object args[] = {username , };
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, args);
        if(list.isEmpty())
            return true;
        return false;
    }

    @Override
    public UserEntity getUserByUsername(String username) {
        String sql = "select * from userinfo where username = ?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<UserEntity>() {
            @Override
            public UserEntity mapRow(ResultSet resultSet, int i) throws SQLException {
                UserEntity user = new UserEntity();
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setIsAllowedGrant(resultSet.getInt("isAllowedGrant"));
                user.setIsAllowedUp(resultSet.getInt("isAllowedUp"));
                user.setIsAllowedDele(resultSet.getInt("isAllowedDele"));
                user.setIsAllowedCheck(resultSet.getInt("isAllowedDele"));
                return user;
            }
        }, username);
    }

    @Override
    public Integer getUserCount() {
        String sql = "select count(1) from userinfo";
        MapSqlParameterSource nameParameters = new MapSqlParameterSource();
        Integer count = namedParameterJdbcTemplate.queryForObject(sql, nameParameters, Integer.class);
        return count;
    }

    @Override
    public Integer newUpdateUser(UserEntity userEntity) {
        return null;
    }
}
