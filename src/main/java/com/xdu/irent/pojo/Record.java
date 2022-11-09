package com.xdu.irent.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zbq
 * @date 2022/11/7 22:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record {

    private Long id;
    private Long r_id;
    private Long l_id;
    private Long h_id;
    private Date tradeTime;

}
