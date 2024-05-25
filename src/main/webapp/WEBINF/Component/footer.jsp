<%@page import="java.time.Year"%>
<footer class="bg-secondary text-center fixed-bottom "
		style="height: 50px;"
		>
	<section class= "mt-2">
		Online Auction System &copy; Copyright
		<%
			out.print(Year.now().getValue());
		%>
	</section>
</footer>