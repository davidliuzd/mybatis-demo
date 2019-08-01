#### [申城异乡人-MyBatis从入门到精通(五)：MyBatis 注解方式的基本用法](http://www.zwwhnly.com/mybatis/2019/07/04/mybatis-study-05.html)
#### [再见乱码：5分钟读懂MySQL字符集设置](https://www.cnblogs.com/chyingp/p/mysql-character-set-collation.html)
#### [彻底解决mybatis 插入数据中文后显示问号(?)的问题](https://blog.csdn.net/l1509214729/article/details/80781740)
#### [启动数据库设置初始密码](https://github.com/jaywcjlove/mysql-tutorial/blob/master/chapter2/2.3.md)


### 注意事项
#### 1. mybatis版本3.5.1使用注解时，不需要指定@Results（指定后获取不到对象属性值）,直接使用@Select即可。

#### 2. 乱码问题（update时数据库为乱码）

##### 2.1 数据库编码
```
Database charset   > utf8
Database collation > utf8_general_ci
``` 
##### 2.2 数据库连接url
```
jdbc.url=jdbc:mysql://localhost:3306/xxxx?useUnicode=true&characterEncoding=UTF-8  
``` 


#### 3. [设置Mysql数据字符集](https://blog.csdn.net/l1509214729/article/details/80781740)

##### 3.1 设置环境到mysql（电脑-属性-环境变量-path-加分号加mysql\bin）
![](img\set-path-to-mysql-bin.png)

##### 3.2 查看mysql字符集（注意：database）

```
SHOW VARIABLES LIKE '%character%'; 
```
![](img\show-mysql-charset.png)

##### 3.2 查看mysql字符集（注意：database）
```
SHOW VARIABLES LIKE '%character%';  

-- 查看支持字符集
SHOW CHARACTER SET;

-- 支持的字符序
SHOW COLLATION;

-- 查看server字符集、字符序
SHOW VARIABLES LIKE "character_set_server";
SHOW VARIABLES LIKE "collation_server";

-- 查看table的字符集/字符序
SHOW TABLE STATUS FROM mybatis_action_db;

-- 查看column的字符集/字符序
SELECT CHARACTER_SET_NAME, COLLATION_NAME FROM information_schema.COLUMNS WHERE TABLE_SCHEMA="mybatis_action_db" AND TABLE_NAME="sys_role" AND COLUMN_NAME="role_name";  
```

#### 3.3 注册Mysql服务
##### 3.3.1  [MySQL服务无法启动—系统错误1067](https://blog.csdn.net/xiao714041/article/details/79101263)

```
输入：net stop mysql、net start mysql时，总是提示：服务名无效
管理员命令启动cmd,转到Mysql\bin目录，运行命令：mysqld --install
再次启动：net start mysql后报无法启动，1067错误，参照3.3.1，执行：mysqladmin -u root -p shutdown解决。
```






