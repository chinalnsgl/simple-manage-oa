package net.sgl.simplemanageoa.repository;

import net.sgl.simplemanageoa.entites.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

    Manager getByAccountAndPassword(String account, String password);
}
