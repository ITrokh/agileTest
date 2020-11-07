package com.agileengine.testtask.cache;

import com.agileengine.testtask.model.Image;
import com.agileengine.testtask.model.ImageList;
import com.agileengine.testtask.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageCache {
    private final ImageService imageService;
    private final Map<String, List<Image>> cache = new HashMap<>();

    public Map<String, List<Image>> getCache() {
        return cache;
    }

    @PostConstruct
    @Scheduled(fixedRateString = "${spring.cache.update.time}")
    public void cacheUpdate(){
        fillCache();
    }

    public void fillCache(){
        Stream.iterate(0, i -> i + 1).map(page-> {
            ImageList imageList = imageService.loadImages(page);
            imageList.getPictures().stream()
                    .map(image -> imageService.loadImage(image.getId()))
                    .map(Image::putImageToCache)
                    .forEach(pair->pair.getValue()
                    .forEach(params->putIfAbsent(params, pair.getKey())));
            return imageList.getHasMore();
        }).findAny();
    }

    private void putIfAbsent(String param, Image image){
        if(cache.containsKey(param)){
            cache.get(param).add(image);
        } else {
            ArrayList<Image> value = new ArrayList<>();
            value.add(image);
            cache.put(param, value);
        }
    }
}
