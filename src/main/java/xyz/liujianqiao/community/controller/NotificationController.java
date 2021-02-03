package xyz.liujianqiao.community.controller;

import xyz.liujianqiao.community.dto.NotificationDTO;
import xyz.liujianqiao.community.enums.NotificationTypeEnum;
import xyz.liujianqiao.community.model.Tourist;
import xyz.liujianqiao.community.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by codedrinker on 2019/6/14.
 */
@Controller
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/notification/{id}")
    public String profile(HttpServletRequest request,
                          @PathVariable(name = "id") Long id) {

//        User user = (User) request.getSession().getAttribute("user");
        Tourist tourist = (Tourist) request.getSession().getAttribute("tourist");
        if (tourist == null) {
            return "redirect:/";
        }
        NotificationDTO notificationDTO = notificationService.read(id, tourist);

        if (NotificationTypeEnum.REPLY_COMMENT.getType() == notificationDTO.getType()
                || NotificationTypeEnum.REPLY_QUESTION.getType() == notificationDTO.getType()) {
            return "redirect:/question/" + notificationDTO.getOuterid();
        } else {
            return "redirect:/";
        }
    }
}
