package br.com.tectectech.tectectechProducer.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class RelatorioProducer {

	private final KafkaTemplate<String, String> kafkaTemplate;

	public RelatorioProducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void publish(String idRelatorio, String phRelatorio) {
		kafkaTemplate.send("tectectech.relatorio", idRelatorio, phRelatorio);
	}

}