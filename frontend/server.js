var express = require('express'),
    cql = require('node-cassandra-cql');

var client = new cql.Client({hosts: ['localhost'], keyspace: 'simpledemo'});

var app = express();
app.use(express.static('./public'));

app.get('/readings', function(req, res) {
  console.log('GET /readings?name=' + req.query.name);
  res.send([{date: '2015-01-01T12:00:00', temp: 12}, {date: '2015-01-01T12:00:00', temp: 15}])
});

app.listen(4500);
console.log('Server listening at 4500');
