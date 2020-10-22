<%--
  Created by IntelliJ IDEA.
  User: mxg
  Date: 2020/10/22
  Time: 12:09 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--分页条的开始 --%>
<div id="page_nav">
    <c:if test="${requestScope.page.pageNo > 1}">
        <a href="${requestScope.page.url}&pageNO=1">首页</a>
        <a href="${requestScope.page.url}&pageNO=${requestScope.page.pageNo - 1}">上一页</a>
    </c:if>

    <%--		页码输出的 开始--%>
    <c:choose>
        <%--		情况1 ： 假如总页码 小于 5   页码的范围 为 1 - 总页码 --%>
        <c:when test="${requestScope.page.pageTotal <= 5}">
            <c:set var="begin" value="1"></c:set>
            <c:set var="end" value="${requestScope.page.pageTotal}"></c:set>
        </c:when>
        <%--		情况2 ： 假如总页码 大于 5--%>
        <c:when test="${requestScope.page.pageTotal > 5}">
            <c:choose>
                <%--		小情况1 ： 当前页码为1 2 3的情况   页码的范围 为 1 - 5 --%>
                <c:when test="${requestScope.page.pageNo <= 3}">
                    <c:set var="begin" value="1"></c:set>
                    <c:set var="end" value="5"></c:set>
                </c:when>
                <%--		小情况2 ： 当前页码为后3个的情况   页码的范围 总页码-4 - 总页码 --%>
                <c:when test="${requestScope.page.pageNo >= requestScope.page.pageTotal - 3}">
                    <c:set var="begin" value="${requestScope.page.pageTotal - 4}"></c:set>
                    <c:set var="end" value="${requestScope.page.pageTotal}"></c:set>
                </c:when>
                <%--		小情况2 ： 当前页码为每5个后2个的情况   页码的范围 总页码-2 - 总页码+2 --%>
                <c:when test="">
                    <c:set var="begin" value="${requestScope.page.pageTotal - 2}"></c:set>
                    <c:set var="end" value="${requestScope.page.pageTotal + 2}"></c:set>
                </c:when>
            </c:choose>
        </c:when>
    </c:choose>

    <c:forEach begin="${begin}" end="${end}" var="i">
        <%--					是当前页码--%>
        <c:if test="${i == requestScope.page.pageNo}">
            【${i}】
        </c:if>
        <%--					不是当前页码--%>
        <c:if test="${i != requestScope.page.pageNo}">
            <a href="client/bookServlet?action=${i}">${i}</a>
        </c:if>
    </c:forEach>


    <%--		页码输出的 结束--%>

    <%--		如果已经是最后一页 则不显示 末页 和 下一页--%>
    <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNO=${requestScope.page.pageNo + 1}">下一页</a>
        <a href="${requestScope.page.url}&pageNO=${requestScope.page.pageTotalCount}">末页</a>
    </c:if>

    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
    到第<input value="${param.pagNo}" name="pn" id="pn_input"/>页
    <input id="searchPageBtn" type="button" value="确定">
    <script type="text/javascript">
        $(function () {
            $("#searchPageBtn").click(function () {
                //跳到指定的 页码 jsp
                var pageNo = $("#pn_input").val();

                var pageTotal = ${requestScope.page.pageTotal};

                //js 提供了 一个location地址栏 对象
                //它有一个属性叫herf，可以获取浏览器地址栏中的地址
                //herf属性 可读 可写
                location.href = "${pageScope.basePath}${requestScope.page.url}&pageNO=1" + pageNo;
            })
        })
    </script>
</div>
<%--分页条的结束 --%>