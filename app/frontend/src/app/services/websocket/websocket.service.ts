import { Injectable } from '@angular/core';
import { Client, Frame, Stomp, StompHeaders } from '@stomp/stompjs';

@Injectable({
  providedIn: 'root'
})
export class WebsocketService {
  private stompClient: Client;

  constructor() {
    this.stompClient = new Client({
      brokerURL: 'ws://localhost:8080/gs-guide-websocket'
    });
  }

  connect(): void {
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

  sendName(name: string): void {
    this.stompClient.publish({
      destination: '/app/hello',
      body: JSON.stringify({ 'name': name })
    });
  }

  subscribeToGreetings(callback: (message: string) => void): void {
    this.stompClient.subscribe('/topic/greetings', (greeting) => {
      const content = JSON.parse(greeting.body).content;
      callback(content);
    });
  }
}
