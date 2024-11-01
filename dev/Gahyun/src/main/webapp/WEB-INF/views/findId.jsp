<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    

<%@ page session="false" pageEncoding="UTF-8" %>

<main>
    <section class="form-section find-id-section">
        <h1>아이디 찾기</h1>
        <form action="${pageContext.request.contextPath}/findId" method="POST">
            <!-- 이름 입력 -->
            <label for="name">이름</label>
            <input type="text" id="name" name="name" placeholder="이름을 입력하세요" required>

            <!-- 이메일 입력 -->
            <label for="email">이메일</label>
            <input type="email" id="email" name="email" placeholder="이메일을 입력하세요" required>

            <button type="submit" class="submit-btn">아이디 찾기</button>
        </form>

         <c:if test="${not empty userId}">
            <script>
                alert("고객님의 아이디는: ${userId}");
            </script>
        </c:if>
    </section>
</main>
