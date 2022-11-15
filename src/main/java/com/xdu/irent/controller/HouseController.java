package com.xdu.irent.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xdu.irent.pojo.House;
import com.xdu.irent.service.HouseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zbq
 * @date 2022/11/14 14:09
 */
@ApiOperation("房屋操作的接口")
@RestController
public class HouseController {
    @Autowired
    private HouseService houseService;
    @Autowired
    private ObjectMapper mapper;
    @ApiOperation("添加房屋信息,需要房东的id:lid")
    @PostMapping(value = "/house/{lid}/add",produces = "application/json;charset=utf-8")
    public void addHouse(@PathVariable Long lid,
                           @RequestParam String title,
                           @RequestParam String address,
                           @RequestParam String houseType,
                           @RequestParam Integer rooms,
                           @RequestParam Double money,
                           @RequestParam String photo){
        House house=new House();
        house.setLandlord_id(lid);
        house.setTitle(title);
        house.setAddress(address);
        house.setHouseType(houseType);
        house.setRooms(rooms);
        house.setMoney(money);
        house.setPhoto(photo);
        houseService.addHouse(house);
    }

    @ApiOperation("修改房屋状态信息,0代表待租赁,1表示已租出")
    @GetMapping("/house/{id}/updateState")
    public void updateState(@PathVariable Long id,@RequestParam int state){
        houseService.updateHouseState(id, state);
    }


}
