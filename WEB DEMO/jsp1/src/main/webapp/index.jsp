<%@ page language="java"  import="in.com.jspdemo.Calculator"%>
<jsp:useBean id="calculator" class="in.com.jspdemo.Calculator"></jsp:useBean>
<h1>
  <%= calculator.add() %>
  <%= calculator.mul() %>
</h1>