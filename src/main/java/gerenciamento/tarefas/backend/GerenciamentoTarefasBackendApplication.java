package gerenciamento.tarefas.backend;

import gerenciamento.tarefas.backend.util.DateUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class GerenciamentoTarefasBackendApplication {

	public static void main(String[] args) throws ParseException {

		SpringApplication.run(GerenciamentoTarefasBackendApplication.class, args);

	}

}
