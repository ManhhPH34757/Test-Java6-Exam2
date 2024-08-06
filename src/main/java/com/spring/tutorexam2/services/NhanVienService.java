package com.spring.tutorexam2.services;

import com.spring.tutorexam2.entities.NhanVien;
import com.spring.tutorexam2.repositories.NhanVienRepository;
import com.spring.tutorexam2.repositories.NhanVienResponseRepository;
import com.spring.tutorexam2.responses.NhanVienResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Autowired
    private NhanVienResponseRepository nhanVienResponseRepository;

    public List<NhanVienResponse> getNhanVienResponses() {
        return nhanVienResponseRepository.getNhanVienResponses();
    }

    public Page<NhanVienResponse> getPage(Pageable pageable) {
        return nhanVienResponseRepository.getPageNhanVienResponses(pageable);
    }

    public NhanVien findById(Integer id) {
        return nhanVienRepository.findById(id).orElse(null);
    }

    public NhanVien save(NhanVien nv) {
        return nhanVienRepository.save(nv);
    }
}
