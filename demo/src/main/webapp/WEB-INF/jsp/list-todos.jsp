<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="Container">
<table class="table table-striped">
<caption> Todo's for ${name} </caption>
<thead>
<tr>
<th> Description </th>
<th> Target Date </th>
<th> Is completed </th>
<th> </th>
<th> </th>
</tr>
</thead>

<tbody>

<c:forEach items="${todos}" var="todo">
<tr>
<td> ${todo.desc} </td>
<td> <fmt:formatDate value="${todo.targetDate}" pattern="dd/MM/yyyy"/> </td>
<td> ${todo.done} </td>
<td> <a type="button" href="/update-todo?id=${todo.id}" class="btn btn-success"> Update </a> </td>
<td> <a type="button" href="/delete-todo?id=${todo.id}" class="btn btn-warning"> Delete </a> </td>
</tr>
</c:forEach>

</tbody>
</table>

<div>
<a class="button" href="/add-todos"> Add Todo </a>
</div>

</div>
<%@ include file="common/footer.jspf" %>
