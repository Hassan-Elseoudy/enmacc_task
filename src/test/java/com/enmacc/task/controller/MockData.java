package com.enmacc.task.controller;

import com.enmacc.task.model.Company;
import com.enmacc.task.model.Contract;

import java.util.ArrayList;
import java.util.List;

public class MockData {

    public static List<Company> getCompanies() {
        return List.of(
                new Company(1L, "ExxonMobil", new ArrayList<>(), new ArrayList<>()),
                new Company(2L, "Royal Dutch Shell", new ArrayList<>(), new ArrayList<>()),
                new Company(3L, "Chevron Corporation", new ArrayList<>(), new ArrayList<>()),
                new Company(4L, "Total", new ArrayList<>(), new ArrayList<>()),
                new Company(5L, "BP", new ArrayList<>(), new ArrayList<>())
        );
    }

}
