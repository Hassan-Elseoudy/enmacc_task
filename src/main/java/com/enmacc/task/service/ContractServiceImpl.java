package com.enmacc.task.service;

import com.enmacc.task.model.Contract;
import com.enmacc.task.model.Graph;
import com.enmacc.task.model.dto.AddContractDto;
import com.enmacc.task.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ContractServiceImpl implements ContractService {

    private final ContractRepository contractRepository;
    private final CompanyService companyService;

    @Autowired
    public ContractServiceImpl(ContractRepository contractRepository, CompanyService companyService) {
        this.contractRepository = contractRepository;
        this.companyService = companyService;
    }

    /**
     * get contract by Id
     *
     * @param id contract id
     * @return Contract
     */
    @Override
    public Contract getOne(Long id) {
        return contractRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    /**
     * create contract using bi-directional role.
     *
     * @param contractDto
     * @return Contract
     */
    @Override
    //TODO: I should check If I have the contract before.
    public Contract createOne(AddContractDto contractDto) {
        Contract fromContract = new Contract();
        fromContract.setFrom(companyService.getOne(contractDto.getFromCompany()));
        fromContract.setTo(companyService.getOne(contractDto.getToCompany()));

        Contract toContract = new Contract();
        toContract.setFrom(companyService.getOne(contractDto.getToCompany()));
        toContract.setTo(companyService.getOne(contractDto.getFromCompany()));


        return contractRepository.saveAll(List.of(fromContract, toContract)).get(0);
    }

    /**
     * @return list of contracts
     */
    @Override
    //TODO: Needs pagination!
    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    /**
     * @param source      source node
     * @param destination destination node
     * @return all sleeves between 2 companies.
     */
    @Override
    public List<String> getAllSleeves(Long source, Long destination) {
        List<Contract> contracts = getAllContracts();
        Graph g = new Graph(contracts.size());
        contracts.forEach(contract -> g.addEdge(contract.getFrom().getId().intValue(), contract.getTo().getId().intValue()));
        return findAllPaths(source.intValue(), destination.intValue(), g, new ArrayList<>());
    }

    /**
     * find all paths from source to destination.
     *
     * @param source
     * @param destinatino
     * @param graph
     * @param paths
     * @return
     */
    public List<String> findAllPaths(int source, int destinatino, Graph graph, List<String> paths) {
        boolean[] isVisited = new boolean[graph.getV()];
        ArrayList<Integer> pathList = new ArrayList<>();
        pathList.add(source);
        dfs(source, destinatino, isVisited, pathList, graph, paths);
        return paths;
    }

    /**
     * recursive function to find all paths from a source to destination.
     *
     * @param source        source node
     * @param destination   destination node
     * @param isVisited     keeps track of vertices in current path.
     * @param localPathList stores actual vertices in the current path
     * @param g             graph instance
     * @param paths         List of paths as string.
     */
    private void dfs(Integer source, Integer destination, boolean[] isVisited, List<Integer> localPathList, Graph g, List<String> paths) {

        if (source.equals(destination)) { // Base case
            paths.add(localPathList.stream().map(Object::toString).collect(Collectors.joining(",")));
            return;
        }

        isVisited[source] = true;
        for (Integer i : g.getAdjList()[source]) {
            if (!isVisited[i]) {
                localPathList.add(i);
                dfs(i, destination, isVisited, localPathList, g, paths);
                localPathList.remove(i);
            }
        }

        isVisited[source] = false;
    }
}
