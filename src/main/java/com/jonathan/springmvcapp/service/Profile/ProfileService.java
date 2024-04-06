package com.jonathan.springmvcapp.service.Profile;

import com.jonathan.springmvcapp.model.Person;
import com.jonathan.springmvcapp.model.Profile;

public interface ProfileService {

   public Profile createrProfile(Profile person);

   public Profile getProfile(Integer id); 

   public boolean setProfile(Profile profile, Integer id); 

}
