FROM mhart/alpine-node:6.5
RUN mkdir /root/hartcode.com
COPY . /root/hartcode.com/
WORKDIR /root/hartcode.com
RUN npm install
RUN npm run build
EXPOSE 8811
ENTRYPOINT ["npm", "start"]
