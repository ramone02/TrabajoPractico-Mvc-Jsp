<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/shared/header.jsp"/>

<h2>Transferencia entre Cuentas</h2>
<div class="mt-5 bg-success p-2 text-dark bg-opacity-10">
    <div class="row">
        <div class="col-md-8 ml-5">
            <div class="card-body m-3">
                <form action="transferencia" method="POST">
                    <div class="form-floating m-3">
                        <select class="form-select" id="floatingSelect" name="origen" aria-label="Floating label select example" required>
                            <option selected>Cuenta Origen</option>
                            <c:forEach items="${cuentas}"  var="item">
                                <option value="${item.getId()}">${item.getId()} - ${item.getSaldo()}</option>
                            </c:forEach>
                        </select>
                        <label for="floatingSelect">Nro de Cuenta - Saldo</label>
                    </div>
                    <div class="form-floating m-3">
                        <select class="form-select" id="floatingSelect" name="destino" aria-label="Floating label select example" required>
                            <option selected>Cuenta Destino</option>
                            <c:forEach items="${cuentas}"  var="item">
                                <option value="${item.getId()}">${item.getId()} - ${item.getSaldo()}</option>
                            </c:forEach>
                        </select>
                        <label for="floatingSelect">Nro de Cuenta - Saldo</label>
                    </div>                    
                    <div class="form-floating m-3">
                        <input type="number" min="0" class="form-control" name="monto" placeholder="Monto a transferir" required>
                        <label for="floatingInputGroup1">Ingrese el monto a Transferir</label>
                    </div>
                    <div class="d-flex justify-content-end form-floating m-3">
                        <button class="btn btn-success" type="submit">Enviar Transferencia</button>
                    </div>
                </form>
            </div>
        </div>
        <div class="col">
            <img src="https://thumbs.dreamstime.com/z/coding-icon-creative-element-design-programmer-icons-collection-pixel-perfect-web-apps-software-print-usage-149551335.jpg" class="img-fluid rounded-start" alt="logo">
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/views/shared/footer.jsp"/>
