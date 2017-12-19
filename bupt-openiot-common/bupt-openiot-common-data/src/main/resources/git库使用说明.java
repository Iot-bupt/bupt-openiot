阿里云上自定的git库：/home/git/repositories目录
设置git密码：/etc/passwd文件
设置连接用户的rsa公钥：将生成的ssh公钥放入/home/git/.ssh/authorized_keys文件中。
添加用户：adduser 用户名  密码：duanyue

初始化一个git远端仓库：在/home/git/repositories目录中新建一个库文件夹，然后使用git init --bare命令初始化一个仓库
注意，在阿里云上创建的远端库需要注意所有文件均需要设置为git用户组。chown git:git /wen
不然使用命令：git push -u origin master将本地仓库push到远端出现以下问题：
Counting objects: 242, done.
Delta compression using up to 4 threads.
Compressing objects: 100% (221/221), done.
remote: fatal: Unable to create temporary file '/home/git/repositories/OpenIoT.git/./objects/pack/tmp_pack_XXXXXX': Permission denied
fatal: sha1 file '<stdout>' write error: Invalid argument
error: failed to push some refs to 'git@120.27.96.78:repositories/OpenIoT.git'

git bash连接远程主机：ssh root@120.27.96.78 然后输入密码
从阿里云的自定义git库中克隆代码库：git clone git@120.27.96.78:repositories/OpenIoT.git

本项目编译命令：在bupt-openiot目录下执行：mvn clean install 命令



