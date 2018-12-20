<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/10/010
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shop Index</title>
    <script type="text/javascript" src="js/components/jquery/dist/jquery.min.js"></script>
    <script type="text/javascript" src="js/components/vue/dist/vue.min.js"></script>


</head>
<body>
<div id="app">

</div>


<script type="text/javascript">
    var app = new Vue({
        el: '#app',
        data: {},
        created: function () {
            this.fetchData()
        },
        watch: {},
        filters: {
            truncate: function (v) {
                var newline = v.indexOf('\n')
                return newline > 0 ? v.slice(0, newline) : v
            },
            formatDate: function (v) {
                return v.replace(/T|Z/g, ' ')
            }
        },
        methods: {
            fetchData: function () {
            }
        }
    })


</script>

</body>
</html>
