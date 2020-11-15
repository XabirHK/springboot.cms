package com.zabir.springboot.cms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zabir.springboot.cms.models.BannerPhoto;
import com.zabir.springboot.cms.repositories.BannerPhotoRepository;


@Service
public class BannerPhotoService {
	@Autowired
	private BannerPhotoRepository bannerPhotoRepository;
	
	public BannerPhoto saveBannerPhoto(BannerPhoto bannerPhoto) {
		 return bannerPhotoRepository.save(bannerPhoto);
    }

    public List<BannerPhoto> saveBannerPhotos(List<BannerPhoto> BannerPhotos) {
        return bannerPhotoRepository.saveAll(BannerPhotos);
    }

    public List<BannerPhoto> getBannerPhotos() {
        return bannerPhotoRepository.findAll();
    }

    public BannerPhoto getBannerPhotoById(int id) {
        return bannerPhotoRepository.findById(id).orElse(null);
    }

//    public BannerPhoto getBannerPhotoByName(String name) {
//        return bannerPhotoRepository.findByName(name);
//    }

    public String deleteBannerPhoto(int id) {
    	bannerPhotoRepository.deleteById(id);
        return "BannerPhoto removed !! " + id;
    }
    
    
    public BannerPhoto updateBannerPhoto(BannerPhoto BannerPhoto) {
        BannerPhoto existingBannerPhoto = bannerPhotoRepository.findById(BannerPhoto.getId()).orElse(null);

        existingBannerPhoto.setTitle(BannerPhoto.getTitle());
        existingBannerPhoto.setDescription(BannerPhoto.getDescription());
        existingBannerPhoto.setPicture(BannerPhoto.getPicture());
       
        return bannerPhotoRepository.save(existingBannerPhoto);
    }
}
