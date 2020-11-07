package com.agileengine.testtask.service.impl;

import com.agileengine.testtask.cache.ImageCache;
import com.agileengine.testtask.model.Image;
import com.agileengine.testtask.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {
    private final ImageCache imageCache;

    @Override
    public List<Image> search(String searchTerm, boolean fullWord) {
        Map<String, List<Image>> cache = this.imageCache.getCache();
        if (fullWord) {
            return cache.get(searchTerm);
        }

        return cache.keySet().stream().filter(key -> key.contains(searchTerm)).map(cache::get).flatMap(List::stream)
                .distinct().collect(Collectors.toList());
    }
}
