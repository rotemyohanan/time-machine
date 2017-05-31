
# SAML

### The SAML specification defines 3 roles:
 1. Principal (user)
 2. IDP (Identity provider)
 3. SP (service provider)

 ### Flow:
 
 The principal requests a service from the service provider.
 The service provider requests and obtains an identity assertion from the identity provider.
 On the basis of this assertion, the service provider can make an access control decision – in other words it can decide whether to perform some service for the connected principal.

 Before delivering the identity assertion to the SP, the IdP may request some information from the principal (such as a user name and password – in order to authenticate the principal).




SAML server is used to authenticate other users.

Config the Bintray Org with the SAML server.

The SAML specification defines three roles

Cooperate SSO.

----

    Identity Provider (IdP) - Provides authentication as a serviceץ
    Service Provider (SP) - Relies on IdP for authentication of its users. (third party or outsourced supplier)
    exanples:
    Telecommunications service providers (TSPs), Application service providers (ASPs), Storage service providers (SSPs)
    SSO (Single Sign on) 
----


## SSO using SAML:

Let us say there are two services SP1 and SP2 the user wishes to access.

1. User visits SP1 and tries to log in. SP1 sends an authentication request to IdP and the user's browser is redirected to IdP where he enters his credentials. After successful authentication the user is again redirected to SP1 and IdP sends an assertion to SP1 which contains authentication information. Now the user is authenticated and may use the services of SP1. In this case the response coming from IdP also contains a cookie to identify the user. This cookie is stored in the browser.

2. Now the user opens another tab in the browser and tries to access SP2's website. Again as he tries to log in the browser is redirected to IdP and with this redirect the cookies set by the IdP are also sent. The IdP receives the cookie and sends an assertion redirecting the browser back to SP2. The user is logged in to SP2 without needing to enter his credentials again.
