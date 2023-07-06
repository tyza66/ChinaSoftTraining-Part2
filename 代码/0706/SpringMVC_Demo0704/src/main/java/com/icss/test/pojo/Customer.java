package com.icss.test.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer implements Serializable {

    private static final long serialVersionUID = 3790998957176847031L;

    private Integer cid;
    private String cname;
    private String cpwd;

}
