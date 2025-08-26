package com.github.codenest.forum.web.front.ai.rest;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.codenest.forum.service.article.service.ArticleRecommendService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.Map;


@Slf4j
@RestController
@RequestMapping(path = "/recommend/api")
public class ArticleRecommendRestController {

    // @Autowired
    // private ArticleService articleService; // 你需要实现这个服务，从ID获取文章内容
    @Autowired
    ArticleRecommendService articleRecommendService;

    @GetMapping("/article")
    public ResponseEntity<List<Long>> recommend(@RequestParam("article_id") String content) throws IOException {
        // 根据文章内容查找相似文章
        // String articleText = articleService.getArticleContentById(articleId);
        if (content == null) {
            return ResponseEntity.badRequest().build();
        }
//        if (articleText == null || articleText.isEmpty()) {
//            return ResponseEntity.badRequest().build();
//        }
        try {
            List<Long> result = articleRecommendService.relatedRecommend(content);

            return ResponseEntity.ok(result);
        } catch (IOException e) {
            log.info(" 调用失败");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
