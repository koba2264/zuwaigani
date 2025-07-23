$(function() {
    const url = "ws://localhost:7766/zuwaigani/WebSocketServer";
    const ws = new WebSocket(url);
    let flag = false;
    const MyId = document.getElementById('myId').dataset.name;
    const SendId = document.getElementById('sendId').dataset.name;
    console.log(MyId);
    console.log(SendId);


    ws.onmessage = function(receive) {
        console.log(receive.data);
    };

    ws.onopen = function() {
	    console.log("接続");
    };

    const btn = document.getElementById('test');
    btn.addEventListner('click', () => {
    	const json = JSON.stringify(obj);
    	const obj = { type:'openChat', sendId:SendId, myId:MyId };
    	ws.send(obj);
    	console.log("btn");
    })

  });