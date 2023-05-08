call runcrud.bat
if "%ERRORLEVEL%" == "0" goto runbrowser
echo.
echo Error building or deploying project
goto fail

:runbrowser
start chrome http://localhost:8080/crud/v1/tasks
if "%ERRORLEVEL%" == "0" goto end
echo.
echo Error opening your browser

:fail
echo.
echo There were errors

:end
echo.
echo Finito!