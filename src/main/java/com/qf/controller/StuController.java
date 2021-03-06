package com.qf.controller;

import com.qf.entity.Classes;
import com.qf.entity.Student;
import com.qf.service.IClassesService;
import com.qf.service.IStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/stu")
public class StuController {


    @Autowired
    private IStuService stuService;

    @Autowired
    private IClassesService classesService;

    @RequestMapping("/list")
    public String stuList(Model model){
        List<Student> students = stuService.queryAll();
        model.addAttribute("stus", students);
        return "stulist";
    }

    @RequestMapping("/toadd")
    public String toAdd(Model model){
        //
        List<Classes> classes = classesService.queryAll();
        model.addAttribute("classes", classes);
        return "stuadd";
    }

    @RequestMapping("/insert")
    public String insert(Student student){
        stuService.insertStu(student);
        return "redirect:/stu/list";
    }

    @RequestMapping("/delete")
    public String delete(int sid){
        stuService.deleteStu(sid);
        return "redirect:/stu/list";
    }

}
