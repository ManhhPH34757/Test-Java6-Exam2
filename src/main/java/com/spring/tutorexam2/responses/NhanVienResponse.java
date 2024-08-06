package com.spring.tutorexam2.responses;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class NhanVienResponse {

    @Id
    private Integer id;

    private String ma;

    private String hoTen;

    private String gioiTinh;

    private String diaChi;

    private String chucVu;

}
