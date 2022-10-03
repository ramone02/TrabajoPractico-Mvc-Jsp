
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/shared/header.jsp"/>
<div class="titulo mt-5">
    <h2>Pagina de Error</h2>
</div>
<div class="col-md-12">
    <ul>
        <c:forEach items="${errores}" var="error">
            <li class="text-black"> error: ${error}</li>                        
        </c:forEach>
    </ul>
    <div>
        <button class="btn btn-success"><a class="text-black"href="/TrabajoPractico-Mvc-Jsp/transferencia">Volver</a></button>
    </div>
</div>

<jsp:include page="/WEB-INF/views/shared/footer.jsp"/>
