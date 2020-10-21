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

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class WorksController {

    @Autowired
    private WorkService workService;
    @Autowired
    private UserService userService;


    //////////////////////////////////////////////////////
    //works
    @RequestMapping("/userLetter")
    public String userLetter(Model model, HttpSession session){

        User user= (User) session.getAttribute("currentUser");
        List<PrivateInfo> list=workService.selectPrivateByUid(user.getUid());

        model.addAttribute("list",list);
        return "works/works-letter";
    }


    @RequestMapping("/addWorks")
    public String addWorks(@RequestParam(value = "file",required = false) MultipartFile file, WorksInfo worksInfo, HttpSession session){

        if (file.getOriginalFilename().contains(".")){
            String picName= UUID.randomUUID().toString();
            String name=file.getOriginalFilename();
            String suffixName=name.substring(name.lastIndexOf("."));//.+后缀
            try {
                file.transferTo(new File("C:/upload/acgPic/work-background/"+picName+suffixName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            worksInfo.setWorkBackground(picName+suffixName);
        }

        if (worksInfo.getWorkId()!=null){//修改已存在的作品

            workService.updateWorks(worksInfo);
        }else {
            workService.addWorks(worksInfo);
        }
        //return Msg.success();
        return "redirect:worksEdit";
    }

    @RequestMapping("/worksEdit")
    public String worksEdit(@RequestParam(value = "workId",required = false) Integer workId,Model model){

        WorksInfo work=workService.selectWorksByWorkId(workId);
        model.addAttribute("work",work);
        return "works/works-edit";
    }

    @RequestMapping("/myWorks")
    public String myWorks(){

        /*User user= (User) session.getAttribute("currentUser");
        List<WorksInfo> list=workService.selectWorksByUid(user.getUid());*/

        return "works/works-myWorks";
    }

    @RequestMapping("/worksDisplay")
    public String worksDisplay(@RequestParam(value = "workId",required = false)Integer workId,Model model){

        WorksInfo work=workService.selectWorksByWorkId(workId);
        List<WorksInfo> list=workService.selectWorksByUidLimit(work.getUid());
        User user=userService.findUserByUid(work.getUid());
        Integer worksCount=workService.selectWorksCount(work.getUid());

        Integer commentCount=workService.selectCommentCountByWorkId(workId);
        List<CommentInfo> commentList=workService.selectCommentByWorkId(workId);

        Integer bombCount=workService.findBombByUid(work.getUid()).getBombNum();

        model.addAttribute("user",user);
        model.addAttribute("work",work);
        model.addAttribute("list",list);
        model.addAttribute("worksCount",worksCount);

        model.addAttribute("commentCount",commentCount);
        model.addAttribute("commentList",commentList);
        model.addAttribute("bombCount",bombCount);
        return "works/works-display";
    }

    @RequestMapping("/sendComment")
    @ResponseBody
    public Msg sendComment(CommentInfo comment,Model model){

        Integer result=workService.addComment(comment);
        List<CommentInfo> commentList=workService.selectCommentByWorkId(comment.getWorkId());

        Integer commentCount=workService.selectCommentCountByWorkId(comment.getWorkId());
        model.addAttribute("commentCount",commentCount);

        if (result>0){
            return Msg.success().add("commentList",commentList);
        }else {
            return Msg.fail();
        }

    }

    @RequestMapping("/showMyWorks")
    @ResponseBody
    public Msg showMyWorks(@RequestParam(value = "pn",defaultValue = "1") Integer pn,HttpSession session){

        User user= (User) session.getAttribute("currentUser");

        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn,5);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<WorksInfo> list=workService.selectWorksByUid(user.getUid());
        
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo pageInfo=new PageInfo(list,3);//显示3个按钮

        return Msg.success().add("pageInfo",pageInfo);
    }



    @RequestMapping("/analyze")
    public String analyze(Model model,HttpSession session){

        User user= (User) session.getAttribute("currentUser");
        Integer bombCount=workService.findBombByUid(user.getUid()).getBombNum();
        Integer worksCount=workService.selectWorksCount(user.getUid());
        Integer commentCount=workService.selectCommentCountByUid(user.getUid());

        model.addAttribute("bombCount",bombCount);
        model.addAttribute("worksCount",worksCount);
        model.addAttribute("commentCount",commentCount);

        return "works/works-analyze";
    }


    @RequestMapping("/bombHistory")
    public String bombHistory(HttpSession session,Model model){

        User user= (User) session.getAttribute("currentUser");
        Integer bombCount=workService.findBombByUid(user.getUid()).getBombNum();

        model.addAttribute("bombCount",bombCount);
        return "works/works-bombHistory";
    }

    @RequestMapping("/doBombHistory")
    @ResponseBody
    public Msg doBombHistory(@RequestParam(value = "pn",defaultValue = "1") Integer pn,HttpSession session){

        User user= (User) session.getAttribute("currentUser");

        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn,8);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<BombRecord> list=workService.findBombNumByUid(user.getUid());

        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo pageInfo=new PageInfo(list,3);//显示3个按钮

        return Msg.success().add("pageInfo",pageInfo);

    }






    //更新浏览数
    @RequestMapping("/addCount")
    @ResponseBody
    public Msg addCount(@RequestParam(value = "workId",required = false) Integer workId){

        Integer result=workService.updateWorkLookCount(workId);
        if (result>0){
            return Msg.success().add("msg","访问量+1");
        }else {
            return Msg.fail().add("msg","失败");
        }
    }

    //更新下载量
    @RequestMapping("/addDownload")
    @ResponseBody
    public Msg addDownload(@RequestParam(value = "workId",required = false) Integer workId){

        Integer result=workService.updateWorkDownloadCount(workId);
        Integer downloadCount=workService.selectWorksByWorkId(workId).getDownloadCount();
        if (result>0){
            return Msg.success().add("downloadCount",downloadCount);
        }else {
            return Msg.fail().add("msg","失败");
        }
    }


    @RequestMapping("/download")
    public String download(@RequestParam(value = "workId" , required =false )Integer workId,Model model){

        WorksInfo work=workService.selectWorksByWorkId(workId);
        model.addAttribute("work",work);

        return "works/works-download";
    }








    /////////////////////////////////////////////////////////
    //积分控制，3分
    @RequestMapping("/bombCount3")
    @ResponseBody
    public Msg bombCount3(@RequestParam(value = "workId" , required = false) Integer workId,HttpSession session){

        Integer result=workService.updateBombCountByWorkId3(workId);//work_count+3
        WorksInfo work=workService.selectWorksByWorkId(workId);

        User user=userService.findUserByUid(work.getUid());//文章作者
        User user1= (User) session.getAttribute("currentUser");//打赏的用户

        //积分增加的一方
        BombRecord bombRecord=new BombRecord(user.getUid(),user1.getUid(),"你的作品：《"+work.getWorkTitle()+"》被打赏3猫爪");
        workService.addBombRecord(bombRecord);//被打赏的一方 增加一条记录
        List<BombRecord> Bomb=workService.findBombNumByUid(user.getUid());
        if (Bomb.get(0).getBombNum()==null||Bomb.get(0).getBombNum()==0){
            Bomb.get(0).setBombNum(0);
            workService.updateBombNumByUid(Bomb.get(0));
        }
        Bomb.get(0).setBombNum(Bomb.get(0).getBombNum()+3);//work作者积分+3
        workService.updateBombNumByUid(Bomb.get(0));


        //积分减少的一方，session
        BombRecord bombRecord1=new BombRecord(user1.getUid(),user.getUid(),"你给作品：《"+work.getWorkTitle()+"》打赏了3猫爪");
        workService.addBombRecord(bombRecord1);//打赏一方 增加一条记录
        List<BombRecord> Bomb1=workService.findBombNumByUid(user1.getUid());
        if (Bomb1.get(0).getBombNum()<=3||Bomb1.get(0).getBombNum()==null){
            Bomb1.get(0).setBombNum(0);
            workService.updateBombNumByUid(Bomb1.get(0));
        }else {
            Bomb1.get(0).setBombNum( Bomb1.get(0).getBombNum()-3);
            workService.updateBombNumByUid( Bomb1.get(0));
        }

        if (result>0){
            return Msg.success();
        }
        else {
            return Msg.fail();
        }

    }

    //积分控制，5分
    @RequestMapping("/bombCount5")
    @ResponseBody
    public Msg bombCount5(@RequestParam(value = "workId" , required = false) Integer workId,HttpSession session){

        Integer result=workService.updateBombCountByWorkId5(workId);//work_count+5
        WorksInfo work=workService.selectWorksByWorkId(workId);

        User user=userService.findUserByUid(work.getUid());//文章作者
        User user1= (User) session.getAttribute("currentUser");//打赏的用户

        //积分增加的一方
        BombRecord bombRecord=new BombRecord(user.getUid(),user1.getUid(),"你的作品：《"+work.getWorkTitle()+"》被打赏5猫爪");
        workService.addBombRecord(bombRecord);//被打赏的一方 增加一条记录
        List<BombRecord> Bomb=workService.findBombNumByUid(user.getUid());
        if (Bomb.get(0).getBombNum()==null||Bomb.get(0).getBombNum()==0){
            Bomb.get(0).setBombNum(0);
            workService.updateBombNumByUid(Bomb.get(0));
        }
        Bomb.get(0).setBombNum(Bomb.get(0).getBombNum()+5);//work作者积分+5
        workService.updateBombNumByUid(Bomb.get(0));


        //积分减少的一方，session
        BombRecord bombRecord1=new BombRecord(user1.getUid(),user.getUid(),"你给作品：《"+work.getWorkTitle()+"》打赏了5猫爪");
        workService.addBombRecord(bombRecord1);//打赏一方 增加一条记录
        List<BombRecord> Bomb1=workService.findBombNumByUid(user1.getUid());
        if (Bomb1.get(0).getBombNum()<=5||Bomb1.get(0).getBombNum()==null){
            Bomb1.get(0).setBombNum(0);
            workService.updateBombNumByUid(Bomb1.get(0));
        }else {
            Bomb1.get(0).setBombNum( Bomb1.get(0).getBombNum()-5);
            workService.updateBombNumByUid( Bomb1.get(0));
        }

        if (result>0){
            return Msg.success();
        }
        else {
            return Msg.fail();
        }

    }

    //积分控制，10分
    @RequestMapping("/bombCount10")
    @ResponseBody
    public Msg bombCount10(@RequestParam(value = "workId" , required = false) Integer workId,HttpSession session){

        Integer result=workService.updateBombCountByWorkId10(workId);//work_count+10
        WorksInfo work=workService.selectWorksByWorkId(workId);

        User user=userService.findUserByUid(work.getUid());//文章作者
        User user1= (User) session.getAttribute("currentUser");//打赏的用户

        //积分增加的一方
        BombRecord bombRecord=new BombRecord(user.getUid(),user1.getUid(),"你的作品：《"+work.getWorkTitle()+"》被打赏10猫爪");
        workService.addBombRecord(bombRecord);//被打赏的一方 增加一条记录
        List<BombRecord> Bomb=workService.findBombNumByUid(user.getUid());
        if (Bomb.get(0).getBombNum()==null||Bomb.get(0).getBombNum()==0){
            Bomb.get(0).setBombNum(0);
            workService.updateBombNumByUid(Bomb.get(0));
        }
        Bomb.get(0).setBombNum(Bomb.get(0).getBombNum()+10);//work作者积分+10
        workService.updateBombNumByUid(Bomb.get(0));


        //积分减少的一方，session
        BombRecord bombRecord1=new BombRecord(user1.getUid(),user.getUid(),"你给作品：《"+work.getWorkTitle()+"》打赏了10猫爪");
        workService.addBombRecord(bombRecord1);//打赏一方 增加一条记录
        List<BombRecord> Bomb1=workService.findBombNumByUid(user1.getUid());
        if (Bomb1.get(0).getBombNum()<=10||Bomb1.get(0).getBombNum()==null){
            Bomb1.get(0).setBombNum(0);
            workService.updateBombNumByUid(Bomb1.get(0));
        }else {
            Bomb1.get(0).setBombNum( Bomb1.get(0).getBombNum()-10);
            workService.updateBombNumByUid( Bomb1.get(0));
        }

        if (result>0){
            return Msg.success();
        }
        else {
            return Msg.fail();
        }

    }



    @RequestMapping("selectBombCount")
    @ResponseBody
    public Msg selectBombCount(@RequestParam(value = "workId" , required = false) Integer workId){
        Integer count=workService.selectWorkBombNumByWorkId(workId);

        return Msg.success().add("count",count);
    }
}
