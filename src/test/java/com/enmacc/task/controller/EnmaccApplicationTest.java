package com.enmacc.task.controller;

import com.enmacc.task.model.Company;
import com.enmacc.task.model.Contract;
import com.enmacc.task.repository.CompanyRepository;
import com.enmacc.task.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.enmacc.task.controller.MockData.getCompanies;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
abstract public class EnmaccApplicationTest {

    @Autowired
    public MockMvc mockMvc;

    @Autowired
    public CompanyRepository companyRepository;

    @Autowired
    public ContractRepository contractRepository;

    void setUp() {
        companyRepository.deleteAll();
        List<Company> companies = getCompanies();
        companies = companyRepository.saveAll(companies);
        contractRepository.save(new Contract(1L, companies.get(1), companies.get(4)));
        contractRepository.save(new Contract(2L, companies.get(1), companies.get(3)));
        contractRepository.save(new Contract(3L, companies.get(4), companies.get(2)));

    }

    void tearDown() {
        contractRepository.deleteAll();
        companyRepository.deleteAll();
    }


}