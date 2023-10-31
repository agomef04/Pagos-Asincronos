import { Injectable } from '@angular/core';
import { Client, Frame, Stomp, StompHeaders} from '@stomp/stompjs';
import * as SockJS from 'sockjs-client';

@Injectable({
  providedIn: 'root'
})
export class WebsocketService {
  private serverUrl = 'ws://localhost:8080/gs-guide-websocket';
  private stompClient: Client = new Client({brokerURL: this.serverUrl});

  constructor() {
  }

  connect(email: string, pass: string): void {

    const ws = new SockJS(this.serverUrl);
    this.stompClient = Stomp.over(ws);

    this.stompClient.connectHeaders= {Ad: "x", login: email, passcode: pass}

    this.stompClient.activate();

    this.stompClient.onConnect = (frame: Frame) => {
      console.log('Connected: ' + frame);
    };

    this.stompClient.onWebSocketError = (error: StompHeaders) => {
      console.error('Error with websocket', error);
    };

    this.stompClient.onStompError = (frame: Frame) => {
      console.error('Broker reported error: ' + frame.headers['message']);
      console.error('Additional details: ' + frame.body);
    };
  }

  disconnect(): void {
    this.stompClient.deactivate();
    console.log("Disconnected");
  }
}
