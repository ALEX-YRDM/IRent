package com.xdu.irent.vo;

import com.xdu.irent.pojo.Renter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zbq
 * @date 2022/11/13 16:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RenterVo {

    private Renter renter;
    private String msg;
}
