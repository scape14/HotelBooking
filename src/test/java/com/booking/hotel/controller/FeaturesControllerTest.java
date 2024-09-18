package com.booking.hotel.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.booking.hotel.services.FeaturesService;

@SpringBootTest
public class FeaturesControllerTest {

	private MockMvc mockMvc;

	@MockBean
	private FeaturesService featuresService;

	@InjectMocks
	private FeaturesController featuresController;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(featuresController).build();

	}

	@Test
	public void testFindedAllFeatures() throws Exception {
		when(featuresService.findedAllFeatures()).thenReturn(Collections.emptyList());

		mockMvc.perform(get("/findallFeatures"));

	}
}
