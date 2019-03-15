@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  user-service startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Add default JVM options here. You can also use JAVA_OPTS and USER_SERVICE_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto init

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto init

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:init
@rem Get command-line arguments, handling Windows variants

if not "%OS%" == "Windows_NT" goto win9xME_args

:win9xME_args
@rem Slurp the command line arguments.
set CMD_LINE_ARGS=
set _SKIP=2

:win9xME_args_slurp
if "x%~1" == "x" goto execute

set CMD_LINE_ARGS=%*

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\user-service-0.0.1.jar;%APP_HOME%\lib\logback-classic-1.2.3.jar;%APP_HOME%\lib\logback-core-1.2.3.jar;%APP_HOME%\lib\proto.jar;%APP_HOME%\lib\grpc-netty-1.16.1.jar;%APP_HOME%\lib\grpc-protobuf-1.16.1.jar;%APP_HOME%\lib\grpc-stub-1.16.1.jar;%APP_HOME%\lib\ktor-server-netty-1.0.1.jar;%APP_HOME%\lib\ktor-gson-1.0.1.jar;%APP_HOME%\lib\ktor-server-host-common-1.0.1.jar;%APP_HOME%\lib\ktor-server-core-1.0.1.jar;%APP_HOME%\lib\ktor-http-cio-1.0.1.jar;%APP_HOME%\lib\ktor-http-jvm-1.0.1.jar;%APP_HOME%\lib\ktor-network-1.0.1.jar;%APP_HOME%\lib\ktor-utils-jvm-1.0.1.jar;%APP_HOME%\lib\kotlin-stdlib-jdk8-1.3.10.jar;%APP_HOME%\lib\kotlin-reflect-1.3.10.jar;%APP_HOME%\lib\kotlin-stdlib-jdk7-1.3.10.jar;%APP_HOME%\lib\kotlinx-coroutines-jdk8-1.0.1.jar;%APP_HOME%\lib\kotlinx-coroutines-io-jvm-0.1.1.jar;%APP_HOME%\lib\kotlinx-coroutines-core-1.0.1.jar;%APP_HOME%\lib\kotlinx-io-jvm-0.1.1.jar;%APP_HOME%\lib\kotlin-stdlib-1.3.10.jar;%APP_HOME%\lib\slf4j-api-1.7.25.jar;%APP_HOME%\lib\grpc-protobuf-lite-1.16.1.jar;%APP_HOME%\lib\grpc-core-1.16.1.jar;%APP_HOME%\lib\netty-codec-http2-4.1.30.Final.jar;%APP_HOME%\lib\netty-handler-proxy-4.1.30.Final.jar;%APP_HOME%\lib\protobuf-java-3.5.1.jar;%APP_HOME%\lib\guava-26.0-android.jar;%APP_HOME%\lib\proto-google-common-protos-1.0.0.jar;%APP_HOME%\lib\ktor-http-1.0.1.jar;%APP_HOME%\lib\ktor-utils-1.0.1.jar;%APP_HOME%\lib\kotlinx-coroutines-io-0.1.1.jar;%APP_HOME%\lib\kotlinx-coroutines-core-common-1.0.1.jar;%APP_HOME%\lib\kotlinx-io-0.1.1.jar;%APP_HOME%\lib\atomicfu-common-0.11.12.jar;%APP_HOME%\lib\kotlin-stdlib-common-1.3.10.jar;%APP_HOME%\lib\annotations-13.0.jar;%APP_HOME%\lib\config-1.3.1.jar;%APP_HOME%\lib\alpn-api-1.1.3.v20160715.jar;%APP_HOME%\lib\gson-2.8.5.jar;%APP_HOME%\lib\grpc-context-1.16.1.jar;%APP_HOME%\lib\opencensus-contrib-grpc-metrics-0.12.3.jar;%APP_HOME%\lib\opencensus-api-0.12.3.jar;%APP_HOME%\lib\error_prone_annotations-2.2.0.jar;%APP_HOME%\lib\jsr305-3.0.2.jar;%APP_HOME%\lib\animal-sniffer-annotations-1.17.jar;%APP_HOME%\lib\netty-codec-http-4.1.30.Final.jar;%APP_HOME%\lib\netty-handler-4.1.30.Final.jar;%APP_HOME%\lib\netty-codec-socks-4.1.30.Final.jar;%APP_HOME%\lib\netty-codec-4.1.30.Final.jar;%APP_HOME%\lib\netty-transport-4.1.30.Final.jar;%APP_HOME%\lib\checker-compat-qual-2.5.2.jar;%APP_HOME%\lib\j2objc-annotations-1.1.jar;%APP_HOME%\lib\netty-buffer-4.1.30.Final.jar;%APP_HOME%\lib\netty-resolver-4.1.30.Final.jar;%APP_HOME%\lib\netty-common-4.1.30.Final.jar

@rem Execute user-service
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %USER_SERVICE_OPTS%  -classpath "%CLASSPATH%" com.freiheit.trainings.user.MainKt %CMD_LINE_ARGS%

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable USER_SERVICE_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%USER_SERVICE_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
