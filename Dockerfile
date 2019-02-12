FROM node:11.9.0-alpine
ARG COMMIT=local
ENV COMMIT ${COMMIT}
ENV NODE_ENV production
RUN groupadd -r nodejs && useradd -m -r -g -s /bin/bash nodejs nodejs
USER nodejs
WORKDIR /home/nodejs/app
COPY ./package.json .
RUN npm install --production
COPY ./build ./build
COPY ./views ./views
COPY ./webpack.config.js ./webpack.config.js
EXPOSE 8811
ENTRYPOINT ["npm","run", "prodstart"]
