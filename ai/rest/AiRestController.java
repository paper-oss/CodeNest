package com.github.codenest.forum.web.front.ai.rest;


import com.github.codenest.forum.service.ai.service.AiDoubaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping(path = "/ai/api")
public class AiRestController {
    @Autowired
    private AiDoubaoService doubaoService;

    @PostMapping("/ask")
    public ResponseEntity<String> ask(@RequestBody Map<String, String> body) {
        String question = body.get("question");
        String answer = doubaoService.chat(question);
        return ResponseEntity.ok(answer);
    }
}
