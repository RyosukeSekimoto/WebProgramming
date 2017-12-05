<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.User" %>

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
            <a href="./register.html" class="middle-btn middle-btn2 btn-right">新規登録</a>
            <!--<p class="validation">ここにバリデーションが入ります。</p>-->
            <div class="users-wrapper">
                <form action="#" method="" class="search-box">
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
                            <input type="date" name="birthDateStart"/>
                            <span style="padding: 0 6px;">〜</span>
                            <input type="date" name="birthdateEnd"/>
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
                        <li class="user-list-item">
                            <span>000000</span>
                            <span>山田一郎</span>
                            <span>0000/00/00</span>
                            <div class="small-btns">
                                <a href="./detail.jsp" class="small-btn">詳細</a>
                                <a href="./update.jsp" class="small-btn small-btn2">更新</a>
                                <a href="./delete.jsp" class="small-btn small-btn3">削除</a>
                            </div>
                        </li>
                        <li class="user-list-item">
                            <span>000000</span>
                            <span>山田一郎</span>
                            <span>0000/00/00</span>
                            <div class="small-btns">
                                <a href="./detail.jsp" class="small-btn">詳細</a>
                                <a href="./update.jsp" class="small-btn small-btn2">更新</a>
                                <a href="./delete.jsp" class="small-btn small-btn3">削除</a>
                            </div>
                        </li>
                        <li class="user-list-item">
                            <span>000000</span>
                            <span>山田一郎</span>
                            <span>0000/00/00</span>
                            <div class="small-btns">
                                <a href="./detail.jsp" class="small-btn">詳細</a>
                                <a href="./update.jsp" class="small-btn small-btn2">更新</a>
                                <a href="./delete.jsp" class="small-btn small-btn3">削除</a>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </body>
</html>