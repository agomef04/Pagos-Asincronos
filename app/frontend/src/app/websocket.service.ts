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
    // tslint:disable-next-line:only-arrow-functions
    this.stompClient.connect({}, function() {
      that.stompClient.subscribe('/message', (message) => {
        if (message.body) {
          that.msg.push(message.body);
        }
      });
    });
  }


  sendMessage(message : any) {
    this.stompClient.send('/app/topic/message' , {}, message);
  }
}