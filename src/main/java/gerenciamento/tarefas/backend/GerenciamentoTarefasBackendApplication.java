package gerenciamento.tarefas.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class GerenciamentoTarefasBackendApplication {

	public static void main(String[] args) {

		SpringApplication.run(GerenciamentoTarefasBackendApplication.class, args);

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		System.out.println(now);
	}

}
