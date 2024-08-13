_DIR=$( cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )

function version() {
  if [[ "${CI:-}" == "true" ]]; then
    if [[ "${GITHUB_REF_TYPE:-}" == "tag" ]]; then
      echo "${GITHUB_REF_NAME:-}"
    else
      git rev-parse --short HEAD
    fi
  else
    echo "snapshot"
  fi
}

function gradlew() {
  "${_DIR}/../gradlew" $@
}
