main
Sub main
Set oShell = CreateObject ("Wscript.Shell") 
Dim strArgs
strArgs = "cmd /c C:\Users\98tae\Desktop\java4\reface\runCheckFaceId.bat"
oShell.Run strArgs, 0, false
End Sub