<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.User" %>

<!DOCTYPE html>
<html lang ="ja">
    <head>
        <meta charset="UTF-8">
        <title>delete</title>
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/styles.css">
    </head>
    <body>
     	<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
        <div class="main">
            <h2 class="title">ユーザ削除確認</h2>
            <div class="delete-wrapper">
                <p><span>ログインID: <c:out value="${deleteUser.loginId}" /></span> を本当に削除してよろしいでしょうか?</p>
                <div class="middle-btns">
                	<a class="middle-btn middle-btn2" href="/UserManagement/UserList">キャンセル</a>
                    <form action="/UserManagement/Delete?loginId=<c:out value="${deleteUser.loginId}" />" method="post">
                    <input type="submit" value="削除" class="middle-btn middle-btn4">
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>