<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="Container">

<font color="red"> ${errormessage} </font>

<form method='POST'>

Name:     <input type='text' name='name'> </input><br>
Password: <input type='password' name='password'> </input> <br>
<input type='submit' value='Submit'> </input>

</form>

</div>

<%@ include file="common/footer.jspf" %>