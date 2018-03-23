<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>左边页面</title>
<link href="${pageContext.request.contextPath }/css/styles.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson .header").click(function(){
		var $parent = $(this).parent();
		$(".menuson>li.active").not($parent).removeClass("active open").find('.sub-menus').hide();
		
		$parent.addClass("active");
		if(!!$(this).next('.sub-menus').size()){
			if($parent.hasClass("open")){
				$parent.removeClass("open").find('.sub-menus').hide();
			}else{
				$parent.addClass("open").find('.sub-menus').show();	
			}
			
			
		}
	});
	
	// 三级菜单点击
	$('.sub-menus li').click(function(e) {
        $(".sub-menus li.active").removeClass("active")
		$(this).addClass("active");
    });
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('.menuson').slideUp();
		if($ul.is(':visible')){
			$(this).next('.menuson').slideUp();
		}else{
			$(this).next('.menuson').slideDown();
		}
	});
})	
</script>


</head>

<body style="background:#f0f9fd;">
    
	<div class="lefttop"style="color:black"><span></span>管理员</div>
    
    <dl class="leftmenu">
     <!--菜单--> 
    <dd>
    <div class="title">
    <span><img src="${pageContext.request.contextPath }/images/leftico01.png" /></span>用户信息
    </div>
    	<ul class="menuson">
        <li>
            <div class="header" >
            <cite></cite>
            <a href="${pageContext.request.contextPath }/SearchUserListServlet" target="rightFrame" style="color:black">用户列表</a>
            <i></i>
            </div>
        </li>

        <li>
            <div class="header" >
            <cite></cite>
            <a href="${pageContext.request.contextPath }/adminpages/userlist.jsp" target="rightFrame" style="color:black">个人用户列表</a>
            <i></i>
            </div>
            
        </li>
        
        <li>
            <div class="header">
            <cite></cite>
            <a href="${pageContext.request.contextPath}/adminpages/companylist.jsp"  target="rightFrame">企业用户列表</a>
            <i></i>
            </div>                
        </li>  
         <li>
            <div class="header">
            <cite></cite>
            <a href="${pageContext.request.contextPath}/DisableUserServlet"  target="rightFrame">禁用用户列表</a>
            <i></i>
            </div>                
        </li>             
        </ul>    
    </dd>
    
       <!--菜单--> 
    <dd>
    <div class="title">
    <span><img src="${pageContext.request.contextPath }/images/leftico01.png" /></span>职位信息
    </div>
    	<ul class="menuson">
        
         <li>
            <div class="header">
            <cite></cite>
            <a href="${pageContext.request.contextPath }/adminpages/relationlist.jsp" target="rightFrame">职位详情</a>
            <i></i>
            </div>                

        </li>
       
        </ul>    
    </dd>
    
       <!--菜单--> 
    <dd>
    <div class="title">
    <span><img src="${pageContext.request.contextPath }/images/leftico01.png" /></span>简历信息
    </div>
    	<ul class="menuson">
        
         <li>
            <div class="header">
            <cite></cite>
            <a href="${pageContext.request.contextPath }/adminpages/resumelist.jsp" target="rightFrame">简历列表</a>
            <i></i>
            </div>                
        </li>
        </ul>    
    </dd>
        <!--菜单--> 
    <dd>
    <div class="title">
    <span><img src="${pageContext.request.contextPath }/images/leftico01.png" /></span>新闻模块
    </div>
    	<ul class="menuson">
        
        <li>
            <div class="header">
            <cite></cite>
            <a href="${pageContext.request.contextPath }/adminpages/addnews.jsp" target="rightFrame">添加新闻</a>
            <i></i>
            </div>                
        </li>
        <li>
           <div class="header">
           <cite></cite>
           <a href="${pageContext.request.contextPath }/NewsListServlet" target="rightFrame">新闻列表</a>
           <i></i>
           </div>                
       </li>
       </ul>    
    </dd>
   </dl>
</body>
</html>