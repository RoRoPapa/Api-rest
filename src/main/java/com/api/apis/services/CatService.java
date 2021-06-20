package com.api.apis.services;

import com.api.apis.enums.CatMod;
import com.api.apis.utils.ApiUtils;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class CatService {

    private String basePath = "/home/roo/Documents/Devops/Api-rest/src/main/resources/static/img/";
    final ApiUtils apiUtils;

    public CatService(ApiUtils apiUtils) {
        this.apiUtils = apiUtils;
    }

    public ByteArrayResource getImg(String mod) throws IOException, IllegalAccessException {
        CatMod catMod = CatMod.getIgnoreCase(mod);
        List<String> imgNames = apiUtils.listFilesUsingFilesList(basePath+catMod.getPath());
        String randomImgName = imgNames.get(apiUtils.getRandomNumber(0, imgNames.size() -1));
        return apiUtils.getImgResize(basePath+catMod.getPath()+randomImgName);
    }

    public ByteArrayResource getGif(String mod) throws IOException {
        return new ByteArrayResource(Files.readAllBytes(Paths.get("/home/silentsudo/Videos/dum111111b.jpg")));
    }
}
