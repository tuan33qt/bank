package com.example.bank.service;

import com.example.bank.model.Notices;

import java.util.List;

public interface NoticesService {
    List<Notices> findAllActiveNotices();
}
