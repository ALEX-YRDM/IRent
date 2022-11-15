package com.xdu.irent.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author zbq
 * @date 2022/10/25 13:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Landlord {
    private Long id;
    private String nickName;
    private String userName;
    private String password;
    private String email;
    private String phoneNumber;
    private String address;
    private Integer gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
}
