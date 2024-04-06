package com.jonathan.springmvcapp.service.Profile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jonathan.springmvcapp.model.Profile;

@Component
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    @SuppressWarnings("null")
    @Override
    public Profile createrProfile(Profile profile) {
        try {
            return profileRepository.saveAndFlush(profile);

        } catch (Exception e) {
            System.out.println(e);
            return new Profile();
        }
    }

    @Override
    public Profile getProfile(Integer id) {
        List<Profile> profiles =  profileRepository.findAll();
        Profile profile = new Profile();
        for (Profile _profile : profiles) {
            if (_profile.getId().equals(id)) {
                profile = _profile;
            }
        }
        return profile;
    }

    @Override
    public boolean setProfile(Profile profile,Integer id) {

       
        try {
            profileRepository.updateProfile(id,profile.getTexto(), profile.getTextoSecundario(), profile.getAbout(), profile.getColor(), profile.getBackground());
            return true;
        } catch (Exception e) {
            
            System.out.println("AQUI e : " + e);
            return false;
        } 
         
    }


}
