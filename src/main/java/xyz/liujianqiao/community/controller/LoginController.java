package xyz.liujianqiao.community.controller;



import com.alibaba.fastjson.JSON;
import xyz.liujianqiao.community.model.Tourist;
import xyz.liujianqiao.community.service.TouristService;
import xyz.liujianqiao.community.utils.FileTool;
import xyz.liujianqiao.community.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;

@Controller
public class LoginController {
    @Autowired
    private TouristService touristService;


    @RequestMapping("/tologin")
    public String tolog(){
        return "login";
    }
    @RequestMapping("/tores")
    public String tores(){
        return "resgist";
    }
    @PostMapping("/tourist")
    public String login(@RequestParam("usercode") String usercode, @RequestParam("password") String password, Model model, HttpSession session) {
        model.addAttribute("usercode",usercode);
        model.addAttribute("password",password);
        Tourist t = new Tourist();
        if (usercode == null || usercode == ""||password == null || password == ""){
            if (usercode == null || usercode == "" ) {
                model.addAttribute("error","账号不为空");

            }
            if (password == null || password == "") {
                model.addAttribute("error","密码不能为空");

            }
            return "login";
        }else {

            Tourist tourist = touristService.find(usercode, MD5Utils.getStrMD5(password));
            System.out.println(JSON.toJSON(tourist));

            if (tourist != null) {
//                session.setAttribute("tourist", tourist);
                session.setAttribute("tourist",tourist);
                return "redirect:/";
            }
            model.addAttribute("error", "账号 密码错误");
            return "login";
        }
    }
    @PostMapping("/res")
    public String res(@RequestParam(value = "file", required = false) MultipartFile multipartFile, @RequestParam("usercode") String usercode, @RequestParam("mm") String password,
                      @RequestParam("username") String username, @RequestParam("email") String email,Model model) {
//        String pa =  publishController.class.getClassLoader().getResource("static/images").toString();
//        String path = StrUtil.subSuf(pa,6);
//        model.addAttribute("zh", usercode);
//        model.addAttribute("nc", username);
//        model.addAttribute("email", email);
//        model.addAttribute("mm", password);
//        model.addAttribute("file", multipartFile);
//          if (usercode == null || usercode == "") {
//                model.addAttribute("error", "账号不为空");
//            return "resgist";
//
//            }  if (username == null || username == "") {
//                model.addAttribute("error", "昵称不为空");
//            return "resgist";
//
//            }  if (email == null || email == "") {
//                model.addAttribute("error", "邮箱不为空");
//            return "resgist";
//
//            }    if (password == null || password == "") {
//                model.addAttribute("error", "密码不能为空");
//            return "resgist";
//
//            }
//



        //    String path ="F:\\image
        String path ="C:\\n\\community\\src\\main\\resources\\static\\images";
        File f = new File(path);
        String originalFilename = multipartFile.getOriginalFilename();
        String a = FileTool.filePath(f, originalFilename);
        System.out.println(a);
        String s = a.substring(a.lastIndexOf("\\") - 7);

        FileTool.FILEUPLOAD(multipartFile, a);

        Tourist tourist = new Tourist();
        tourist.setUser_code(usercode);
        tourist.setUser_email(email);
        tourist.setUser_name(username);
        tourist.setUser_password(MD5Utils.getStrMD5(password));
        tourist.setUser_state(1);
        tourist.setUser_photo(s);
        tourist.setExp("魂士");
        int insert = touristService.insert(tourist);
        System.out.print(insert);
//            if (insert > 0) {
//                model.addAttribute("error","注册成功请登录");
//                return "resgist";
//            }
//            System.out.println(insert);
//            model.addAttribute("error","注册失败 ，请重新注册");
        return "redirect:tologin";
    }
    @PostMapping("/los")
    public String res( @RequestParam("usercode") String usercode, @RequestParam("password") String password,
                       @RequestParam("email") String email,Model model) {

        int update = touristService.update(email, MD5Utils.getStrMD5(password), usercode);
        if (update>0){
            model.addAttribute("err","修改成功");
            return "redirect:/tologin";
        }
        else {
            model.addAttribute("err","修改失败，请检查账号或者邮箱是否正确");
            return "lose";
        }

    }
    @RequestMapping("/tolos")
    public String tolos(){
        return "lose";
    }


}
