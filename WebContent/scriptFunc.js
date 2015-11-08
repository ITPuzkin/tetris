            var ID;
            
            function qqq(a){
                SendPost(a);
                ID=setInterval(SendPost, 100);
            }
            
            function SendPost(a) {
                //отправляю POST запрос и получаю ответ
                $$a({
                    type:'post',//тип запроса
                    url: document.location.href+'Game',//url адрес файла обработчика
                    data:{'a':a},//параметры запроса
                    response:'text',//тип возвращаемого ответа text либо xml
                    success:function (data) {//возвращаемый результат от сервера
                        var event = JSON.parse(data);
                        Score(event[24][0]);
                        draw(event);
                        if(event[24][1] == 0) {
                            clearInterval(ID);
                            alert("Game is over !");
                        }
                    }
                });
                
            }
            //постановка на паузу
            function SendEx() {
                clearInterval(ID);
                //отправляю POST запрос и получаю ответ
                $$a({
                    type:'post',//тип запроса: get,post либо head
                    url:document.location.href+'Game',//url адрес файла обработчика
                    data:{'a':'ex'},//параметры запроса
                    response:'text'//тип возвращаемого ответа text либо xml
                });
                
            }
            //новая игра
            function NewG() {
                //отправляю POST запрос и получаю ответ
                clearInterval(ID);
                $$a({
                    type:'post',//тип запроса: get,post либо head
                    url:document.location.href+'Game',//url адрес файла обработчика
                    data:{'a':'ng'},//параметры запроса
                    response:'text',//тип возвращаемого ответа text либо xml
                    success:function (data) {//возвращаемый результат от сервера
                        //qqq(null);
                        ID=setInterval(SendPost, 100);
                    }
                });
                
            }