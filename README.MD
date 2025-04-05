## TODO
- Standard Response Api Response 2
- Exception handling (5 - uses that guys pattern for fun)
- Security (6 implement https/ jwt security cookie for fun and google sign OAuth google sign in and single sign-on)
  - Multi-factor Authentication
- picture cloudinary 1 (Done)
- validation (3 create a custom annotation for fun)
- dto's (4 combine using dto's and returning specific info from db)
- Lastly Dockerize CI-CD


## Later functionalities
- forget and reset password functionalities
- shouldnt be able to update password, email, and role directly using the normal update.
- endpoint to update role also will be created
- Role consideration
  - user should not be able to input there role
  - on start of app there should be a super admin already
  - on creation of a user, user will be assign role user.

## My Security Setup:
- will be using cookies and jwt in header
- cookies for frontend interaction
- jwt in header for service to service communication
- Session i will be using in-memory db like redis to store session
- i will also implement google OAuth2
- Two way factor authentication

## Start small
- lets do simple registration first.
- MFA Authentication (Simple email verification)
- then we implement OAuth2 for google registeration
- then service to service jwt implementation on header
- then lastly cookie and session on redis for frontend comunicaton

## MFA will be implemented this way
Best Practice:
Use simple authentication (email verification) at registration 📝.

Enforce MFA for high-risk actions (admin login, transactions, password reset). 🔐
