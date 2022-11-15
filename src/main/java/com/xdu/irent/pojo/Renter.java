package com.xdu.irent.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author zbq
 * @date 2022/10/25 12:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Renter {
    private Long id;
    private String nickName;
    private String userName;
    private String password;
    private Integer gender;
    private String phoneNumber;
    private String email;
    private String address;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
}
