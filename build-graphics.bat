@echo OFF

echo.
echo Building Graphics
echo.
echo speed this up with 'inkscape --shell'
echo.

rem include Inkscape in the PATH
set PATH=%PATH%;C:\Program Files (x86)\Inkscape

rem export images
rem Inkscape CLI documentation: http://tavmjong.free.fr/INKSCAPE/MANUAL/html/CommandLine-Export.html
inkscape --export-png=resources\public\img\xebang-16.png logo.svg -h 16 -w 16
inkscape --export-png=resources\public\img\xebang-32.png logo.svg -h 32 -w 32
inkscape --export-png=resources\public\img\xebang-48.png logo.svg -h 48 -w 48
inkscape --export-png=resources\public\img\xebang-64.png logo.svg -h 64 -w 64

copy resources\public\img\xebang-16.png resources\public\img\favicon.png