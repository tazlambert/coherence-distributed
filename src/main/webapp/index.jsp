<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.net.UnknownHostException"%>
<%@page import="java.net.InetAddress"%>

<%
    String hostname, serverAddress;
    hostname = "error";
    serverAddress = "error";
    try {
        InetAddress inetAddress;
        inetAddress = InetAddress.getLocalHost();
        hostname = inetAddress.getHostName();
        serverAddress = inetAddress.toString();
    } catch (UnknownHostException e) {
        e.printStackTrace();
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!! Demo using SpringMVC</h1>
        <h2>To access Hello World using SpringMVC add URI http://ip:port/demo/hello</h2>
        <h2>To access Coherence Demo using SpringMVC add URI http://ip:port/demo/cohwlsdemo</h2>
        <ul>
            <li>getVirtualServerName(): <%= request.getServletContext().getVirtualServerName() %></li>
            <li>InetAddress.hostname: <%=hostname%></li>
            <li>InetAddress.serverAddress: <%=serverAddress%></li>
            <li>getLocalAddr(): <%=request.getLocalAddr()%></li>
            <li>getLocalName(): <%=request.getLocalName()%></li>
            <li>getLocalPort(): <%=request.getLocalPort()%></li>
            <li>getServerName(): <%=request.getServerName()%></li>
        </ul>
    </body>
</html>
