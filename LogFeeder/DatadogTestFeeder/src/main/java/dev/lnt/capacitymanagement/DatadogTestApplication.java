package dev.lnt.capacitymanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.timgroup.statsd.NonBlockingStatsDClientBuilder;
import com.timgroup.statsd.StatsDClient;

@SpringBootApplication
@ComponentScan("dev.lnt")
public class DatadogTestApplication {

	public static void main(String[] args) throws Exception {
		
		StatsDClient Statsd = new NonBlockingStatsDClientBuilder()
									.prefix("statsd")
									.hostname("localhost")
									.port(8125)
									.build();
		
		for(int i = 0; i < 10; i++) {
			Statsd.incrementCounter("example_metric.increment", new String[] {"environment:dev"});
			Statsd.decrementCounter("example_metric.decrement", new String[] {"environment:dev"});
			Statsd.count("example_metric.count", 2, new String[] {"environment:dev"});
			Thread.sleep(1000);
		}
		
		SpringApplication.run(DatadogTestApplication.class, args);
	}

}
