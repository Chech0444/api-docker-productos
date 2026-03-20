### Despliegue con docker

# Creamos Volumen para la persistencia de datos

docker volume create mysql-data

# Creamos redes correspondientes a las conexiones entre el front, back y mysql

docker network create red-back-db

docker network create red-front-back

# Desplegamos contenedor referente a la bd

docker run -d \
--name mysql-db \
--network red-back-db \
-e MYSQL_ROOT_PASSWORD=1234 \
-e MYSQL_DATABASE=productos_db \
-v mysql-data:/var/lib/mysql \
-p 3307:3306 \
mysql:8

# Creamos imagen y despliegue de contenedor referente al backend

docker build -t backend-app .

docker run -d \
--name backend \
--network red-back-db \
-e DB_HOST=mysql-db \
-e DB_USER=root \
-e DB_PASSWORD=1234 \
-e DB_NAME=productos_db \
-p 8080:8080 \
backend-app

# Conectamos el backend a la red del front y el back

docker network connect red-front-back backend

# Creamos imagen y despliegue de contenedor referente al backend

docker build -t frontend-app .

docker run -d \
--name frontend \
--network red-front-back \
-p 4200:80 \
frontend-app

# El puerto en donde se puede acceder al sistema es el 4200