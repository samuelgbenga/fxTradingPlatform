package com.fxsimulator.usermanagementservice.service;



import com.fxsimulator.usermanagementservice.dto.response.ImageResponseDto;
import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {

    ImageResponseDto uploadFile(MultipartFile file);

    boolean deleteFile(String publicId);
}