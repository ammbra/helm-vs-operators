#FROM node:15.6.0-alpine AS builder
#
#WORKDIR /opt/web
#COPY package.json package-lock.json ./
#RUN npm install
#
#ENV PATH="./node_modules/.bin:$PATH"
#
#COPY . ./
#RUN npm run build
#
#FROM nginx:1.17-alpine
#RUN apk --no-cache add curl
#RUN curl -L https://github.com/a8m/envsubst/releases/download/v1.1.0/envsubst-`uname -s`-`uname -m` -o envsubst && \
#    chmod +x envsubst && \
#    mv envsubst /usr/local/bin
#COPY ./nginx.conf /etc/nginx/nginx.template
#CMD ["/bin/sh", "-c", "envsubst < /etc/nginx/nginx.template > /etc/nginx/conf.d/default.conf && nginx -g 'daemon off;'"]
#COPY --from=builder /opt/web/build /usr/share/nginx/html
FROM node:lts-alpine AS builder
WORKDIR /app
ENV PATH /app/node_modules/.bin:$PATH
COPY package.json ./
COPY package-lock.json ./
RUN npm ci --silent
RUN npm install react-scripts@3.4.0 -g --silent
COPY . ./
RUN npm run build:prod

# production environment
FROM nginx:stable-alpine
RUN apk --no-cache add curl
RUN curl -L https://github.com/a8m/envsubst/releases/download/v1.1.0/envsubst-`uname -s`-`uname -m` -o envsubst && \
    chmod +x envsubst && \
    mv envsubst /usr/local/bin
WORKDIR /code
COPY --from=builder /app/build .
COPY nginx.conf  /etc/nginx/nginx.conf
EXPOSE 3000:3000
CMD ["nginx", "-g", "daemon off;"]