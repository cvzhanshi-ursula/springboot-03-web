package cn.cvzhanshi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


/**
 * @author cVzhanshi
 * @create 2021-06-15 22:05
 */
@Controller
public class LoginController {
    @RequestMapping("/user/login")
    public String login(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password")String password,
                        Model model, HttpSession session){
        //具体的业务
        if (!StringUtils.isEmpty(username) && "123456".equals(password)){
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else {
            //告知用户登录失败
            model.addAttribute("msg","用户名或者密码错误!");
            return "index";
        }
    }
}
