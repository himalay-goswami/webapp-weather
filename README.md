# webapp-weather

To get started, first clone the two stubs: 

### https://github.com/himalay-goswami/weather-stub-1 (port: 9119)

### https://github.com/himalay-goswami/weather-stub-1 (port: 9118)

Fetch the core application (webapp-weather). For simplicity, user Services in IntelliJ Ultimate to manage all 3 builds from a single window.

*Make sure to not add any application context during deployment while adding Tomcat to avoid any URL issues (the current is http://localhost:8080)

Application's algorithm can be explained in simple steps:

The entry point of the system is the RESULT SERVICE class, which makes a scheduled calls to the two stubs after every interval.  

1. Result service makes use of CompletableFuture to get data from two stubs, calculate mean temperature and save the Weather object to database     and cache layer. (I have implemented a Cache Service Layer that store values of latest weather data in an in-memory list to reduce calls to     the database).

2. As soon as the window loads, (localhost:8080), a WEB SOCKET connection is established and the user is prompted to input preferred minimum and    maximum values of temperature to be notified. These values are saved in an object and persisted to data layer and cache layer. Weather  Service class is the interface between data layer and service layers, and all other services call weather service to get/save data from/to cache and database. 

3. As soon as new data arrives, notification service class is triggered as scheduled, which in turn calls Condition Service to check if the latest data meets user preferred requirements. If the condition is met, KAFKA sender is triggered which publishes the notification message on a queue. Listener class, which listens on the queue, then calls the registered notification channels (in-app, slack, and SMS) to deliver the notifications.

Here's a rough schematic of the entire operation which like an event. 

![Untitled Diagram drawio](https://user-images.githubusercontent.com/89119726/224597590-6e1807d6-22db-4633-935d-5e2c10915afb.png)

To start Kafka, I have added 3 CMD scripts to start zookeeper server, kafka server, and to create topics. Please edit the CMD scripts based on the installation of Kafka on your local machine. 

I have written unit tests for all the business logic classes and controllers and DAO, and made best efforts to make seperation of concerns as clear as possible. All the configurations are kept seperate in a config package. 
