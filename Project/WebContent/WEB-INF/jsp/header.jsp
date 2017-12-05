<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.User" %>

<header class="header">
	<div class="header-wrapper clearfix">
		<h1 class="site-title"></h1>
        <nav class="grobal-nav">
			<ul class="nav-list">
				<li class="nav-item"><span class=""><c:out value="${user.name}" /></span>さん</li>
                <li class="nav-item"><a href="">ログアウト</a></li>
            </ul>
       	</nav>
	</div>
</header>