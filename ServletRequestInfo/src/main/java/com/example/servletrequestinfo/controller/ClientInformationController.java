package com.example.servletrequestinfo.controller;


import com.example.servletrequestinfo.ClientInfo;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/info")
@Scope("prototype")
public class ClientInformationController {
    private final HttpServletRequest request;
    private final ClientInfo clientInfo;

    public ClientInformationController(HttpServletRequest request, ClientInfo clientInfo) {
        this.request = request;
        this.clientInfo = clientInfo;
    }

    @GetMapping("/client")
    public ClientInfo getClientInfo() {
        return clientInfo.setLocalAddress(request.getLocalAddr())
                .setRemoteAdress(request.getRemoteAddr())
                .setRemoteHost(request.getRemoteHost())
                .setLocalPort(request.getLocalPort())
                .setRemotePort(request.getRemotePort());
    }

}
