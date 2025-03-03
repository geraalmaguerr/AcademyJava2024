package com.javatechie.spring.batch.config;

import com.javatechie.spring.batch.entity.Customer;
import com.javatechie.spring.batch.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import java.util.function.Supplier;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class SpringBatchConfig {

    private JobBuilderFactory jobBuilderFactory;

    private StepBuilderFactory stepBuilderFactory;

    private CustomerRepository customerRepository;


    @Bean
    public FlatFileItemReader<Customer> reader() {
        FlatFileItemReader<Customer> itemReader = new FlatFileItemReader<>();
        itemReader.setResource(new FileSystemResource("src/main/resources/customers.csv"));
        itemReader.setName("csvReader");
        itemReader.setLinesToSkip(1);
        itemReader.setLineMapper(lineMapper());
        return itemReader;
    }

    private LineMapper<Customer> lineMapper() {
        DefaultLineMapper<Customer> lineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("id", "firstName", "lastName", "email", "gender", "contactNo", "country", "dob");

        BeanWrapperFieldSetMapper<Customer> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Customer.class);

        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;
    }

    @Bean
    public Step step1() {
        Supplier<RepositoryItemWriter<Customer>> supplier = () -> {
            RepositoryItemWriter<Customer> writer = new RepositoryItemWriter<>();
            writer.setRepository(customerRepository);
            writer.setMethodName("save");
            return writer;
        };

        return stepBuilderFactory.get("csv-step-Brazil")
                .<Customer, Customer>chunk(10)
                .reader(reader()) // Use the same reader for both steps
                .processor((ItemProcessor<Customer, Customer>) customer -> {
                    if (customer.getCountry().equals("Brazil"))
                        return customer;
                    return null; // Skip non-Brazil customers
                })
                .writer(supplier.get())
                .taskExecutor(taskExecutor())
                .build();
    }

    @Bean
    public Step step2() {
        Supplier<RepositoryItemWriter<Customer>> supplier = () -> {
            RepositoryItemWriter<Customer> writer = new RepositoryItemWriter<>();
            writer.setRepository(customerRepository);
            writer.setMethodName("save");
            return writer;
        };

        return stepBuilderFactory.get("csv-step-China")
                .<Customer, Customer>chunk(10)
                .reader(reader()) // Reuse the same reader
                .processor((ItemProcessor<Customer, Customer>) customer -> {
                    if (customer.getCountry().equals("China"))
                        return customer;
                    return null; // Skip non-China customers
                })
                .writer(supplier.get())
                .taskExecutor(taskExecutor())
                .build();
    }

    
    @Bean
    public Job runJob() {
        return jobBuilderFactory
        		.get("importCustomers")
        		.flow(step1())
        		.end()
        		.build();

    }

    @Bean
    public TaskExecutor taskExecutor() {
        SimpleAsyncTaskExecutor asyncTaskExecutor = new SimpleAsyncTaskExecutor();
        asyncTaskExecutor.setConcurrencyLimit(10);
        return asyncTaskExecutor;
    }

}
