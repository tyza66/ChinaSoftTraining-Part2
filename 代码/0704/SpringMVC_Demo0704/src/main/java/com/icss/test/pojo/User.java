package com.icss.test.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor //无参数构造方法
@AllArgsConstructor //全部参数的构造方法
@Data //get方法和set方法
public class User implements Serializable {

    private static final long serialVersionUID = -7648620824938355761L;
// null
    private String uname;
    private String pwd;
    private Integer age;


}
