package com.example.bank.service;

import com.example.bank.model.Notices;
import com.example.bank.repository.NoticesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticesServiceImpl implements NoticesService {
    NoticesRepository noticesRepository;
    @Autowired
    public NoticesServiceImpl(NoticesRepository noticesRepository) {
        this.noticesRepository = noticesRepository;
    }

    @Override
    public List<Notices> findAllActiveNotices() {
        List<Notices> notices=noticesRepository.findAllActiveNotices();
        return notices;
    }
}
