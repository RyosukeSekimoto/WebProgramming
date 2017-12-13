<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.User" %>
<%@ page import="model.DateLogic" %>

<!DOCTYPE html>
<html lang ="ja">
    <head>
        <meta charset="UTF-8">
        <title>User</title>
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/styles.css">
    </head>
    <body>
        <jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
        <div class="main">
            <h2 class="title">ユーザ一覧</h2>
            <a href="/UserManagement/Register" class="middle-btn middle-btn2 btn-right">新規登録</a>
            <div class="users-wrapper">
                <form action="/UserManagement/UserList" method="get" class="search-box">
                    <div class="search-area clearfix">
                        <div class="login-col">
                            <p class="form-label">ログインID</p>
                            <input type="text" name="loginId"/>
                        </div>
                        <div class="user-col">
                            <p class="form-label">ユーザ名</p>
                            <input type="text" name="userName"/>
                        </div>
                        <div class="birth-col clearfix">
                            <p class="form-label">生年月日</p>
                            <input type="date" name="birthdayFrom"/>
                            <span style="padding: 0 6px;">〜</span>
                            <input type="date" name="birthdayTo"/>
                        </div>
                    </div>
                    <p class="submit"><input type="submit" class="middle-btn middle-btn3" value="検索" /></p>
                </form>
                <div class="user-list-area">
                    <ul class="list-title">
                        <li>ログインID</li>
                        <li>ユーザ名</li>
                        <li>生年月日</li>
                    </ul>
                    <ul class="user-list">
                    <c:forEach var="user" items="${userList}">
                    	<c:if test="${user.loginId.equals('admin')? false : true}">
							<li class="user-list-item">
                       	    	<span><c:out value="${user.loginId}" /></span>
                            	<span><c:out value="${user.name}" /></span>
                            	<span><c:out value="${DateLogic.DateFormat(user.birthDate)}" /></span>
                            	<div class="small-btns">
                                	<a href="Detail?loginId=<c:out value="${user.loginId}" />" class="small-btn">詳細</a>
                                	<c:if test="${loginUser.loginId.equals(user.loginId) || loginUser.loginId.equals('admin')}">
                                		<a href="Update?loginId=<c:out value="${user.loginId}" />" class="small-btn small-btn2">更新</a>
                                	</c:if>
                                	<c:if test="${loginUser.loginId.equals('admin')}">
                                	<a href="Delete?loginId=<c:out value="${user.loginId}" />" class="small-btn small-btn3">削除</a>
                                	</c:if>
                            	</div>
                        	</li>
    					</c:if>
					</c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </body>
</html>