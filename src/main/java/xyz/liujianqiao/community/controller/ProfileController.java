package xyz.liujianqiao.community.controller;

import xyz.liujianqiao.community.dto.PaginationDTO;
import xyz.liujianqiao.community.model.Tourist;
import xyz.liujianqiao.community.service.NotificationService;
import xyz.liujianqiao.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by codedrinker on 2019/5/15.
 */
@Controller
public class ProfileController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private NotificationService notificationService;

    @GetMapping("/profile/{action}")
    public String profile(HttpServletRequest request,
                          @PathVariable(name = "action") String action,
                          Model model,
                          @RequestParam(name = "page", defaultValue = "1") Integer page,
                          @RequestParam(name = "size", defaultValue = "5") Integer size) {

//        User user = (User) request.getSession().getAttribute("user");
        Tourist user = (Tourist) request.getSession().getAttribute("tourist");
        if (user == null) {
            return "redirect:/";
        }

        if ("questions".equals(action)) {
            model.addAttribute("section", "questions");
            model.addAttribute("sectionName", "我的提问");
            PaginationDTO paginationDTO = questionService.list(user.getUser_id(), page, size);
            model.addAttribute("pagination", paginationDTO);
        } else if ("replies".equals(action)) {
            PaginationDTO paginationDTO = notificationService.list(user.getUser_id(), page, size);
            model.addAttribute("section", "replies");
            model.addAttribute("pagination", paginationDTO);
            model.addAttribute("sectionName", "最新回复");
        }
        return "profile";
    }
    @GetMapping("/del")
    public String del(Long id, Model model){
        int del = questionService.del(id);
        if (del>0){
            model.addAttribute("del","删除成功");
            return "redirect:/";
        }else {
            model.addAttribute("del","删除失败");
            return "redirect:/";
        }
    }
}
