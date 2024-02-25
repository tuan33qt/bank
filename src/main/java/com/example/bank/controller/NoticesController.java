package com.example.bank.controller;

import com.example.bank.model.Notices;
import com.example.bank.service.NoticesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NoticesController {
    private NoticesService noticesService;
    @Autowired
    public NoticesController(NoticesService noticesService) {
        this.noticesService = noticesService;
    }
    @GetMapping("/mynotices")
    public List<Notices> getNotices() {
        List<Notices> notices=noticesService.findAllActiveNotices();
        if (notices != null) {
            return notices;
        }else {
            throw new RuntimeException("Notice is not found ");
        }
    }
}
