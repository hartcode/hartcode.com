IMAGENAME=gcr.io/hartonline-cloud/hartcode.com
IMAGEVERSION=1.0
docker build -t $IMAGENAME:$IMAGEVERSION .
docker tag $IMAGENAME:$IMAGEVERSION $IMAGENAME:latest
gcloud docker push $IMAGENAME:$IMAGEVERSION
gcloud docker push $IMAGENAME:latest
