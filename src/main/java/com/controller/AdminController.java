package com.controller;

import com.entity.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.AdminService;
import com.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/*.do")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/login.do")
    public String login(){
        return "admin/login";
    }

    @RequestMapping("/doLogin.do")
    public String doLogin(@RequestParam(required = false,defaultValue = "0")int remember, Admin admin, HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model){


        Admin result=adminService.selectAdmin(admin);

        //System.out.println(result);
        if (result!=null){
            session.setAttribute("currentAdmin",result);

            if (remember==1){//选中记住
                //创建cookie对象
                Cookie cookie1=new Cookie("name",result.getUsername());
                Cookie cookie2=new Cookie("pwd",result.getPassword());
                cookie1.setMaxAge(60*60*24);//1天
                cookie2.setMaxAge(60*60*24);
                cookie1.setPath("/");
                cookie2.setPath("/");//设置有效范围，/ 为全路径
                response.addCookie(cookie1);
                response.addCookie(cookie2);

            }else {//没选中记住
                Cookie[] cookies=request.getCookies();
                for (Cookie cookie:cookies){
                    if (cookie.getName().equals(admin.getUsername())){
                        cookie.setMaxAge(0);
                        cookie.setPath("/");
                        response.addCookie(cookie);
                    }
                }
            }

            return "admin/index";
        }else{
            model.addAttribute("error","账号或密码错误！");
            return "admin/login";
        }
    }

/////////////////////////////////////////////////////////
    @RequestMapping("/indexUser.do")
    public String indexUser(){
        return "admin/index";
    }

    @RequestMapping("/manageUser.do")
    @ResponseBody
    public Msg manageUser(@RequestParam(value = "pn",defaultValue = "1") Integer pn){

        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn,7);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<User> myList=adminService.selectAllUser();

        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo pageInfo=new PageInfo(myList,3);//显示3个按钮

        return Msg.success().add("pageInfo",pageInfo);
    }

    @RequestMapping("/deleteUser.do")
    @ResponseBody
    public Msg deleteUser(@RequestParam(value = "uid",required = false) Integer uid){

        Integer result=adminService.deleteUserByUid(uid);

        if (result>0){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }

    ////////////////////////////////////////////////////////////////


    @RequestMapping("/indexWork.do")
    public String indexWork(){
        return "admin/index-work";
    }

    @RequestMapping("/manageWork.do")
    @ResponseBody
    public Msg manageWork(@RequestParam(value = "pn",defaultValue = "1") Integer pn){

        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn,7);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<WorksInfo> myList=adminService.selectAllWorksInfo();

        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo pageInfo=new PageInfo(myList,3);//显示3个按钮

        return Msg.success().add("pageInfo",pageInfo);
    }

    @RequestMapping("/deleteWork.do")
    @ResponseBody
    public Msg deleteWork(@RequestParam(value = "workId",required = false) Integer workId){

        Integer result=adminService.deleteWorkByWorkId(workId);

        if (result>0){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }

    ////////////////////////////////////////////////////////////////////////

    @RequestMapping("/indexComment.do")
    public String indexComment(){
        return "admin/index-comment";
    }

    @RequestMapping("/manageComment.do")
    @ResponseBody
    public Msg manageComment(@RequestParam(value = "pn",defaultValue = "1") Integer pn){

        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn,7);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<CommentInfo> myList=adminService.selectAllComment();

        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo pageInfo=new PageInfo(myList,3);//显示3个按钮

        return Msg.success().add("pageInfo",pageInfo);
    }

    @RequestMapping("/deleteComment.do")
    @ResponseBody
    public Msg deleteComment(@RequestParam(value = "commentId",required = false) Integer commentId){

        Integer result=adminService.deleteCommentByCommentId(commentId);

        if (result>0){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
}
