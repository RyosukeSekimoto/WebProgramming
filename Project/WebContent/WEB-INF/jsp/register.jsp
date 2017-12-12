<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.User" %>
<%@ page import="model.DateExecute" %>

<!DOCTYPE html>
<html lang ="ja">
    <head>
        <meta charset="UTF-8">
        <title>register</title>
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/styles.css">
    </head>
    <body>
        <jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
        <div class="main">
            <h2 class="title">ユーザ新規登録</h2>
            <p class="validation red"><c:out value="${errorMessage}" /></p>
            <div class="register-wrapper">
                <div class="register-box">
                    <form action="/UserManagement/Register" method="post">
                        <p class="form-label">ログインID</p>
                        <p class="loginId"><input type="text" name="loginId"/></p>
                        <p class="form-label">パスワード</p>
                        <p class="pass"><input type="password" name="pass"/></p>
                        <p class="form-label">パスワード（確認）</p>
                        <p class="pass"><input type="password" name="checkingPass"/></p>
                        <p class="form-label">ユーザ名</p>
                        <p class="name"><input type="text" name="name"/></p>
                        <p class="form-label">生年月日</p>
                        <p class="birthDate"><input type="date" name="birthDate"/></p>
                        <input type="hidden" name="createDate" value="<c:out value="${DateExecute.dateTime()}" />">
                        <input type="hidden" name="updateDate" value="<c:out value="${DateExecute.dateTime()}" />">
                        <p class="submit"><input type="submit" class="middle-btn" value="登録"/></p>
                    </form>
                </div>
            </div>
            <div><p class="back"><a href="/UserManagement/UserList">>戻る</a></p></div>
        </div>
    </body>
</html>