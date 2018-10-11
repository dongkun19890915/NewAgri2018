---
date: 2017-10-25 10:22
status: public
title: redhat系统yum源配置
---

# 1 本地yum源配置
## 1.1 虚拟机挂在yum源
1） 配置本地光盘
虚拟机(virtual machine) --> 设置(settings) --> CD/DVD(IDE)
2）然后再把光盘挂载到/media目录当中
```
[root@localhost /]# mount -r /dev/sr0 /media
```
3）接着就是要编辑yum的配置文件
```
[root@localhost /]# cd /etc/yum.repos.d/
[root@localhost /]# rm -rf *
[root@localhost /]# vi Meida.repo
```
在Meida.repo配置文件中新增以下内容：
```
[Media]
name=Media - /media
baseurl=file:///media
enabled=1
gpgcheck=0
gpgkey=file:///media/RPM-GPG-KEY-redhat-release
```
参数说明：
- `[Media]`：这是yum源的容器的名称,中括号内可以随便写任意字符串
- `name=Media - /media`：这是对容器的说明,也是可以随便写
- `baseurl=file:///media`：容器地址,本地光盘采用file://这种协议
- `enabled=1`：是否启用这个yum源
- `gpgcheck=1`：是否进行验证来源合法性
- `gpgkey=file:///media/RPM-GPG-KEY-redhat-release`：验证公钥的位置 