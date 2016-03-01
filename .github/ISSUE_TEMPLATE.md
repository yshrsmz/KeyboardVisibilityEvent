Before reporting issue, please confirm your project that

1. your Activity's `windowSoftInputMode` is set to the mode that actually changes Activity's height upon Keyboard visibility change.  
   If `windowSoftInputMode` does not change Activity's height, the library can't detect Keyboard visibility change.  

2. your Keyboard is actually changing Activity's height.   
   The library can't detect event when a user is using a keyboard that does not change Activity's height. 
   
   
If either of these are true, It's the library's limitation. I can't help you for now.  
If you come up with something nice to handle these situation, please help me :)


If neither of these are true, please tell me your issue.

You need to let me know:

1. your Activity's `windowSoftInputMode`
2. Android version
3. Android device
4. and other stuff you think might be helpful
