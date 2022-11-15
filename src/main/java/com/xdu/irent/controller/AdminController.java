package com.xdu.irent.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xdu.irent.dao.AdminMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zbq
 * @date 2022/11/14 16:29
 */
@ApiOperation(value = "管理员接口,用来获取所有后台数据")
@RestController
public class AdminController {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private ObjectMapper mapper;
    @ApiOperation(value = "获取所有租客信息")
    @ResponseBody
    @GetMapping("/admin/getAllRenter")
    public String getRenter() throws JsonProcessingException {
        return mapper.writeValueAsString(adminMapper.getAllRenter());
    }

    @ApiOperation("获取所有房东信息")
    @ResponseBody
    @GetMapping("/admin/getAllLandlord")
    public String getLandlord() throws JsonProcessingException {
        return mapper.writeValueAsString(adminMapper.getAllLandlord());
    }
    @ApiOperation("获取所有房屋信息")
    @ResponseBody
    @GetMapping("/admin/getAllHouse")
    public String getHouse() throws JsonProcessingException {
        return mapper.writeValueAsString(adminMapper.getAllHouse());
    }
    @ApiOperation("获取所有交易记录信息")
    @ResponseBody
    @GetMapping("/admin/getAllRecord")
    public String getRecord()throws JsonProcessingException{
        return mapper.writeValueAsString(adminMapper.getAllRecord());
    }


}
