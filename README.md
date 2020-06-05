## 论坛项目

## 快速运行

1. 安装必备工具  
   JDK，Maven，IDEA
2. 克隆代码到本地  
3. 运行命令创建数据库脚本

```sh
mvn flyway:migrate
```

4. 运行打包命令

```sh
mvn package
```

5. 运行项目  

```sh
java -jar target/community-0.0.1-SNAPSHOT.jar
```

6. 访问项目

```
http://localhost:8080
```


## 资料

[Spring 文档](https://spring.io/guides)    
[Spring Web](https://spring.io/guides/gs/serving-web-content/)   
[es](https://elasticsearch.cn/explore)    
[Github deploy key](https://developer.github.com/v3/guides/managing-deploy-keys/#deploy-keys)    
[Bootstrap](https://v3.bootcss.com/getting-started/)    
[Github OAuth](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)    
[Spring](https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#boot-features-embedded-database-support)    
[菜鸟教程](https://www.runoob.com/mysql/mysql-insert-query.html)    
[Thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#setting-attribute-values)    
[Spring Dev Tool](https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#using-boot-devtools)  
[Spring MVC](https://docs.spring.io/spring/docs/5.0.3.RELEASE/spring-framework-reference/web.html#mvc-handlermapping-interceptor)  
[Markdown 插件](http://editor.md.ipandao.com/)   
[UFfile SDK](https://github.com/ucloud/ufile-sdk-java)  
[Count(*) VS Count(1)](https://mp.weixin.qq.com/s/Rwpke4BHu7Fz7KOpE2d3Lw)  

## 工具

[Git](https://git-scm.com/download)   
[Visual Paradigm](https://www.visual-paradigm.com)    
[Flyway](https://flywaydb.org/getstarted/firststeps/maven)  
[Lombok](https://www.projectlombok.org)    
[ctotree](https://www.octotree.io/)   
[Table of content sidebar](https://chrome.google.com/webstore/detail/table-of-contents-sidebar/ohohkfheangmbedkgechjkmbepeikkej)    
[One Tab](https://chrome.google.com/webstore/detail/chphlpgkkbolifaimnlloiipkdnihall)    
[Live Reload](https://chrome.google.com/webstore/detail/livereload/jnihajbhpnppcggbcgedagnkighmdlei/related)  
[Postman](https://chrome.google.com/webstore/detail/coohjcphdfgbiolnekdpbcijmhambjff)

## 脚本

```sql
/*
Navicat MySQL Data Transfer

Source Server         : limingyang
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : css_rbac

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2020-06-05 20:22:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_course
-- ----------------------------
DROP TABLE IF EXISTS `tb_course`;
CREATE TABLE `tb_course` (
  `id` bigint(20) NOT NULL COMMENT '课程号',
  `course_name` varchar(20) NOT NULL COMMENT '课程名称',
  `coursec_redit` float NOT NULL COMMENT '学分',
  `coursec_time` smallint(6) NOT NULL COMMENT '学时',
  `course_desc` text NOT NULL COMMENT '课程描述',
  `course_address` varchar(50) DEFAULT NULL COMMENT '上课地点',
  `course_volume` int(6) NOT NULL COMMENT '容量 人数',
  `teacher_num` bigint(20) NOT NULL COMMENT '教师工号',
  `view_count` int(10) DEFAULT NULL COMMENT '访问数',
  `start_time` datetime NOT NULL COMMENT '开课时间',
  `end_time` datetime NOT NULL COMMENT '结束时间时间',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程信息表';

-- ----------------------------
-- Records of tb_course
-- ----------------------------

-- ----------------------------
-- Table structure for tb_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_permission`;
CREATE TABLE `tb_permission` (
  `id` int(11) NOT NULL COMMENT 'id',
  `parent_id` int(11) DEFAULT '0' COMMENT '父id',
  `name` varchar(50) NOT NULL COMMENT '名称',
  `css` varchar(30) DEFAULT NULL COMMENT '样式',
  `href` varchar(1000) DEFAULT NULL COMMENT '跳转地址',
  `type` tinyint(4) NOT NULL COMMENT '类型',
  `permission` varchar(50) NOT NULL COMMENT '权限',
  `sort` int(11) NOT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_permission
-- ----------------------------

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `id` int(11) NOT NULL COMMENT 'id',
  `name` varchar(50) NOT NULL COMMENT '角色名称',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表表';

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES ('1', '超级管理员', '最高权利', '2020-06-05 15:50:16', '2020-06-05 15:50:18');
INSERT INTO `tb_role` VALUES ('2', '普通管理员', '一人之下', '2020-06-05 15:51:17', '2020-06-05 15:51:19');
INSERT INTO `tb_role` VALUES ('3', '老师', '部分权限', '2020-06-05 15:51:57', '2020-06-05 15:51:59');
INSERT INTO `tb_role` VALUES ('4', '学生', '被管理', '2020-06-05 15:52:22', '2020-06-05 15:52:24');

-- ----------------------------
-- Table structure for tb_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_permission`;
CREATE TABLE `tb_role_permission` (
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `permission_id` int(11) NOT NULL COMMENT '权限id',
  KEY `permission_id` (`permission_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `tb_role_permission_ibfk_1` FOREIGN KEY (`permission_id`) REFERENCES `tb_permission` (`id`),
  CONSTRAINT `tb_role_permission_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限关联表';

-- ----------------------------
-- Records of tb_role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for tb_role_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_user`;
CREATE TABLE `tb_role_user` (
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  KEY `fk_us` (`user_id`),
  KEY `fk_ro` (`role_id`),
  CONSTRAINT `fk_us` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`id`),
  CONSTRAINT `fk_ro` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of tb_role_user
-- ----------------------------
INSERT INTO `tb_role_user` VALUES ('1111111', '1');

-- ----------------------------
-- Table structure for tb_stucourse
-- ----------------------------
DROP TABLE IF EXISTS `tb_stucourse`;
CREATE TABLE `tb_stucourse` (
  `student_num` bigint(20) NOT NULL COMMENT '学号',
  `course_num` bigint(20) NOT NULL COMMENT '课程号',
  `teacher_num` bigint(20) NOT NULL COMMENT '教师工号',
  `grade` smallint(6) DEFAULT NULL COMMENT '成绩',
  KEY `course_num` (`course_num`),
  CONSTRAINT `tb_stucourse_ibfk_1` FOREIGN KEY (`course_num`) REFERENCES `tb_course` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='选课信息表';

-- ----------------------------
-- Records of tb_stucourse
-- ----------------------------

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `username` varchar(60) NOT NULL COMMENT '用户名',
  `password` varchar(60) NOT NULL COMMENT '密码',
  `nickname` varchar(255) NOT NULL COMMENT '别名',
  `avatar_url` varchar(10) DEFAULT NULL COMMENT '头像',
  `phone` varchar(11) DEFAULT NULL COMMENT '电话号码',
  `sex` tinyint(4) NOT NULL COMMENT '性别 0 为女， 1 为男',
  `birthday` datetime DEFAULT NULL COMMENT '出生年月',
  `status` varchar(100) NOT NULL COMMENT '状态',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1111111', '1218lmy', '121891li', '超级管理员', null, '15281890615', '1', '2019-05-08 15:48:44', '1', '2020-06-05 15:48:53', '2020-06-05 15:48:58');

```

```bash
mvn flyway:migrate
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
```

## 更新日志

