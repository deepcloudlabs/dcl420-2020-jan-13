const fetch = require('node-fetch');
let i = 1;

setInterval( async () => {
    fetch(`http://localhost:8080/imdb-rest-api/api/v1/movies/${i++%200}`
           ,{
        headers: { 'Accept' : 'application/json' }
    }).then( res => res.json())
      .then( body => console.log(body));
} , 1000)
