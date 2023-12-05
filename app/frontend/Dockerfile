# Etapa de construcción
FROM node:16 AS build
WORKDIR /app
COPY package.json package-lock.json ./
RUN npm install
COPY . .
RUN npm run build

# Etapa de producción
FROM httpd:alpine
COPY --from=build /app/dist/ /usr/local/apache2/htdocs/
EXPOSE 4200

