package com.jonathan.springmvcapp.service.Log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jonathan.springmvcapp.model.Log;

@Component
public class LogServiceImpl implements LogService {

    @Autowired
    LogRepository logRepository;

    @Override
    public void newLog(Log log) {
        logRepository.save(log);
    }

}
