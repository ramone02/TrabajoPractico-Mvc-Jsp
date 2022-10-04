
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/shared/header.jsp"/>
<div class="titulo mt-5">
    <h2>Pagina de Error</h2>
</div>
<div class="mt-5 bg-success p-2 text-dark bg-opacity-10">
    <div class="row">
        <div class="col-md-6 ml-5">
            <c:forEach items="${errores}" var="error">
                <div class="alert alert-danger" role="alert">
                    ${error}
                </div>
            </c:forEach>
        </div>
        <div class="col">
            <img src="${context_path}/WEB-INF/assets/img/error" class="img-fluid rounded-start" alt="Mensaje de Error">
        </div>
        <div class="d-flex ">
            <button class="btn btn-success"><a class="text-black text-decoration-none"href="/TrabajoPractico-Mvc-Jsp/transferencia">Volver</a></button>
        </div>
    </div>

    <jsp:include page="/WEB-INF/views/shared/footer.jsp"/>
