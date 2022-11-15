package com.xdu.irent.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author zbq
 * @date 2022/10/25 12:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class House {

    private Long id;
    private Long landlord_id;
    private String title;
    private String address;
    private String houseType;
    private Integer rooms;
    private Double money;
    private String photo;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;
    private int state;

}
