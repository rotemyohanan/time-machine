
# SAML

### The SAML specification defines three roles:
 1. the principal (typically a user)
 2. the Identity provider (IdP)
 3. the service provider (SP)

 ### Flow:
 
 The principal requests a service from the service provider.
 The service provider requests and obtains an identity assertion from the identity provider.
 On the basis of this assertion, the service provider can make an access control decision – in other words it can decide whether to perform some service for the connected principal.

 Before delivering the identity assertion to the SP, the IdP may request some information from the principal (such as a user name and password – in order to authenticate the principal).




SAML server is used to authenticate other users.

Config the Bintray Org with the SAML server.

The SAML specification defines three roles

Cooperate SSO (Single Sign on)

=======================================
Idp = identity provider.
Sp = Service Provider (third party or outsourced supplier)
such as:
Telecommunications service providers (TSPs), Application service providers (ASPs), Storage service providers (SSPs)
=======================================
