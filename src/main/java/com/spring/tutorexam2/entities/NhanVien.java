package com.spring.tutorexam2.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "nhan_vien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotEmpty(message = "Ma couldn't be null")
    @Column(name = "ma", length = 20)
    private String ma;

    @NotEmpty(message = "Ten couldn't be null")
    @Nationalized
    @Column(name = "ten", length = 30)
    private String ten;

    @NotEmpty(message = "Ten dem couldn't be null")
    @Nationalized
    @Column(name = "ten_dem", length = 30)
    private String tenDem;

    @NotEmpty(message = "Ho couldn't be null")
    @Nationalized
    @Column(name = "ho", length = 30)
    private String ho;

    @NotEmpty(message = "Gioi tinh couldn't be null")

    @Nationalized
    @Column(name = "gioi_tinh", length = 10)
    private String gioiTinh;

    @NotEmpty(message = "Dia chi couldn't be null")
    @Nationalized
    @Column(name = "dia_chi", length = 100)
    private String diaChi;

    @NotEmpty(message = "So dien thoai couldn't be null")

    @Column(name = "sdt", length = 30)
    private String sdt;

    @NotNull(message = "Id Cv couldn't be null")
    @Column(name = "mat_khau", length = 50)
    private String matKhau;

    @NotEmpty(message = "Mat khau couldn't be null")
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_cv")
    private ChucVu idCv;

    @NotNull(message = "Trang thai couldn't be null")
    @Column(name = "trang_thai")
    private Integer trangThai;

}