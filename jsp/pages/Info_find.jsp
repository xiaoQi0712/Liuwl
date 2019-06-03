<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
 <base href="<%=basePath %>">
	<meta charset="UTF-8">
	<title>销售机会管理</title>
	<link rel="stylesheet" href="layui/css/layui.css">
	<script src="js/form.js"></script>
</head>
<body>
	<div class="list">
		<span class="layui-breadcrumb">
  <a href="">首页</a>
  <a href="">列表页</a>
  <a href="">客户信息管理</a>
 
</span>
	</div>
	<div class="listOne">
		
	</div>
	<div class="inp">
		<form class="layui-form" action="">
  <div class="layui-form-item">
   
    <div class="layui-input-block" style="margin-left:20px">
      <input type="text" name="title"    placeholder="请输入客户名称" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
   
    <div class="layui-input-block" style="margin-left:230px;margin-top:-52px">
      <input type="text" name="title"    placeholder="请输入客户名称" autocomplete="off" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item">
   
    <div style="margin-left:440px;margin-top:-52px;" class="layui-input-block" >
      <select name="city" lay-verify="required">
        <option value=""></option>
        <option value="0">华中</option>
        <option value="1">华北</option>
        <option value="2">华南</option>
        <option value="3">华东</option>
        
      </select>
    </div>
  </div>
  <div class="layui-form-item" >
   
    <div class="layui-input-block" style="margin-left:650px;margin-top:-52px;" >
      <select name="city" lay-verify="required">
        <option value=""></option>
        <option value="0">1</option>
        <option value="1">2</option>
        <option value="2">3</option>
        <option value="3">4</option>
        
      </select>
    </div>
  </div>
  
  
</form>
  <div class="layui-input-block" style="margin-left:900px;margin-top:-54px">
     <button id="fun" class="layui-btn layui-btn-normal">查询</button>
      <button type="reset" class="resrt">重置</button>
    </div>


	<div class="tab">
		<table class="layui-table">
  <colgroup>
    <col width="150">
    <col width="200">
    <col>
  </colgroup>
  <thead>
    <tr>
      <th>序号</th>
      <th>客户名称</th>
      <th>客户经理</th>
      <th>所属地区</th>
      <th>客户等级</th>
	 
	  <th >操作</th>


    </tr> 
  </thead>
  <tbody>
    <c:forEach items="${list }" var="customer" varStatus="status">
    <tr>
      <td>${status.index+1 }</td>
      <td>${customer.cust_name }</td>
      <td>${customer.cust_manager_name }</td>
      <td>${customer.cust_region }</td>
      <td>${customer.cust_level_label }</td>
     
      <td class="test">
      	
      	<i id="first" value="${customer.cust_id }" class="layui-icon layui-icon-edit" style="font-size: 20px; color: #1E9FFF;padding:15px"></i> 
        <i id="user" value="${customer.cust_id }"  class="layui-icon layui-icon-username" style="font-size: 20px; color: #1E9FFF;padding:15px"></i>  
      	<i value="${customer.cust_id }" class="layui-icon layui-icon-read" title="编辑" style="font-size: 20px; color: #1E9FFF;padding:15px"></i>
        <i value="${customer.cust_id }" class="layui-icon layui-icon-delete" style="font-size: 20px; color: #1E9FFF;padding:15px"></i>    
      </td>

    </tr>
  	</c:forEach> 
    
  </tbody>
</table>
	</div>
  <div id="test1" style="margin-left:400px"></div>
 
<script>
    layui.use('laypage', function(){
  var laypage = layui.laypage;
  
	  //执行一个laypage实例
	  laypage.render({
	    elem: 'test1' //注意，这里的 test1 是 ID，不用加 # 号
	    ,count: 50 //数据总数，从服务端得到
	  });
	});
	 $('.layui-icon-edit').on('click', function(){
		
    layer.open({
      type: 1,
      area: ['600px', '360px'],
      shadeClose: true, //点击遮罩关闭
      content:`<div style="padding:20px;">
      <form id="custForm" action="cust/updatecustomer" method="post">

      <div class="layui-form-item">
      	
      <input id="hidden1" type="hidden" name="cust_id" value="" >
      	
        <div class="layui-input-block">
          <input style="width:400px;height:30px;margin-top:15px" type="text" name="cust_name" required  lay-verify="required" placeholder="请输入客户名称" autocomplete="off" class="layui-input">
        </div>
         
        <div class="layui-input-block">
          <input style="width:400px;height:30px;margin-top:15px" type="text" name="cust_manager_name" value="${user.usr_name }"  readonly="readonly" required  lay-verify="required" placeholder="请输入客户经理名称" autocomplete="off" class="layui-input">
        </div>
      
        <div class="layui-input-block">
          <input style="width:400px;height:30px;margin-top:15px" type="text" name="cust_addr" required  lay-verify="required" placeholder="请输入客户地址" autocomplete="off" class="layui-input">
        </div>
       
        <div class="layui-input-block">
          <input style="width:400px;height:30px;margin-top:15px" type="text" name="cust_zip" required  lay-verify="required" placeholder="请输入邮政编码" autocomplete="off" class="layui-input">
        </div>
       
        <div class="layui-input-block">
          <input style="width:400px;height:30px;margin-top:15px" type="text" name="cust_tel" required  lay-verify="required" placeholder="请输入客户电话" autocomplete="off" class="layui-input">
        </div>
       
        <div class="layui-input-block">
          <input style="width:400px;height:30px;margin-top:15px" type="text" name="cust_fax" required  lay-verify="required" placeholder="请输入客户传真" autocomplete="off" class="layui-input">
        </div>
       
        <div class="layui-input-block">
          <input style="width:400px;height:30px;margin-top:15px" type="text" name="cust_website" required  lay-verify="required" placeholder="请输入客户网址" autocomplete="off" class="layui-input">
        </div>
        
        <div class="layui-input-block">
          <input style="width:400px;height:30px;margin-top:15px" type="text" name="cust_licence_no" required  lay-verify="required" placeholder="请输入注册号" autocomplete="off" class="layui-input">
        </div>

        
        <div class="layui-input-block">
          <input style="width:400px;height:30px;margin-top:15px" type="text" name="cust_chieftain" required  lay-verify="required" placeholder="请输入企业法人名称" autocomplete="off" class="layui-input">
        </div>
        
        <div class="layui-input-block">
          <input style="width:400px;height:30px;margin-top:15px" type="text" name="cust_bankroll" required  lay-verify="required" placeholder="请输入注册资金" autocomplete="off" class="layui-input">
        </div>
        
        <div class="layui-input-block">
          <input style="width:400px;height:30px;margin-top:15px" type="text" name="cust_turnover" required  lay-verify="required" placeholder="请输入年营业额" autocomplete="off" class="layui-input">
        </div>
        
        <div class="layui-input-block">
          <input style="width:400px;height:30px;margin-top:15px" type="text" name="cust_bank" required  lay-verify="required" placeholder="请输入开户行名称" autocomplete="off" class="layui-input">
        </div>
       
        <div class="layui-input-block">
          <input style="width:400px;height:30px;margin-top:15px" type="text" name="cust_bank_account" required  lay-verify="required" placeholder="请输入银行账号" autocomplete="off" class="layui-input">
        </div>
        
        
        
        <div class="layui-input-block">
          <input style="width:400px;height:30px;margin-top:15px" type="text" name="cust_local_tax_no" required  lay-verify="required" placeholder="请输入地税登记号" autocomplete="off" class="layui-input">
        </div>

        <div class="layui-input-block">
          <input style="width:400px;height:30px;margin-top:15px" type="text" name="cust_national_tax_no" required  lay-verify="required" placeholder="请输入国税登记号" autocomplete="off" class="layui-input">
        </div>
      
      </div>




    

   <div class="layui-form-item">
        
        
          <select  style="width:400px;height:30px;margin-left:110px" name="cust_region" lay-verify="required">
            <option value="华中">请选择地区</option>
            <option value="华中">华中</option>
            <option value="华北">华北</option>
            <option value="华南">华南</option>
            <option value="华东">华东</option>
            
          </select>
        
      </div>
      <div class="layui-form-item">
       
        
          <select style="width:400px;height:30px;margin-left:110px" name="cust_level_label" lay-verify="required">
            <option value="普通客户">请选择客户等级</option>
            <option value="普通客户">普通客户</option>
            <option value="重点开发客户">重点开发客户</option>
            <option value="大客户">大客户</option>
            <option value="合作伙伴">合作伙伴</option>
            <option value="战略合作伙伴">战略合作伙伴</option>
            
          </select>
        
      </div>
      





       <div class="layui-input-block">
      <button id="model" class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
      
    </div>
    </form>
       
      </div>`

    });
    
    var	cust_id = $(this).attr('value');
 	$('#hidden1').attr('value',cust_id);
    
    
  });
  
    
 
        
     
  	$(document).on('click','#model',function(){
                    
        	
        	$('.layui-body').load($('#custForm').submit());
        
            
        }); 
  
  
  			/* $(document).ready(function()
	      {
	        $(".layui-icon-edit").click(function()
	        {
	        	var	cust_id = $(this).attr('value');
	        	var url = "cust/changeCust?cust_id"+cust_id;
	        	$('#custForm').attr('action',url);
	        	$('#custForm').submit();
	        })
	      }); */
 
            $(document).ready(function()
      {
        $(".layui-icon-username").click(function()
        {
        	var	cust_id = $(this).attr('value');
	           $('.layui-body').load("cust/findlinkman?cust_id="+cust_id);
        })
      });
           $(document).ready(function()
      {
        $(".layui-icon-read").click(function()
        {
        	 var cust_id = $(this).attr('value');
           $('.layui-body').load("cust/findacv?cust_id="+cust_id);
        })
      })
   
         

   


      var	cust_id1 ;
    $('.layui-icon-delete').on('click', function(){
           
    	cust_id1 = $(this).attr('value');
             layer.confirm('确认删除？', {
         
        }, function(){
        	$('.layui-body').load("cust/deletecustomer?cust_id="+cust_id1); 
          layer.msg('删除成功', {icon: 1});
        }, function(){
          layer.msg('也可以这样', {
            time: 20000, //20s后自动关闭
            btn: ['明白了', '知道了']
          });
        });
            
            
          });
    $('#fun').click(function(){
      alert('查询');
    })




</script> 
	</div>

<script src="layui/layui.all.js"></script>


</body>
</html>