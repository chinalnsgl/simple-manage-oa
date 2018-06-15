package net.sgl.simplemanageoa.services.impl;

import net.sgl.simplemanageoa.entites.Manager;
import net.sgl.simplemanageoa.repository.ManagerRepository;
import net.sgl.simplemanageoa.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerRepository managerRepositoryp;

    @Override
    public Manager save(Manager manager) {
        return managerRepositoryp.save(manager);
    }

    @Override
    public Manager getByAccountAndPassword(String account, String password) {
        return managerRepositoryp.getByAccountAndPassword(account,password);
    }
}
