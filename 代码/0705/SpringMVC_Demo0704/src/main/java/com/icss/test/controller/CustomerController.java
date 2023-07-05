package com.icss.test.controller;

import com.icss.test.pojo.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

//    保存顾客信息
    @PostMapping
//    @RequestBody 代表接收json字符串对象
    public boolean saveCus(@RequestBody Customer customer){
        System.out.println("保存顾客信息");
        System.out.println("customer" + customer);
        return true;
    }

//    修改顾客信息
//    @PutMapping("/customer")
    @PutMapping
    public boolean UpdateCus(@RequestBody Customer customer){
        System.out.println("修改顾客信息");
        System.out.println("customer " + customer);
        return true;
    }
//    删除顾客信息 http://localhost:8081/customer/1
//    @DeleteMapping("/customer/{cid}")
    @DeleteMapping("/{cid}")
    public boolean deleteCusById(@PathVariable("cid") Integer cid){
        System.out.println("删除顾客信息");
        System.out.println("cid " + cid);
        return true;
    }

//    查看所有顾客信息
//    @GetMapping("/customer")
    @GetMapping
    public List<Customer> selectAllCus(){
        System.out.println("查询所有的员工信息");
        List<Customer> list = new ArrayList<>();
        list.add(new Customer(1,"tom","abc"));
        list.add(new Customer(2,"jack","hui"));
        return list;
    }

//    根据顾客编号查询顾客信息
//    @GetMapping("/customer/{cid}")
    @GetMapping("/{cid}")
    public Customer selectCusById(@PathVariable Integer cid){
        System.out.println("根据顾客编号查询顾客信息");
        return new Customer(3,"模拟用户","kkk");
    }

//    分页查询顾客数据
//    currpage 当前页 ,pageNum 每页显示的数目  可以作为前端传递的参数
//    @GetMapping("/customer/{currpage}/{pageNum}")
    @GetMapping("/{currpage}/{pageNum}")
    public List<Customer> selectCusByPage(@PathVariable Integer currpage,@PathVariable Integer pageNum){
        System.out.println("当前页 " + currpage + "每页显示的数目 " + pageNum);
        List<Customer> list = new ArrayList<>();
        list.add(new Customer(1,"tom","abc"));
        list.add(new Customer(2,"jack","hui"));
        return list;
    }




}
