@echo off

if "%1"=="list" (
    echo === Tartalom kiiratasa ===
    type html_deleter.bat
) else if "%1"=="delete" (
    echo === HTML fajlok torlese ===
    del /s /q *.html
) else (
    type html_deleter.bat
)