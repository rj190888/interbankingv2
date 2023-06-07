set TARGET_BXRC=bochsrc2.4.6
set BXSHARE=C:\Program Files (x86)\Bochs-2.4.6
set IDABASE=C:\Program Files (x86)\IDA

"%IDABASE%\idaq.exe" -c -A -OIDAPython:mbr.py %TARGET_BXRC%.bxrc
"%IDABASE%\idaq.exe" -rbochs %TARGET_BXRC%.idb