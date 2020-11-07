package com.agileengine.testtask.service;


import com.agileengine.testtask.model.Image;

import java.util.List;

public interface SearchService {
    List<Image> search(String searchTerm, boolean fullWord);
}
