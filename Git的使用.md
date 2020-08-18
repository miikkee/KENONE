# Git的使用

## 第一阶段  自己写操作   版本控制 使用git来管理文件夹

首先进入要管理的文件夹,然后进行文件夹的git初始化,使用git进行管理,最后生成版本

```java
git初始化命令    打开要管理的文件夹    git init  --初始化文件夹交给git管理
```

```java
查看当前文件夹下文件状态   git status --查看管理文件夹下文件状态  新文件和被修改的文件是红色
```

```java
添加管理文件  git add 文件名 --添加文件到git管理
把未被管理的文件全部都进行添加  git add .     --状态变成绿色
```

```
提交添加的文件给git管理   git commit   -m  '版本名称' 
```

```
查看提交记录  git log
```

## 补充  预处理 配置用户名和邮箱

```java
git config --global  user.email  "邮箱"
git config --global user.name  "用户名"
```

git  三大区域

![image-20200812160129690](C:\Users\mike\AppData\Roaming\Typora\typora-user-images\image-20200812160129690.png)

 ```java
版本回滚   git  reset --hard  版本号
 ```

```
git reflog   --版本展示  有所有版本的记录
```

# 认识git的分支

```java
查看分支  git  brance
创建新的分支    git branch dev  --创建了一个dev分支
切换到dev分支   git checkout dev 
```

```java
合并分支 bug分支合并到master分支  先切换到master分支  git merge bug  --合并bug分支到当前所处分支
删除分支  git branch -d bug --删除bug分支
```

# 团队合作开始   使用GitHub

```
使用github的流程
1.注册账号
2.创建仓库
3.推送本地代码到远程仓库
```

```
拉取代码    git  clone  仓库地址     --下载了所有的版本的代码 不显示 直接切换
给远程仓库起别名  git remote add origin 远程仓库地址
向远程推送代码  git push -u origin 分支
```







