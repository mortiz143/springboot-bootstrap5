echo '--- :docker: tag and push '
#gcloud auth activate-service-account --key-file /.google-credentials
#gcloud config set project scg-container-registry
export BUILDKITE_PIPELINE_SLUG=bootstrap-spike
export BUILDKITE_BUILD_NUMBER=local-1
export SCG_CONTAINER_REGISTRY=asia.gcr.io/scg-container-registry/ffis
echo $SCG_CONTAINER_REGISTRY/$BUILDKITE_PIPELINE_SLUG:$BUILDKITE_BUILD_NUMBER
docker build -f Dockerfile.app --build-arg PACKAGE_NAME=$BUILDKITE_PIPELINE_SLUG -t $SCG_CONTAINER_REGISTRY/$BUILDKITE_PIPELINE_SLUG:$BUILDKITE_BUILD_NUMBER .
docker push $SCG_CONTAINER_REGISTRY/$BUILDKITE_PIPELINE_SLUG:$BUILDKITE_BUILD_NUMBER
docker image tag $SCG_CONTAINER_REGISTRY/$BUILDKITE_PIPELINE_SLUG:$BUILDKITE_BUILD_NUMBER $SCG_CONTAINER_REGISTRY/$BUILDKITE_PIPELINE_SLUG:latest
docker push $SCG_CONTAINER_REGISTRY/$BUILDKITE_PIPELINE_SLUG:latest