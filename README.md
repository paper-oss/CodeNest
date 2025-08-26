# HybridRetrieval 文章推荐模块

该模块是 **文章推荐系统** 的核心部分，基于 **语义向量 + 关键词检索** 构建高效推荐机制。  
本仓库只包含文章推荐相关的实现，完整项目可参考主项目仓库：[主项目地址](https://github.com/xxx/xxx)。

---

## 📖 功能介绍
- **语义检索**：基于 [SentenceTransformer](https://www.sbert.net/) 将文章内容生成语义向量。  
- **向量索引**：使用 [Qdrant](https://qdrant.tech/) 构建向量索引，实现高效相似度查询。  
- **关键词检索**：结合 Elasticsearch 提供关键词搜索能力。  
- **Hybrid Retrieval**：融合语义相似度和关键词匹配，实现精准文章推荐。  

---

## 🛠️ 技术栈
- **Java 8**
- **Spring Boot 2.7**
- **SentenceTransformer**（Python 依赖，可通过 REST API 调用）  
- **Qdrant**（向量数据库）
- **Elasticsearch**（关键词检索）
- **Maven**（项目管理与依赖）


