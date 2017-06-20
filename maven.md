maven

The maven naming convention:
...

Flag: SSL:

allow self sign certificate:

    -Dmaven.wagon.http.ssl.insecure=true
    
allow mismatch certificate:

    -Dmaven.wagon.http.ssl.allowall=true
