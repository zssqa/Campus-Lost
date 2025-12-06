# 校园失物招领平台 (Campus Lost & Found)

## 项目简介

这是一个基于Spring Boot开发的校园失物招领平台，实现了用户注册登录、失物/拾到信息发布、信息检索、分类筛选等核心功能。项目提供了美观的图形化Web界面和RESTful API接口两种使用方式，方便用户通过浏览器或移动端应用进行交互。

本项目采用现代化的前后端分离架构设计，前端使用Bootstrap 5框架实现响应式布局，后端基于Spring Boot生态系统构建，具有良好的可扩展性和维护性。

## 技术栈

- Spring Boot 3.5.8
- Spring Security
- Spring Web MVC
- MyBatis 3.0.5
- MySQL
- Lombok
- Thymeleaf (模板引擎)
- Bootstrap 5
- HTML5/CSS3/JavaScript

## 功能特性

### 用户管理
1. 用户注册与登录
2. 用户会话管理

### 信息发布
1. 失物信息发布
2. 拾到信息发布
3. 信息分类管理（证件、电子产品、钥匙、书籍、衣物、其他）
4. 信息标签管理
5. 发生时间与地点记录
6. 匿名发布选项

### 信息展示
1. 失物/拾到信息列表展示
2. 信息详情查看
3. 分类筛选功能
4. 类型筛选功能
5. 响应式卡片布局

### 系统特性
1. 响应式Web界面设计
2. RESTful API接口
3. 数据持久化存储
4. 完整的异常处理机制
5. 美观的UI界面和交互动效
6. 支持暗黑模式

## 快速开始

### 环境要求

- JDK 17或更高版本
- MySQL 8.0或更高版本
- Maven 3.6或更高版本
- 推荐使用IntelliJ IDEA作为开发环境

> 注意：开发环境建议使用JDK 17，MySQL 8.0+，确保Maven能够正常下载依赖。

### 数据库配置

1. 创建数据库：
```sql
CREATE DATABASE campus_lost CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

2. 在`application.properties`中配置数据库连接信息：
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/campus_lost?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai
spring.datasource.username=root
spring.datasource.password=root
```

3. 数据库表结构可通过执行`src/main/resources/db/init.sql`脚本创建，该脚本包含了所有必要的表结构和初始数据

> 注意：数据库连接信息可根据实际环境进行调整，确保数据库服务已启动并可访问。

### 启动项目

#### 方法一：使用Maven命令行启动（推荐）

1. 打开终端或命令提示符
2. 进入项目根目录
3. 执行以下命令：
```bash
mvn spring-boot:run
```

#### 方法二：在IDE中直接运行

1. 使用IntelliJ IDEA等IDE打开项目
2. 找到`src/main/java/edu/sias/CampusLostApplication.java`文件
3. 右键点击文件，选择"Run CampusLostApplication"

#### 方法三：打包成jar包运行

1. 在项目根目录执行以下命令打包：
```bash
mvn clean package
```

2. 进入target目录，执行以下命令运行：
```bash
java -jar Campus-Lost-0.0.1-SNAPSHOT.jar
```

> 提示：首次运行时，Maven会自动下载所有依赖项，请确保网络连接正常。

### 验证启动成功

1. 当控制台输出类似以下信息时表示启动成功：
```
Started CampusLostApplication in X.XXX seconds
Tomcat started on port(s): 8080 (http)
```

2. 通过以下方式访问系统：

#### 方式一：图形化Web界面（推荐）
打开浏览器访问：http://localhost:8080

Web界面包含以下页面：
- 首页：http://localhost:8080/
- 登录页面：http://localhost:8080/login
- 注册页面：http://localhost:8080/register
- 失物招领信息列表：http://localhost:8080/posts
- 发布信息页面：http://localhost:8080/post/create

> 默认测试账户：
> - 管理员账户：admin/123456
> - 普通用户：user1/user123

#### 方式二：RESTful API接口
使用API测试工具（如Postman、curl等）访问以下API接口：
- 用户注册: POST http://localhost:8080/api/auth/register
- 用户登录: POST http://localhost:8080/api/auth/login
- 获取公开信息列表: GET http://localhost:8080/api/public/posts
- 获取信息详情: GET http://localhost:8080/api/public/posts/{id}
- 获取分类列表: GET http://localhost:8080/api/public/categories
- 用户发布信息: POST http://localhost:8080/api/user/posts

> API接口采用JSON格式进行数据交换，请求和响应均使用UTF-8编码。

### 常见问题解决

1. **端口被占用**：默认端口为8080，如需更改，在`application.properties`中添加：
```properties
server.port=8081
```

2. **数据库连接失败**：检查数据库是否启动，用户名密码是否正确

3. **依赖下载失败**：检查网络连接或更换Maven镜像源

4. **页面显示异常**：确保浏览器支持JavaScript和CSS3，并已正确加载静态资源

5. **中文乱码问题**：确保数据库和应用程序使用UTF-8编码

6. **静态资源加载失败**：检查网络连接，确保CDN资源可访问或替换为本地资源

## API接口说明

### 公共接口（无需认证）

- `GET /api/public/posts` - 获取已发布的失物/拾到信息列表
- `GET /api/public/posts/{id}` - 获取信息详情
- `GET /api/public/categories` - 获取分类列表

### 认证接口

- `POST /api/auth/register` - 用户注册
- `POST /api/auth/login` - 用户登录

### 用户接口（需要认证）

- `POST /api/user/posts` - 发布信息

> 注意：当前版本为简化版，实际使用中应实现完整的JWT认证机制或Session认证机制。
>
> API响应格式统一为：{"code": 200, "message": "success", "data": {}}，其中code为状态码，message为消息，data为返回数据。

## 项目结构

```
src/main/java/edu/sias
├── CampusLostApplication.java  # 启动类
├── common/                     # 通用类
│   └── ResponseResult.java     # 统一响应结果封装
├── config/                     # 配置类
│   └── SecurityConfig.java     # Spring Security配置
├── controller/                 # 控制器
│   ├── AuthController.java     # 认证相关接口
│   ├── CategoryController.java # 分类相关接口
│   ├── HomeController.java     # 页面路由控制器
│   └── PostController.java     # 信息相关接口
├── dto/                        # 数据传输对象
│   ├── PostCreateDTO.java      # 信息发布数据传输对象
│   ├── UserLoginDTO.java       # 用户登录数据传输对象
│   └── UserRegisterDTO.java    # 用户注册数据传输对象
├── entity/                     # 实体类
│   ├── Category.java           # 分类实体
│   ├── Comment.java            # 评论实体
│   ├── Message.java            # 站内信实体
│   ├── Post.java               # 信息实体
│   ├── PostImage.java          # 信息图片实体
│   ├── Report.java             # 举报实体
│   └── User.java               # 用户实体
├── mapper/                     # MyBatis Mapper接口
│   ├── CategoryMapper.java     # 分类Mapper
│   ├── PostMapper.java         # 信息Mapper
│   └── UserMapper.java         # 用户Mapper
├── service/                    # 服务接口及实现
│   ├── CategoryService.java    # 分类服务接口
│   ├── PostService.java        # 信息服务接口
│   ├── UserService.java        # 用户服务接口
│   └── impl/                   # 服务实现类
│       ├── CategoryServiceImpl.java
│       ├── PostServiceImpl.java
│       └── UserServiceImpl.java
└── resources/
    ├── templates/              # Thymeleaf模板文件
    ├── static/                 # 静态资源文件(css,js,images)
    │   └── css/
    │       └── style.css       # 自定义样式文件
    ├── db/                     # 数据库脚本
    │   └── init.sql            # 数据库初始化脚本
    └── application.properties  # 配置文件
```

## 开发说明

1. 项目采用MVC架构模式，控制器层负责处理HTTP请求，业务逻辑在服务层实现，数据访问通过Mapper接口完成。
2. 前端页面使用Thymeleaf模板引擎渲染，静态资源存放在static目录下。
3. 数据库操作使用MyBatis框架，通过Mapper接口和XML映射文件实现。
4. 统一响应格式封装在ResponseResult类中，便于前后端数据交互。
5. 安全配置通过Spring Security实现，当前为简化版本。