FROM mhart/alpine-node:8
ENV NODE_ENV production
RUN npm install --global yarn
RUN mkdir -p /root/hartcode.com/build
COPY ./build /root/hartcode.com/build
COPY ./package.json /root/hartcode.com/package.json
WORKDIR /root/hartcode.com
RUN yarn
RUN yarn run build
EXPOSE 8811
ENTRYPOINT ["yarn", "start"]
