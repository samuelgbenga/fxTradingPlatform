package com.fxsimulator.usermanagementservice.service.impl;

import com.cloudinary.Cloudinary;
import com.fxsimulator.usermanagementservice.dto.response.ImageResponseDto;
import com.fxsimulator.usermanagementservice.service.CloudinaryService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CloudinaryServiceImpl implements CloudinaryService {

    @Resource
    private Cloudinary cloudinary;

    @Override
    public ImageResponseDto uploadFile(MultipartFile file) {
        try{
            HashMap<Object, Object> options = new HashMap<>();
            options.put("folder", "fxs_img_folder");
            Map uploadedFile = cloudinary.uploader().upload(file.getBytes(), options);
            String publicId = (String) uploadedFile.get("public_id");
            String imgUrl = cloudinary.url().secure(true).generate(publicId);
            return new ImageResponseDto(publicId, imgUrl);

        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteFile(String publicId) {
        try {
            Map result = cloudinary.uploader().destroy(publicId, new HashMap<>());
            return "ok".equals(result.get("result"));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
