<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/20 0020
  Time: 上午 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script>
        function query(pageNo) {

            document.getElementById("pageNo").value = pageNo;
            document.forms[0].submit();

        }
    </script>
</head>
<body>

<form method="post" action="${pageContext.request.contextPath}/disease">
    <input id="pageNo" type="hidden" name="pageNo" value="${pageInfo.pageNo}"/>
    <input id="pageSize" type="hidden" name="pageSize" value="${pageInfo.pageSize}"/>


    <label>疾病名称</label>
    <input type="text" name="diseaseName" value="${param['diseaseName']}" />

    <input type="submit">


</form>


<table border='1' width='100%' cellpadding='0' cellspacing='0'>
    <tr>
        <td><input type="checkbox"/></td>
        <td>序号</td>
        <td>diseaseCode</td>
        <td>diseaseName</td>
        <td>diseaseIcd</td>
        <td>cateId</td>
        <td>createtime</td>
        <td>valid</td>
        <td>操作</td>
    </tr>

    <c:forEach var="disease" items="${pageInfo.list}" varStatus="stat">
        <tr>
            <td><input type="checkbox" name="ids" value="${disease.id}"/></td>
            <td>${stat.count}</td>
            <td>${disease.diseaseCode}</td>
            <td>${disease.diseaseName}</td>
            <td>${disease.diseaseIcd}</td>
            <td>${disease.cateId}</td>
            <td>${disease.createtime}</td>
            <td>${disease.valid}</td>

            <td><a href='disease?type=toEdit&id=${disease.id}'>编辑</a> <a href='disease?type=del&id=${disease.id}'>删除</a>
            </td>
        </tr>
    </c:forEach>

</table>

<p>
    当前页号:${pageInfo.pageNo}/${pageInfo.totalPage}

    <c:if test="${pageInfo.pageNo == 1}">首页&nbsp;&nbsp;上一页 </c:if>

    <c:if test="${pageInfo.pageNo > 1}">

        <a href="javascript:query(1)">首页</a>
        <a href="javascript:query(${pageInfo.pageNo -1 })">上一页</a>
    </c:if>



    <c:if test="${pageInfo.pageNo == pageInfo.totalPage}">下一页&nbsp;&nbsp;尾页 </c:if>

    <c:if test="${pageInfo.pageNo < pageInfo.totalPage}">

        <a href="javascript:query(${pageInfo.pageNo + 1 })">下一页</a>
        <a href="javascript:query(${pageInfo.totalPage })">尾页</a>
    </c:if>


</p>


</body>
</html>