package net.sgl.simplemanageoa.services;

import net.sgl.simplemanageoa.entites.Manager;

public interface ManagerService {

    Manager save(Manager manager);

    Manager getByAccountAndPassword(String account, String password);
}
