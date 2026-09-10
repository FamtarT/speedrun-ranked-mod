#!/usr/bin/env sh

#
# Copyright 2015 the original author or authors.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

##############################################################################
##
##  Gradle start up script for UN*X
##
##############################################################################

# Attempt to set APP_HOME
# Resolve links: $0 may be a symlink
PRG="$0"
# Need this for relative symlinks.
while [ -h "$PRG" ] ; do
    ls -ld "$PRG"
    link=$(expr "$PRG" : '.*->\(.*\)$')
    if expr "$link" : '/.*' > /dev/null; then
        PRG="$link"
    else
        PRG=$(dirname "$PRG")/"$link"
    fi
done
SAVE_DIR=$(pwd)
cd "$(dirname "$PRG")" >/dev/null
APP_HOME=$(pwd -P)
cd "$SAVE_DIR" >/dev/null

APP_NAME="Gradle"
APP_BASE_NAME=$(basename "$0")

# Add default JVM options here. You can also use JAVA_OPTS and GRADLE_OPTS to pass JVM options to this script.
DEFAULT_JVM_OPTS=''-Xmx64m -Xms64m''

# Use the maximum available, or set MAX_FD != unlimited if you know the value.
MAX_FD=maximum

warn () {
    echo "$*" >&2
}

die () {
    echo
    echo "$*" >&2
    exit 1
}

# OS specific support (must be 'true' or 'false').
darwin=false
msys=false
cygwin=false
native=false
case "$(uname)" in
  Darwin* )
    darwin=true
    ;;
  MINGW* )
    msys=true
    ;;
  CYGWIN* )
    cygwin=true
    ;;
  MSYS* )
    msys=true
    ;;
  NATIVEIMAGE )
    native=true
    ;;
esac

# Determine the Java command to use to start the JVM.
if [ -n "$JAVA_HOME" ] ; then
    if [ -x "$JAVA_HOME/jre/sh/java" ] ; then
        # IBM's JDK on AIX uses strange locations for the executables
        JAVACMD="$JAVA_HOME/jre/sh/java"
    else
        JAVACMD="$JAVA_HOME/bin/java"
    fi
    if [ ! -x "$JAVACMD" ] ; then
        die "ERROR: JAVA_HOME is set to an invalid directory: $JAVA_HOME

Please set the JAVA_HOME variable in your environment to match the
location of your Java installation."
    fi
else
    JAVACMD=java
    which java >/dev/null 2>&1 || die "ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.

Please set the JAVA_HOME variable in your environment to match the
location of your Java installation."
fi

# Increase the maximum file descriptors if we can.
if ! "$cygwin" && ! "$darwin" && ! "$msys" && ! "$native" ; then
    case $system_procs in
      *)
        MAX_FD_LIMIT=$(/sbin/sysctl -n kern.maxfilesperproc)
        ;;
    esac
    if [ -n "$MAX_FD_LIMIT" ] && [ "$MAX_FD_LIMIT" -gt 131072 ] ; then
        MAX_FD=$MAX_FD_LIMIT
    fi
fi

# Collect all arguments for the java command, stacking in reverse order:
#   * args from the command line
#   * the main class name
#   * -classpath
#   * -D...sysproperties
#   * --module-path (only if needed)
#   * DEFAULT_JVM_OPTS, JAVA_OPTS, and GRADLE_OPTS environment variables.

# For Cygwin or MSYS, switch paths to Windows format before running java
if "$cygwin" || "$msys" ; then
    APP_HOME=$(cygpath --path --mixed "$APP_HOME")
    CLASSPATH=$(cygpath --path --mixed "$CLASSPATH")

    JAVACMD=$(cygpath --mixed "$JAVACMD")

    for arg do
        if cygpath -m ./ >/dev/null 2>&1; then
            arg=$(cygpath --path --mixed "$arg")
        fi
        APP_ARGS=$APP_ARGS\ "$arg"
    done
fi

# Escape application args
save () {
    for i do printf '%s\n' "$i" | sed "s/'/'\\\\''/g;1s/^/'/;\$s/\$/'" ; done
    echo " "
}
APP_ARGS=$(save "$@")

# Collect all arguments for the java command, following the shell quoting and substitution rules
eval "set -- $(
        printf '%s\n' "$APP_ARGS" |
        xargs -n1 |
        sed ' s~[^-/]*/~-~g; t; s~^~-D~' |
        tr '\n' ' '
    ) -classpath "$CLASSPATH" org.gradle.wrapper.GradleWrapperMain "$@"
"

# by default we should be in the correct project dir, but when run from Finder on Mac, the cwd is wrong
if [ "$(uname)" = "Darwin" ] && [ "$HOME" = "$COLON" ] ; then
    cd "$(dirname "$0")/.." || exit 1
fi

exec "$JAVACMD" "$@"
