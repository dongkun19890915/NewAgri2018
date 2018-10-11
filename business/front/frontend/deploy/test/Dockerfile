FROM registry.cn-beijing.aliyuncs.com/yyjc-prod/nginx
RUN cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
COPY frontend /usr/share/nginx/html/frontend
COPY nginx.conf /etc/nginx/nginx.conf