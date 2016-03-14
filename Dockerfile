FROM iron/node
RUN mkdir /root/hartcode.com
ADD src /root/hartcode.com/src
ADD devServer.js /root/hartcode.com/devServer.js
ADD package.json /root/hartcode.com/package.json
RUN cd /root/hartcode.com/ && npm install

EXPOSE 8811
CMD cd /root/hartcode.com/ && npm start
