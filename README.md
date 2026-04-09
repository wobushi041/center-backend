# center-backend

用户管理系统后端，基于 Spring Boot + MyBatis-Plus 实现，提供用户注册、登录、注销、查询、删除等基础能力，并集成 Knife4j 接口文档。

## 1. 技术栈

- Java 8
- Spring Boot 2.6.13
- MyBatis-Plus 3.5.2
- MySQL
- Maven
- Knife4j 

## 2. 项目结构

```text
center-backend
├─ src/main/java
│  ├─ org/wobushi041/centerbackend
│  │  ├─ config            # 配置（CORS、Knife4j 等）
│  │  ├─ controller        # 控制器
│  │  ├─ mapper            # Mapper 接口
│  │  ├─ model             # 实体与请求对象
│  │  ├─ common/exception  # 通用响应与异常处理
│  │  └─ constant          # 常量
│  └─ service              # 业务接口与实现
├─ src/main/resources
│  ├─ application.yml      # 应用配置
│  └─ mapper               # MyBatis XML
└─ pom.xml
```

## 3. 环境要求

- JDK: `1.8`
- Maven: `3.6+`
- MySQL: `5.7+`（建议 `8.x`）

## 4. 快速启动

### 4.1 克隆并进入项目

```powershell
git clone <https://github.com/wobushi041/center-backend.git>
cd center-backend
```

### 4.2 配置数据库

默认配置在 `src/main/resources/application.yml`：

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/center-backend
    username: 
    password:
```

请按本地环境修改数据库连接信息，并提前创建数据库（如：`center-backend`）。

### 4.3 启动服务

```powershell
mvn spring-boot:run
```

启动成功后默认访问地址：

- 服务根路径：`http://localhost:8080/api`
- 接口文档（Knife4j）：`http://localhost:8080/api/doc.html`
- OpenAPI 文档：`http://localhost:8080/api/v3/api-docs`

## 5. 打包与运行

### 5.1 打包

```powershell
mvn clean package
```

### 5.2 运行 jar

```powershell
java -jar target/center-backend-0.0.1-SNAPSHOT.jar
```

## 6. 常见问题

- 连接数据库失败：检查 MySQL 是否启动、账号密码是否正确、数据库名是否存在。
- 文档页面无法访问：确认服务已启动，且访问地址带上上下文路径 `/api`。
- 登录态丢失：前端请求需携带 Cookie（跨域时需正确配置 `withCredentials` 与 CORS）。



