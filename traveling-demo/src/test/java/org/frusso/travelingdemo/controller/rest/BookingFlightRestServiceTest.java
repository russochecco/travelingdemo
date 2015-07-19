package org.frusso.travelingdemo.controller.rest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.frusso.travelingdemo.TravelingDemoApplication;
import org.frusso.travelingdemo.domain.Flight;
import org.frusso.travelingdemo.service.FlightService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TravelingDemoApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port=9000")
public class BookingFlightRestServiceTest {
	
	private Logger logger;
	private RestTemplate restTemplate;
	
	@Autowired
	private FlightService flightService;

	@Before
	public void setUp() throws Exception {
		
		logger = Logger.getLogger(BookingFlightRestServiceTest.class);
		restTemplate = new TestRestTemplate();
		
	}

	@Test
	public void findAllTest() {
		

		
		
//		public void post(){
//			MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
//			map.add("name", "xx");
//			map.add("password", "xx");
//		
//			String result = rest.postForObject("http://localhost:8080/soa-server/user/", map, String.class);
//			System.out.println(result);
//		}
//		
//		ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:9000//booking-flight/flight-all", String.class);
//		
//		assertTrue(entity.getStatusCode().is2xxSuccessful());		
//		
//		logger.info(entity.getBody());
		
	}
	
	@Test
	public void findFlightsByDepartureTest() {
		
		ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:9000//booking-flight/flight-by-departure?departure=Hong Kong (HKG)", String.class);		

		assertTrue(entity.getStatusCode().is2xxSuccessful());		
		
		assertTrue(entity.getBody().contains("Hong Kong (HKG)"));		
		
		logger.info(entity.getBody());
		
	}
	
	@Test
	public void addFlightTest() {
		
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("number", "AA40000");
		map.add("departure", "Hong Kong (HKG)");
		map.add("destination", "Kunming (KMG)");
		map.add("date", "2015-10-05");
		map.add("timeDeparture", "9:20");
		map.add("timeArrival", "16:20");
		map.add("status", "available");
		map.add("price", "250.0");
		map.add("type", "HK Express");
		

		String response = restTemplate.postForObject("http://localhost:9000//booking-flight/flight-add", map, String.class);		

		response.isEmpty();

//		HttpMessageConverter formHttpMessageConverter = new FormHttpMessageConverter();
//		HttpMessageConverter stringHttpMessageConverternew = new StringHttpMessageConverter();
//		
//		restTemplate.setMessageConverters(new HttpMessageConverter[]{formHttpMessageConverter, stringHttpMessageConverternew});

		
		

		
//		String request ="flight={\"number\":\"AA40000\",\"departure\":\"Hong Kong (HKG)\",\"destination\":\"Kunming (KMG)\",\"date\":\"2015-10-05"
//				+ "\",\"timeDeparture\":\"10:30\",\"timeArrival\":\"16:20\",\"status\":\"available\",\"price\":\"250.00\",\"type\":\"HK Express\"}";
//
//		HttpEntity<String> entity = new HttpEntity<String>(request,headers);
//		restTemplate.put("http://localhost:9000//booking-flight/flight-add", entity);
//		
//		Flight found = flightService.findByNumber("AA40000");
//	
//		assertNotNull(found);	
		
//		ResponseEntity<String> entity = restTemplate.postForEntity("http://localhost:9000//booking-flight/flight-add?flight=" + flight, String.class);		
//		
//		assertTrue(entity..is2xxSuccessful());		
//		
//		assertEquals(entity.getBody().toString(), flight);		
//		
//		logger.info(entity.getBody());
		
	}

}
