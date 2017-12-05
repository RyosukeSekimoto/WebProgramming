<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.User" %>

<!DOCTYPE html>
<html lang ="ja">
    <head>
        <meta charset="UTF-8">
        <title>login</title>
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/styles.css">
    </head>
    <body>
        <div id="form" class="main">
                <div class="login-wrapper">
                    <h2 class="title">ログイン画面</h2>
                    <c:if test="${not empty errorMessage}">
                    	<p class="validation red">ログインIDまたはパスワードが正しくありません。</p>
                    </c:if>
                    <form action="/UserManagement/Login" method="post" class="login-box">
                        <p class="form-label">ログインID</p>
                        <p class="login-id"><input type="text" name="loginId"/></p>
                        <p class="form-label">パスワード</p>
                        <p class="pass"><input type="password" name="pass"/></p>
                        <p class="submit"><input type="submit" class="middle-btn" value="ログイン" /></p>
                    </form>
                </div>
        </div>
    </body>
</html>