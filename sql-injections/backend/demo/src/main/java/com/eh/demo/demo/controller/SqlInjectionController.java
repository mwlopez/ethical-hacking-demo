package com.eh.demo.demo.controller;

import com.eh.demo.demo.entity.RequestEntity;
import com.eh.demo.demo.service.SqlInjectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController()
@Slf4j
public class SqlInjectionController {
    @Autowired
    SqlInjectionService sqlInjectionService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/sql")
    public ResponseEntity<Object> injectionDemo(@RequestBody RequestEntity request) throws SQLException {
        log.info("{}", request);

        Object o = sqlInjectionService.listUser(request);

        return ResponseEntity.ok(o);
    }

    @GetMapping("/sql")
    public ResponseEntity<Object> injectGetDemo(@RequestParam String name, @RequestParam String password) throws SQLException {

        RequestEntity request = RequestEntity.builder().input(name).password(password).build();

        Object o = sqlInjectionService.listUser(request);

        return ResponseEntity.ok(o);
    }
}
