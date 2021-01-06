package com.concertcare.sivatask.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-test.properties")
public class TestStudentRestController {

	@Autowired
	private MockMvc mockMvc;

	// test save() operation
	@Test
	public void testSave() throws Exception {
		// a.create HttpRequest
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/rest/student/save")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"studentName\":\"A\",\"studentFee\":3.3,\"studentCourse\":\"Boot\"}");

		// b. execute and get Result
		MvcResult result = mockMvc.perform(request).andReturn();

		// c. Read Response
		MockHttpServletResponse resp = result.getResponse();

		// d. Validate Using JUnit API
		assertEquals(200, resp.getStatus());
		if (!resp.getContentAsString().contains("saved")) {
		}
	}

	// test getAll() operation
	@Test
	public void testGetAll() throws Exception {
		// a.create HttpRequest
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/rest/student/all");
		// b. execute and get Result
		MvcResult result = mockMvc.perform(request).andReturn();
		// c. Read Response
		MockHttpServletResponse response = result.getResponse();
		// d. Validate Using JUnit API
		assertEquals(200, response.getStatus());
		assertEquals("application/json", response.getContentType());
		assertNotNull(response.getContentAsString());
	}

	// test getOneStudent() operation
	@Test
	public void testGetOne() throws Exception {
		// a.create HttpRequest
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/rest/student/one/1");
		// b. execute and get Result
		MvcResult result = mockMvc.perform(request).andReturn();
		// c. Read Response
		MockHttpServletResponse response = result.getResponse();
		// d. Validate Using JUnit API
		assertEquals(200, response.getStatus());
		assertEquals("application/json", response.getContentType());
		assertNotNull(response.getContentAsString());
	}

	// test update operation
	@Test
	public void testUpdate() throws Exception {
		// a.create HttpRequest
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.put("/rest/student/update")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"studentId\":2,\"studentName\":\"siva\",\"studentFee\":99.99,\"studentCourse\":\"HIB\"}");
		// b. execute and get Result
		MvcResult result = mockMvc.perform(request).andReturn();
		// c. Read Response
		MockHttpServletResponse response = result.getResponse();
		// d. Validate Using JUnit API
		assertEquals(200, response.getStatus());
		if (!response.getContentAsString().contains("Updated")) {
			fail("No data found/not updated");
		}

	}

	// test removeOneStudentDate() opertaion
	@Test
	public void testRemove() throws Exception {
		// a.create HttpRequest
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.delete("/rest/student/remove/4");
		// b. execute and get Result
		MvcResult result = mockMvc.perform(request).andReturn();
		// c. Read Response
		MockHttpServletResponse response = result.getResponse();
		// d. Validate Using JUnit API
		assertEquals(200, response.getStatus());
		if (!response.getContentAsString().contains("removed")) {
			fail("Not Removed");
		}
	}
}
