package com.trepudox.testeH2;

import com.trepudox.testeH2.model.Jogador;
import com.trepudox.testeH2.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;
import java.util.Random;

@EnableScheduling
@SpringBootApplication
public class TesteH2Application {

	@Autowired
	private JogadorRepository jogadorRepository;

	private static Random random = new Random();
	private static List<String> vogal = List.of("a","e","i","o","u"); // 5
	private static List<String> consoante = List.of("b","c","d","f","g","h","j","k","l","m","n","p","q","r","s","t","v",
			"w","x","y","z"); // 21

	public static void main(String[] args) {
		SpringApplication.run(TesteH2Application.class, args);
	}

	@Scheduled(fixedDelay = 10000)
	private void addJogador() {
		int pace = random.nextInt(49) + 50;
		int dribbling = random.nextInt(50) + 50;
		int passing = random.nextInt(49) + 50;
		int shooting = random.nextInt(49) + 50;
		int overall = (pace + dribbling + passing + shooting) / 4;

		Jogador j = Jogador.builder()
				.nome(nomeAleatorio())
				.overall(overall)
				.pace(pace)
				.dribbling(dribbling)
				.passing(passing)
				.shooting(shooting)
				.build();

		j = jogadorRepository.save(j);
		System.out.println("Jogador "+ j.getId() + " salvo com sucesso");
	}

	private String nomeAleatorio() {
		String nome = "";
		boolean ultimaFoiVogal = false;

		if (random.nextDouble() > 0.80) {
			nome += consoante.get(random.nextInt(21));
		} else {
			nome += vogal.get(random.nextInt(5));
			ultimaFoiVogal = true;
		}


		for (; nome.length() < random.nextInt(8) + 3;) {
			if (ultimaFoiVogal && random.nextDouble() > 0.9) {
				nome += vogal.get(random.nextInt(5));
				nome += consoante.get(random.nextInt(21));
				ultimaFoiVogal = false;
			}

			if (!ultimaFoiVogal && random.nextDouble() > 0.8) {
				nome += consoante.get(random.nextInt(21));
			}

			if (ultimaFoiVogal) {
				nome += consoante.get(random.nextInt(21));
				ultimaFoiVogal = false;
			} else {
				nome += vogal.get(random.nextInt(5));
				ultimaFoiVogal = true;
			}


		}

		return nome;
	}

}
