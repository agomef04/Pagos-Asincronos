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
      this.stompClient.subscribe(`/topic/newTransfer/${email}`, (message : any) => {
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

  sendMoney(tlfDest: string, amount: Number, concept: string, phoneNumber: string): void {

    let message: any = {
      "amount": amount,
      "concept": concept,
      "bankAccountOrigin": phoneNumber,
      "numberPhone": tlfDest
    };
  
    this.stompClient.send("/app/createdTransfer", message);
    console.log("Money sent");
  }

  ngOnInit(): void {
    this.stompClient.messageReceived.subscribe((message: string) => {
      console.log('Mensaje recibido:', message); // Muestra el mensaje en la consola
      // Puedes hacer cualquier otra lógica aquí con el mensaje recibido
    });
  }
}