package com.himalaya.service.kafka;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SenderTest {

    private static final String MESSAGE = "test message";
    private static final String TOPIC = "notifications";

    @Mock
    private KafkaTemplate<String, String> kafkaTemplate;

    @Test
    void testPublishMessage() {
        Sender sender = new Sender(kafkaTemplate);
        sender.publishMessage(MESSAGE);
        verify(kafkaTemplate).send(eq(TOPIC), eq(MESSAGE));
    }
}





/*
package com.himalaya.service.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.kafka.test.rule.EmbeddedKafkaRule;
import org.springframework.kafka.test.utils.ContainerTestUtils;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.kafka.test.hamcrest.KafkaMatchers.hasValue;
import static org.springframework.kafka.test.utils.KafkaTestUtils.consumerProps;

@RunWith(SpringRunner.class)
@DirtiesContext
@Component
public class SpringKafkaProducerTest {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(SpringKafkaProducerTest.class);

    private static final String SENDER_TOPIC = "notifications";

    @Autowired
    private Sender sender;

    private KafkaMessageListenerContainer<String, String> container;

    private BlockingQueue<ConsumerRecord<String, String>> records;

    @ClassRule
    public static EmbeddedKafkaRule embeddedKafka =
            new EmbeddedKafkaRule(1, true, SENDER_TOPIC);

    @Before
    public void setUp() {
        // set up the Kafka consumer properties
        Map<String, Object> consumerProperties =
                consumerProps("sender", "false",
                        embeddedKafka.getEmbeddedKafka());

        // create a Kafka consumer factory
        DefaultKafkaConsumerFactory<String, String> consumerFactory =
                new DefaultKafkaConsumerFactory<>(
                        consumerProperties);

        // set the topic that needs to be consumed
        ContainerProperties containerProperties =
                new ContainerProperties(SENDER_TOPIC);

        // create a Kafka MessageListenerContainer
        container = new KafkaMessageListenerContainer<>(consumerFactory,
                containerProperties);

        // create a thread safe queue to store the received message
        records = new LinkedBlockingQueue<>();

        // setup a Kafka message listener
        container
                .setupMessageListener((MessageListener<String, String>) record -> {
                    LOGGER.debug("test-listener received message='{}'",
                            record);
                    records.add(record);
                });

        // start the container and underlying message listener
        container.start();

        // wait until the container has the required number of assigned partitions
        ContainerTestUtils.waitForAssignment(container,
                embeddedKafka.getEmbeddedKafka().getPartitionsPerTopic());
    }

    @After
    public void tearDown() {
        // stop the container
        container.stop();
    }

    @Test
    public void testSend() throws InterruptedException {

        // send the message
        String greeting = "Hello Spring Kafka Sender!";
        sender.publishMessage(greeting);

        // check that the message was received
        ConsumerRecord<String, String> received =
                records.poll(10, TimeUnit.SECONDS);

        // Hamcrest Matchers to check the value
        assertThat(received, hasValue(greeting));
    }
}
*/
