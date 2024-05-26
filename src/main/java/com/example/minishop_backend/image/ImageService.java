package com.example.minishop_backend.image;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;
    public List<Image> getImages(){
        return imageRepository.findAll();
    }
    public void addImage(Image image){
        imageRepository.save(image);
    }
    @Transactional
    public void updateImage(Long id,String url){
        Image oldImage = imageRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Image with id " + id + " does not exists"));
        if(url != null &&
                !url.isEmpty()&&
                !Objects.equals(oldImage.getUrl(),url)){
            oldImage.setUrl(url);
        }
    }
    public void deleteImage(Long id){
        boolean exists = imageRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("image with id " + id + " does not exists");
        }
        imageRepository.deleteById(id);
    }
}
