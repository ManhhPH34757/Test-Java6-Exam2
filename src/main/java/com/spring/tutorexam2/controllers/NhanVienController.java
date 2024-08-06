package com.spring.tutorexam2.controllers;

import com.spring.tutorexam2.entities.NhanVien;
import com.spring.tutorexam2.requests.NhanVienRequest;
import com.spring.tutorexam2.responses.NhanVienResponse;
import com.spring.tutorexam2.services.ChucVuService;
import com.spring.tutorexam2.services.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staffs")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private ChucVuService chucVuService;

    @GetMapping()
    public List<NhanVienResponse> getNhanVienResponses() {
        return nhanVienService.getNhanVienResponses();
    }

    @GetMapping("/page")
    public Page<NhanVienResponse> getPage(Pageable pageable) {
        return nhanVienService.getPage(pageable);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NhanVien> updateNhanVienResponse(@PathVariable Integer id, @Validated @RequestBody NhanVienRequest nhanVienRequest, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body((NhanVien) result.getAllErrors());
        }

        if(nhanVienService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        NhanVien nv = new NhanVien();
        nv.setId(id);
        nv.setMa(nhanVienRequest.getMa());
        nv.setHo(nhanVienRequest.getHo());
        nv.setTenDem(nhanVienRequest.getTenDem());
        nv.setTen(nhanVienRequest.getTen());
        nv.setGioiTinh(nhanVienRequest.getGioiTinh());
        nv.setDiaChi(nhanVienRequest.getDiaChi());
        nv.setSdt(nhanVienRequest.getSdt());
        nv.setIdCv(chucVuService.getChucVu(nhanVienRequest.getIdCv()));
        nv.setMatKhau(nhanVienRequest.getMatKhau());
        nv.setTrangThai(nhanVienRequest.getTrangThai());

        return ResponseEntity.ok(nhanVienService.save(nv));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NhanVien> getNhanVienById(@PathVariable Integer id) {
        NhanVien nv = nhanVienService.findById(id);
        if(nv == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(nv);
    }



}
