package com.agileengine.testtask.web;

import com.agileengine.testtask.model.Image;
import com.agileengine.testtask.model.ImageList;
import com.agileengine.testtask.service.ImageService;
import com.agileengine.testtask.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.agileengine.testtask.web.PathConstants.*;


@RestController
@RequestMapping(value = IMAGE_PATH)
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;
    private final SearchService searchService;

    @GetMapping("/{page}")
    public ImageList loadImage(@PathVariable(name = "page") Integer page){
        return imageService.loadImages(page);
    }

    @GetMapping(SEARCH_PATH)
    public List<Image> searchImagesFullWord(@PathVariable(name = "searchTerm") String searchTerm,
                                            @RequestParam(value = "isFullWord", required = false) boolean fullWord){
        return searchService.search(searchTerm, fullWord);
    }
}
