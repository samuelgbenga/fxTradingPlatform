package com.fxsimulator.usermanagementservice.repository;

import com.fxsimulator.usermanagementservice.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, String> {
}
