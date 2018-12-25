<%--
  Created by IntelliJ IDEA.
  User: nhandang
  Date: 19-Dec-18
  Time: 3:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<%@include file="/common/tablibs.jsp" %>
<c:url var="formUrl" value="/login.html"/> <%--submitForm --%>

<div id="login-box" class="login-box visible widget-box no-border">
    <div class="widget-body">
        <div class="widget-main">
            <h4 class="header blue lighter bigger">
                <i class="ace-icon fa fa-coffee green"></i>
                <fmt:message key="label.test" bundle="${lang}"/> <%-- cái cần sử dụng trong file .properties--%>
            </h4>

            <div class="space-6"></div>

            <form action="${formUrl}" method="post">
                <fieldset>
                    <c:if test="${not empty messageResponse}"> <%--nếu thông báo rỗng sẽ không hiện lên--%>
                        <div class="alert alert-block alert-${alert}">
                            <button type="button" class="close" data-dismiss="alert">
                                <i class="ace-icon fa fa-times"></i>
                            </button>
                            ${messageResponse}
                        </div>
                    </c:if>

                    <label class="block clearfix">
                        <span class="block input-icon input-icon-right">
                            <input type="text" class="form-control" placeholder="Username" name="pojo.name"/>
                            <i class="ace-icon fa fa-user"></i>
                        </span>
                    </label>

                    <label class="block clearfix">
                        <span class="block input-icon input-icon-right">
                            <input type="password" class="form-control" placeholder="Password" name="pojo.password"/>
                            <i class="ace-icon fa fa-lock"></i>
                        </span>
                    </label>

                    <div class="space"></div>

                    <div class="clearfix">
                        <button type="submit" class="width-35 pull-right btn btn-sm btn-primary">
                            <i class="ace-icon fa fa-key"></i>
                            <span class="bigger-110">Login</span>
                        </button>
                    </div>

                    <div class="space-4"></div>
                </fieldset>
            </form>
        </div><!-- /.widget-main -->
    </div><!-- /.widget-body -->
</div><!-- /.login-box -->
