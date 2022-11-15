package com.xdu.irent.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xdu.irent.pojo.Landlord;
import com.xdu.irent.service.LandlordService;
import com.xdu.irent.vo.LandlordVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zbq
 * @date 2022/11/14 13:13
 */
@ApiOperation("房东操作的接口")
@RestController
public class LandlordController {
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private LandlordService landlordService;
    @ApiOperation("根据用户名和密码查询房东")
    @ResponseBody
    @GetMapping(value = "/landlord/login",produces = "application/json;charset=utf-8")
    public String landlordLogin(@RequestParam String username, @RequestParam String password, HttpSession session) throws JsonProcessingException {
        Landlord landlord = landlordService.findLandlordByUsernameAndPassword(username, password);
        if(landlord!=null){
            session.setAttribute("landlord",landlord);
            return mapper.writeValueAsString(new LandlordVo(landlord,landlord.getNickName()+"登陆成功"));
        }else{
            return mapper.writeValueAsString(new LandlordVo(null,"用户名或密码错误"));
        }
    }
    @ApiOperation("用户退出登录,好像没什么用")
    @GetMapping("/landlord/logout")
    public String landlordLogout(HttpSession session){
        session.removeAttribute("landlord");
        return "注销成功";
    }
    @ApiOperation("注册房东信息")
    @PostMapping("/landlord/register")
    public void landlordRegister(@RequestParam String nickname,
                                   @RequestParam String username,
                                   @RequestParam String password,
                                   @RequestParam String email,
                                   @RequestParam String phoneNumber,
                                   @RequestParam String address,
                                   @RequestParam String gender,
                                   @RequestParam Date birthday) throws JsonProcessingException {
        Landlord landlord=new Landlord();
        landlord.setAddress(address);
        landlord.setBirthday(birthday);
        landlord.setEmail(email);
        landlord.setNickName(nickname);
        landlord.setUserName(username);
        landlord.setPassword(password);
        landlord.setPhoneNumber(phoneNumber);
        if(gender.equals("男"))
            landlord.setGender(1);
        else
            landlord.setGender(0);
        landlordService.addLandlord(landlord);
    }
    @ApiOperation("修改房东信息,需要传递房东id进行修改")
    @PostMapping("/landlord/{id}/update")
    public void landlordUpdate(@RequestParam String nickname,
                               @RequestParam String username,
                               @RequestParam String password,
                               @RequestParam String email,
                               @RequestParam String phoneNumber,
                               @RequestParam String address,
                               @RequestParam String gender,
                               @RequestParam Date birthday,
                               @PathVariable Long id){
        Landlord landlord=new Landlord();
        landlord.setAddress(address);
        landlord.setBirthday(birthday);
        landlord.setEmail(email);
        landlord.setNickName(nickname);
        landlord.setUserName(username);
        landlord.setPassword(password);
        landlord.setPhoneNumber(phoneNumber);
        if(gender.equals("男"))
            landlord.setGender(1);
        else
            landlord.setGender(0);
        landlord.setId(id);
        landlordService.updateLandlord(landlord);
    }
    @ApiOperation("根据id删除房东")
    @GetMapping("/landlord/{id}/delete")
    public void deleteLandlord(@PathVariable Long id){
        landlordService.deleteById(id);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期 注意这里的转化要和传进来的字符串的格式一直 如2015-9-9 就应该为yyyy-MM-dd
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }

    @ApiOperation("根据id获取房东的所有房屋")
    @ResponseBody
    @GetMapping(value = "/landlord/{lid}/getHouse")
    public String getLandlordHouse(@PathVariable Long lid) throws JsonProcessingException {
        return mapper.writeValueAsString(landlordService.getHouseByLid(lid));
    }


}
