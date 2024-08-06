package com.spring.tutorexam2.services;

import com.spring.tutorexam2.entities.ChucVu;
import com.spring.tutorexam2.repositories.ChucVuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChucVuService {

    @Autowired
    private ChucVuRepository chucVuRepository;

    public ChucVu getChucVu(Integer id) {
        return chucVuRepository.findById(id).orElse(null);
    }

}
