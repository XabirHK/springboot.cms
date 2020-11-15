package com.zabir.springboot.cms.repositories;

import org.springframework.stereotype.Repository;

import com.zabir.springboot.cms.models.BannerPhoto;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BannerPhotoRepository extends  JpaRepository <BannerPhoto, Integer>{
	
}
