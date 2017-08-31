package br.com.flaviodev.manytomany;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.flaviodev.manytomany.model.Anexo;
import br.com.flaviodev.manytomany.model.Correspondencia;
import br.com.flaviodev.manytomany.model.RegistroMovimento;
import br.com.flaviodev.manytomany.repository.AnexoRepository;
import br.com.flaviodev.manytomany.repository.CorrespondenciaRepository;
import br.com.flaviodev.manytomany.repository.RegistroMovimentoRepository;


@SpringBootApplication
public class ManyToManyApplication  implements CommandLineRunner {

	@Autowired
	private AnexoRepository anexoRepository;
	
	@Autowired
	private CorrespondenciaRepository correspondenciaRepository;
	
	@Autowired
	private RegistroMovimentoRepository registroMovimentoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ManyToManyApplication.class, args);
	}

	
	// limpa as tabelas e inclui os registros para serem apresentados na home
	public void run(String... args) throws Exception {
		
		registroMovimentoRepository.deleteAll();
		correspondenciaRepository.deleteAll();		
		anexoRepository.deleteAll();
		
		
		Anexo anexo1 = new Anexo();
		anexo1.setNome("Anexo 1");
		anexoRepository.save(anexo1);
		
		Anexo anexo2 = new Anexo();
		anexo2.setNome("Anexo 2");
		anexoRepository.save(anexo2);

		Anexo anexo3 = new Anexo();
		anexo3.setNome("Anexo 3");
		anexoRepository.save(anexo3);

		Correspondencia correspondencia1 = new Correspondencia();
		correspondencia1.setDestinatario("destinatário 1");
		correspondenciaRepository.save(correspondencia1);

		Correspondencia correspondencia2 = new Correspondencia();
		correspondencia2.setDestinatario("destinatário 2");
		correspondenciaRepository.save(correspondencia2);
		
		RegistroMovimento registro1 = new RegistroMovimento();
		registro1.setAnexo(anexo1);
		registro1.setCorrespondencia(correspondencia1);
		registroMovimentoRepository.save(registro1);

		RegistroMovimento registro2 = new RegistroMovimento();
		registro2.setAnexo(anexo1);
		registro2.setCorrespondencia(correspondencia2);
		registroMovimentoRepository.save(registro2);

		RegistroMovimento registro3 = new RegistroMovimento();
		registro3.setAnexo(anexo2);
		registro3.setCorrespondencia(correspondencia1);
		registroMovimentoRepository.save(registro3);

		RegistroMovimento registro4 = new RegistroMovimento();
		registro4.setAnexo(anexo2);
		registro4.setCorrespondencia(correspondencia2);
		registroMovimentoRepository.save(registro4);

		RegistroMovimento registro5 = new RegistroMovimento();
		registro5.setAnexo(anexo3);
		registro5.setCorrespondencia(correspondencia2);
		registroMovimentoRepository.save(registro5);

		
	}
	
	
	
}
