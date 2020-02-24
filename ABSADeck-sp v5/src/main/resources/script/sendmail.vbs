
Set fso=CreateObject("Scripting.FileSystemObject")
Set oFile=fso.OpenTextFile("C:\Users\10655036\Desktop\Project\IntegratedProject\absadeck-sp v5\src\main\resources\script\dm9.txt")

Const PR_ATTACH_MIME_TAG = "http://schemas.microsoft.com/mapi/proptag/0x370E001E"
Const PR_ATTACH_CONTENT_ID = "http://schemas.microsoft.com/mapi/proptag/0x3712001E"


MessageAttachment1 = "C:\Users\10655036\Desktop\Project\IntegratedProject\absadeck-sp v5\src\main\resources\script\Footer.jpg"
MessageAttachment2 = "C:\Users\10655036\Desktop\Project\IntegratedProject\absadeck-sp v5\src\main\resources\script\absalogo.png"

Set outlook=CreateObject("Outlook.Application")
Set newMail=outlook.CreateItem(0)

With newMail
.Subject = "DM9 Pre-Batch Health Check"
.To="isaac.maria@lntinfotech.com; dhruv.bindoria@lntinfotech.com; amey.more@lntinfotech.com;"


Set realAttachment1 = newMail.Attachments.Add(MessageAttachment1)
Set realAttachment2 = newMail.Attachments.Add(MessageAttachment2)


Set oPA1 = realAttachment1.PropertyAccessor
Set oPA2 = realAttachment2.PropertyAccessor


oPA1.SetProperty PR_ATTACH_MIME_TAG, "image/jpg"
oPA1.SetProperty PR_ATTACH_CONTENT_ID, "footer"

oPA2.SetProperty PR_ATTACH_MIME_TAG, "image/png"
oPA2.SetProperty PR_ATTACH_CONTENT_ID, "logo"


.HTMLBody = oFile.ReadAll


.Send
End With

Wscript.Quit