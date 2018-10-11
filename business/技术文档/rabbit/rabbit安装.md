---
date: 2017-10-25 08:44
status: public
title: rabbit安装-redhat6.5
---

[springboot整合RabbitMQ.pdf](/新农险技术文档/rabbit/_attachment/rabbit安装/springboot整合RabbitMQ.pdf)# 1 安装环境
## 1.1 操作系统
RedHat6.5
## 1.2 yum源配置
配置yum源（略）
## 1.3 安装依赖文件
```
[root@localhost yum.repos.d]# yum install gcc glibc-devel make ncurses-devel openssl-devel xmlto
``` 
 
## 1.3 Erlang安装配置
RabbitMQ是基于Erlang的，所以首先必须配置Erlang环境
下载：[otp_src_20.1.tar.gz](http://www.erlang.org/download/otp_src_20.1.tar.gz)
1）新建文件路径
```
[root@localhost src]# cd /usr/local/src
[root@localhost src]# mkdir erlang
[root@localhost src]# cd erlang/
```
2）上传安装包otp_src_20.1.tar.gz到 /usr/local/src/erlang/下
3）解压
```
[root@localhost erlang]# tar -xvf otp_src_20.1.tar.gz
[root@localhost erlang]# cd otp_src_20.1 
```
4）配置安装路径编译代码
```
[root@localhost otp_src_20.1]# ./configure --prefix=/opt/erlang
```
5）执行编译结果
```
[root@localhost otp_src_20.1]# make && make install   
```
6）验证
```
[root@localhost bin]# cd /opt/erlang/bin
[root@localhost bin]# ./erl
```
出现以下信息,代表安装完成：
```
Erlang/OTP 20 [erts-9.1] [source] [64-bit] [smp:1:1] [ds:1:1:10] [async-threads:10] [hipe] [kernel-poll:false]

Eshell V9.1  (abort with ^G)
1> 
```
7）修改环境变量
```
[root@localhost bin]# vi /etc/profile
```
在最后面加上
```
#set erlang environment
export PATH=$PATH:/opt/erlang/bin
```
使配置生效
```
[root@localhost /]# source /etc/profile
```
# 2 RabbitMQ-server 安装和配置
1）下载：http://www.rabbitmq.com/releases/rabbitmq-server/v3.6.12/
我下载的版本为：rabbitmq-server-generic-unix-3.6.12.tar.xz
2） 进入`/opt`
```
[root@localhost bin]# cd /opt/
```
3）上传rabbitmq-server-generic-unix-3.6.12.tar.xz文件到`/opt/`
4）解压：
```
[root@localhost opt]# xz -d rabbitmq-server-generic-unix-3.6.12.tar.xz 
[root@localhost opt]# tar -xvf rabbitmq-server-generic-unix-3.6.12.tar 
```
5）修改名称
```
[root@localhost opt]# mv rabbitmq_server-3.6.12 rabbitmq
```
6) 修改环境变量
```
[root@localhost opt]# vi /etc/profile
```
在文件最后新增：
```
#set rabbitmq environment
export PATH=$PATH:/opt/rabbitmq/sbin
```
是配置生效
```
[root@localhost opt]# source /etc/profile
```
7）启动服务
```
[root@localhost opt]# rabbitmq-server -detached
```
8）配置网页插件
新建文件夹（不建文件夹可能会报错）
```
[root@localhost opt]# mkdir /etc/rabbitmq
```
然后启用插件：
```
[root@localhost opt]# rabbitmq-plugins enable rabbitmq_management
```
9）关闭防火墙
```
[root@localhost opt]# service iptables stop
[root@localhost opt]# chkconfig iptables off
```
10）验证
配置linux 端口 15672 网页管理  5672 AMQP端口
然后访问http://localhost:15672即可 
默认用户guest 密码guest

# 3 远程访问配置
默认网页是不允许访问的，需要增加一个用户修改一下权限，代码如下：
- 添加用户:
```
[root@localhost opt]# rabbitmqctl add_user rabbit rabbit
```
- 添加权限:
```
[root@localhost opt]# rabbitmqctl set_permissions -p "/" rabbit ".*" ".*" ".*"
```
- 修改用户角色:
```
[root@localhost opt]# rabbitmqctl set_user_tags rabbit administrator
```

# 4 rabbitmq常用命令
```
add_user        <UserName> <Password>
delete_user    <UserName>
change_password <UserName> <NewPassword>
list_users
add_vhost    <VHostPath>
delete_vhost <VHostPath>
list_vhostsset_permissions  [-p <VHostPath>] <UserName> <Regexp> <Regexp> <Regexp>
clear_permissions [-p <VHostPath>] <UserName>
list_permissions  [-p <VHostPath>]
list_user_permissions <UserName>
list_queues    [-p <VHostPath>] [<QueueInfoItem> ...]
list_exchanges [-p <VHostPath>] [<ExchangeInfoItem> ...]
list_bindings  [-p <VHostPath>]
list_connections [<ConnectionInfoItem> ...]
```