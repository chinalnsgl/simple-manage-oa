package net.sgl.simplemanageoa.controller;

import lombok.extern.slf4j.Slf4j;
import net.sgl.simplemanageoa.bean.BaseResponse;
import net.sgl.simplemanageoa.entites.Manager;
import net.sgl.simplemanageoa.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Slf4j
public class LoginController {

    @Autowired
    private ManagerService managerService;

    @GetMapping("/login")
    public BaseResponse<Manager> login(String account, String password) {
        log.info("account : {} , password : {}", account, password);
        for (int i = 0; i < 10; i++) {
            password = DigestUtils.md5DigestAsHex(password.getBytes());
        }
        Manager manager = managerService.getByAccountAndPassword(account,password);
        BaseResponse<Manager> baseResponse = new BaseResponse<>();
        if (manager == null) {
            baseResponse.setCode(404);
            baseResponse.setMsg("no body");
            return baseResponse;
        }
        baseResponse.setData(manager);
        return baseResponse;
    }
}
