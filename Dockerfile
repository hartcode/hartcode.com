yFROM node:11.9.0-alpine
ARG COMMIT=local
ENV COMMIT ${COMMIT}
ENV NODE_ENV production
RUN addgroup -S nodejs && adduser -S -G nodejs -s /bin/sh -h /home/nodejs nodejs
USER nodejs
RUN mkdir -p /home/nodejs/app
WORKDIR /home/nodejs/app
COPY ./package.json .
RUN npm install --production
COPY ./build ./build
COPY ./views ./views
COPY ./webpack.config.js ./webpack.config.js
EXPOSE 8811
ENTRYPOINT ["npm","run", "prodstart"]
