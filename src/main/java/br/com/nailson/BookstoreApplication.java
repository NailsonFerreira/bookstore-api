package br.com.nailson;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.nailson.domain.Categoria;
import br.com.nailson.domain.Livro;
import br.com.nailson.repository.CategoriaRepository;
import br.com.nailson.repository.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository repoCat;
	
	@Autowired
	private LivroRepository repoLiv;
	

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Categoria cat1 = new Categoria(null, "Romance", "Livros de romance");
		
		Livro liv1 = new Livro(null, "Como eu era antes de você", "Jojo Moyes", "Will e Lou", cat1); 
		
		cat1.getLivros().addAll(Arrays.asList(liv1));
		
		repoCat.saveAll(Arrays.asList(cat1));
		repoLiv.saveAll(Arrays.asList(liv1));
	}

}
