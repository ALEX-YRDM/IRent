package com.xdu.irent.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xdu.irent.pojo.Landlord;
import com.xdu.irent.pojo.Renter;
import com.xdu.irent.service.LandlordService;
import com.xdu.irent.service.RenterService;
import com.xdu.irent.vo.RenterVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zbq
 * @date 2022/11/14 13:13
 */
@ApiOperation("租客操作接口")
@RestController
public class RenterController {
    @Autowired
    private RenterService renterService;
    @Autowired
    private ObjectMapper mapper;
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期 注意这里的转化要和传进来的字符串的格式一直 如2015-9-9 就应该为yyyy-MM-dd
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }
    @ApiOperation("根据用户名和密码查询租客账号")
    @ResponseBody
    @GetMapping(value = "/renter/login",produces = "application/json;charset=utf-8")
    public String renterLogin(@RequestParam String username, @RequestParam String password, HttpSession session, RedirectAttributes attributes) throws JsonProcessingException {
        Renter renter = renterService.findRenterByUsernameAndPassword(username, password);
        RenterVo renterVo=new RenterVo();
        if(renter!=null){
            session.setAttribute("renter",renter);
            renterVo.setRenter(renter);
            renterVo.setMsg(renter.getNickName()+"登陆成功");
            return mapper.writeValueAsString(renterVo);
        }else{
            attributes.addAttribute("msg","用户名或密码错误");
            renterVo.setRenter(null);
            renterVo.setMsg("用户名或密码错误");
            return mapper.writeValueAsString(renterVo);
        }
    }


    @ApiOperation("租客退出登录,好像没什么用")
    @GetMapping("/renter/logout")
    public String renterLogout(HttpSession session){
        session.removeAttribute("renter");
        return "注销成功";
    }
    @ApiOperation("租客注册信息")
    @PostMapping("/renter/register")
    public void renterRegister(@RequestParam String nickname,
                                 @RequestParam String username,
                                 @RequestParam String password,
                                 @RequestParam String email,
                                 @RequestParam String phoneNumber,
                                 @RequestParam String address,
                                 @RequestParam String gender,
                                 @RequestParam Date birthday){
        Renter renter=new Renter();
        renter.setNickName(nickname);
        renter.setUserName(username);
        renter.setPassword(password);
        renter.setEmail(email);
        renter.setPhoneNumber(phoneNumber);
        renter.setAddress(address);
        renter.setBirthday(birthday);
        if(gender.equals("男")) renter.setGender(1);
        else renter.setGender(0);
        renterService.addRenter(renter);

    }
    @ApiOperation("根据id修改租客信息")
    @PostMapping("/renter/{id}/update")
    public void renterUpdate(@RequestParam String nickname,
                               @RequestParam String username,
                               @RequestParam String password,
                               @RequestParam String email,
                               @RequestParam String phoneNumber,
                               @RequestParam String address,
                               @RequestParam String gender,
                               @RequestParam Date birthday,
                               @PathVariable Long id){
        Renter renter=new Renter();
        renter.setNickName(nickname);
        renter.setUserName(username);
        renter.setPassword(password);
        renter.setEmail(email);
        renter.setPhoneNumber(phoneNumber);
        renter.setAddress(address);
        renter.setBirthday(birthday);
        if(gender.equals("男")) renter.setGender(1);
        else renter.setGender(0);
        renter.setId(id);
        renterService.updateRenter(renter);
    }
    @ApiOperation("根据id删除租客")
    @GetMapping("/renter/{id}/delete")
    public void deleteRenter(@PathVariable Long id){
        renterService.deleteRenterById(id);
    }
    @ApiOperation("查询所有可以租用的房屋")
    @ResponseBody
    @GetMapping("/renter/getNotRentedHouse")
    public String getNotRentedHouse() throws JsonProcessingException {
        return mapper.writeValueAsString(renterService.getNotRentedHouse());
    }
    @ApiOperation("根据输入框信息查询房屋")
    @ResponseBody
    @GetMapping("/renter/searchHouse")
    public String searchHouse(@RequestParam String text) throws JsonProcessingException {
        return mapper.writeValueAsString(renterService.searchHouse(text));
    }

}
