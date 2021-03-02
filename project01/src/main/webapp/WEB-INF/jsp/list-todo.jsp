<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>


<div class="container">
<h1 class="h1 black">${username} Your Todos</h1>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Description</th>
                    <th>Date</th>
                    <th>Is it Done?</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${todos}" var="todo">
                    <tr>
                        <td>${todo.desc}</td>
                        <td><fmt:formatDate pattern="dd/MM/yyyy" value="${todo.targetDate}" /></td>
                        <td>${todo.done}</td>
                        <td><a class="btn btn-info" href="/update-todo?id=${todo.id}">UPDATE</a></td>
                        <td><a class="btn btn-danger" href="/delete-todo?id=${todo.id}">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a class="btn btn-outline-success" href="/add-todo">Add Todo</a>
</div>

<%@ include file="common/footer.jspf" %>
