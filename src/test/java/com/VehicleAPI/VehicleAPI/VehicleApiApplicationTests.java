package com.VehicleAPI.VehicleAPI;

import com.VehicleAPI.VehicleAPI.Controllers.VehicleRestController;
import com.VehicleAPI.VehicleAPI.Entities.Vehicle;
import org.aspectj.lang.annotation.Before;
import org.h2.util.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.security.RunAs;
import java.util.Map;

import static javax.swing.UIManager.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class VehicleApiApplicationTests {

	@Autowired
	private WebApplicationContext webAppContext;
	private MockMvc mockMvc;

	@Before("")
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
	}

	@Test
	void contextLoads() {

	}

	//Tests creating a vehicle and checks if the returned response matches the vehicle created.
	@Test
	void testCreateVehicle() throws Exception{
		mockMvc.perform(post("/api/create")
				.content("{'year':'2011','make':'toyota','model':'yaris'}")
				.contentType("application/json")
		)
				.andExpect(status().isCreated())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.year").value("2011")).andExpect(jsonPath("$.make").value("toyota")).andExpect(jsonPath("$.model").value("yaris"));
	}

	//Tests getting all vehicles
	@Test
	void testGetVehicles() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/vehicles"))
				.andExpect(status().isOk())
				.andExpect(status().isCreated())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.year").value("2011")).andExpect(jsonPath("$.make").value("toyota")).andExpect(jsonPath("$.model").value("yaris"));
	}

	//Tests getting a vehicle by id and checks if the returned response matches the vehicle created.
	@Test
	void testGetVehicleById() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/vehicles/1"))
				.andExpect(status().isOk())
				.andExpect(status().isCreated())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.year").value("2011")).andExpect(jsonPath("$.make").value("toyota")).andExpect(jsonPath("$.model").value("yaris"));
	}

	//Tests deleting a vehicle
	@Test
	void testDeleteVehicle() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/api/vehicles/delete/1"))
				.andExpect(status().isOk())
				.andExpect(status().isCreated())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.year").value("2011")).andExpect(jsonPath("$.make").value("toyota")).andExpect(jsonPath("$.model").value("yaris"));
	}

	//Tests updating a vehicle and checks if the returned response matches the vehicle updated.
	@Test
	void testUpdateVehicle() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.put("/api/vehicles/update")
				.content("{'id':'1',year':'2012','make':'toyota','model':'corolla'}")
				.contentType("application/json")
		)
				.andExpect(status().isOk())
				.andExpect(status().isCreated())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.year").value("2012")).andExpect(jsonPath("$.make").value("toyota")).andExpect(jsonPath("$.model").value("corolla"));
	}

}
