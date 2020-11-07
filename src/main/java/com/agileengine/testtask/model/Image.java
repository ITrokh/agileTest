package com.agileengine.testtask.model;

import com.google.common.collect.Lists;
import javafx.util.Pair;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@EqualsAndHashCode
public class Image implements Serializable {
    private String id;
    private String author;
    private String camera;
    private String tags;
    private String cropped_picture;
    private String full_picture;

    public static Pair<Image, List<String>> putImageToCache(Image image) {
        List<String> collect = Arrays.stream(image.getClass().getDeclaredFields()).flatMap(field -> {
            if (field.getName().contains("picture"))
                return Stream.empty();
            field.setAccessible(true);
            String param = null;
            try {
                param = (String) field.get(image);
            } catch (IllegalAccessException e) {
                //ignored
            }
            if (param == null) return Stream.empty();
            return Lists.newArrayList(param.split(" ")).stream();
        }).collect(Collectors.toList());
        return new Pair<>(image, collect);
    }
}
