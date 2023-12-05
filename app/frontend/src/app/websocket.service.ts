import { Injectable } from '@angular/core';

// Declare SockJS and Stomp
declare var SockJS : any;
declare var Stomp : any;

@Injectable({
  providedIn: 'root'
})
export class WebsocketService {

  public stompClient : any;
  public msg = []

  constructor() { 
    this.initializedWebSocketConnection();
  }


  initializedWebSocketConnection() {
    const serverUrl = 'http://localhost:8080/ws-endpoint';
    const ws = new SockJS(serverUrl);
    this.stompClient = Stomp.over(ws);
    const that = this;
    
    this.stompClient.connect({}, (frame : any) => {
      this.stompClient.subscribe('/message', (message : any) => {
        if (message.body) {
          this.msg = message.body;
        }
      });
    });
  }


  sendMessage(message : any) {
    this.stompClient.send('/app/topic/message' , {}, message);
  }
}