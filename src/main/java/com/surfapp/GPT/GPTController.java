package com.surfapp.GPT;



import com.surfapp.event.Event;
import com.surfapp.event.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GPTController {


    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    @PostMapping(
            path = "api/gpt",
            consumes = "application/json; charset=utf-8"
    ) public ChatElement getAnswer(@RequestBody ChatElement chatElement){
        String answer = ChatGPT.gptMethod(chatElement.getContent());
        System.out.println("GPT answer:" + answer);
        return new ChatElement(answer);
    }








}
