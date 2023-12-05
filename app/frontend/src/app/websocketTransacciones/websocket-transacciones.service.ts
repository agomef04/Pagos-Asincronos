import { Injectable } from '@angular/core';
declare var SockJS : any;
declare var Stomp : any;

@Injectable({
  providedIn: 'root'
})
export class websocketTransacciones {
  private serverUrl = 'http://localhost:8080/';
  public stompClient : any;
  public msg = []

  constructor() {
  }

  connect(email: string, pass: string): void {
    const ws = new SockJS(this.serverUrl);
    this.stompClient = Stomp.over(ws);

    const messageContent = {
      email: email,
      password: pass
    };

    this.stompClient.connect({}, (frame : any) => {
      console.log(messageContent)
      if (this.stompClient.status === 'CONNECTED') {
        this.stompClient.send('/app/topic/message' , {}, messageContent);
      }
    });
  }

  disconnect(): void {
    this.stompClient.deactivate();
    console.log("Disconnected");
  }
}