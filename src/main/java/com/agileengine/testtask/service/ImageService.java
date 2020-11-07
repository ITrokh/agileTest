package com.agileengine.testtask.service;


import com.agileengine.testtask.model.Image;
import com.agileengine.testtask.model.ImageList;

public interface ImageService {
    ImageList loadImages(Integer page);

    Image loadImage(String id);
}
