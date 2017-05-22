package com.hotelspro.challange.burak.karatas;

import com.hotelspro.challange.burak.karatas.models.enums.CalculateResponseStatus;
import com.hotelspro.challange.burak.karatas.models.enums.CalculateType;
import com.hotelspro.challange.burak.karatas.models.request.CalculatorRequestBody;
import com.hotelspro.challange.burak.karatas.models.request.CalculatorRestRequest;
import com.hotelspro.challange.burak.karatas.models.request.RequestHeader;
import com.hotelspro.challange.burak.karatas.models.response.CalculatorRestResponse;
import com.hotelspro.challange.burak.karatas.services.CalculatorService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MetchallangeApplicationTests {

    @Autowired
    CalculatorService calculatorService;

    private final String BASE_PATH = "http://localhost:8080/calc/";

    @Before
    public void init() {
    }

    @Test
    public void additionEndpointTest() {

        TestRestTemplate restTemplate = new TestRestTemplate();
        ResponseEntity<CalculatorRestResponse> response = restTemplate.postForEntity(BASE_PATH + "addition", getRestRequestMock(),
                CalculatorRestResponse.class);
        HttpStatus statusCode = response.getStatusCode();
        CalculateResponseStatus responseStatus = response.getBody().getHeader().getResponseStatus();
        Assertions.assertThat(statusCode).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(responseStatus).isEqualTo(CalculateResponseStatus.SUCCESS);
    }


    @Test
    public void subtractionEndpointTest() {
        TestRestTemplate restTemplate = new TestRestTemplate();
        ResponseEntity<CalculatorRestResponse> response = restTemplate.postForEntity(BASE_PATH + "subtraction", getRestRequestMock(),
                CalculatorRestResponse.class);
        HttpStatus statusCode = response.getStatusCode();
        CalculateResponseStatus responseStatus = response.getBody().getHeader().getResponseStatus();
        Assertions.assertThat(statusCode).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(responseStatus).isEqualTo(CalculateResponseStatus.SUCCESS);
    }

    @Test
    public void cEndpointTest() {
        TestRestTemplate restTemplate = new TestRestTemplate();
        ResponseEntity<CalculatorRestResponse> response = restTemplate.postForEntity(BASE_PATH + "division", getRestRequestMock(),
                CalculatorRestResponse.class);
        HttpStatus statusCode = response.getStatusCode();
        CalculateResponseStatus responseStatus = response.getBody().getHeader().getResponseStatus();
        Assertions.assertThat(statusCode).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(responseStatus).isEqualTo(CalculateResponseStatus.SUCCESS);
    }

    @Test
    public void multiplyEndpointTest() {
        TestRestTemplate restTemplate = new TestRestTemplate();
        ResponseEntity<CalculatorRestResponse> response = restTemplate.postForEntity(BASE_PATH + "multiply", getRestRequestMock(),
                CalculatorRestResponse.class);
        HttpStatus statusCode = response.getStatusCode();
        CalculateResponseStatus responseStatus = response.getBody().getHeader().getResponseStatus();
        Assertions.assertThat(statusCode).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(responseStatus).isEqualTo(CalculateResponseStatus.SUCCESS);
    }


    @Test
    public void powEndpointTest() {
        TestRestTemplate restTemplate = new TestRestTemplate();
        ResponseEntity<CalculatorRestResponse> response = restTemplate.postForEntity(BASE_PATH + "pow", getRestRequestMock(),
                CalculatorRestResponse.class);
        HttpStatus statusCode = response.getStatusCode();
        CalculateResponseStatus responseStatus = response.getBody().getHeader().getResponseStatus();
        Assertions.assertThat(statusCode).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(responseStatus).isEqualTo(CalculateResponseStatus.SUCCESS);
    }

    @Test
    public void testSubstractionProcess() {
        Double param1 = 2d;
        Double param2 = 3d;
        Double expectedResult = -1d;
        Double result = calculatorService.calculate(param1, param2, CalculateType.SUBSTRACTION);
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testAdditionProcess() {
        Double param1 = 2d;
        Double param2 = 3d;
        Double expectedResult = 5d;
        Double result = calculatorService.calculate(param1, param2, CalculateType.ADDITION);
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testDivisionProcess() {
        Double param1 = 6d;
        Double param2 = 3d;
        Double expectedResult = 2d;
        Double result = calculatorService.calculate(param1, param2, CalculateType.DIVISION);
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testMultiplyProcess() {
        Double param1 = 2d;
        Double param2 = 3d;
        Double expectedResult = 6d;
        Double result = calculatorService.calculate(param1, param2, CalculateType.MULTIPLY);
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testPowProcess() {
        Double param1 = 2d;
        Double param2 = 3d;
        Double expectedResult = 8d;
        Double result = calculatorService.calculate(param1, param2, CalculateType.POW);
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

    private CalculatorRestRequest getRestRequestMock() {
        CalculatorRestRequest result = new CalculatorRestRequest();
        CalculatorRequestBody requestBody = new CalculatorRequestBody();
        RequestHeader header = new RequestHeader();
        header.setClient("test");
        header.setToken("xyxn");
        header.setUser("an-ast-asia");
        requestBody.setParam1(2d);
        requestBody.setParam2(3d);
        result.setBody(requestBody);
        result.setHeader(header);
        return result;
    }


}
