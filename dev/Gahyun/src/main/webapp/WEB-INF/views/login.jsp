<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.gahyun.dev.model.UserDto" %>  <!-- UserDto ����Ʈ -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<main class="main-content">
    <section class="image-section">
        <div class="image-slider">
            <img src="${pageContext.request.contextPath}/res/images/pool003.jpg" alt="����Ʈ �̹��� 1" class="active">
            <img src="${pageContext.request.contextPath}/res/images/outside001.jpg" alt="����Ʈ �̹��� 1">
            <img src="${pageContext.request.contextPath}/res/images/yoga003.jpg" alt="����Ʈ �̹��� 3">
        </div>
    </section>

    <section class="login-section">
        <div class="login-container">
            <% 
                UserDto user = (UserDto) session.getAttribute("user");
                if (user != null) { 
                	 %>
                     <!-- �α��� ���� �� �̹��� ǥ�� -->
                     <h2>ȯ���մϴ�, <%= user.getName() %>��!</h2>
                     <img src="${pageContext.request.contextPath}/res/images/your_image.jpg" alt="�α��� �� �̹���"> <!-- ���ϴ� �̹���-->
                     <a href="${pageContext.request.contextPath}/logout">�α׾ƿ�</a>
                 <% 
                 
                } else { 
            %>
                <!-- �α��ε��� ���� ���� -->
                <h2>�α���</h2>
                <form action="${pageContext.request.contextPath}/login" method="post">
                    <input type="text" name="userid" placeholder="���̵�">
                    <input type="password" name="password" placeholder="��й�ȣ">
                    <button type="submit" id="loginsubmit">�α���</button>
                    <button type="button" id="userregister">ȸ������</button>
                    <a href="#">���̵�/��й�ȣ ã��</a>
                </form>
            <% 
                } 
            %>
        </div>
    </section>
</main>
</body>
</html>
