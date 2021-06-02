package com.api.apis.utils;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class ApiUtils {


    public List<String> listFilesUsingFilesList(String dir) throws IOException {
        Stream<Path> stream = Files.list(Paths.get(dir));
        return stream.filter(file -> !Files.isDirectory(file)).map(Path::getFileName).map(Path::toString).collect(Collectors.toList());
    }

    public int getRandomNumber(int init, int end){
        return ThreadLocalRandom.current().nextInt(init, end + 1);
    }

    public ByteArrayResource getImgResize(String path) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        Thumbnails.of(path).size(200, 200).outputFormat("jpg").toOutputStream(os);
        return new ByteArrayResource(os.toByteArray());
    }

}
