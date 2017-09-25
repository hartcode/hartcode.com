FROM mhart/alpine-node:8
ENV NODE_ENV production
RUN npm install --global yarn
RUN mkdir -p /root/hartcode.com/build
COPY ./build /root/hartcode.com/build
COPY ./views /root/hartcode.com/views
COPY ./package.json /root/hartcode.com/package.json
COPY ./webpack.config.js /root/hartcode.com/webpack.config.js
WORKDIR /root/hartcode.com
RUN yarn
EXPOSE 8811
ENTRYPOINT ["yarn", "prodstart"]
