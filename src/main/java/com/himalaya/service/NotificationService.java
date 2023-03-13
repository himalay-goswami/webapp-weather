package com.himalaya.service;

import com.himalaya.entity.shared.io.UserPreferenceDto;
import com.himalaya.service.fetcherservice.ResultService;
import com.himalaya.service.kafka.Sender;
import com.himalaya.utils.ConstantUtils;
import org.springframework.kafka.KafkaException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class NotificationService {

    private final Sender sender;

    private final ResultService resultService;

    private final UserPreferenceService userPreferenceService;

    public NotificationService(Sender sender, ResultService resultService, UserPreferenceService userPreferenceService) {
        this.sender = sender;
        this.resultService = resultService;
        this.userPreferenceService = userPreferenceService;
    }

    public boolean checkForConditionFulfilment(UserPreferenceDto entity) throws ExecutionException, InterruptedException {

        double meanTemperature = resultService.getMeanTemperature();
        double minValue = entity.getName();
        double maxValue = entity.getValue();

        return meanTemperature < minValue || meanTemperature > maxValue;
    }


    @Async
    @Scheduled(fixedRate = 30000, initialDelay = 10000)
    public void sendNotifications() {
        try{
            if(checkForConditionFulfilment(userPreferenceService.getUserPreferenceEntity("Pune"))){
                sender.publishMessage(ConstantUtils.MESSAGE);
            }
        }catch (ExecutionException | InterruptedException | KafkaException exception){
            exception.printStackTrace();
        }
    }
}
