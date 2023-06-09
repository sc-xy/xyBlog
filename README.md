### SpringBoot个人博客搭建

话不多说先给源码：[sc-xy/xyBlog: 基于SpringBoot框架开发的前后端分离的个人博客项目 (github.com)](https://github.com/sc-xy/xyBlog) 

博客主页：[某洋の博客 (sc-xy.top)](http://springblog.sc-xy.top/) ~详细的~搭建思路会在博客中给出

开始运行
1. 数据库运行`xyblog.sql`创建数据库~记得在user表中添加管理员用户~
2. 修改`application.yml`中的配置文件，切换项目为`dev`(开发)
3. 修改`application-dev.yml` `application-pro.yml`中的数据库地址，用户，密码
4. 运行`XyBlogApplication`测试项目是否正常工作
5. 打包后`java -jar *.jar`

## 一、 技术栈

|   工具   |           选择           |
| :------: | :----------------------: |
| 开发工具 |      IDEA 2022.3.1       |
| 项目框架 | SpringBoot 2.3.4.RELEASE |
|   语言   |   java8、Html、css、js   |
| 模板引擎 |        Thymeleaf         |
|  数据库  |          Mysql           |
|   ORM    |         Mybatis          |
| 项目管理 |          Maven           |
| 前端框架 |       Semantic Ui        |

## 二、前端页面

基于[Semantic Ui](https://semantic-ui.com/)前端框架和[Thymeleaf](https://www.thymeleaf.org/)模板引擎进行前端页面渲染

1. Semantic Ui提供的组件和模板相当好用，对于前端小白十分友好
2. Thymeleaf模板引擎框架是SpringBoot官方推荐的前端模板引擎，几乎可以完全取代Jsp，对于交互操作相当友好

## 三、Mysql数据库搭建

主要有 `blog` `type` `comment` `friend` `message` `user`等表格，整个搭建过程并不复杂

## 四、Idea环境搭建

采用Maven进行包管理，加之SpringBoot官方已经封装了不少依赖包，添加第三方依赖只需要保证依赖不冲突即可

![](https://gcore.jsdelivr.net/gh/sc-xy/Blogimg@main/img/20230315234343.png)

## 五、后台管理界面

### 1.1 后台登陆

对用户名密码进行校验，对管理员路径进行拦截，虽然本项目主要考虑的是单人博客，但是仍旧可以改进为多用户发布博客（战未来！）

![](https://gcore.jsdelivr.net/gh/sc-xy/Blogimg@main/img/20230315234440.png)

### 1.2 博客管理

实现了对博客的增删查改等基础功能，支持全局查询、关键字模糊查询、博客分页展示和多条件查询

![](https://gcore.jsdelivr.net/gh/sc-xy/Blogimg@main/img/20230315234529.png)

### 1.3 分类管理

实现了对分类的增删改等基础功能，同时保证不会删除仍旧博客属于的类别

![](https://gcore.jsdelivr.net/gh/sc-xy/Blogimg@main/img/20230315234618.png)

### 1.4 友链管理

实现了对友链的增删改等基础功能

![](https://gcore.jsdelivr.net/gh/sc-xy/Blogimg@main/img/20230315234640.png)

## 六、前端页面展示

### 1.1 前端首页

支持对博客的分页查询，全局查询，能够推送推荐博客以及支持博客名称模糊查询，在允许评论的博客下用户输入自己的QQ号即可评论（通过调用api抓取用户的昵称和头像），主要难点是评论的回复功能实现以及楼中楼显示

![](https://gcore.jsdelivr.net/gh/sc-xy/Blogimg@main/img/20230315234744.png)

### 1.2 分类展示

实现了指定分类查询

![](https://gcore.jsdelivr.net/gh/sc-xy/Blogimg@main/img/20230315234836.png)

### 1.3 时间轴展示

实现对博客进行全局查询并根据更新时间进行排序

![](https://gcore.jsdelivr.net/gh/sc-xy/Blogimg@main/img/20230315234903.png)

### 1.4 留言板展示

实现对留言进行全局查询和楼中楼展示

![](https://gcore.jsdelivr.net/gh/sc-xy/Blogimg@main/img/20230315234935.png)

### 1.5 友链展示

实现了对友链进行全局查询

![](https://gcore.jsdelivr.net/gh/sc-xy/Blogimg@main/img/20230315235001.png)

### 1.6 关于页面

关于作者（静态展示）

![](https://gcore.jsdelivr.net/gh/sc-xy/Blogimg@main/img/20230315235023.png)

## 七、项目部署

进行项目构建并部署到服务器上（我采用的是ubuntu 20.04）