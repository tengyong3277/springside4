###常用服务命令

     先打 module/test目录下包， 后执行module/parent目录下install.bat目录文件

###nginx服务配置

     日志的配置(注意log目录是接在 /var/后面的)
     location /log {
        autoindex on;
        root         /var/;
    }
