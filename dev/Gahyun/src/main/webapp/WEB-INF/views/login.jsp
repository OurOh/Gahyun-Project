<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
                    <h2>�α���</h2>
                    <form>
                        <input type="text" placeholder="���̵�">
                        <input type="password" placeholder="��й�ȣ">
                        <button type="submit" id="loginsubmit">�α���</button>
                        <button type="button" id="userregister">ȸ������</button>
                        <a href="#">���̵�/��й�ȣ ã��</a>
                    </form>
                </div>
            </section>
        </main>
</body>
</html>