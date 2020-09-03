This is a simple demo that describes how to use Keycloak with Spring Boot in REST web applications.

Run a Keycloak server the way you want (kubernetes, Docker, standalone...)
import the file src\main\resources\static\realm-export.json into your realm.

The access type of the client called "api" is bearer-only.
You have to pass the access token with the request to access the API.
To get the access token you can use postman.
send a POST request to http://localhost:8080/auth/realms/api/protocol/openid-connect/token
You have to provide client_id = postman, username = user1, password = user, grant_type = password as params to call above URI

Once you receive the token you can use it in Bearer Authorization header.
