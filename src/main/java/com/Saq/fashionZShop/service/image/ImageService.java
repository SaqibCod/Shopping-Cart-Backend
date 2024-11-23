package com.Saq.fashionZShop.service.image;

import com.Saq.fashionZShop.dto.ImageDto;
import com.Saq.fashionZShop.exceptions.ResourceNotFoundException;
import com.Saq.fashionZShop.model.Image;
import com.Saq.fashionZShop.repository.ImageRepository;
import com.Saq.fashionZShop.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.Saq.fashionZShop.model.Product;
import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService implements IImageService{

    private final ProductService productService;
    private final ImageRepository imageRepository;

    @Override
    public Image getImageById(Long id) {
        return imageRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Image not found"));
    }

    @Override
    public List<ImageDto> saveImages(List<MultipartFile> files, Long product_id) {

        Product product = productService.getProductById(product_id);
        List<ImageDto> savedImageDto = new ArrayList<>();
        
        for (MultipartFile file: files){
            try {
                Image image = new Image();
                image.setFileName(file.getOriginalFilename());
                image.setFileType(file.getContentType());
                image.setImage(new SerialBlob(file.getBytes()));
                image.setProduct(product);

                String downloadUrl = "api/v1/images/image/download" + image.getId();
                image.setDownloadUrl(downloadUrl);
                Image savedimage = imageRepository.save(image);

                savedimage.setDownloadUrl("api/v1/images/image/download" + savedimage.getId());
                imageRepository.save(savedimage);

                ImageDto imageDto = new ImageDto();
                imageDto.setImageId(savedimage.getId());
                imageDto.setImageName(savedimage.getFileName());
                imageDto.setDownloadUrl(savedimage.getDownloadUrl());
                savedImageDto.add(imageDto);

            } catch(IOException | SQLException e){
                throw new RuntimeException(e.getMessage());
            }
        }
        return savedImageDto;
    }

    @Override
    public void updateImage(MultipartFile file, Long image_id) {
        Image image = getImageById(image_id);
        try{
            image.setFileName(file.getOriginalFilename());
            image.setFileType(file.getContentType());
            image.setImage(new SerialBlob(file.getBytes()));
            imageRepository.save(image);

        } catch (IOException | SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deleteImageById(Long id) {
        imageRepository.findById(id).ifPresentOrElse(imageRepository :: delete,() ->{
            throw new ResourceNotFoundException("Image not found with id: " + id);
        } );
    }
}
