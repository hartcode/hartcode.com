FROM mhart/alpine-node:6.5
RUN mkdir /root/hartcode.com
ADD html /root/hartcode.com/html
ADD views /root/hartcode.com/views
ADD devServer.js /root/hartcode.com/devServer.js
ADD package.json /root/hartcode.com/package.json
WORKDIR /root/hartcode.com
RUN npm install

EXPOSE 8811
ENTRYPOINT ["npm", "start"]
