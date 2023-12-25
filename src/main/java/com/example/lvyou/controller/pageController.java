package com.example.lvyou.controller;

import com.example.lvyou.bean.*;
import com.example.lvyou.service.AUserService;
import com.example.lvyou.service.TUserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

@Controller
public class pageController {
    @Resource
    AUserService auserService;

    @Resource
    TUserService tuserService;

    //  管理员登录及主页
    @RequestMapping("/loginU")
    public String showloginU() {
        return "loginU";
    }

    @RequestMapping("/homeU")
    public String showhomeU() {
        return "homeU";
    }

    //  订单增删
    @RequestMapping("/selectMU")
    public String showselectMU() {
        return "selectMU";
    }

    @RequestMapping("/addMU")
    public String showaddMU() {
        return "addMU";
    }

    @RequestMapping("/updateMU")
    public String showupdateMU() {
        return "updateMU";
    }

    //  景点增删
    @RequestMapping("/selectPU")
    public String showselectPU() {
        return "selectPU";
    }

    @RequestMapping("/addPU")
    public String showaddPU() {
        return "addPU";
    }

    @RequestMapping("/selectTU")
    public String showselectTU() {
        return "selectTU";
    }

    //  游客增删
    @RequestMapping("/addTU")
    public String showaddTU() {
        return "addTU";
    }

    @RequestMapping("/deleteTU")
    public String showdeleteTU() {
        return "deleteTU";
    }

    @RequestMapping("/updateTU")
    public String showupdateTU() {
        return "updateTU";
    }

    //  旅游团增删
    @RequestMapping("/addTeamU")
    public String showaddTeamU() {
        return "addTeamU";
    }

    @RequestMapping("/selectTeamU")
    public String showselectTeamU() {
        return "selectTeamU";
    }

    //  旅游线路增删
    @RequestMapping("/addRU")
    public String showaddRU() {
        return "addRU";
    }

    @RequestMapping("/selectRU")
    public String showselectRU() {
        return "selectRU";
    }

    //  管理员增删
    @RequestMapping("/addU")
    public String showaddU() {
        return "addU";
    }

    @RequestMapping("/selectU")
    public String showselectU() {
        return "selectU";
    }

    //  用户
    @RequestMapping("/login")
    public String showLogin() {
        return "login";
    }

    @RequestMapping("/home")
    public String showhome() {
        return "home";
    }

    @RequestMapping("/register")
    public String showregister() {
        return "register";
    }

    @RequestMapping("/addM")
    public String showaddM() {
        return "addM";
    }

    @RequestMapping("/selectM")
    public String showselectM() {
        return "selectM";
    }

    @RequestMapping("/selectP")
    public String showselectP() {
        return "selectP";
    }

    @RequestMapping("/selectR")
    public String showselectR() {
        return "selectR";
    }

    @RequestMapping("/selectTeam")
    public String showselectTeam() {
        return "selectTeam";
    }

    @RequestMapping("/update")
    public String showupdate() {
        return "update";
    }

    @RequestMapping("/updateT")
    public String updateT() {
        return "updateT";
    }

    @RequestMapping(value = "/loginU1", method = RequestMethod.POST)
    public String UloginMethod(String name, String pwd, Model model) {
        String msg = "登录信息";
        if (name.isEmpty() || pwd.isEmpty()) {
            if (name.isEmpty()) {
                msg = "姓名不能为空";
                model.addAttribute("pwd", pwd);
            } else {
                msg = "密码不能为空";
                model.addAttribute("name", name);
            }
            model.addAttribute("msg", msg);
            return "loginU";
        }
        AUserBean auserBean = auserService.loginU(name, pwd);
        if (auserBean != null) {
            msg = "login successfully";
            model.addAttribute("msg", msg);
            return "homeU";
        } else {
            model.addAttribute("name", name);
            model.addAttribute("pwd", pwd);
            msg = "姓名或密码错误";
            model.addAttribute("msg", msg);
            return "loginU";
        }
    }

    @RequestMapping(value = "/loginT1", method = RequestMethod.POST)
    public String TloginMethod(String name, String pwd, Model model) {
        String msg = "登录信息";
        if (name.isEmpty() || pwd.isEmpty()) {
            if (name.isEmpty()) {
                msg = "姓名不能为空";
                model.addAttribute("pwd", pwd);
            } else {
                msg = "密码不能为空";
                model.addAttribute("name", name);
            }
            model.addAttribute("msg", msg);
            return "login";
        }
        TUserBean tuserBean = tuserService.loginT(name, pwd);
        if (tuserBean != null) {
            msg = "login successfully";
            model.addAttribute("msg", msg);
            return "home";
        } else {
            model.addAttribute("name", name);
            model.addAttribute("pwd", pwd);
            msg = "姓名或密码错误";
            model.addAttribute("msg", msg);
            return "login";
        }
    }

    @RequestMapping(value = "/selectU1", method = RequestMethod.POST)
    public String selectU(Model model) {
        List<AUserBean> auserList = auserService.selectU();
        String tableHeaders = "<tr><th>编号</th><th>姓名</th><th>密码</th><th>入职时间</th><th>薪资</th><th>备注</th></tr>";
        String ausersHTML = "";
        ausersHTML += tableHeaders;
        Iterator<AUserBean> iterator = auserList.iterator();
        String pHTML;
        while (iterator.hasNext()) {
            AUserBean a = iterator.next();
            pHTML = "<tr><td>" + a.getAid() + "</td><td>" + a.getAname() + "</td><td>" + a.getApwd() + "</td><td>" + a.getAdate() + "</td><td>" + a.getAsalary() + "</td><td>" + a.getAother() + "</td></tr>";
            ausersHTML += pHTML;
        }
        String msg = "查询结果如下";
        model.addAttribute("msg", msg);
        model.addAttribute("rs", "<table border=\"1\" cellspacing=\"0\" id='table'>" + ausersHTML + "</table>");
        return "selectU";
    }

    @RequestMapping(value = "/addU1", method = RequestMethod.POST)
    public String addU(int num, String name, String pwd, String date, int salary, String other, Model model) {
        String msg = null;
        if (date.isEmpty()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            int day = calendar.get(Calendar.DATE);
            date = year + "-" + "-" + month + "-" + day;
        }
        if (other.isEmpty()) {
            other = "无";
        }
        model.addAttribute("other", other);
        model.addAttribute("date", date);
        model.addAttribute("num", num);
        model.addAttribute("salary", salary);
        model.addAttribute("name", name);
        model.addAttribute("pwd", pwd);
        if (name.isEmpty() || pwd.isEmpty()) {
            if (name.isEmpty()) {
                msg = "姓名不能为空";
                model.addAttribute("msg", msg);
                return "addU";
            }
            if (pwd.isEmpty()) {
                msg = "密码不能为空";
                model.addAttribute("msg", msg);
                return "addU";
            }
        }
        auserService.addU(num, name, pwd, date, salary, other);
        msg = "添加成功";
        model.addAttribute("msg", msg);
        return "addU";
    }

    @RequestMapping(value = "/addTU1", method = RequestMethod.POST)
    public String addTU(int num, String name, String pwd, String sex, int age, String phone, String ephone, Model model) {
        String msg = null;
        if (ephone.isEmpty()) {
            ephone = "无";
        }
        model.addAttribute("ephone", ephone);
        model.addAttribute("phone", phone);
        model.addAttribute("num", num);
        model.addAttribute("age", age);
        model.addAttribute("sex", sex);
        model.addAttribute("pwd", pwd);
        model.addAttribute("name", name);
        if (name.isEmpty() || pwd.isEmpty() || phone.isEmpty()) {
            if (name.isEmpty()) {
                msg = "姓名不能为空";
                model.addAttribute("msg", msg);
                return "addTU";
            }
            if (pwd.isEmpty()) {
                msg = "密码不能为空";
                model.addAttribute("msg", msg);
                return "addTU";
            }
            if (phone.isEmpty()) {
                msg = "电话不能为空";
                model.addAttribute("msg", msg);
                return "addTU";
            }
        }
        String sexm = "男";
        String sexf = "女";
        if (!sex.equals(sexm)) {
            if (!sex.equals(sexf)) {
                msg = "性别只能为'男'或'女'";
                model.addAttribute("msg", msg);
                return "addTU";
            }
        }
        auserService.addTU(num, name, pwd, sex, age, phone, ephone);
        msg = "添加成功";
        model.addAttribute("msg", msg);
        return "addTU";
    }

    @RequestMapping(value = "/selectTU1", method = RequestMethod.POST)
    public String selectTU(Model model) {
        List<TUserBean> auserList = tuserService.selectTU();
        String tableHeaders = "<tr><th>游客编号</th><th>姓名</th><th>密码</th><th>性别</th><th>年龄</th><th>电话</th><th>紧急电话</th></tr>";
        String tusersHTML = "";
        tusersHTML += tableHeaders;
        Iterator<TUserBean> iterator = auserList.iterator();
        String pHTML;
        while (iterator.hasNext()) {
            TUserBean a = iterator.next();
            pHTML = "<tr><td>" + a.getTnum() + "</td><td>" + a.getTname() + "</td><td>" + a.getTpwd() + "</td><td>" + a.getTsex() + "</td><td>" + a.getTage() + "</td><td>" + a.getTphone() + "</td><td>" + a.getTephone() + "</td></tr>";
            tusersHTML += pHTML;
        }
        String msg = "查询结果如下";
        model.addAttribute("msg", msg);
        model.addAttribute("rs", "<table border='1' cellspacing='0' id='table'>" + tusersHTML + "</table>");
        return "selectTU";
    }

    @RequestMapping(value = "/deleteTU1", method = RequestMethod.POST)
    public String deleteTU(String name, String pwd, Model model) {
        String msg;
        model.addAttribute("name", name);
        model.addAttribute("pwd", pwd);
        if (name.isEmpty() || pwd.isEmpty()) {
            if (name.isEmpty()) {
                msg = "姓名不能为空";
                model.addAttribute("msg", msg);
                return "deleteTU";
            }
            if (pwd.isEmpty()) {
                msg = "密码不能为空";
                model.addAttribute("msg", msg);
                return "deleteTU";
            }
        }
        tuserService.deleteTU(name, pwd);
        msg = "删除成功";
        model.addAttribute("msg", msg);
        return "deleteTU";
    }

    @RequestMapping(value = "/updateTU1", method = RequestMethod.POST)
    public String updateTU(String name, String pwd, String sex, int age, String phone, Model model) {
        String msg;
        model.addAttribute("phone", phone);
        model.addAttribute("age", age);
        model.addAttribute("sex", sex);
        model.addAttribute("pwd", pwd);
        model.addAttribute("name", name);
        if (name.isEmpty() || pwd.isEmpty() || phone.isEmpty()) {
            if (name.isEmpty()) {
                msg = "姓名不能为空";
                model.addAttribute("msg", msg);
                return "updateTU";
            }
            if (pwd.isEmpty()) {
                msg = "密码不能为空";
                model.addAttribute("msg", msg);
                return "updateTU";
            }
            if (phone.isEmpty()) {
                msg = "电话不能为空";
                model.addAttribute("msg", msg);
                return "updateTU";
            }
        }
        String sexm = "男";
        String sexf = "女";
        if (!sex.equals(sexm)) {
            if (!sex.equals(sexf)) {
                msg = "性别只能为'男'或'女'";
                model.addAttribute("msg", msg);
                return "updateTU";
            }
        }
        tuserService.updateTU(name, pwd, sex, age, phone);
        msg = "更新成功";
        model.addAttribute("msg", msg);
        return "updateTU";
    }

    @RequestMapping(value = "/selectPU1", method = RequestMethod.POST)
    public String selectPU(Model model) {
        List<PlaceBean> placeList = auserService.selectPU();
        String tableHeaders = "<tr><th>景点编号</th><th>名称</th><th>地区</th><th>星级</th><th>门票</th><th>备注</th></tr>";
        String HTML = "";
        HTML += tableHeaders;
        Iterator<PlaceBean> iterator = placeList.iterator();
        String pHTML;
        while (iterator.hasNext()) {
            PlaceBean a = iterator.next();
            pHTML = "<tr><td>" + a.getPlacenum() + "</td><td>" + a.getPlacename() + "</td><td>" + a.getPlace() + "</td><td>" + a.getStar() + "</td><td>" + a.getTicket() + "</td><td>" + a.getPlaceother() + "</td></tr>";
            HTML += pHTML;
        }
        String msg = "查询结果如下";
        model.addAttribute("msg", msg);
        model.addAttribute("rs", "<table border='1' cellspacing='0' id='table'>" + HTML + "</table>");
        return "selectPU";
    }

    @RequestMapping(value = "/addPU1", method = RequestMethod.POST)
    public String addPU(int num, String name, String place, int star, int ticket, String other, Model model) {
        String msg = null;
        if (other.isEmpty()) {
            other = "无";
        }
        model.addAttribute("other", other);
        model.addAttribute("ticket", ticket);
        model.addAttribute("num", num);
        model.addAttribute("star", star);
        model.addAttribute("name", name);
        model.addAttribute("place", place);
        if (name.isEmpty() || place.isEmpty()) {
            if (name.isEmpty()) {
                msg = "姓名不能为空";
                model.addAttribute("msg", msg);
                return "addPU";
            }
            if (place.isEmpty()) {
                msg = "地区不能为空";
                model.addAttribute("msg", msg);
                return "addPU";
            }
        }
        auserService.addPU(num, name, place, star, ticket, other);
        msg = "添加成功";
        model.addAttribute("msg", msg);
        return "addPU";
    }

    @RequestMapping(value = "/addTeamU1", method = RequestMethod.POST)
    public String addTeamU(int num, String name, String phone, int rnum, String other, Model model) {
        String msg = null;
        if (other.isEmpty()) {
            other = "无";
        }
        model.addAttribute("other", other);
        model.addAttribute("num", num);
        model.addAttribute("rnum", rnum);
        model.addAttribute("name", name);
        model.addAttribute("phone", phone);
        if (name.isEmpty() || phone.isEmpty()) {
            if (name.isEmpty()) {
                msg = "姓名不能为空";
                model.addAttribute("msg", msg);
                return "addTeamU";
            }
            if (phone.isEmpty()) {
                msg = "电话不能为空";
                model.addAttribute("msg", msg);
                return "addTeamU";
            }
        }
        auserService.addTeamU(num, name, phone, rnum, other);
        msg = "添加成功";
        model.addAttribute("msg", msg);
        return "addTeamU";
    }

    @RequestMapping(value = "/selectTeamU1", method = RequestMethod.POST)
    public String selectTeamU(Model model) {
        List<TeamBean> teamList = auserService.selectTeamU();
        String tableHeaders = "<tr><th>旅游团编号</th><th>名称</th><th>电话</th><th>路线编号</th><th>备注</th></tr>";
        String HTML = "";
        HTML += tableHeaders;
        Iterator<TeamBean> iterator = teamList.iterator();
        String pHTML;
        while (iterator.hasNext()) {
            TeamBean a = iterator.next();
            pHTML = "<tr><td>" + a.getTeamrnum() + "</td><td>" + a.getTeamname() + "</td><td>" + a.getTeamphone() + "</td><td>" + a.getTeamrnum() + "</td><td>" + a.getTeamother() + "</td></tr>";
            HTML += pHTML;
        }
        String msg = "查询结果如下";
        model.addAttribute("msg", msg);
        model.addAttribute("rs", "<table border='1' cellspacing='0' id='table'>" + HTML + "</table>");
        return "selectTeamU";
    }

    @RequestMapping(value = "/selectRU1", method = RequestMethod.POST)
    public String selectRU(Model model) {
        List<RouteBean> routeList = auserService.selectRU();
        String tableHeaders = "<tr><th>旅游线路编号</th><th>特色景点</th><th>起始站</th><th>终点站</th><th>时间（天）</th></tr>";
        String HTML = "";
        HTML += tableHeaders;
        Iterator<RouteBean> iterator = routeList.iterator();
        String pHTML;
        while (iterator.hasNext()) {
            RouteBean a = iterator.next();
            pHTML = "<tr><td>" + a.getRoutenum() + "</td><td>" + a.getSpecialplace() + "</td><td>" + a.getBegin() + "</td><td>" + a.getEnd() + "</td><td>" + a.getLongtime() + "</td></tr>";
            HTML += pHTML;
        }
        String msg = "查询结果如下";
        model.addAttribute("msg", msg);
        model.addAttribute("rs", "<table border='1' cellspacing='0' id='table'>" + HTML + "</table>");
        return "selectTeamU";
    }

    @RequestMapping(value = "/addRU1", method = RequestMethod.POST)
    public String addRU(int num, String special, String begin, String end, int time, Model model) {
        String msg = null;
        model.addAttribute("special", special);
        model.addAttribute("num", num);
        model.addAttribute("begin", begin);
        model.addAttribute("end", end);
        model.addAttribute("time", time);
        if (special.isEmpty() || begin.isEmpty() || end.isEmpty()) {
            if (special.isEmpty()) {
                msg = "特色景点不能为空";
                model.addAttribute("msg", msg);
                return "addRU";
            }
            if (begin.isEmpty()) {
                msg = "起点站不能为空";
                model.addAttribute("msg", msg);
                return "addRU";
            }
            if (end.isEmpty()) {
                msg = "终点站不能为空";
                model.addAttribute("msg", msg);
                return "addRU";
            }
        }
        auserService.addRU(num, special, begin, end, time);
        msg = "添加成功";
        model.addAttribute("msg", msg);
        return "addRU";
    }

    @RequestMapping(value = "/selectMU1", method = RequestMethod.POST)
    public String selectMU1(Model model) {
        List<ManageBean> manageList = auserService.selectMU();
        String tableHeaders = "<tr><th>订单编号</th><th>游客编号</th><th>旅游团编号</th><th>操作</th><th>日期</th><th>备注</th></tr>";
        String HTML = "";
        HTML += tableHeaders;
        Iterator<ManageBean> iterator = manageList.iterator();
        String pHTML;
        while (iterator.hasNext()) {
            ManageBean a = iterator.next();
            pHTML = "<tr><td>" + a.getMnum() + "</td><td>" + a.getTusernum() + "</td><td>" + a.getTeamnum() + "</td><td>" + a.getManage() + "</td><td>" + a.getMdate() + "</td><td>" + a.getMother() + "</td></tr>";
            HTML += pHTML;
        }
        String msg = "查询结果如下";
        model.addAttribute("msg", msg);
        model.addAttribute("rs", "<table border='1' cellspacing='0' id='table'>" + HTML + "</table>");
        return "selectMU";
    }

    @RequestMapping(value = "/selectMU2", method = RequestMethod.POST)
    public String selectMU2(String manage, int teamnum, Model model) {
        String msg;
        model.addAttribute("manage", manage);
        model.addAttribute("teamnum", teamnum);
        if (manage.isEmpty() && teamnum == 0) {
            msg = "操作和旅游团编号不能都为空";
            model.addAttribute("msg", msg);
            return "selectMU";
        }
        List<ManageBean> manageList;
        if (teamnum == 0) {
            manageList = auserService.selectMUmanage(manage);
        } else if (manage.isEmpty()) {
            manageList = auserService.selectMUteamnum(teamnum);
        } else {
            manageList = auserService.selectMUteamnum_manage(manage, teamnum);
        }
        String tableHeaders = "<tr><th>订单编号</th><th>游客编号</th><th>旅游团编号</th><th>操作</th><th>日期</th><th>备注</th></tr>";
        String HTML = "";
        HTML += tableHeaders;
        Iterator<ManageBean> iterator = manageList.iterator();
        String pHTML;
        while (iterator.hasNext()) {
            ManageBean a = iterator.next();
            pHTML = "<tr><td>" + a.getMnum() + "</td><td>" + a.getTusernum() + "</td><td>" + a.getTeamnum() + "</td><td>" + a.getManage() + "</td><td>" + a.getMdate() + "</td><td>" + a.getMother() + "</td></tr>";
            HTML += pHTML;
        }
        msg = "查询结果如下";
        model.addAttribute("msg", msg);
        model.addAttribute("rs", "<table border='1' cellspacing='0' id='table'>" + HTML + "</table>");
        return "selectMU";
    }

    @RequestMapping(value = "/addMU1", method = RequestMethod.POST)
    public String addMU(int num, int tusernum, int teamnum, String manage, String date, String other, Model model) {
        String msg = null;
        if (date.isEmpty()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            int day = calendar.get(Calendar.DATE);
            date = year + "-" + "-" + month + "-" + day;
        }
        if (other.isEmpty()) {
            other = "无";
        }
        if (manage.isEmpty()) {
            manage = "报名";
        }
        model.addAttribute("tusernum", tusernum);
        model.addAttribute("num", num);
        model.addAttribute("teamnum", teamnum);
        model.addAttribute("manage", manage);
        model.addAttribute("date", date);
        model.addAttribute("other", other);
        String do1 = "报名";
        if (!manage.equals(do1)) {
            msg = "报名时操作只能为'报名'";
            model.addAttribute("msg", msg);
            return "addMU";
        }
        auserService.addMU(num, tusernum, teamnum, manage, date, other);
        msg = "添加成功";
        model.addAttribute("msg", msg);
        return "addMU";
    }

    @RequestMapping(value = "/updateMU1", method = RequestMethod.POST)
    public String updateMU(int num, int tusernum, int teamnum, String manage, String date, String other, Model model) {
        String msg = null;
        if (date.isEmpty()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            int day = calendar.get(Calendar.DATE);
            date = year + "-" + "-" + month + "-" + day;
        }
        if (other.isEmpty()) {
            other = "无";
        }
        model.addAttribute("tusernum", tusernum);
        model.addAttribute("num", num);
        model.addAttribute("teamnum", teamnum);
        model.addAttribute("manage", manage);
        model.addAttribute("date", date);
        model.addAttribute("other", other);
        String do1 = "报名";
        String do2 = "取消";
        if (!manage.equals(do1)) {
            if (!manage.equals(do2)) {
                msg = "操作只能为'报名'或'取消'";
                model.addAttribute("msg", msg);
                return "updateMU";
            }
        }
        auserService.updateMU(num, tusernum, teamnum, manage, date, other);
        msg = "更新成功";
        model.addAttribute("msg", msg);
        return "updateMU";
    }

    @RequestMapping(value = "/register1", method = RequestMethod.POST)
    public String register(int num, String name, String pwd, String sex, int age, String phone, String ephone, Model model) {
        String msg = null;
        if (ephone.isEmpty()) {
            ephone = "无";
        }
        model.addAttribute("ephone", ephone);
        model.addAttribute("phone", phone);
        model.addAttribute("num", num);
        model.addAttribute("age", age);
        model.addAttribute("sex", sex);
        model.addAttribute("pwd", pwd);
        model.addAttribute("name", name);
        if (name.isEmpty() || pwd.isEmpty() || phone.isEmpty()) {
            if (name.isEmpty()) {
                msg = "姓名不能为空";
                model.addAttribute("msg", msg);
                return "register";
            }
            if (pwd.isEmpty()) {
                msg = "密码不能为空";
                model.addAttribute("msg", msg);
                return "register";
            }
            if (phone.isEmpty()) {
                msg = "电话不能为空";
                model.addAttribute("msg", msg);
                return "register";
            }
        }
        String sexm = "男";
        String sexf = "女";
        if (!sex.equals(sexm)) {
            if (!sex.equals(sexf)) {
                msg = "性别只能为'男'或'女'";
                model.addAttribute("msg", msg);
                return "register";
            }
        }
        auserService.addTU(num, name, pwd, sex, age, phone, ephone);
        msg = "注册成功";
        model.addAttribute("msg", msg);
        return "register";
    }

    @RequestMapping(value = "/updateT1", method = RequestMethod.POST)
    public String updateT(String name, String pwd, String sex, int age, String phone, Model model) {
        String msg;
        model.addAttribute("phone", phone);
        model.addAttribute("age", age);
        model.addAttribute("sex", sex);
        model.addAttribute("pwd", pwd);
        model.addAttribute("name", name);
        if (name.isEmpty() || pwd.isEmpty() || phone.isEmpty()) {
            if (name.isEmpty()) {
                msg = "姓名不能为空";
                model.addAttribute("msg", msg);
                return "updateT";
            }
            if (pwd.isEmpty()) {
                msg = "密码不能为空";
                model.addAttribute("msg", msg);
                return "updateT";
            }
            if (phone.isEmpty()) {
                msg = "电话不能为空";
                model.addAttribute("msg", msg);
                return "updateT";
            }
        }
        String sexm = "男";
        String sexf = "女";
        if (!sex.equals(sexm)) {
            if (!sex.equals(sexf)) {
                msg = "性别只能为'男'或'女'";
                model.addAttribute("msg", msg);
                return "updateT";
            }
        }
        tuserService.updateTU(name, pwd, sex, age, phone);
        msg = "更新成功";
        model.addAttribute("msg", msg);
        return "updateT";
    }

    @RequestMapping(value = "/addM1", method = RequestMethod.POST)
    public String addM(int num, int tusernum, int teamnum, String manage, String date, String other, Model model) {
        String msg = null;
        if (date.isEmpty()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            int day = calendar.get(Calendar.DATE);
            date = year + "-" + "-" + month + "-" + day;
        }
        if (other.isEmpty()) {
            other = "无";
        }
        if (manage.isEmpty()) {
            manage = "报名";
        }
        model.addAttribute("tusernum", tusernum);
        model.addAttribute("num", num);
        model.addAttribute("teamnum", teamnum);
        model.addAttribute("manage", manage);
        model.addAttribute("date", date);
        model.addAttribute("other", other);
        String do1 = "报名";
        if (!manage.equals(do1)) {
            msg = "报名时操作只能为'报名'";
            model.addAttribute("msg", msg);
            return "addM";
        }
        auserService.addMU(num, tusernum, teamnum, manage, date, other);
        msg = "添加成功";
        model.addAttribute("msg", msg);
        return "addM";
    }

    @RequestMapping(value = "/updateM1", method = RequestMethod.POST)
    public String updateM(int num, int tusernum, int teamnum, String manage, String date, String other, Model model) {
        String msg = null;
        if (date.isEmpty()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            int day = calendar.get(Calendar.DATE);
            date = year + "-" + "-" + month + "-" + day;
        }
        if (other.isEmpty()) {
            other = "无";
        }
        model.addAttribute("tusernum", tusernum);
        model.addAttribute("num", num);
        model.addAttribute("teamnum", teamnum);
        model.addAttribute("manage", manage);
        model.addAttribute("date", date);
        model.addAttribute("other", other);
        String do1 = "报名";
        String do2 = "取消";
        if (!manage.equals(do1)) {
            if (!manage.equals(do2)) {
                msg = "操作只能为'报名'或'取消'";
                model.addAttribute("msg", msg);
                return "update";
            }
        }
        auserService.updateMU(num, tusernum, teamnum, manage, date, other);
        msg = "更新成功";
        model.addAttribute("msg", msg);
        return "update";
    }

    @RequestMapping(value = "/selectM1", method = RequestMethod.POST)
    public String selectM1(int tusernum, String manage, Model model) {
        String msg;
        model.addAttribute("manage", manage);
        model.addAttribute("tusernum", tusernum);
        if (manage.isEmpty() || tusernum == 0) {
            msg = "操作和游客编号不能为空";
            model.addAttribute("msg", msg);
            return "selectM";
        }
        String do1 = "报名";
        String do2 = "取消";
        if (!manage.equals(do1)) {
            if (!manage.equals(do2)) {
                msg = "操作只能为'报名'或'取消'";
                model.addAttribute("msg", msg);
                return "update";
            }
        }
        List<ManageBean> manageList = auserService.selectMUtusernum_manage(manage, tusernum);
        String tableHeaders = "<tr><th>订单编号</th><th>游客编号</th><th>旅游团编号</th><th>操作</th><th>日期</th><th>备注</th></tr>";
        String HTML = "";
        HTML += tableHeaders;
        Iterator<ManageBean> iterator = manageList.iterator();
        String pHTML;
        while (iterator.hasNext()) {
            ManageBean a = iterator.next();
            pHTML = "<tr><td>" + a.getMnum() + "</td><td>" + a.getTusernum() + "</td><td>" + a.getTeamnum() + "</td><td>" + a.getManage() + "</td><td>" + a.getMdate() + "</td><td>" + a.getMother() + "</td></tr>";
            HTML += pHTML;
        }
        msg = "查询结果如下";
        model.addAttribute("msg", msg);
        model.addAttribute("rs", "<table border='1' cellspacing='0' id='table'>" + HTML + "</table>");
        return "selectM";
    }

    @RequestMapping(value = "/selectR1", method = RequestMethod.POST)
    public String selectR(Model model) {
        List<RouteBean> routeList = auserService.selectRU();
        String tableHeaders = "<tr><th>旅游线路编号</th><th>特色景点</th><th>起始站</th><th>终点站</th><th>时间（天）</th></tr>";
        String HTML = "";
        HTML += tableHeaders;
        Iterator<RouteBean> iterator = routeList.iterator();
        String pHTML;
        while (iterator.hasNext()) {
            RouteBean a = iterator.next();
            pHTML = "<tr><td>" + a.getRoutenum() + "</td><td>" + a.getSpecialplace() + "</td><td>" + a.getBegin() + "</td><td>" + a.getEnd() + "</td><td>" + a.getLongtime() + "</td></tr>";
            HTML += pHTML;
        }
        String msg = "查询结果如下";
        model.addAttribute("msg", msg);
        model.addAttribute("rs", "<table border='1' cellspacing='0' id='table'>" + HTML + "</table>");
        return "selectR";
    }

    @RequestMapping(value = "/selectP1", method = RequestMethod.POST)
    public String selectP(Model model) {
        List<PlaceBean> placeList = auserService.selectPU();
        String tableHeaders = "<tr><th>景点编号</th><th>名称</th><th>地区</th><th>星级</th><th>门票</th><th>备注</th></tr>";
        String HTML = "";
        HTML += tableHeaders;
        Iterator<PlaceBean> iterator = placeList.iterator();
        String pHTML;
        while (iterator.hasNext()) {
            PlaceBean a = iterator.next();
            pHTML = "<tr><td>" + a.getPlacenum() + "</td><td>" + a.getPlacename() + "</td><td>" + a.getPlace() + "</td><td>" + a.getStar() + "</td><td>" + a.getTicket() + "</td><td>" + a.getPlaceother() + "</td></tr>";
            HTML += pHTML;
        }
        String msg = "查询结果如下";
        model.addAttribute("msg", msg);
        model.addAttribute("rs", "<table border='1' cellspacing='0' id='table'>" + HTML + "</table>");
        return "selectP";
    }

    @RequestMapping(value = "/selectTeam1", method = RequestMethod.POST)
    public String selectTeam(Model model) {
        List<TeamBean> teamList = auserService.selectTeamU();
        String tableHeaders = "<tr><th>旅游团编号</th><th>名称</th><th>电话</th><th>路线编号</th><th>备注</th></tr>";
        String HTML = "";
        HTML += tableHeaders;
        Iterator<TeamBean> iterator = teamList.iterator();
        String pHTML;
        while (iterator.hasNext()) {
            TeamBean a = iterator.next();
            pHTML = "<tr><td>" + a.getTeamrnum() + "</td><td>" + a.getTeamname() + "</td><td>" + a.getTeamphone() + "</td><td>" + a.getTeamrnum() + "</td><td>" + a.getTeamother() + "</td></tr>";
            HTML += pHTML;
        }
        String msg = "查询结果如下";
        model.addAttribute("msg", msg);
        model.addAttribute("rs", "<table border='1' cellspacing='0' id='table'>" + HTML + "</table>");
        return "selectTeam";
    }
}