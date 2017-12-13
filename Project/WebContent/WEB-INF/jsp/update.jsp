<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.User" %>
<%@ page import="model.DateLogic" %>

<!DOCTYPE html>
<html lang ="ja">
    <head>
        <meta charset="UTF-8">
        <title>update</title>
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/styles.css">
    </head>
    <body>
		<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
        <div class="main">
            <h2 class="title">ユーザ情報更新</h2>
            <p class="validation red"><c:out value="${errorMessage}" /></p>
            <div class="update-wrapper">
                <div id="form" class="update-box">
                    <div class="form-wrapper">
                        <form action="/UserManagement/Update?loginId=<c:out value="${updateUser.loginId}" />" method="post">
                            <p class="form-label">ログインID</p>
                            <p class="loginId"><input type="text" name="loginId" disabled="disabled" value="<c:out value="${updateUser.loginId}" />"/></p>
                            <p class="form-label">パスワード</p>
                            <p class="pass"><input type="password" name="pass"/></p>
                            <p class="form-label">パスワード（確認）</p>
                            <p class="pass"><input type="password" name="checkingPass"/></p>
                            <p class="form-label">ユーザ名</p>
                            <p class="name"><input type="text" name="name" value="<c:out value="${updateUser.name}" />"/></p>
                            <p class="form-label">生年月日</p>
                            <p class="birthDate"><input type="date" name="birthDate" value="<c:out value="${updateUser.birthDate}" />"/></p>
                            <p class="submit"><input type="submit" class="middle-btn" value="更新" /></p>
                            <input type="hidden" name="updateDate" value="<c:out value="${DateExecute.dateTime()}" />">
                        </form>
                    </div>
                </div>
            </div>
            <p class="back"><a href="/UserManagement/UserList">>戻る</a></p>
        </div>
    </body>
</html>