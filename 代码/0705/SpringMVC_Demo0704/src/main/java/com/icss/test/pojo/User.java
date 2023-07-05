package com.icss.test.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor //无参数构造方法
@AllArgsConstructor //全部参数的构造方法
@Data //get方法和set方法
@ToString
public class User implements Serializable {

    private static final long serialVersionUID = -7648620824938355761L;
// null
    private String uname;
    private String pwd;
    private Integer age;

//    按照传入参数的日期类型格式 进行接收
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;






}
