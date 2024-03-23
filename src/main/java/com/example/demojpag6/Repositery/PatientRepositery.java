package com.example.demojpag6.Repositery;

import com.example.demojpag6.Entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;

public interface PatientRepositery extends JpaRepository<Patient,Long> {
    List<Patient> findByMalade(boolean m);
//    Page<Patient> findByMalade(boolean m, Pageable p);
    List<Patient> findByMaladeAndScoreLessThan(boolean m,int s);
    List<Patient> findByMaladeIsTrueAndScoreLessThan(int s);
    List <Patient> findByDateNaissanceBetween(Date d1,Date d2);
    @Query("select p from  Patient p where p.dateNaissance between :x and :y or p.nom like :z")
    List<Patient> chercherPatients(@Param("x") Date d1,@Param("y") Date d2,@Param("z") String m);
}
