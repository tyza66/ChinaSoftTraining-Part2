package com.sdm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Author: tyza66
 * Date: 2023/7/4 15:12
 * Github: https://github.com/tyza66
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User implements Serializable {

    private static final long serialVersionUID = 900837982303960753L;

    private String name;
    private String pwd;
    private Integer age;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
}
