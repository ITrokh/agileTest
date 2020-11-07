package com.agileengine.test.service.impl;

import com.agileengine.testtask.Application;
import com.agileengine.testtask.service.ImageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = Application.class)
class ImageServiceImplTest {
    @Autowired
    private ImageService imageService;

    @Test
    void loadImagesTest(){
        assertNotNull(imageService.loadImages(0));
    }

    @Test
    void loadImageTest(){
        assertNotNull(imageService.loadImage("f6dbc60eb91e29426955"));
    }
}