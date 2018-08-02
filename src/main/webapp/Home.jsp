<%@page import="com.dhruv.user.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <jsp:include page="/componet/header.jsp" />
 
 <%  
 
     Object obj=request.getAttribute("userList");
     List<User> listUser=(List<User>)obj;
     
     Object otherOb=listUser;
     System.out.print(listUser);
%>

<%if(listUser!=null){ %>
   
   <% for(User user:listUser){ %>
      <div> 
            Name: <%=user.getId()%> 
            FirstName=<%=user.getFirstName() %>          
      </div>
      <hr>
  <%}%>
  
  <%}%>
  



</body>
</html>