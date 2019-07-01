<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>医药管理系统</title>
<link href="./Wopop_files/style_log.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Wopop_files/style.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Wopop_files/userpanel.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Wopop_files/jquery.ui.all.css">

</head>

<body class="login" mycollectionplug="bind" style="background:url(images/bgooo.jpg);background-repeat:no-repeat;background-size:cover">
<div class="login_m">
<div class="login_logo"><img src="./Wopop_files/logo1.png" width="400" height="69"></div>
<div class="login_boder">

<div class="login_padding" id="login_model">

<form action="${pageContext.request.contextPath}/login_adminLogin" method="post">
  <h2>用户名</h2>
  <label>
    <input type="text" id="username" name="name" placeholder="请输入用户名" class="txt_input txt_input2" onfocus="if (value ==&#39;Your name&#39;){value =&#39;&#39;}" >
  </label>
  <h2>密码</h2>
  <label>
    <input type="password" name="password" id="userpwd"  placeholder="请输入密码" class="txt_input" onfocus="if (value ==&#39;******&#39;){value =&#39;&#39;}" >
  </label>
  <p class="forgot"><a id="iforget" href="${pageContext.request.contextPath}/login.jsp">店员登录</a></p>
  <div class="rem_sub">
  <div class="rem_sub_l">
  <input type="checkbox" name="checkbox" id="save_me">
   <label for="checkbox">记住密码</label>
   </div>
    <label>
      <input type="submit" class="sub_button" name="button" id="button" value="登录" style="opacity: 0.7;">
    </label>
  </div>
  </form>
</div>
</div>
</div>
</body>
</html>