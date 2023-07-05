package com.sdm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Author: tyza66
 * Date: 2023/7/5 12:48
 * Github: https://github.com/tyza66
 **/

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer implements Serializable {

    private static final long serialVersionUID = -833151884485511235L;

    private Integer id;
    private Integer name;
}
