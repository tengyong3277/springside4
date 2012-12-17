<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div id="header" class="span12">
	<div id="title">
		<!--  
	    <h1><small>应用</small></h1>
	    -->
	    <shiro:user>
			<div class="btn-group pull-right">
				<div class="container">

      <div class="content">
       
        <div class="row">                  
            <!--begin wijmo menu-->
             <link href="${ctx}/static/jquery-ui-bootstrap/third-party/wijmo/jquery.wijmo-open.1.5.0.css" type="text/css" rel="stylesheet" />
              <style>
                  .wijmo-container
                  {
                      display: block;
                      clear: both;
                      width: 600px;
                  }
              </style>
              <div class="wijmo-container">                                    
                  <ul id="menu1">
                      <li>
                          <h3>
                              <a href="">Project Name</a></h3>
                      </li>
                      <li><a href="#">Home</a></li>
                      <li><a href="#">Link</a></li>
                      <li><a href="#">Link</a></li>
                      <li><a href="#">Dropdown</a>
                          <ul>
                              <li><a href="#"><shiro:principal property="name"/></a> </li>
                              <li></li>
                              <li><a href="${ctx}/logout">Logout</a></li>
                          </ul>
                      </li>
                      <li>
                          <input type="text" placeholder="Search">
                      </li>
                  </ul>
                  <!-- End demo markup -->
              </div>
            <!--end wijmo menu-->                  
      
          </div>
          <!--end col-->
        </div>
      </div>
    </div> <!-- /container -->
				<!--  
				<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
					<shiro:principal property="name"/>
					<span class="caret"></span>
				</a>
			
				<ul class="dropdown-menu">
					<li><a href="#">Edit Profile</a></li>
					<li><a href="${ctx}/logout">Logout</a></li>
				</ul>
				-->
			</div>
			<script type="text/javascript">
        $(function () {

    //Wijmo
    $("#menu1").wijmenu({ trigger: ".wijmo-wijmenu-item", triggerEvent: "click" });
    //$(".wijmo-wijmenu-text").parent().bind("click", function () {
    //    $("#menu1").wijmenu("hideAllMenus");
    //});
    //$(".wijmo-wijmenu-link").hover(function () {
    //    $(this).addClass("ui-state-hover");
    //}, function () {
    //    $(this).removeClass("ui-state-hover");
    //});

});
        </script>
		</shiro:user>
	</div>
		<script src="${ctx}/static/jquery-ui-bootstrap/js/jquery-ui-1.8.16.custom.min.js" type="text/javascript"></script>
	 	
              
        <!--wijmo-->
        <script src="${ctx}/static/jquery-ui-bootstrap/third-party/wijmo/jquery.mousewheel.min.js" type="text/javascript"></script>
        <script src="${ctx}/static/jquery-ui-bootstrap/third-party/wijmo/jquery.bgiframe-2.1.3-pre.js" type="text/javascript"></script>
        <script src="${ctx}/static/jquery-ui-bootstrap/third-party/wijmo/jquery.wijmo-open.1.5.0.min.js" type="text/javascript"></script>
        
        <!--init for this page-->
        
</div>