package com.zabir.springboot.cms.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zabir.springboot.cms.models.BannerPhoto;
import com.zabir.springboot.cms.services.BannerPhotoService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class BannerPhotoController {
	
	@Autowired
	private BannerPhotoService bannerPhotoService;
	
	@PostMapping("banner/add")
    public BannerPhoto addBannerPhoto(BannerPhoto bannerPhoto) {
        return bannerPhotoService.saveBannerPhoto(bannerPhoto);
    }

    @GetMapping("/banners")
    public List<BannerPhoto> findAllBannerPhotos() {
        return bannerPhotoService.getBannerPhotos();
    }

    @GetMapping("/banner/{id}")
    public BannerPhoto findBannerPhotoById(@PathVariable int id) {
        return bannerPhotoService.getBannerPhotoById(id);
    }

    @PutMapping("banner/update")
    public BannerPhoto updateBannerPhoto(BannerPhoto bannerPhoto) {
        return bannerPhotoService.updateBannerPhoto(bannerPhoto);
    }

    @DeleteMapping("banner/delete/{id}")
    public String deleteBannerPhoto(@PathVariable int id) {
        return bannerPhotoService.deleteBannerPhoto(id);
    }
}
