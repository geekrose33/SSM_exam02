<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getScheme() + "://" + request.getServerName() + ":" +
            request.getServerPort() + request.getContextPath() + "/";

%>
<html>
<head>
    <title>Title</title>
    <base href="<%=path%>">
    <script  src="webjars/jquery/3.4.1/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function () {

        })
        function citySelect() {
            $.ajax({
                url:"http://localhost:8080/mybatis_exam_02/city/select.do",
                type:"GET",
                data:$("#myform").serialize(),
                // async:false,  同步
                success:function (msg) {
                    /*for (let i = 0; i < msg.length; i++) {
                        $("#data").html("<tr><td>"+msg[i].cid+"</td><td>"
                                +msg[i].cname+"</td><td>"+msg[i].pid+"</td></tr>");
                    }*/
                    $("#data").html("");
                    $.each(eval(msg),function (index,value) {
                        $("#data").append("<tr><td>"+msg[index].cid+"</td><td>"
                            +msg[index].cname+"</td><td>"+msg[index].pid+"</td></tr>");
                    })
                },
                dataType:"json"
            })
        }
        function deleteCity() {
            $.ajax({
                url:"http://localhost:8080/mybatis_exam_02/city/delete.do",
                data:{"cid":$("#cid").val()},
                type: "GET",
                dataType: "json",
                success:function (msg) {
                    if (msg == null){
                        $("#info").show();
                        $("#info").val("请输入正确的城市id");
                    }
                    $("#data").html("");
                    $.each(eval(msg),function (index,value) {
                        $("#data").append("<tr><td>"+msg[index].cid+"</td><td>"
                            +msg[index].cname+"</td><td>"+msg[index].pid+"</td></tr>");
                    })
                }


            })
        }
    </script>
</head>
<body>
<div align="center">
    <h3>查询所有城市记录</h3>
    <form method="get" id="myform">
        城市id：<input type="text" name="cid" id="cid"> <br>
        城市name：<input type="text" name="cname"> <br>
        所属省份id：<input type="text" name="pid"> <br>
        <input type="submit" id="select" onclick="citySelect();return false" value="查看城市">
    </form>

    <br>
    <span hidden="hidden" id="info"></span>
    <br><br>
    <button id="delete" onclick="deleteCity()">删除指定城市信息</button>
    <br><br>
    <a href="index.jsp">主页</a>
    <br><br>
    <table>
        <thead>
        <tr>
            <td>城市id</td>
            <td>城市名称</td>
            <td>所属省份id</td>
        </tr>
        </thead>

        <tbody id="data">


        </tbody>
    </table>
</div>


</body>
</html>
