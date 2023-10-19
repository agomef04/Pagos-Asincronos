package com.WebSocket;

import com.WebSocket.model.*;
import com.WebSocket.repository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;

@SpringBootApplication
public class WebSocketApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(WebSocketApplication.class);

		UserRepository repositoryUser = context.getBean(UserRepository.class);
		BankAccountRepository repositoryBankAccount = context.getBean(BankAccountRepository.class);
		StateRepository repositoryState = context.getBean(StateRepository.class);
		TransferRepository repositoryTransfer = context.getBean(TransferRepository.class);

		// Eliminar todos los registros
		repositoryTransfer.deleteAll();
		repositoryBankAccount.deleteAll();
		repositoryState.deleteAll();
		repositoryUser.deleteAll();


		// Guardar usuarios
		User user = new User("juan@gmail.com","password","juanito","987654321");
		BankAccount bankAccount = new BankAccount(0.0, user);
		State pendentState = new State("PENDENT", "Esta en cola para ser procesada la transferencia");
		Transfer transfer = new Transfer(0.0, "prueba", new Date(), pendentState, bankAccount, bankAccount);


		repositoryUser.save(user);
		repositoryBankAccount.save(bankAccount);
		repositoryState.save(pendentState);
		repositoryTransfer.save(transfer);

		//findAll heredado de la interface CrudRepository
		Iterable<User> todos = repositoryUser.findAll();
		System.out.println("Listar todos los usuarios");
		for(User u : todos) {
			System.out.println("\t" + u);
		}
		System.out.println();

		context.close();


	}

}
