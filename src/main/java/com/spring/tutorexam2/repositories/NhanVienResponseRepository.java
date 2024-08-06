package com.spring.tutorexam2.repositories;

import com.spring.tutorexam2.responses.NhanVienResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhanVienResponseRepository extends JpaRepository<NhanVienResponse, Integer> {

        @Query(
            value = "select " +
                    "nv.id AS id," +
                    "nv.ma AS ma," +
                    "CONCAT(nv.ho, ' ', nv.ten_dem, ' ', nv.ten) AS ho_ten," +
                    "nv.gioi_tinh AS gioi_tinh," +
                    "nv.dia_chi AS dia_chi," +
                    "cv.ten AS chuc_vu " +
                    "from nhan_vien nv join chuc_vu cv on nv.id_cv = cv.id",
            nativeQuery = true
    )
    List<NhanVienResponse> getNhanVienResponses();

    @Query(
            value = "select " +
                    "nv.id AS id," +
                    "nv.ma AS ma," +
                    "CONCAT(nv.ho, ' ', nv.ten_dem, ' ', nv.ten) AS ho_ten," +
                    "nv.gioi_tinh AS gioi_tinh," +
                    "nv.dia_chi AS dia_chi," +
                    "cv.ten AS chuc_vu " +
                    "from nhan_vien nv join chuc_vu cv on nv.id_cv = cv.id",
            nativeQuery = true
    )
    Page<NhanVienResponse> getPageNhanVienResponses(Pageable pageable);

}