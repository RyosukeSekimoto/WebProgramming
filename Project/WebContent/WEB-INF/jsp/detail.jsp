<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.User" %>
<%@ page import="model.DateExecute" %>

<!DOCTYPE html>
<html lang ="ja">
    <head>
        <meta charset="UTF-8">
        <title>detail</title>
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/styles.css">
    </head>
    <body>
        <jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
        <div class="main">
            <h2 class="title">ユーザ情報詳細参照</h2>
            <div class="detail-wrapper">
                <table class="detail-table">
                    <tr>
                        <th>ログインID</th>
                        <td><c:out value="${detailUser.loginId}" /></td>
                    </tr>
                    <tr>
                        <th>ユーザ名</th>
                        <td><c:out value="${detailUser.name}" /></td>
                    </tr>
                    <tr>
                        <th>生年月日</th>
                        <td><c:out value="${DateExecute.DateFormat(detailUser.birthDate)}" /></td>
                    </tr>
                    <tr>
                        <th>登録日時</th>
                        <td><c:out value="${DateExecute.DateTimeFormat(detailUser.createDate)}" /></td>
                    </tr>
                    <tr>
                        <th>更新日時</th>
                        <td><c:out value="${DateExecute.DateTimeFormat(detailUser.updateDate)}" /></td>
                    </tr>
                </table>
            </div>
            <p class="back"><a href="/UserManagement/UserList">>戻る</a></p>
        </div>
    </body>
</html>