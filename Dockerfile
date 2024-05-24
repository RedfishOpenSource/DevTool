# jre基础环境
FROM openjdk:8-jre-alpine

# 维护者信息
LABEL maintainer="Redfish"

# 添加jar包到容器中 -- tips: app.jar 和 Dockerfile 在同一级
ADD ./starter/target/App.jar /home/

# 对外暴漏的端口号
EXPOSE 8080

# RUN🏃🏃
CMD nohup java -jar /home/App.jar >> /home/app.log 2>&1 & \
    echo "****** 查看日志..." & \
    tail -f /home/app.log