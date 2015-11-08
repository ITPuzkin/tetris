<%-- 
    Document   : index
    Created on : 23.03.2013, 14:31:25
    Author     : benq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html id="bod">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="test1.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="scriptjava.js"></script>
        <script type="text/javascript" src="scriptFunc.js"></script>
        <script type="text/javascript" src="scriptDraw.js"></script>
        <script type="text/javascript" src="scriptKey.js"></script>
        <script type="text/javascript">
            function Score(point) {
                var ttt = document.getElementById('score').value = point ;
            }
        </script>
    </head>

    <body onload="drawempty();">
        <div id="main">
            <h1 id="h1">Tetris</h1>
            <div id="draw">
                <canvas id="canvas" height="340" width="220">Не подерживается</canvas>
            </div>
            <div id="butt">
                <input class="but1" id="b1" type="button" onclick="NewG();" value="New Game" style="width:80px"/>
                <input class="but1" id="b1" type="button" onclick="SendEx();" value="Pause" style="width:80px" />
                <input class="but1" id="b3" type="button" onclick="qqq('stg');" value="UnPause" style="width:80px" />
                Количество Очков
                <input type="text" id="score" size="15"/>

            </div>
            <div id="info">ВТ2-С10</div>
        </div>
    </body>