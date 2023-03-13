# webapp-weather

To get started, first clone the two stubs: 

# https://github.com/himalay-goswami/weather-stub-1 (port: 9119)

# https://github.com/himalay-goswami/weather-stub-1 (port: 9118)

Fetch the core application (webapp-weather). For simplicity, user Services in IntelliJ Ultimate to manage all 3 builds from a single window.

*Make sure to not add any application context during deployment while adding Tomcat to avoid any URL issues (the current is http://localhost:8080)

Application's algorithm can be explained in simple steps:

1. The entry point of the system is the RESULT SERVICE class, which makes a scheduled calls to the two stubs after every interval.  



![Untitled Diagram drawio](https://user-images.githubusercontent.com/89119726/224597590-6e1807d6-22db-4633-935d-5e2c10915afb.png)
