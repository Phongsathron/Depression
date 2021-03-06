package com.depression.resourceserv.resourceserv.controller;

import com.depression.resourceserv.resourceserv.model.AuthenticationClient;
import com.depression.resourceserv.resourceserv.services.ClientRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/client")
public class ClientControl {

    @Autowired
    private ClientRequestService clientRequestService;

    @RequestMapping(value="/register", method=RequestMethod.POST)
    public AuthenticationClient register(
            @RequestParam(value="name") String name,
            @RequestParam(value="email") String email,
            @RequestParam(value="homepageUrl") String homepageUrl,
            @RequestParam(value="description") String description,
            @RequestParam(value="redirectUrl") String redirectUrl){

        AuthenticationClient client = new AuthenticationClient();
        client.setName(name);
        client.setEmail(email);
        client.setHomepageUrl(homepageUrl);
        client.setDescription(description);

        return clientRequestService.addClient(client, redirectUrl);
    }
}
