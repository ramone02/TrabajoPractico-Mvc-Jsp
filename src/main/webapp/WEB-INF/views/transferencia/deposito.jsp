<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/shared/header.jsp"/>

<h2>Transferencia entre Cuentas</h2>
<div class="mt-5 bg-success p-2 text-dark bg-opacity-10">
    <div class="row">
        <div class="col-md-8 ml-5">
            <h1>Deposito</h1>
            <div class="card-body m-3">
                <c:forEach items="${parametros}" var="item">
                  <p>${item}</p>                                 
                </c:forEach>                
            </div>
            <div class="card-body m-3">
                <p>${origen}</p>
                <p>${destino}</p>
                <p>${monto}</p>
            </div>
        </div>
        <div class="col">
            <img src="https://thumbs.dreamstime.com/z/coding-icon-creative-element-design-programmer-icons-collection-pixel-perfect-web-apps-software-print-usage-149551335.jpg" class="img-fluid rounded-start" alt="logo">
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/views/shared/footer.jsp"/>
