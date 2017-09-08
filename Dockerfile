FROM mhart/alpine-node:7.5
RUN npm install --global yarn
RUN mkdir /root/hartcode.com
COPY . /root/hartcode.com/
WORKDIR /root/hartcode.com
RUN yarn
RUN yarn run build
EXPOSE 8811
ENTRYPOINT ["yarn", "start"]
