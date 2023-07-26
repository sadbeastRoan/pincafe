package com.project.pincafe.user;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserDAO {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public UserTblVO selectOneUser(UserTblVO vo) throws Exception
    {
        return sqlSessionTemplate.selectOne("selectOneUser", vo);

    }



   
}
