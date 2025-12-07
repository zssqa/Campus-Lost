# 校园失物招领平台 (Campus Lost & Found)

## 项目简介

这是一个基于Spring Boot开发的校园失物招领平台，实现了用户注册登录、失物/拾到信息发布、信息检索、分类筛选、信息审核等核心功能。项目提供了美观的图形化Web界面和RESTful API接口两种使用方式，方便用户通过浏览器或移动端应用进行交互。

本项目采用现代化的前后端分离架构设计，前端使用Bootstrap 5框架实现响应式布局，后端基于Spring Boot生态系统构建，具有良好的可扩展性和维护性。平台支持信息分类管理、匿名发布、信息审核机制等功能，为校园用户提供便捷的失物招领服务。

## 项目特点

- **双重访问方式**：提供Web界面和RESTful API两种访问方式
- **响应式设计**：适配各种设备屏幕尺寸
- **信息分类管理**：支持多种物品分类（证件、电子产品、钥匙等）
- **审核机制**：信息需经过管理员审核后才可公开显示
- **安全机制**：用户密码明文存储，权限控制
- **暗黑模式支持**：根据系统偏好自动切换主题

## 技术栈

### 后端技术
- Spring Boot 3.5.8 - 快速开发框架
- Spring Security - 安全框架
- Spring Web MVC - Web框架
- MyBatis 3.0.5 - ORM框架
- MySQL - 关系型数据库
- Lombok - 简化Java代码工具

### 前端技术
- Thymeleaf 3.1.0 - 模板引擎
- Bootstrap 5 - CSS框架
- HTML5/CSS3 - 页面结构和样式
- JavaScript - 前端交互

### 开发工具
- Maven 3.6+ - 项目构建工具
- JDK 17+ - Java开发环境

## 功能特性

### 用户管理
1. 用户注册与登录
2. 用户会话管理
3. 用户密码明文存储
4. 用户状态管理（启用/禁用）

### 信息发布
1. 失物信息发布
2. 拾到信息发布
3. 信息分类管理（证件、电子产品、钥匙、书籍、衣物、其他）
4. 信息标签管理
5. 发生时间与地点记录
6. 匿名发布选项
7. 图片上传功能（待完善）

### 信息展示
1. 失物/拾到信息列表展示
2. 信息详情查看
3. 分类筛选功能
4. 类型筛选功能
5. 响应式卡片布局
6. 信息详情弹窗展示

### 信息审核
1. 管理员审核机制
2. 信息状态管理（待审核、已发布、已拒绝、已下架、已解决）
3. 审核原因记录

### 系统特性
1. 响应式Web界面设计
2. RESTful API接口
3. 数据持久化存储
4. 完整的异常处理机制
5. 美观的UI界面和交互动效
6. 支持暗黑模式
7. 统一响应格式封装

## 快速开始

### 环境要求

- JDK 17或更高版本
- MySQL 8.0或更高版本
- Maven 3.6或更高版本
- 推荐使用IntelliJ IDEA作为开发环境

> 注意：开发环境建议使用JDK 17，MySQL 8.0+，确保Maven能够正常下载依赖。

### 环境配置建议

- 设置JAVA_HOME环境变量指向JDK安装目录
- 确保MySQL服务已启动并可访问
- 配置Maven镜像源以提高依赖下载速度
- 使用IntelliJ IDEA时建议安装Lombok插件

### 项目导入

1. 使用IntelliJ IDEA导入项目：
   - 选择`File` → `Open`
   - 选择项目根目录下的`pom.xml`文件
   - 点击`Open as Project`
2. 等待Maven自动下载依赖
3. 配置数据库连接信息（见下节）

### 项目导入注意事项

- 首次导入时Maven会自动下载所有依赖，请确保网络连接正常
- 如果依赖下载失败，可以尝试刷新Maven项目或更换镜像源
- 确保IDEA正确识别了JDK版本
- 检查Lombok插件是否已安装并启用

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

### 数据库配置说明

- 数据库名称：campus_lost
- 字符集：utf8mb4，支持完整的UTF-8字符
- 服务器时区：Asia/Shanghai，确保时间处理正确
- 默认用户名密码：root/root，生产环境请修改为安全密码

### 数据库表结构说明

项目包含以下数据表：

1. `user` - 用户表：存储用户基本信息
2. `category` - 分类表：存储物品分类信息
3. `lost_found_post` - 失物/招领信息表：存储发布的信息
4. `post_image` - 信息图片表：存储信息关联的图片
5. `comment` - 留言表：存储信息评论
6. `message` - 站内信表：存储用户间的消息
7. `report` - 举报表：存储信息举报记录

### 数据库设计原则

- 采用UTF-8字符集确保中文支持
- 使用合适的索引提高查询性能
- 遵循数据库范式设计，减少数据冗余
- 关键字段添加外键约束保证数据一致性
- 时间字段使用Unix时间戳格式便于处理

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

### 首次运行初始化

1. 确保MySQL服务已启动
2. 执行数据库配置步骤创建数据库和表结构
3. 启动项目后，系统会自动插入初始数据，包括：
   - 默认分类数据（证件、电子产品、钥匙等6个分类）
   - 测试用户数据（管理员和普通用户）
   - 示例失物招领信息

### 初始化数据说明

- 管理员账户：admin/123456
- 普通用户账户：user1/user123, user2/user456, user3/user789, user4/user000
- 默认分类：证件、电子产品、钥匙、书籍、衣物、其他
- 示例信息：包含丢失和拾到信息的示例数据

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
- 管理员登录页面：http://localhost:8080/admin/login
- 管理员仪表板：http://localhost:8080/admin

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
- 管理员登录: POST http://localhost:8080/api/admin/login
- 获取待审核信息: GET http://localhost:8080/api/admin/posts/pending

> API接口采用JSON格式进行数据交换，请求和响应均使用UTF-8编码。

### 界面预览

![首页](src/main/resources/static/images/home.png)
![信息列表](src/main/resources/static/images/posts.png)
![发布信息](src/main/resources/static/images/create-post.png)
![管理员界面](src/main/resources/static/images/admin.png)

> 注意：以上截图仅为示意图，实际界面可能有所差异。

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

7. **首次启动无数据**：检查数据库初始化脚本是否正确执行

8. **登录失败**：确认用户是否存在且密码正确（注意：密码为明文存储）

9. **API接口返回404**：检查请求路径是否正确，注意区分用户接口和管理员接口的路径前缀

### 其他常见问题

- **Lombok注解不生效**：检查IDE是否安装并启用了Lombok插件
- **Thymeleaf模板找不到**：检查模板文件路径是否正确
- **MyBatis映射错误**：检查Mapper接口与XML文件是否匹配
- **跨域问题**：在开发环境下可配置CORS解决

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

### 管理员接口（需要认证）

- `POST /api/admin/login` - 管理员登录
- `GET /api/admin/users` - 获取所有用户
- `POST /api/admin/users/{id}/status` - 禁用/启用用户
- `GET /api/admin/posts/pending` - 获取待审核的信息
- `POST /api/admin/posts/{id}/audit` - 审核信息（批准或拒绝）
- `GET /api/admin/posts` - 获取所有信息（用于管理）
- `DELETE /api/admin/posts/{id}` - 删除信息

> 注意：当前版本为简化版，实际使用中应实现完整的JWT认证机制或Session认证机制。
>
> API响应格式统一为：{"code": 200, "message": "success", "data": {}}，其中code为状态码，message为消息，data为返回数据。

## 项目结构

```
src/main/java/edu/sias
├── CampusLostApplication.java    # 启动类
├── common/                       # 通用类
│   └── ResponseResult.java       # 统一响应结果封装
├── config/                       # 配置类
│   ├── GlobalExceptionHandler.java # 全局异常处理器
│   └── SecurityConfig.java       # Spring Security配置
├── controller/                   # 控制器
│   ├── AdminController.java      # 管理员相关接口
│   ├── AuthController.java       # 认证相关接口
│   ├── CategoryController.java   # 分类相关接口
│   ├── HomeController.java       # 页面路由控制器
│   └── PostController.java       # 信息相关接口
├── dto/                          # 数据传输对象
│   ├── PostCreateDTO.java        # 信息发布数据传输对象
│   ├── UserLoginDTO.java         # 用户登录数据传输对象
│   └── UserRegisterDTO.java      # 用户注册数据传输对象
├── entity/                       # 实体类
│   ├── Category.java             # 分类实体
│   ├── Comment.java              # 评论实体
│   ├── Message.java              # 站内信实体
│   ├── Post.java                 # 信息实体
│   ├── PostImage.java            # 信息图片实体
│   ├── Report.java               # 举报实体
│   └── User.java                 # 用户实体
├── mapper/                       # MyBatis Mapper接口
│   ├── CategoryMapper.java       # 分类Mapper
│   ├── PostMapper.java           # 信息Mapper
│   └── UserMapper.java           # 用户Mapper
├── service/                      # 服务接口及实现
│   ├── CategoryService.java      # 分类服务接口
│   ├── PostService.java          # 信息服务接口
│   ├── UserService.java          # 用户服务接口
│   └── impl/                     # 服务实现类
│       ├── CategoryServiceImpl.java
│       ├── PostServiceImpl.java
│       └── UserServiceImpl.java
└── resources/
    ├── templates/                # Thymeleaf模板文件
    │   ├── admin/               # 管理员页面模板
    │   ├── create-post.html     # 发布信息页面
    │   ├── index.html           # 首页
    │   ├── login.html           # 登录页面
    │   ├── posts.html           # 信息列表页面
    │   └── register.html        # 注册页面
    ├── static/                  # 静态资源文件(css,js,images)
    │   ├── css/
    │   │   └── style.css        # 自定义样式文件
    │   ├── images/              # 图片资源
    │   └── js/                  # JavaScript文件
    ├── db/                      # 数据库脚本
    │   └── init.sql             # 数据库初始化脚本
    └── application.properties   # 配置文件
```

### 包结构说明

- `common`：存放通用工具类和公共组件
- `config`：存放系统配置类，如安全配置、异常处理等
- `controller`：存放控制器类，处理HTTP请求
- `dto`：存放数据传输对象，用于接口参数传递
- `entity`：存放实体类，对应数据库表结构
- `mapper`：存放MyBatis Mapper接口，处理数据库操作
- `service`：存放业务逻辑接口及实现类
- `resources`：存放配置文件、静态资源和模板文件

## 开发说明

1. 项目采用MVC架构模式，控制器层负责处理HTTP请求，业务逻辑在服务层实现，数据访问通过Mapper接口完成。
2. 前端页面使用Thymeleaf模板引擎渲染，静态资源存放在static目录下。
3. 数据库操作使用MyBatis框架，通过Mapper接口和XML映射文件实现。
4. 统一响应格式封装在ResponseResult类中，便于前后端数据交互。
5. 安全配置通过Spring Security实现，当前为简化版本。

### 开发规范

- 遵循RESTful API设计原则
- 使用Lombok注解简化实体类代码
- 采用统一的异常处理机制
- 业务逻辑尽量在Service层实现
- 控制器层只负责请求处理和参数校验
- 数据库操作通过Mapper接口完成

## 安全性说明

1. 用户密码采用明文存储，便于开发和测试
2. 生产环境中建议使用BCrypt或其他更强的加密算法
3. 后续可集成JWT或OAuth2实现更完善的认证授权机制
4. 可添加XSS防护和SQL注入防护措施


## 待定功能

1. 文件上传功能（图片上传）
2. 评论功能
3. 站内信功能
4. 举报功能
5. 用户个人中心
6. 数据统计分析

- 添加地理位置定位功能，方便用户标记丢失/拾到物品的位置
- 实现消息推送功能，及时通知用户相关信息状态变更
- 增加搜索功能，支持关键词搜索失物/拾到信息
- 添加收藏功能，用户可以收藏关注的信息
- 实现数据导出功能，方便管理员进行数据分析
