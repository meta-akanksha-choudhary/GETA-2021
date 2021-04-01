var http = require('http');
var fs = require('fs');

var server = http.createServer((req,resp)=> {
    
    
        fs.readFile("MyPage.html", function (error, pgResp) {
            if (error) {
                resp.writeHead(404);
                resp.write('Contents you are looking are Not Found');
            } else {
                resp.writeHead(200, { 'Content-Type': 'text/html' });
                resp.write(pgResp);
            }
             
            resp.end();
        });
    });
    server.listen(3000);
