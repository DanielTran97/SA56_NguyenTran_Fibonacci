FROM node:20.3.1-alpine 

WORKDIR /app

COPY package.json ./

COPY package-lock.json ./

RUN npm install --silent
RUN npm install react-scripts@5.0.1 -g --silent

EXPOSE 8000

CMD [ "npm", "start" ]

