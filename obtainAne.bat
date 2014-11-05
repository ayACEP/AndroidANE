set library_directory=%2%
set library_name=%~n2
set native_directory=%1%
set native_name=%~n1
set signing_options=-storetype pkcs12 -keystore "%~dp0\mycert.p12" -storepass 123456
set dest_ANE=%library_directory%\%library_name%.ane
set extension_XML=%library_directory%\src\extension.xml
set library_SWC=%library_directory%\bin\%library_name%.swc

%~d0
cd %~dp0
echo %native_directory%

jar -cvf0 %native_name%\native\%native_name%.jar -C %native_directory%\bin\classes \
unzip -o %library_SWC% library.swf -d %native_directory%\native
adt -package %signing_options% -target ane "%dest_ANE%" "%extension_XML%" -swc "%library_SWC%" -platform Android-ARM -C "%native_directory%\native" .
