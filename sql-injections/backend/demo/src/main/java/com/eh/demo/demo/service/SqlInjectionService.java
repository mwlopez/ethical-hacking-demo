package com.eh.demo.demo.service;

import com.eh.demo.demo.entity.RequestEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SqlInjectionService {

    @Autowired
    private DataSource dataSource;

    public Object listUser(RequestEntity en) throws SQLException {
        log.info("{}", dataSource);

        PreparedStatement statement = dataSource.getConnection().prepareStatement("select * from public.user where name = '" + en.getInput() + "' and password='" + en.getPassword() + "'");

        ResultSet resultSet = statement.executeQuery();

        log.info("{}", resultSet );

        List<String> list = new ArrayList<>();

        while (resultSet.next()) {
            list.add(resultSet.getString(1));
        }

        return list;
    }

}
