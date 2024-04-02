package com.jonathan.springmvcapp.service.Profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jonathan.springmvcapp.model.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

}