package com.enmacc.task.controller;

import com.enmacc.task.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static com.enmacc.task.controller.MockData.getCompanies;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
abstract public class EnmaccApplicationTest {

    @Autowired
    public MockMvc mockMvc;

    @Autowired
    public CompanyRepository companyRepository;

    void setUp() {
        companyRepository.deleteAll();
        companyRepository.saveAll(getCompanies());
    }

    void tearDown() {
        companyRepository.deleteAll();
    }


}