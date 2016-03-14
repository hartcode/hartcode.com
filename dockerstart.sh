sudo docker build -t hartcode.com .
sudo docker run --restart=always -p 8811:8811 -d hartcode.com
