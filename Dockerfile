FROM mhart/alpine-node:5
RUN mkdir /root/hartcode.com
ADD src /root/hartcode.com/src
ADD devServer.js /root/hartcode.com/devServer.js
ADD package.json /root/hartcode.com/package.json
WORKDIR /root/hartcode.com
RUN npm install

EXPOSE 8811
ENTRYPOINT ["npm", "start"]
