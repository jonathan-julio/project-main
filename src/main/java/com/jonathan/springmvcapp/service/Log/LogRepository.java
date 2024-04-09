package com.jonathan.springmvcapp.service.Log;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jonathan.springmvcapp.model.Log;

@Repository
public interface LogRepository extends JpaRepository<Log, Integer> {

}