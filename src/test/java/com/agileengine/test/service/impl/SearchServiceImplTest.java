package com.agileengine.test.service.impl;

import com.agileengine.testtask.Application;
import com.agileengine.testtask.service.impl.SearchServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = Application.class)
class SearchServiceImplTest {
    @Autowired
    private SearchServiceImpl searchService;

    @Test
    void searchTest(){
        assertNotNull(searchService.search("213d806b28c4e00bb3b2", true));
        assertEquals(1,searchService.search("213d806b28c4e00", false).size());
    }
}