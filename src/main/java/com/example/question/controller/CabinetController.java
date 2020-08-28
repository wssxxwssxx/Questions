package com.example.question.controller;

import com.example.question.entity.User;
import com.example.question.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;


@Controller
public class CabinetController {

    @Autowired
    private UserRepository userRepository;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/cabinet")
    public String cabinet(){
        return "cabinet.html";
    }

    @PostMapping("/cabinet")
    public String add(@RequestParam("file") MultipartFile file,
                      Model model) throws IOException {

        User user = new User();

        Iterable<User> users = userRepository.findAll();

        if(file != null && !file.getOriginalFilename().isEmpty()){
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            user.setFilename(resultFilename);

        }

        model.addAttribute("users",users);

        return "cabinet";
    }
}
