package com.xdu.irent.vo;

import com.xdu.irent.pojo.Landlord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zbq
 * @date 2022/11/14 13:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LandlordVo {
    private Landlord landlord;
    private String msg;
}
