package nus.iss.tfip.pafday28;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import nus.iss.tfip.pafday28.repository.AppRepository;
import nus.iss.tfip.pafday28.repository.PlaystoreRepository;

@SpringBootApplication
public class PafDay28Application implements CommandLineRunner{

	@Autowired
	private AppRepository appRepo;

	public static void main(String[] args) {
		SpringApplication.run(PafDay28Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Document> results = appRepo.sortAppNameByCategory();

		for (Document d: results)
			System.out.printf(">>> %s\n", d.toJson());
	}

}
