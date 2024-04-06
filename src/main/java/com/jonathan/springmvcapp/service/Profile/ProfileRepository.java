package com.jonathan.springmvcapp.service.Profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.jonathan.springmvcapp.model.Profile;

import jakarta.transaction.Transactional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Profile p SET p.texto = :texto, p.textoSecundario = :textoSecundario, p.about = :about, p.color = :color, p.background = :background WHERE p.id = :id")
    void updateProfile(@Param("id") int id, @Param("texto") String texto, @Param("textoSecundario") String textoSecundario, @Param("about") String about, @Param("color") String color, @Param("background") String background);

}