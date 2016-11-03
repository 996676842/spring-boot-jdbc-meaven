<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="com.bonc.tender.entity.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<script>
	$(function() {

		$("input[name='delete']").click(function() {
			$.ajax({
				type : "post",
				url : "delete",
				data : {
					"name" : $(this).parent().prev().prev().prev().text()
				}

			});
			$(this).parent().parent().remove();
		});

		$("input[name='update']").click(function() {
			var input = document.createElement('input'); //创建input节点
			input.setAttribute('type', 'hidden'); //定义类型是文本输入
			input.setAttribute('name', 'id');
			input.setAttribute('id', 'id');
			document.getElementById('form_up').appendChild(input); //添加到form中显示

			var idValue = $(this).parent().prev().prev().prev().prev().text();
			document.getElementById("id").value = idValue;

			var nameValue = $(this).parent().prev().prev().prev().text();
			document.getElementById("name").value = nameValue;

			var classesValue = $(this).parent().prev().prev().text();
			document.getElementById("classes").value = classesValue;

			var gradeValue = $(this).parent().prev().text();
			document.getElementById("grade").value = gradeValue;

		});
	})
</script>
<style>
div, ul, li {
	margin: 0px;
	padding: 0px;
}

li {
	list-style: none;
	float: left;
	width: 120px;
	height: 24px;
	line-height: 24px;
	text-align: center;
	border: solid 1px black;
}

#cart {
	width: 620px;
	text-align: center;
}

#form_create {
	width: 224px;
}

#form_create input {
	
}

.page {
	width: 450px;
	margin-left: 210px;
}
#select{
width:500px;
}
</style>
</head>
<body>

	<h2>显示学生信息</h2>
	<form action="remove">
	<input type="submit" value="显示所有信息">
	</form>
	<div id="cart">
		<ul>
			<li>Id号</li>
			<li>姓名</li>
			<li>班级</li>
			<li>成绩</li>
			<li>操作</li>

		</ul>


		<c:forEach items="${studentList}" var="stu">

			<ul>
				<li>${stu.id}</li>
				<li>${stu.name}</li>
				<li>${stu.classes}</li>
				<li>${stu.grade}</li>
				<li><input type="button" value="删除" name="delete"
					class="delete"> <input type="button" value="修改信息"
					name="update" class="update"></li>
			</ul>
		</c:forEach>



	</div>
	<div class="page">
		<a href="showAll?p=${prePage }"> <input class="btn1" type="button"
			value="上一页" onClick="">
		</a> <a href="showAll?p=${nextPage }"> <input class="btn1"
			type="button" value="下一页" onClick="">
		</a>

	</div>
	<div id="form_create">
		<h2>更新学生信息</h2>
		<form name="form_up" id="form_up" method="post" action="update">

			姓名：<input type="text" name="name" id="name"><br> 班级：<input
				type="text" name="classes" id="classes"><br> 成绩：<input
				type="text" name="grade" id="grade"><br> <input
				type="submit" value="提交"> <input type="reset" value="清除">
		</form>
	</div>
	
	<div id="select">
	<h2>根据条件查询学生信息</h2>
	  <form name="form_select" id="form_select" method="post" action="savekey">
	  <select name="choice">
	  <option value="name">姓名</option>
	  <option value="class">班级</option>
	  <option value="grade">成绩</option>
	  </select>
	  <input type="text" name="str" id="str">
	  <input type="submit" value="提交">
	  </form>
	</div>

</body>
</html>