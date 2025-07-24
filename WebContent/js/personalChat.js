// 左側チャットリストのサイドバー折りたたみ機能
document.querySelector('.collapse-btn').addEventListener('click', function() {
  const leftSidebar = document.querySelector('.left-sidebar');
  const menu = document.querySelector('.sidebar-menu');
  // パネル表示/非表示を切り替え
  leftSidebar.classList.toggle('hidden');
  menu.classList.toggle('collapsed');
  // 矢印アイコンの向きを変更
  const icon = this.querySelector('i');
  if (leftSidebar.classList.contains('hidden')) {
    icon.classList.remove('fa-chevron-left');
    icon.classList.add('fa-chevron-right');
  } else {
    icon.classList.remove('fa-chevron-right');
    icon.classList.add('fa-chevron-left');
  }
});

const resetInput = () => {
	document.getElementById('send-text').value = "";
}
const MyId = document.getElementById('myId').dataset.name;
let selectId = "";

document.querySelectorAll('.chat-list-item').forEach((element) => {
	element.addEventListener('click',() => {
		const sendId = element.querySelector('.id').value;
		if (selectId != sendId) {
			resetInput();
			document.querySelectorAll('.chat-list-item').forEach((ele) => {
				ele.classList.remove('active');
			});
			element.classList.add('active');
			element.querySelector('.chat-time').innerHTML = "";
			let name = element.querySelector('.name').value;
			selectId = sendId;
			document.querySelector('.chat-user-name').innerHTML = name;
			fetch('/zuwaigani/GetChat',{
				method: 'POST',
				headers: {
					'Content-Type': 'application/json'
				},
				body: JSON.stringify({
					myId: MyId,
					name: name,
					sendId: sendId
				})
			}).then(response => response.json()).then(data => {
				const chat = document.querySelector('.chat-messages');
				chat.innerHTML = "";
				let html = "";
				for (const mes of data.message) {
					if (mes.id == MyId) {
						html += '<div class="message self">';
					} else {
						html += '<div class="message friend">';
					}
					html += `
						<div class="message-bubble">
						${ mes.text }
						</div>
						<div class="message-divider">${ mes.time }</div>
						</div>
						`
				}
				const messages = document.createElement('div');
				messages.innerHTML = html;
				chat.appendChild(messages);
				chat.scrollTop = chat.scrollHeight;
				console.log(data);
			}).catch(error => {
				console.error('エラー',error);
			})
		}
	})
})


$(function() {
    const url = "ws://localhost:7766/zuwaigani/WebSocketServer";
    const ws = new WebSocket(url);
    let flag = false;

    ws.onmessage = function(receive) {
        console.log(receive.data);
        if (receive.data == 'Open') {
        	console.log(ws.readyState);
        	const data = {
        			type: "Open",
        			myId: MyId
        	}
        	ws.send(JSON.stringify(data));
        }
        const text = document.getElementById('send-text').value = receive.data;
    };

    ws.onopen = function() {
    	const data = {
    			type: "Open",
    			myId: MyId
    	}
    	ws.send(JSON.stringify(data));
    };

    const ChatInputElm = document.querySelector('.chat-input-area');
    const sendMes = () => {
    	if (selectId != "") {
    		const text = document.getElementById('send-text').value;
    		fetch('/zuwaigani/SendChat',{
				method: 'POST',
				headers: {
					'Content-Type': 'application/json'
				},
				body: JSON.stringify({
					sendId: MyId,
					receiveId: selectId,
					text: text,
				})
    		}).then(response => response.json()).then(data => {
    			resetInput();
    			const html = `
	    			<div class="message-bubble">
						${ data.text }
					</div>
					<div class="message-divider">${ data.time }</div>
    			`
    			const message = document.createElement('div');
				message.innerHTML = html;
				message.classList.add('message','self');
				const chatAreaElm = document.querySelector('.chat-messages');
				chatAreaElm.appendChild(message);
    			chatAreaElm.scrollTop = chatAreaElm.scrollHeight;
    			ws.close();
    		    ws.onopen = function() {
    		    	const send = {
    		    			type: "Send",
    		    			myId: MyId,
    		    			sendId: selectId
    		    	}
    		    	ws.send(JSON.stringify(data));
    		    };
    		})
    	}
    }
    ChatInputElm.querySelector('.send-btn').addEventListener('click',sendMes);
    document.getElementById('send-text').addEventListener('keydown',(e) => {
    	if (e.key === "Enter") {
    		sendMes();
    	}
    });

  });