import { Injectable } from '@angular/core';
declare var SockJS : any;
declare var Stomp : any;

@Injectable({
  providedIn: 'root'
})
export class websocketTransacciones {
  private serverUrl = 'http://localhost:8080/ws-endpoint';
  public stompClient : any;
  public msg = []

  constructor() {
  }

  connect(email: String): void {
    const ws = new SockJS(this.serverUrl);
    this.stompClient = Stomp.over(ws);

    this.stompClient.connect({}, (frame : any) => {
      this.stompClient.subscribe(`/topic/transfer/${email}`, (message : any) => {
        if (message.body) {
          alert(message.body);
        }
      });
    });
  }

  disconnect(): void {
    this.stompClient.deactivate();
    console.log("Disconnected");
  }
}