<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<title>QuickStart示例:<sitemesh:title/></title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />

<link type="image/x-icon" href="${ctx}/static/images/favicon.ico" rel="shortcut icon">
<link href="${ctx}/static/bootstrap/2.1.1/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/jquery-validation/1.10.0/validate.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/styles/default.css" type="text/css" rel="stylesheet" />
<script src="${ctx}/static/jquery/1.7.2/jquery.min.js" type="text/javascript"></script>
<script src="${ctx}/static/jquery-validation/1.10.0/jquery.validate.min.js" type="text/javascript"></script>
<script src="${ctx}/static/jquery-validation/1.10.0/messages_bs_zh.js" type="text/javascript"></script>

	<!-- Le styles -->
	<!-- Use the raw LESS for debugging purposes -->
	<!--link rel="stylesheet/less" href="${ctx}/static/bootstrap05/less/style.less">
	<script src="${ctx}/static/bootstrap05/assets/js/less-1.4.2.min.js"></script>-->
	<!-- for PROD use the compiled CSS -->
    <link type="text/css" href="${ctx}/static/bootstrap05/less/style.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="${ctx}/static/bootstrap05/assets/css/font-awesome.min.css">
    <!--[if IE 7]>
    <link rel="stylesheet" href="${ctx}/static/bootstrap05/assets/css/font-awesome-ie7.min.css">
    <![endif]-->
    <!--[if lt IE 9]>
    <link rel="stylesheet" href="${ctx}/static/bootstrap05/css/custom-theme/jquery.ui.1.10.2.ie.css">
    <![endif]-->
    <link rel="stylesheet" href="${ctx}/static/bootstrap05/assets/css/docs.css">
    <link rel="stylesheet" href="${ctx}/static/bootstrap05/assets/js/google-code-prettify/prettify.css">

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${ctx}/static/bootstrap05/assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${ctx}/static/bootstrap05/assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${ctx}/static/bootstrap05/assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="${ctx}/static/bootstrap05/assets/ico/apple-touch-icon-57-precomposed.png">
    <link rel="shortcut icon" href="${ctx}/static/bootstrap05/assets/ico/favicon.png">
	
	<link href="${ctx}/static/wizard/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- custom styles -->
	<link href="${ctx}/static/wizard/examples/custom.css" rel="stylesheet">
	<link href="${ctx}/static/wizard/prettify.css" rel="stylesheet">


<sitemesh:head/>
</head>

<body>
	<div class="container">
		<%@ include file="/WEB-INF/layouts/header.jsp"%>
		<div id="content">
			<sitemesh:body/>
		</div>
		<%@ include file="/WEB-INF/layouts/footer.jsp"%>
	</div>
	<script src="${ctx}/static/bootstrap/2.1.1/js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>