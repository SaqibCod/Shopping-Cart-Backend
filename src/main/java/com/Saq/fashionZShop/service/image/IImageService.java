package com.Saq.fashionZShop.service.image;

import com.Saq.fashionZShop.dto.ImageDto;
import com.Saq.fashionZShop.model.Image;
import com.Saq.fashionZShop.model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IImageService {

    Image getImageById(Long id);
    List<ImageDto> saveImages(List<MultipartFile> files, Long product_id);
    void updateImage(MultipartFile file, Long image_id);
    void deleteImageById(Long id);

}
