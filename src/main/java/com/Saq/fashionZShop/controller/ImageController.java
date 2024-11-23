package com.Saq.fashionZShop.controller;

import com.Saq.fashionZShop.dto.ImageDto;
import com.Saq.fashionZShop.model.Image;
import com.Saq.fashionZShop.response.ApiResponse;
import com.Saq.fashionZShop.service.image.IImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/images")
public class ImageController {

    private final IImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<ApiResponse> saveImages(@RequestParam List<MultipartFile> files, @RequestParam Long productId){
        try {
            List<ImageDto> imageDtos = imageService.saveImages(files,productId);
            return ResponseEntity.ok(new ApiResponse("upload succesful", imageDtos));

        } catch (Exception e) {
           return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse("Upload failed", e.getMessage()));
        }
    }


//    public ResponseEntity<ApiResponse> downloadImage(@PathVariable Long imageId){
//        Image image = imageService.getImageById(imageId);
//    }


















}
