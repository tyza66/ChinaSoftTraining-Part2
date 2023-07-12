$(function(){
    //    查看所有的用户
    selectAllCus(1);
})

//查询所有的用户
// traditional:true  防止对数组序列化  {ids:ids} ids 数组 选中项目的id 后端request.getParameterValues()
function selectAllCus(currpage){
    //清空的操作
    $("#content").html("");
    $("#page").html("");
    $.ajax({
        type:"get",
        url:"SelectAllCusServlet",
        data:{"currpage":currpage},
        dataType:"json",
        success:function(res){
            $.each(res.list,function(index,tmp){
                $("table").append(`<tr>
                        <td><input type="checkbox" name="ids" value="${tmp.cid}"></td>
                        <td>${tmp.cid}</td>
                        <td>${tmp.cname}</td>
                         <td>${tmp.cpwd}</td>
                         <td>${tmp.cage}</td>
                         <td><a href="javascript:deleteCusById(${tmp.cid})">删除</td>
                         <td><a href="javascript:showCus(${tmp.cid},'${tmp.cname}',${tmp.cpwd},${tmp.cage})" >修改</a></td>
                       </tr>`);
            })

            //    添加页码
            let y = `<nav> <ul class="pagination"><li><a href="javascript:selectAllCus(${currpage - 1 <= 0 ? 1 : currpage - 1})" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a> </li>`;
            for (let i = 1; i <= res.pager.pageNum; i++) {
                y += ` <li><a href="javascript:selectAllCus(${i})">${i}</a></li>`;
            }
            y += `<li>  <a href="javascript:selectAllCus(${currpage + 1 >= res.pager.pageNum ? res.pager.pageNum : currpage + 1 })" aria-label="Next"><span aria-hidden="true">&raquo;</span></a> </li></ul></nav>`;

            $("#page").append(y);


        },error:function(){
            alert("请求失败");
        }
    })


}

//按照用户编号删除员工
function deleteCusById(cid){
    // alert("cid" + cid);
    if (confirm("确认要删除吗")) {
        $.ajax({
            type:"get",
            url:"DeleteCusByIdServlet",
            data:{"cid":cid},
            dataType: "text",
            success:function(res){
                if (res == "true") {
                    //调用查询用户
                    selectAllCus(1);
                } else {
                    alert("删除失败");
                }
            }
        })
    }
}
//用户信息回显
function showCus(cid,cname,cpwd,cage){
    //开启模态框
    $("#myModal").modal("show");
    $("#inputCid").val(cid);
    $("#inputCname").val(cname);
    $("#inputPassword").val(cpwd);
    $("#inputCage").val(cage);
}

//修改用户信息
$("#updateBtn").click(function(){
    $.ajax({
        type:"post",
        url:"UpdateCusByIdServlet",
        data:{"cid":$("#inputCid").val(),"cname": $("#inputCname").val(),"cpwd": $("#inputPassword").val(),"cage":$("#inputCage").val()},
        dataType:"text",
        success:function(res){
            if (res == "true") {
                //调用查询用户
                selectAllCus(1);
            } else {
                alert("修改失败");
            }
            $("#myModal").modal("hide");
        }
    })

})
// 全选与反选
$("#chose").click(function(){
    $("input[name=ids]").prop("checked", $("#chose").prop("checked"));
})

//删除选中项目
$("#delSelectedBtn").click(function(){
    //    验证：要求必须选中一个
    //    1 获取选中的复选框的用户编号 存储在数组中
    let arr = [];
    $.each( $("input[name=ids]:checked"),function(index,tmp){
        // console.log($(tmp).val());
        arr.push($(tmp).val());
    })

    $.ajax({
        type:"get",
        url:"DeleteSelectedByIdsServlet",
        data:{"ids":arr},
        traditional:true,
        dataType:"json",
        success:function(res){//json 则返回布尔类型的值
            console.log("res",res);
            if (res == true) {
                selectAllCus(1);
            } else {
                alert("删除选中的项目失败");
            }
        },error(){
            alert("请求失败");
        }
    })

})

//    根据用户输入 多条件的查找
function selectCusByNameAndAge(currpage){
    //清空的操作
    $("#content").html("");
    $("#page").html("");
    $.ajax({
        type:"get",
        url:"SelectCusByNameAndAgeServlet",
        data:{"cname":$("#searchName").val(),"cage":$("#searchAge").val(),"currpage":currpage},
        dataType:"json",
        success(res){
            $.each(res.list,function(index,tmp){
                $("table").append(`<tr>
                        <td><input type="checkbox" name="ids" value="${tmp.cid}"></td>
                        <td>${tmp.cid}</td>
                        <td>${tmp.cname}</td>
                         <td>${tmp.cpwd}</td>
                         <td>${tmp.cage}</td>
                         <td><a href="javascript:deleteCusById(${tmp.cid})">删除</td>
                         <td><a href="javascript:showCus(${tmp.cid},'${tmp.cname}',${tmp.cpwd},${tmp.cage})" >修改</a></td>
                       </tr>`);
            })

            //    添加页码
            let y = `<nav> <ul class="pagination"><li><a href="javascript:selectCusByNameAndAge(${currpage - 1 <= 0 ? 1 : currpage - 1})" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a> </li>`;
            for (let i = 1; i <= res.pager.pageNum; i++) {
                y += ` <li><a href="javascript:selectCusByNameAndAge(${i})">${i}</a></li>`;
            }
            y += `<li>  <a href="javascript:selectCusByNameAndAge(${currpage + 1 >= res.pager.pageNum ? res.pager.pageNum : currpage + 1 })" aria-label="Next"><span aria-hidden="true">&raquo;</span></a> </li></ul></nav>`;

            $("#page").append(y);
        },error(){
            alert("按条件查找请求失败");
        }
    })
}