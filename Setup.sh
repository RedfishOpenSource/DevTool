# maven项目打包
mvn clean
mvn package

# 清空本机所有容器和镜像
docker stop $(docker ps -a -q)
docker rm $(docker ps -a -q)
docker rmi -f $(docker images -q)

# 阻塞等待当前脚本所有docker stop等命令执行完成（如mac上，docker stop等命令是异步的）
wait

# 打包成docker镜像
docker build -t dev-tool .


# 本机运行容器
docker run -d -p 8080:8080 --name dev-tool dev-tool


# 清空gitRunner上的多余文件
mvn clean
