<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RDF-presentation</title>
<link rel="icon" href="images/aitech_head.ico" type="image/x-icon">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link href="css/index.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<!-- 页眉 -->
<nav class="navbar navbar-fixed-top navbar-inverse navbar-md navbar-embossed" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-9">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<img src="images/Aitech1.png" class="pull-left" id="logo" />
			<a class="navbar-brand" href="#">爱智慧科技</a>
		</div>
	</div>
</nav>

<div class="doc-header">
    <div class="container">
        <h1>查尔德系统</h1>
        <p class="lead">直观了解我们的产品</p>
    </div>
</div>

<!-- 内容 -->
<div class="container-fluid col-md-offset-2 col-md-8 container-main">
	<div class="row-fluid">
		<div class="span12">
			<form role="form">
				<div class="form-group">
					<label for="name"></label>
					<textarea class="form-control" id="textarea_id" rows="5"></textarea>
				</div>
			</form>
		</div>
		<div class="span3"></div>
	</div>
	<button type="button" class="btn btn-primary" id="content_id">解析</button>
	
	<!-- 进度条 -->
	<%-- <div class="progress progress-striped active">
		<div class="progress-bar progress-bar-success" role="progressbar" 
			aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" 
			style="width: 70%;">
			<span>40%</span>
		</div>
	</div> --%>

	<!-- 横线 -->
	<div class="line"></div>
	
	<!-- 解析的结果 -->
	<div class="table-responsive">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>主语</th>
					<th>谓语</th>
					<th>宾语</th>
					<th>时间</th>
				</tr>
			</thead>
			<tbody class="add-tuple">
				<!-- <tr>
					<td>张三</td>
					<td>去</td>
					<td>发货</td>
					<td>23/11/2013</td>
				</tr> -->
			</tbody>
		</table>
	</div>

</div>

<!-- 备案信息 -->
<!-- <div class="container doc-footer">
	<div class="row">
		<div class="col-md-12">
			<p style="text-align: center;">
				深圳市爱智慧科技有限公司
				&nbsp;&nbsp;
				<a href="http://www.miitbeian.gov.cn" >粤ICP备16077995号</a>
			</p>
		</div>
	</div>
</div> -->

<script src="js/parse_naf.js"></script>

</body>
</html>