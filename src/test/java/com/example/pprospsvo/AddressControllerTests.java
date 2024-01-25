package com.example.pprospsvo;

import com.example.pprospsvo.cotrollers.AddressController;
import com.example.pprospsvo.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(AddressController.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class AddressControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AddressService addressService;
}
