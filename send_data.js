var request = require('request'),
    async = require('async');

var stations = [
  {name: 'Tampere', prev: 12},
  {name: 'Helsinki', prev: 14}
];

var sendData = function(name, value, cb) {
  console.log('Station: ' + name + ', temperature: ' + value);
  request({
    uri: 'http://localhost:4000/readings',
    method: 'post',
    json: true,
    body: {station: name, temperature: value}
  }, cb);
}

var rand = function(item, cb) {
  item.prev = item.prev + Math.random() * (Math.random() < 0.5 ? -1 : 1);
  sendData(item.name, item.prev, cb)
}

var run = function() {
  async.each(stations, rand, function(err) {
    setTimeout(run, 10000);
  });
}

run();
