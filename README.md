###常用服务命令

     service jenkins start 

###nginx服务配置

     日志的配置(注意log目录是接在 /var/后面的)
     location /log {
        autoindex on;
        root         /var/;
    }
