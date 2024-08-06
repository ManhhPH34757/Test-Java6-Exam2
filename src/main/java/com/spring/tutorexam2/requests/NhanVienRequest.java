package com.spring.tutorexam2.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NhanVienRequest {
    @NotEmpty(message = "Ma couldn't be null")
    private String ma;
    @NotEmpty(message = "Ho couldn't be null")
    private String ho;
    @NotEmpty(message = "Ten dem couldn't be null")
    private String tenDem;
    @NotEmpty(message = "Ten couldn't be null")
    private String ten;
    @NotEmpty(message = "Gioi tinh couldn't be null")
    private String gioiTinh;
    @NotEmpty(message = "Dia chi couldn't be null")
    private String diaChi;
    @NotEmpty(message = "So dien thoai couldn't be null")
    private String sdt;
    @NotNull(message = "Id Cv couldn't be null")
    private Integer idCv;
    @NotEmpty(message = "Mat khau couldn't be null")
    private String matKhau;
    @NotNull(message = "Trang thai couldn't be null")
    private Integer trangThai;
}
