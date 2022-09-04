
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<h1>Enter Todos</h1>
	<form:form method="post" modelAttribute="todo">
		<!--  Mapping the form to the todo in the addnewTodo function -->
		<fieldset class="mb-3">
			<form:label path="des">Description</form:label>
			<form:input type="text" name="des" path="des" />
			<!--  add this to the des field in the Todo object -->
			<form:errors path="des" />
		</fieldset>

		<fieldset class="mb-3">
			<form:label path="target">TargetDate</form:label>
			<form:input type="text" name="target" path="target" />
			<!--  add this to the des field in the Todo object -->
			<form:errors path="target" />
		</fieldset>

		<fieldset class="mb-3">
			<form:label path="done">IsDone?</form:label>
			<form:input type="text" name="done" path="done" />
			<!--  add this to the des field in the Todo object -->
			<form:errors path="done" />
		</fieldset>

		<form:input path="id" type="hidden" />
		<form:input path="done" type="hidden" />
		<input type="submit" class="btn btn-success">
	</form:form>

</div>
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
<script
	src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript">
			$('#target').datepicker({
			    format: 'yyyy-mm-dd'
			});
		</script>

</body>
</html>