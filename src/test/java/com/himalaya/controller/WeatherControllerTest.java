package com.himalaya.controller;

import com.himalaya.entity.shared.io.WeatherDto;
import com.himalaya.service.WeatherService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.time.LocalTime;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class WeatherControllerTest {

    @Mock
    private WeatherService weatherService;

    @Mock
    private Model model;

    @InjectMocks
    private WeatherController weatherController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(weatherController).build();
    }

    @Test
    public void testShowPage() throws Exception {
        WeatherDto weatherData = new WeatherDto();
        weatherData.setId(1);
        weatherData.setCityName("pune");
        weatherData.setTemperature(25);
        weatherData.setTimeStamp(LocalTime.now().toString());

        when(weatherService.getLatestCachedData()).thenReturn(weatherData);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("main-menu"))
                .andExpect(model().attribute("LatestTemperature", weatherData.getTemperature()))
                .andExpect(model().attribute("cityName", "Pune"));

        verify(weatherService, times(1)).getLatestCachedData();
    }
}
