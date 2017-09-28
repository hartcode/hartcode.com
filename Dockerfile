FROM mhart/alpine-node:8
ENV COMMIT ${TRAVIS_COMMIT}
ENV TAG ${TRAVIS_TAG}
ENV NODE_ENV production
RUN mkdir -p /root/hartcode.com/build
COPY ./build /root/hartcode.com/build
COPY ./views /root/hartcode.com/views
COPY ./package.json /root/hartcode.com/package.json
COPY ./webpack.config.js /root/hartcode.com/webpack.config.js
WORKDIR /root/hartcode.com
RUN npm install
EXPOSE 8811
ENTRYPOINT ["npm","run", "prodstart"]
