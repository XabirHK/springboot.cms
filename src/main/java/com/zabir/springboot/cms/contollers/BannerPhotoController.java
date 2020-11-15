package com.zabir.springboot.cms.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zabir.springboot.cms.models.BannerPhoto;
import com.zabir.springboot.cms.services.BannerPhotoService;

@RestController
public class BannerPhotoController {
	
	@Autowired
	private BannerPhotoService bannerPhotoService;
	
	@PostMapping("banner/add")
    public BannerPhoto addBannerPhoto(BannerPhoto bannerPhoto) {
        return bannerPhotoService.saveBannerPhoto(bannerPhoto);
    }

//    @BannerPhotoMapping("/bannerPhoto/addall")
//    public List<BannerPhoto> addBannerPhotos(@RequestBody List<BannerPhoto> bannerPhotos) {
//        return bannerPhotoService.saveBannerPhotos(bannerPhotos);
//    }

    @GetMapping("/banners")
    public List<BannerPhoto> findAllBannerPhotos() {
        return bannerPhotoService.getBannerPhotos();
    }

    @GetMapping("/banner/{id}")
    public BannerPhoto findBannerPhotoById(@PathVariable int id) {
        return bannerPhotoService.getBannerPhotoById(id);
    }

//    @GetMapping("/bannerPhoto/{name}")
//    public BannerPhoto findBannerPhotoByName(@PathVariable String name) {
//        return bannerPhotoService.getBannerPhotoByName(name);
//    }

    @PutMapping("banner/update")
    public BannerPhoto updateBannerPhoto(BannerPhoto bannerPhoto) {
        return bannerPhotoService.updateBannerPhoto(bannerPhoto);
    }

    @DeleteMapping("banner/delete/{id}")
    public String deleteBannerPhoto(@PathVariable int id) {
        return bannerPhotoService.deleteBannerPhoto(id);
    }
}
