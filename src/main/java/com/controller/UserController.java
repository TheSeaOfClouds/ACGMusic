package com.controller;

import com.entity.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.UserService;
import com.service.WorkService;
import com.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private WorkService workService;


    //////////////////////////////////////////////////////////////
    //index
    @RequestMapping("/")
    public String index(Model model){

        List<WorksInfo> worksRandom=workService.selectWorksRandom7();//首页7个作品
        List<WorksInfo> acgAnimeLimit=userService.selectAcgByTypeLimit("ACG动漫");
        List<WorksInfo> acgMusicLimit=userService.selectAcgByTypeLimit("ACG音乐");
        List<WorksInfo> acgGameLimit=userService.selectAcgByTypeLimit("ACG游戏");
        List<WorksInfo> acgPhotoLimit=userService.selectAcgByTypeLimit("ACG图片");

        //List<User> users=userService.selectUsersByBombNum();//用户积分排行
        List<User> usersLimit=userService.selectUsersByBombNumLimit6();//用户积分排行6

        //List<WorksInfo> worksInfos=userService.selectWorksByLookNum();//作品访问量排行
        List<WorksInfo> worksInfosLimit=userService.selectWorksByLookNumLimit6();//作品访问量排行6
        List<WorksInfo> worksInfosLimit4=userService.selectWorksByLookNumLimit4();//作品访问量排行4

        List<CommentInfo> commentLimit=userService.selectCommentLimit();

        model.addAttribute("acgAnimeLimit",acgAnimeLimit);
        model.addAttribute("acgMusicLimit",acgMusicLimit);
        model.addAttribute("acgGameLimit",acgGameLimit);
        model.addAttribute("acgPhotoLimit",acgPhotoLimit);
        model.addAttribute("worksRandom",worksRandom);

        model.addAttribute("commentLimit",commentLimit);

        //model.addAttribute("users",users);
        model.addAttribute("usersLimit",usersLimit);
        //model.addAttribute("worksInfos",worksInfos);
        model.addAttribute("worksInfosLimit",worksInfosLimit);
        model.addAttribute("worksInfosLimit4",worksInfosLimit4);
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public Msg addUser(User user){

        userService.addUser(user);

        User user1=userService.findUserByEmail(user.getEmail());
        workService.addBombRecord(new BombRecord(user1.getUid(),0,10,"注册成功加10猫爪"));
        return Msg.success();
    }

    @RequestMapping("/doLogin")
    @ResponseBody
    public Msg doLogin(@RequestParam(required = false,defaultValue = "0")int remember, User user, HttpServletRequest request, HttpServletResponse response, HttpSession session,Model model){

        User result=userService.findUserByEmailAndPassword(user);
        //System.out.println(result);
        if (result!=null){
            session.setAttribute("currentUser",result);

            if (remember==1){//选中记住
                //创建cookie对象
                Cookie cookie1=new Cookie("email",result.getEmail());
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
                    if (cookie.getName().equals(user.getEmail())){
                        cookie.setMaxAge(0);
                        cookie.setPath("/");
                        response.addCookie(cookie);
                    }
                }
            }


            BombRecord bombRecord=workService.findBombNumByUid(result.getUid()).get(0);
            bombRecord.setBombNum(bombRecord.getBombNum()+5);

            bombRecord.setBombHistory("登录成功加5猫爪");
            workService.updateBombNumByUid(bombRecord);
            workService.addBombRecord(bombRecord);

            return Msg.success();
        }else{
            model.addAttribute("error","账号或密码错误！");
            return Msg.fail().add("error","账号或密码错误！");
        }
    }

    @RequestMapping("/acgAnime")
    public String acgAnime(){
        return "acgAnime";
    }

    @RequestMapping("/doAcgAnime")
    @ResponseBody
    public Msg doAcgAnime(@RequestParam(value = "pn",defaultValue = "1") Integer pn){

        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn,8);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<WorksInfo> list=userService.selectAcgByType("ACG动漫");

        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo pageInfo=new PageInfo(list,3);//显示3个按钮

        return Msg.success().add("pageInfo",pageInfo);
    }



    @RequestMapping("/acgMusic")
    public String acgMusic(){
        return "acgMusic";
    }

    @RequestMapping("/doAcgMusic")
    @ResponseBody
    public Msg doAcgMusic(@RequestParam(value = "pn",defaultValue = "1") Integer pn){

        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn,8);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<WorksInfo> list=userService.selectAcgByType("ACG音乐");

        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo pageInfo=new PageInfo(list,3);//显示3个按钮

        return Msg.success().add("pageInfo",pageInfo);
    }



    @RequestMapping("/acgGame")
    public String acgGame(){
        return "acgGame";
    }

    @RequestMapping("/doAcgGame")
    @ResponseBody
    public Msg doAcgGame(@RequestParam(value = "pn",defaultValue = "1") Integer pn){

        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn,8);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<WorksInfo> list=userService.selectAcgByType("ACG游戏");

        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo pageInfo=new PageInfo(list,3);//显示3个按钮

        return Msg.success().add("pageInfo",pageInfo);
    }





    @RequestMapping("/acgPhoto")
    public String acgPhoto(){
        return "acgPhoto";
    }

    @RequestMapping("/doAcgPhoto")
    @ResponseBody
    public Msg doAcgPhoto(@RequestParam(value = "pn",defaultValue = "1") Integer pn){

        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn,8);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<WorksInfo> list=userService.selectAcgByType("ACG图片");

        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo pageInfo=new PageInfo(list,3);//显示3个按钮

        return Msg.success().add("pageInfo",pageInfo);
    }


    //////////////////////////////////////////////////////////////
    //user
    @RequestMapping("/authorIndex")
    public String authorIndex(@RequestParam(value = "uid",required = false)Integer uid,Model model){

        User user=userService.findUserByUid(uid);
        Integer commentCount=workService.selectCommentCountByUid(uid);
        Integer workCount=workService.selectWorksCount(uid);
        Integer bombCount=workService.findBombNumByUid(uid).get(0).getBombNum();

        model.addAttribute("workCount",workCount);
        model.addAttribute("commentCount",commentCount);
        model.addAttribute("bombCount",bombCount);
        model.addAttribute("user",user);
        return "user/author-index";
    }

    @RequestMapping("/authorWorks")
    public String authorWorks(@RequestParam(value = "uid",required = false)Integer uid,Model model){

        User user=userService.findUserByUid(uid);
        List<WorksInfo> list=workService.selectWorksByUid(uid);
        List<Integer> commentCountList=new ArrayList<>();
        for (int i=0;i<list.size();i++){
            commentCountList.add(i,workService.selectCommentCountByWorkId(list.get(i).getWorkId()));
        }

        model.addAttribute("user",user);
        model.addAttribute("list",list);
        model.addAttribute("commentCountList",commentCountList);
        return "user/author-works";
    }

    @RequestMapping("/ranking")
    public String ranking(){
        return "ranking";
    }

    @RequestMapping("rankingHot")
    @ResponseBody
    public Msg rankingHot(){

        List<WorksInfo> works=userService.selectWorksByLookNum();

        return Msg.success().add("Works",works);
    }


    @RequestMapping("rankingNew")
    @ResponseBody
    public Msg rankingNew(){

        List<WorksInfo> works=userService.selectWorksByTime();

        return Msg.success().add("Works",works);
    }




    @RequestMapping("/authorComments")
    public String authorComments(@RequestParam(value = "uid",required = false)Integer uid,Model model){

        List<CommentInfo> list=workService.selectCommentByUid(uid);
        Integer commentCount=workService.selectCommentCountByUid(uid);
        User user=userService.findUserByUid(uid);
        model.addAttribute("user",user);
        model.addAttribute("commentCount",commentCount);
        model.addAttribute("list",list);
        return "user/author-comments";
    }

    @RequestMapping("/updatePassword")
    public String updatePassword(){

        return "user/user-updatePassword";
    }

    @RequestMapping("/doUpdatePassword")
    @ResponseBody
    public Msg doUpdatePassword(User user){

        Integer result=userService.updateUserPassword(user);
        if (result>0){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }

    @RequestMapping("/updateHeadImage")
    public String updateHeadImage(){
        return "user/user-headImage";
    }

    @RequestMapping("/doUpdateHeadImage")
    @ResponseBody
    public Msg doUpdateHeadImage(@RequestParam(value = "headImage" ,required = false ) MultipartFile file,Integer uid,HttpSession session){

        User user=userService.findUserByUid(uid);
        User user1= (User) session.getAttribute("currentUser");

        String picName= UUID.randomUUID().toString();
        String name=file.getOriginalFilename();
        String suffixName=name.substring(name.lastIndexOf("."));//.+后缀
        try {
            file.transferTo(new File("C:/upload/acgPic/head-image/"+picName+suffixName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        user.setHeadImage(picName+suffixName);
        user1.setHeadImage(picName+suffixName);

        Integer result=userService.updateHeadImage(user);

        if (result>0){
            session.setAttribute("currentUser",user1);
            return Msg.success().add("user",user1);
        }else {
            return Msg.fail();
        }
    }


    @RequestMapping("/mySettings")
    public String mySettings(){
        return "user/user-settings";
    }

    @RequestMapping("/doMySettings")
    @ResponseBody
    public Msg doMySettings(User user){

        Integer result=userService.updateUserIfo(user);
        if (result>0){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }




    @RequestMapping("/exit")
    @ResponseBody
    public Msg doExit(HttpSession session){
        session.invalidate();

        return Msg.success();
    }

    @RequestMapping("/findUserByUid")
    @ResponseBody
    public Msg findUserByUid(Integer uid){

        User user=userService.findUserByUid(uid);
        if (user!=null){
            return Msg.success().add("findUser",user);
        }else {
            return Msg.fail();
        }
    }

    @RequestMapping("/sendUserMessage")
    @ResponseBody
    public Msg sendUserMessage(PrivateInfo privateInfo){

        privateInfo.setState(0);
        Integer result=userService.addPrivateMsg(privateInfo);
        if (result>0){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }



    @RequestMapping("/myRemind")
    public String myRemind(){
        return "user/user-myRemind";
    }

    @RequestMapping("/doMyRemind")
    @ResponseBody
    public Msg doMyRemind(@RequestParam(value = "pn",defaultValue = "1") Integer pn,HttpSession session){

        User user= (User) session.getAttribute("currentUser");
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn,8);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<CommentInfo> list=workService.selectCommentByUid(user.getUid());

        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo pageInfo=new PageInfo(list,3);//显示3个按钮

        return Msg.success().add("pageInfo",pageInfo);
    }


    @RequestMapping("/search")
    public String search(String s,Model model){

        List<WorksInfo> list=userService.selectWorksLikeName(s);
        List<Integer> commentCount=new ArrayList();

        for (int i=0;i<list.size();i++){
            commentCount.add(workService.selectCommentCountByWorkId(list.get(i).getWorkId()));
        }


        model.addAttribute("list",list);
        model.addAttribute("commentCount",commentCount);
        return "search";
    }

}
