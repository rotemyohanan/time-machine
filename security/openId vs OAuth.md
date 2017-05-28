### From the User perspective:

##### The scenario for OpenID:
----

1. User wants to access his account on example.com
2. example.com (the “Relying Party” in OpenID lingo) asks the user for his OpenID User enters his OpenID
3. example.com redirects the user to his OpenID provider.
4. User authenticates himself to the OpenID provider
5. OpenID provider redirects the user back to example.com
6. example.com allows the user to access his account

##### The scenario for OAuth:
----

User is on example.com and wants to import his contacts from mycontacts.com
example.com (the “Consumer” in OAuth lingo) redirects the user to mycontacts.com (the “Service Provider”)
User authenticates himself to mycontacts.com (which can happen by using OpenID)
mycontacts.com asks the user whether he wants to authorize example.com to access his contacts
User makes his choice
mycontacts.com redirects the user back to example.com
example.com retrieves the contacts from mycontacts.com
example.com informs the user that the import was successful

From those scenarios we can see that OpenID is about authentication (i.e. I can identify myself with an url), 
whereas OAuth is about authorization (i.e. I can grant permission to access my data on some website to another website, without providing this website the authentication information for the original website).
