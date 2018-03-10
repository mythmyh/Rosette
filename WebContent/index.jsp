<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Testing websockets</title>
<style type="text/css">
p {text-indent: 2em; margin: 5px; font-size: 4vw;}
</style>
</head>
<body>

  <p id="messages"/>
  <script type="text/javascript" charset="UTF-8">
    var webSocket =
      new WebSocket('ws://192.168.0.115:9000/Rosette/websocketTest');
   
    webSocket.onerror = function(event) {
        onError(event)
      };
   
      webSocket.onopen = function(event) {
        onOpen(event)
      };
   
      webSocket.onmessage = function(event) {
        onMessage(event)
      };
   
      function onMessage(event) {
        document.getElementById('messages').innerHTML
          += '<br/>' + event.data;
      }
   
      function onOpen(event) {
        document.getElementById('messages').innerHTML
          = '';
      }
   
      function onError(event) {
        alert(event.data);
      }
      function start() {
    	  var login_name='连接已经建立,准备翻译...';
    	  login_name = encodeURI(login_name); 
          webSocket.send(login_name);
          return false;
        }
      setTimeout(start,1000);
    </script>
<script>
var sh;
sh=self.setInterval(ts,2000);
function ts() {
    var aDiv = document.getElementsByTagName('div');
    var arr = [];
    for(var i=0;i<aDiv.length;i++)
    {
        arr.push(aDiv[i]);  //aDiv是元素的集合，并不是数组，所以不能直接用数组的sort进行排序。
    }
    arr.sort(function(a,b){return a.getAttribute('data-id') - b.getAttribute('data-id')});
   for(var i=0;i<arr.length;i++)
    {
        document.body.appendChild(arr[i]); //将排好序的元素，重新塞到body里面显示。
    }
   
   
   if(aDiv.length == 31 ) {
	 clearInterval(sh);
	 document.getElementById('messages').innerHTML
     = '翻译结束...';
          
   }
  }
</script>
  </body>
  </html>