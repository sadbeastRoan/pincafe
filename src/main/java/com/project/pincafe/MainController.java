package com.project.pincafe;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;


import com.project.pincafe.common.SessionUtil;
import com.project.pincafe.user.UserDAO;
import com.project.pincafe.user.UserTblVO;

@Controller
public class MainController {

    @Autowired
    UserDAO userDAO;
    
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login()
    {
        return "login";
    }

    // 아이디 패스워드를 넘겨서 로그인을 실제로 처리해달라는 요청.
    @PostMapping("/login")
    public void login(@ModelAttribute("UserTblVO") UserTblVO vo,
                      HttpServletRequest request, 
                      HttpServletResponse response) throws Exception
    {
        
        UserTblVO resultVO = userDAO.selectOneUser(vo);

        if (resultVO == null)
        {
            response.sendRedirect("login");
            System.out.println("로그인 실패");

        }
        else
        {
            
            SessionUtil.set(request, "USER", resultVO);
            response.sendRedirect("index");            
            System.out.println("로그인 성공");
            System.out.println(resultVO);
            
        }
        
    }


}   
