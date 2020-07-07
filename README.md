# Echo-Server

A simple server which returns a serialized version of the parameters it received.

Purpose: check if your code is sending the expected data to an external server (in this case, the echo-server).

Can be extended to respond with a copy of header fields received etc.

## Usage:
 
    curl -X POST -d foo=bar "http://localhost:10101/echo"
    
returns

    {"foo":["bar"]}
        
        