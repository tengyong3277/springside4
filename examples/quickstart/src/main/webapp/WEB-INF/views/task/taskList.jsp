<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>任务管理</title>
</head>

<body>
	<c:if test="${not empty message}">
		<div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
	</c:if>
	<div class="row">
		<div class="span4 offset7">
			<form class="form-search" action="#">
			 	<label>名称：</label> <input type="text" name="search_LIKE_title" class="input-medium" value="${param.search_LIKE_title}"> 
			    <button type="submit" class="btn">Search</button>
		    </form>
	    </div>
	    <tags:sort/>
	</div>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>任务</th><th>管理</th></tr></thead>
		<tbody>
		<c:forEach items="${tasks.content}" var="task">
			<tr>
				<td><a href="${ctx}/task/update/${task.id}">${task.title}</a></td>
				<td><a href="${ctx}/task/delete/${task.id}">删除</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<tags:pagination page="${tasks}" paginationSize="5"/>

	<div><a class="btn" href="${ctx}/task/create">创建任务</a></div>
	
	<div class='container'>
		
		<div class="span12">
			<section id="wizard">
			  <div class="page-header">
	            <h1>设置屏幕信息</h1>
	          </div>
	
				<div id="rootwizard">
					<ul>
					  	<li><a href="#tab1" data-toggle="tab"><span class="label">1</span> 基本设置</a></li>
						<li><a href="#tab2" data-toggle="tab"><span class="label">2</span> 租用设置</a></li>
						<li><a href="#tab3" data-toggle="tab"><span class="label">3</span>店面照片和标题</a></li>
						
					</ul>
					<div class="tab-content">
					    <div class="tab-pane" id="tab1">
					      1
					    </div>
					    <div class="tab-pane" id="tab2">
					      2
					    </div>
						<div class="tab-pane" id="tab3">
							3
					    </div>
						
						<ul class="pager wizard">
							<li class="previous first" style="display:none;"><a href="#">First</a></li>
							<li class="previous"><a href="#">上一步</a></li>
							<li class="next last" style="display:none;"><a href="#">Last</a></li>
						  	<li class="next"><a href="#">下一步</a></li>
						</ul>
					</div>	
				</div>
			</section>
 		</div>
	</div>
	
	
	
	<script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="${ctx}/static/wizard/bootstrap/js/bootstrap.min.js"></script>
	<script src="${ctx}/static/wizard/jquery.bootstrap.wizard.js"></script>
	<script src="${ctx}/static/wizard/prettify.js"></script>
	

	<script>
	$(document).ready(function() {
	  	$('#rootwizard').bootstrapWizard({'tabClass': 'bwizard-steps'});
	  	
	  	
		window.prettyPrint && prettyPrint()
	});	
	</script>
</body>
</html>
